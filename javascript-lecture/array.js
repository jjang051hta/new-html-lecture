// 배열(나열)
// 순서없는 것들에게 순서 매기기
// 60 임재호/ 김승환 / 장일성
// 6-1 ["임재호","김승환","장일성"]
let myClass = ["임재호", "김승환", "장일성"];
console.log(myClass[0] === "임재호");
console.log(myClass[1] === "김승환");
console.log(myClass[2] === "장일성");
const current = new Date();
console.log(current);
const yoilArray = ["일", "월", "화", "수", "목", "금", "토"];
yoilArray.unshift("천");
const yoil = current.getDay();
console.log(yoilArray[yoil]);
// 모든 프로그래밍 언어에는 문(statement (조건문 / 반복문)) 식(expression)

let i = 5;

for (let i = 0; i < 7; i++) {
  //여기 실행
  console.log(yoilArray[i]);
}
if (yoil === 1) {
  console.log("월요일");
} else if (yoil === 2) {
  console.log("화요일");
} else if (yoil === 3) {
  console.log("수요일");
} else if (yoil === 4) {
  console.log("목요일");
} else if (yoil === 5) {
  console.log("금요일");
} else if (yoil === 6) {
  console.log("토요일");
} else if (yoil === 0) {
  console.log("일요일");
}

//  배열 복사
let animals = ["cat", "puppy", "bear", "lion"];
let copyAnimals = [...animals, "chicken"]; // 얕은 복사

//copyAnimals.push("chicken");
console.log(animals[0]);
console.log(animals[1]);
console.log(animals[2]);
console.log(animals[3]);
for (let i = 0; i < copyAnimals.length; i++) {
  console.log(copyAnimals[i]);
}
animals.forEach(function (item, index) {
  console.log(index, ":", item);
});
console.log(...animals); // spread operator
// 배열 메스드에 반복문 있다.  ()
