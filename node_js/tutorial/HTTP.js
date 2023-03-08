// 서버의 기초 : 응답과 처리

const http = require('http');
/*
// 서버를 만듦. 이 코드만으로는 작동이 안됨
const server = http.createServer((req, res)=> {
//    console.log(req);
    console.log(req.url);
});

//localhost:3000
server.listen(3000,()=> {  // port, 
    console.log("The server is listening on port 3000");
});
*/

/*
req.url로 바꾸면
/
/abc
경로 출력

*/


const server = http.createServer((req, res)=> {
    if (req.url === "/"){
        res.write("<h1>HI, ICEBARE!</h1>");
    }else {
        //기본값이 아닌 다른 값으로 들어갔을 때
        res.write(`<h1>You have entered invalid url : ${req.url}</h1>`);
    }
    res.end();
    });
server.listen(3000,()=> {  // port, 
    console.log("The server is listening on port 3000");
});