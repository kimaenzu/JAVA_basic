const express = require("express");
const server = express();
/*
//모든 요청은 use를 지나감
server.use((req,res)=>{
    //check가 두번 뜨고 다음으로 넘어가지 않음
    console.log("check");
})
*/

// use id를 확인하고 아래 두개의 server.get 을 확인한다
server.use((req,res,next)=>{
    req.user = {
        id:"1234"
    };
    next();
});
// 다음으로 넘어가지 않던 창이 넘어가고, { id: '1234' }가 출력 됨

server.get("/", (req,res) => {
    console.log(req.user);
//    res.send("<h1>HELLO</h1>")
    res.sendFile(__dirname + "/index.html");
});

server.get("/about", (req,res) => {
    res.sendFile(__dirname + "/About.html")
});

server.use((req,res)=>{
    res.sendFile(__dirname + "/404.html")
});
//GET       www.facebock.com/
//POST      ID: IB, PW:0000
//DELETE    
//PUT       update

server.listen(3000,(err)=> {
    //err 시 출력
    if (err) return console.log(err);
    console.log("The Server is listening on port 3000");
});

//index.css 파일을 만든다고 해도 express.js index.html을 불러올 때 index.css 파일을 찾을 수 없음
// 보내는 방법이 따로 있음 -> Middleware