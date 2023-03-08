const express = require("express");
const hbs = require("express-handlebars");

const server = express();

//engine 사용
server.engine(
    "hbs", 
    //원래는 hbs 였는데 hbs is not a funcion 오류로 .engine을 붙였음
    hbs.engine({
        extname: "hbs",
        defaultLayout: "layouts.hbs",
        partialsDir: "partials",
    })
);
server.set("view engine", "hbs");
server.use(express.static(__dirname + "/public"));

server.get("/", (req,res) => {
    res.render("home", {
        //message로 값을 보낼 수 있음
        message: "Hello Node.js!"
    });
});


server.listen(3000,(err)=> {
    //err 시 출력
    if (err) return console.log(err);
    console.log("The Server is listening on port 3000");
});