
var Service = function (host, port) {

    var that = this

    this.host = host
    this.port = port

    this.reqCallbacks = []

    var openListeners = []
    var closeListeners = []

    var ws = new WebSocket("ws://" + host + ":" + port)

    this.onOpen = function (func) {
        openListeners.push(func)
    };

    this.onClose = function (func) {
        closeListeners.push(func)
    };

    ws.onopen = function () {
        console.log('Connection open');
        for (var i = 0; i < openListeners.length; i++) {
            openListeners[i]()
        }
    };

    ws.onclose = function () {
        console.log('Connection closed');
        for (var i = 0; i < closeListeners.length; i++) {
            closeListeners[i]()
        }
    };

    ws.onmessage = function (evt) {

        var msg = JSON.parse(evt.data)
        if (msg.error !== undefined) {
            console.error(msg.error)
        }
        if (msg.id !== undefined) {
            var id = msg.id
            var callback = that.reqCallbacks[id];
            if (callback !== undefined) {
                callback(msg.result)
                delete that.reqCallbacks[id];
            }
        }

    };


    this.isConnecting = function () {
        return ws.readyState === 0
    };

    this.isOpen = function () {
        return ws.readyState === 1
    };

    this.isClosing = function () {
        return ws.readyState === 2
    };

    this.isClosed = function () {
        return ws.readyState === 3
    };

    this.close = function () {
        ws.close()
    };

    this.send = function (data) {
        ws.send(data)
    };

    Service.prototype.generateGUID = function () {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000)
                .toString(16)
                .substring(1);
        }
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
            s4() + '-' + s4() + s4() + s4();
    };

    Service.prototype.request = function (method, params) {

        var guid = this.generateGUID();

        var payload = {
            jsonrpc: "2.0",
            method: method,
            params: params,
            id: guid
        };


        this.send(JSON.stringify(payload));

        return new Promise(function (resolve, reject) {
            that.reqCallbacks[guid] = function (result) {
                resolve(result)
            }
        })

    };

    Service.prototype.notify = function (method, params) {
        var payload = {
            jsonrpc: "2.0",
            method: method,
            params: params
        };
        this.send(JSON.stringify(payload));
    };


    Service.prototype.load = function(url) {
        return this.request("load", [url])
    }

    Service.prototype.createInstanceFromCS = function(fmuId) {
        return this.request("createInstanceFromCS", [fmuId])
    }

    Service.prototype.simpleSetup = function(slaveId) {
        return this.request("simpleSetup", [slaveId])
    }

    Service.prototype.setupExperiment = function(slaveId, start, stop, tolerance) {
        return this.request("setupExperiment", [slaveId, start, stop, tolerance])
    }

    Service.prototype.enterInitializationMode = function(slaveId) {
        return this.request("enterInitializationMode", [slaveId])
    }

    Service.prototype.exitInitializationMode = function(slaveId) {
        return this.request("exitInitializationMode", [slaveId])
    }

    Service.prototype.doStep = function(slaveId, stepSize) {
        return this.request("doStep", [slaveId, stepSize])
    }

    Service.prototype.reset = function(slaveId) {
        return this.request("reset", [slaveId])
    }

    Service.prototype.terminate = function(slaveId) {
        return this.request("terminate", [slaveId])
    }

    Service.prototype.readReal = function(slaveId, vr) {
        return this.request("readReal", [slaveId, vr])
    }

}