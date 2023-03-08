const fs = require("fs");

//파일을 작성한다. Sync 하게
//fs.writeFileSync("./hello.txt", "Hello ICEBARE");

//파일을 읽는다. Sync 하게
//const data = fs.readFileSync("./hello.txt", {encoding: "utf-8"});

//console.log(data);

//파일에 추가한다.
//fs.appendFileSync("./hello.txt",'\nWelcome!');

//경로에 있는 파일명 읽기
const list = fs.readdirSync(".");
console.log(list);

//Synchronous vs Asynchronous
// Block      vs Non-Block