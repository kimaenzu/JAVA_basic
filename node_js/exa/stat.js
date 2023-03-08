/*
const pi = 3.14;
const mean = (arr) => {
    if (arr.length === 0) {
        return 0;
    }
    let sum = 0;
    for(let i=0; i<arr.length; i++) {
        sum += arr[i];
    }
    return sum/arr.length;
};
// 두 개의 값을 보내는 모듈 키:변수
// object를 사용해서 값을 보냄

module.exports = {
    pi,
    mean
}

//
module.exports.pi = pi;
module.exports.mean = mean;


exports.pi = pi;
exports.mean = mean;
*/


exports.pi = 3.14;
exports.mean = (arr) => {
    if (arr.length === 0) {
        return 0;
    }
    let sum = 0;
    for(let i=0; i<arr.length; i++) {
        sum += arr[i];
    }
    return sum/arr.length;
};