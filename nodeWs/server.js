var express = require('express');
var app = express();

app.get("/essai1", function(req, res,next) {
	var objData = {
		ref : "ref1",
		value : 12
	};
	res.send(objData);
});

app.listen(8585,function () {
	console.log("http://localhost:8585");
});

// node server.js
// http://localhost:8585/essai1