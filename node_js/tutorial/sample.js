const express = require("express");
const hbs = require("express-handlebars");
const bodyParser = require("body-parser");
const server = express();
let words = require("./db/words.json");
//console.log(words);           // 프로그램 실행 전 출력 됨
//console.log(typeof words);    // object
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
server.use(bodyParser.urlencoded({extended: false}));
server.get("/", (req,res) => {
    res.render("home", {
        //message로 값을 보낼 수 있음
//        message: "Hello Node.js!"
//        words: words,  // 아래랑 같은 거 (자바스크립트에선)
        words,
    });
});

server.post("/", (req,res)=> {
    const {query} = req.body;
    res.render("home", {
        words:words.filter(w=>w.word.toLowerCase().includes(query.toLowerCase()))
    })
})

server.delete("/", (req,res) =>{
    console.log(req.body);
    let {word} = req.body;
    words = words.filter((w) => !(w.word === word));
});

server.get("/add", (req,res) => {
    res.render("add");
});

server.get("/quiz", (req,res) => {
    res.render("quiz");
});

server.use((req, res) => {
    res.render("404");
})
server.listen(3000,(err)=> {
    //err 시 출력
    if (err) return console.log(err);
    console.log("The Server is listening on port 3000");
});