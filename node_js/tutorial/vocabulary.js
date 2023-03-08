// 단어장 만들어보기

/*
1. 원하는 동작 선택

1. 단어 암기 : 단어 2개 보여주기
2. 퀴즈 : 문장 속 가려진 단어 맞추기
3. 예시 보기 : 단어에 대한 예시 보기
4. 단어 추가 : 단어와 뜻 추가
5. 종료


*/
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

MENU = ```
1. Word memorization: Show 2 words
2. Quiz: Guess the hidden word in the sentence
3. Examples: View examples of words
4. Add words: add words and definitions
5. Exit
```
/*
word()
quiz()
exam()
add()
*/


while (true) {
    rl.question(MENU, (answer) => {
        if (answer == 5) {
            rl.close();
        } 
        switch (answer) {
            case 1 : word()
            case 2 : quiz()
            case 3 : exam()
            case 4 : add()
        }
    });
}







