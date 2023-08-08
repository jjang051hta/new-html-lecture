//while, for
let i = 0;
while (i < 10) {
  console.log("나는 조건을 만족하면 실행됩니다.");
  i++;
}
console.log("끝");
//3의 배수의 합
for (let j = 1; j < 10; j++) {
  //console.log("2 x " + j + " = " + 2 * j);
  for (let k = 1; k < 10; k++) {
    console.log(`${j} x ${k} = ${j * k}`);
  }
}
