var stompClient = null;
var uuid = "";

var appendString = "<tr>\n" +
    "                    <th scope=\"row\">{{price}}</th>\n" +
    "                    <td>{{amount}}</td>\n" +
    "                    <td>{{option}}</td>\n" +
    "                </tr>";

function setConnected(connected) {
    if (connected) {
        infoMessage("Connected to Backend!");
    } else {
        warnMessage("Disconnected to Backend!");
    }
}

function processTableData(content) {
    processBuyData(content.topBuyOrders);
    processSellData(content.topSellOrders);
}

function processBuyData(topBuyOrders) {
    $("#orderBookBuyContent").empty();
    for (var item in topBuyOrders) {
        var topBuyOrder = topBuyOrders[item];
        var object = appendString
            .replace("{{price}}", topBuyOrder.price)
            .replace("{{amount}}", topBuyOrder.amount)
            .replace("{{option}}", topBuyOrder.orderTyp);
        $("#orderBookBuyContent").append(object);
    }
}

function processSellData(topSellOrders) {
    $("#orderBookSellContent").empty();
    for (var item in topSellOrders) {
        var topSellOrder = topSellOrders[item];
        var object = appendString
            .replace("{{price}}", topSellOrder.price)
            .replace("{{amount}}", topSellOrder.amount)
            .replace("{{option}}", topSellOrder.orderTyp);
        $("#orderBookSellContent").append(object);
    }
}

function connect() {
    var socket = new SockJS('/teletrader-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/orderBook', function (data) {
            var content = JSON.parse(data.body);
            processTableData(content);
        });
        stompClient.subscribe('/topic/replies', function (data) {
            var reply = JSON.parse(data.body);
            if (uuid === reply.uuid) {
                (reply.success) ? successMessage("Order successfully set") : errorMessage("Error: " + reply.errorMessage);
            }
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendOrder(orderType) {

    var price = $("#price").val();
    var amount = $("#amount").val();
    if (price == "" || amount == "") {
        console.log("Missing Arguments! No order set!");
        errorMessage("Missing Arguments! No order set!");
        return;
    }

    stompClient.send("/app/placeOrder", {},
        JSON.stringify(
            {
                'price': price,
                'amount': amount,
                'orderType': orderType,
                'uuid': uuid
            }
        )
    )
    ;
}

function cleanUpForm() {
    $("#price").val("");
    $("#amount").val("")
}

function errorMessage(message) {
    console.error(message);
    $.notify({
        // options
        message: message
    }, {
        // settings
        type: 'danger'
    });
}

function successMessage(message) {
    console.log(message);
    $.notify({
        // options
        message: message
    }, {
        // settings
        type: 'success'
    });
}

function infoMessage(message) {
    console.debug(message);
    $.notify({
        // options
        message: message
    }, {
        // settings
        type: 'info'
    });
}

function warnMessage(message) {
    console.warn(message);
    $.notify({
        // options
        message: message
    }, {
        // settings
        type: 'warning'
    });
}

function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }

    return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
}

$(function () {
    uuid = guid();
    connect();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });

    $("#buyOrder").click(function (e) {
        sendOrder("BUY");
        cleanUpForm();
    });

    $("#sellOrder").click(function (e) {
        sendOrder("SELL");
        cleanUpForm();
    });

});