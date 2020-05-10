var http = require('follow-redirects').http;
var fs = require('fs');

exports.insertInput = function (req, res) {
    var userData=req.body;
    var departure=userData.departure;
    var departure_airport=userData.departure_airport;
    var destination=userData.destination;
    var destination_airport=userData.destination_airport;
    var email=userData.email;
    var departure_date=userData.departure_date;
    var arrival_date=userData.arrival_date;
    var subCategory1= userData.subCategory1;
    var subCategory2= userData.subCategory2;
    var subCategory3= userData.subCategory3;

    console.log(userData);
    var startDay=new Date(departure_date);
    var endDay=new Date(arrival_date);
    var days=endDay.getTime()-startDay.getTime();
    days=parseInt(days/(1000*60*60*24)-1);

    if(userData==null){
        res.status(403).send("No data sent!");
    }
    if(days>0) {
        try {

            var options = {
                'method': 'POST',
                'hostname': 'localhost',
                'port': 5050,
                'path': '/travel/information',
                'headers': {
                    'Content-Type': ['application/json', 'application/json']
                },
                'maxRedirects': 20
            };
            var req = http.request(options, function (res) {
                var chunks = [];

                res.on("data", function (chunk) {
                    chunks.push(chunk);
                });

                res.on("end", function (chunk) {
                    var body = Buffer.concat(chunks);
                    console.log(body.toString());
                });

                res.on("error", function (error) {
                    console.error(error);
                });
            });
            var postData = JSON.stringify({
                "email": email,
                "origin": departure,
                "destination": destination,
                "originStation": departure_airport,
                "destinationStation": destination_airport,
                "outboundDate": departure_date,
                "subCategory1": subCategory1,
                "subCategory2": subCategory2,
                "subCategory3": subCategory3,
                "inboundDate": arrival_date,
                "numDays": days
            });

            req.write(postData);
            req.end();
            res.render('finish', {title: 'Express'});
        } catch (e) {
            res.status(500).send('error ' + e);
        }
    }else{
        res.render('userInput', { title: 'Express',email:email });
    }
}
