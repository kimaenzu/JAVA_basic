const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

rl.question('What is your name? ', (answer) => {
    console.log('Hello'+ answer)
// 여기서 끝난다면 HELLO 출력 이후에도 값을 입력할 수 있음 
// rl.close(); 로 추가 입력을 막아줌
    rl.close();
});

