// https://www.kindsonthegenius.com/nodejs/rest-api/
//REST API demo in Node.js
let express = require('express'); // requre the express framework
let app = express();
let fs = require('fs'); //require file system object
var cors = require('cors')

app.use(cors())

//Cualquiera de las dos funciona para abrir los cors, importando cors o con la funcion de abajo
// app.use(function(req, res, next) {
//     res.header("Access-Control-Allow-Origin", "*");
//     res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//     next();
//   });

// Endpoint to Get a list of users
app.get('/getProductos', function(req, res){
    fs.readFile(__dirname + "/" + "productos.json", 'utf8', function(err, data){
        console.log(data);
        res.end(data); // you can also use res.send()
    });
})

// Create a server to listen at port 8080
let server = app.listen(8080, function(){
    let host = server.address().address
    let port = server.address().port
    console.log("REST API demo app listening at http://%s:%s", host, port)
})
