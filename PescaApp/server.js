var express = require('express');
var morgan = require('morgan');
var app = express();
var nconf = require('nconf');
var env = process.env.NODE_ENV || 'development';


if ('development' == env) {
    app.use(express.static(__dirname + '/app'));
    app.use(morgan('dev'));
}

app.listen(8017, function() {
    console.log('App escuchando en el puerto 8017');
});


app.get('/', function(req, res) {
    res.sendFile('/app/index.html');
});