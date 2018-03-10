/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.fmu_proxy.grpc.services

import io.grpc.BindableService
import io.grpc.stub.StreamObserver
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmu_proxy.grpc.StatusProto
import no.mechatronics.sfi.fmu_proxy.grpc.StatusCodeProto

interface GrpcFmuService : BindableService {

    fun convert(status: FmiStatus): StatusCodeProto {
        return when (status) {
            FmiStatus.OK -> StatusCodeProto.OK_STATUS
            FmiStatus.Warning -> StatusCodeProto.WARNING_STATUS
            FmiStatus.Discard -> StatusCodeProto.DISCARD_STATUS
            FmiStatus.Error -> StatusCodeProto.ERROR_STATUS
            FmiStatus.Fatal -> StatusCodeProto.FATAL_STATUS
            FmiStatus.Pending -> StatusCodeProto.PENDING_STATUS
            FmiStatus.NONE -> StatusCodeProto.UNRECOGNIZED
        }
    }

    fun statusReply(status: FmiStatus, responseObserver: StreamObserver<StatusProto>) {
        StatusProto.newBuilder()
                .setCode(convert(status))
                .build().also {
            responseObserver.onNext(it)
            responseObserver.onCompleted()
        }
    }

}