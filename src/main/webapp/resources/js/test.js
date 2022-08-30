alert("Welcome");

//1
//int num=1; java
var num = 1;
//num='abc'
let num2='1';

console.log(num==num2);
console.log(num===num2);

for(var i=0;i<10;i++) {
    console.log(i);
    count=1;
}

console.log('-----');
console.log(i);
console.log(count);
console.log('-----');

let ar = ['4', '2', 3, '2'];
console.log(ar[0]);
console.log(ar[1]);
console.log(ar[2]);

ar.push(5); //끝에 요소를 추가
console.log(ar);
ar.unshift('9'); //처음에 요소를 추가
console.log(ar);
ar.sort(); //정렬, 오름 차순
console.log(ar);
ar.reverse(); // 역순
console.log(ar);

ar.forEach(function(v, i, ar){
    console.log("v",v);//"v :"+v
    console.log("i",i);
    console.log("-----");
});
