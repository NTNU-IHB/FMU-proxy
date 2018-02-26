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

package no.mechatronics.sfi.rmu.grpc.services

import io.grpc.BindableService
import io.grpc.stub.StreamObserver
import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.rmu.FmiDefinitions

interface GrpcFmuService : BindableService {

    fun convert(status: FmiStatus): FmiDefinitions.StatusCode {
        return when (status) {
            FmiStatus.OK -> FmiDefinitions.StatusCode.OK
            FmiStatus.Warning -> FmiDefinitions.StatusCode.WARNING
            FmiStatus.Discard -> FmiDefinitions.StatusCode.DISCARD
            FmiStatus.Error -> FmiDefinitions.StatusCode.ERROR
            FmiStatus.Fatal -> FmiDefinitions.StatusCode.FATAL
            FmiStatus.Pending -> FmiDefinitions.StatusCode.PENDING
            FmiStatus.NONE -> FmiDefinitions.StatusCode.UNRECOGNIZED
        }
    }

    fun statusReply(status: FmiStatus, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        statusReply(FmiDefinitions.Status.newBuilder()
                .setCode(convert(status))
                .build(), responseObserver)
    }

    fun statusReply(status: FmiDefinitions.Status, responseObserver: StreamObserver<FmiDefinitions.Status>) {
        responseObserver.onNext(status)
        responseObserver.onCompleted()
    }

}