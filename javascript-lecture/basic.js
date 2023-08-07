console.log("hello js");
// 컴파일러... 인터프리터...
// javascript  type 이 정해져 있지 않다.
// var / let / const
// 변수
let myName = "장성호";
let myAge = 30;
const pi = 3.14;
myAge = myAge + 1; // 할당 연산자
//console.log(31 = "31");
let isMarried = 0 / 0; // boolean(true / false)
// falsy = 0,undefined, null ,"", NaN 등등
let myWeight = null; // 아무것도 없다.
let test = 100 / "aa";
console.log(typeof myWeight);
console.log(myWeight);
if (isMarried) {
  console.log("기혼");
} else {
  console.log("미혼");
}
