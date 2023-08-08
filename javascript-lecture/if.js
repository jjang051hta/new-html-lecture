// true/false
// 비만
let height = 180;
let weight = 80;
let meterHeight = height / 100;
//console.log(meterHeight ** 2);
//console.log(Math.pow(meterHeight, 2));
let result = weight / meterHeight ** 2;
console.log(result);
if (result <= 18.5) {
  console.log("저체중");
} else if (result >= 25) {
  console.log("비만");
} else {
  console.log("정상");
}
