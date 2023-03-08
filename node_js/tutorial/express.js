const express = require("express");
const server = express();

// 모든 파일의 출처/소스 는 __dirname + "/public" 안에 있다고 말해 줌
server.use(express.static(__dirname + "/public"));

//index.css를 public 폴더로 이동
server.get("/", (req,res) => {
    res.sendFile(__dirname + "/index.html");
});

server.get("/about", (req,res) => {
    res.sendFile(__dirname + "/About.html")
});

server.use((req,res)=>{
    res.sendFile(__dirname + "/404.html")
});

server.listen(3000,(err)=> {
    //err 시 출력
    if (err) return console.log(err);
    console.log("The Server is listening on port 3000");
});