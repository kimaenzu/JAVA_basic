/*
//패키지를 사용할 준비
const readline = require('readline-sync');

const name = readline.question("What is your name?\n");

console.log(name);

// JSON : Javascript Object Notation
*/
//
const fs = require('fs');
/*
const data = fs.readFileSync("./vocab.json", {encoding:"utf-8"});
console.log(data);
console.log(typeof data);
*/
/*
[1,2,3,4,5]
string  // 배열인데 string 타입이라고 출력
*/
// string을 parse 하여 출력해봄
/*
console.log(JSON.parse(data));
console.log(typeof JSON.parse(data));
let arr = JSON.parse(data);
console.log(arr[2]);
*/
/*
[ 1, 2, 3, 4, 5 ]
object
3
*/

const ob = { 
    name: "icebare",
    age: 20,
    description: "I go to school",
};

//fs.writeFileSync("test.json", ob.toString());

/*
test.json
[object Object]
로 저장됨
fs.writeFileSync("test.json", ob);
fs.writeFileSync("test.json", ob.toString());
error) The "data" argument must be of type string or  ~ 에러가 발생해 toString()을 붙여주었고 강의와 같은 결과가 나왔음
*/


fs.writeFileSync("test.json", JSON.stringify(ob));
/*
{"name":"icebare","age":20,"description":"I go to school"}
로 저장됨
*/