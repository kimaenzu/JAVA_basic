const fs = require("fs");

/*
//Sync
const data = fs.readFileSync("./hello.txt", {encoding : "utf-8"});
console.log(data);
*/
/*
// callback function이 있다는게 다름
fs.readFile("./hello.txt", {encoding:"utf-8"}, (err,data)=>{
    console.log(data);
});
*/
/*
//data가 text에 들어가는지 확인하기 위함
let text = "default";
fs.readFile("./hello.txt", {encoding:"utf-8"}, (err,data)=>{
    text = data;
});
console.log(text); // text에 data를 덮어쓰기 했으므로 data의 값이 나와야 하지만 default가 나옴
*/

/*

let text = "default";
fs.readFile("./hello.txt", {encoding:"utf-8"}, (err,data)=>{
    console.log(data); 
    text = data;
});
console.log(text); 
*/
/*
출력
default
Hello ICEBARE
Welcome!
data가 먼저 출력되어야 되는데 default먼저 나왔음
=>
*/


/*
let text = "default";
// 5초 뒤에 출력
setTimeout(() => {
    console.log("Print after 5 seconds");
},5000);
console.log("Do i get executed?");
*/
// 실행시간 측정 해보기
let startTime = Date.now();
let text = "default";
setTimeout(() => {
    console.log(Date.now() - startTime, "First");
},5000);
console.log(Date.now() - startTime, "Second");
/*
출력
0 Second
5014 First
*/
/*
fs.readFile("./hello.txt", {encoding:"utf-8"}, (err,data)=>{
    console.log(data); 
    text = data;
});
console.log(text); 
*/