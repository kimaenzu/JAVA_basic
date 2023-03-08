const fs = require("fs");

// 1.Word
const f_voca = fs.readFileSync("./voca.txt", {encoding: "utf-8"});
exports.word = f_voca;

// 2.Quiz
exports.quiz = () => {
    const q_voca = fs.readFileSync("./quiz.txt", {encoding: "utf-8"});
    const voca_quiz = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    voca_quiz.question(q_voca, (answer) => {
        if (answer = "learn") {
            console.log("Correct!!!");
        }else {
            console.log("Answer is [learn] ...");
        }
    }
};

// 3. 에휴 모르겠다
