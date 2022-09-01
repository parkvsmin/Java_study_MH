const remove1 = document.getElementById("remove1"); //remove1버튼
const remove2 = document.getElementById("remove2"); //remove2버튼
const d1 = document.getElementById("d1"); //div#d1
const d2 = document.getElementById("d2"); //div#d2
const d2_1 = document.getElementById("d2_1"); //h1#d2_1
const d2_2 = document.getElementById("d2_2"); //h1#d2_2
const d2_3 = document.getElementById("d2_3"); //h1#d2_3
const d2_4 = document.getElementById("d2_4"); //h1#d2_4

remove1.addEventListener("click", function(){
    //삭제
    d1.remove();

});

// remove2.addEventListener("click", function(){
//     d2.removeChild(d2_1);
//     d2.removeChild(d2_2);
//     d2.removeChild(d2_3);
//     d2.removeChild(d2_4);
// });

remove2.addEventListener("click", function(){
    // const ch = document.getElementsByClassName("ch");
    // const ar = [];
    //for(데이터타입 변수명 : 컬렉션 변수명)
    // for(let i=0;i<ch.length;i++) {
    //     ar.push(ch[i].id);
    // }
    // for(i of ar) {
    //     let d = document.getElementById(i);
    //     d2.removeChild(d);
    // }
    for(let i=1;i<5;i++) {
        const d2_1 = document.getElementById("d2_"+i);
        d2.removeChild(d2_1);
    }
});