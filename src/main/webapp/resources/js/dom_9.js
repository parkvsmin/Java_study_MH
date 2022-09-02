const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.querySelector("#btn");

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);


console.log("---------------------------------------")

//parentNode
console.log(d1_2_1_2.parentNode.parentNode.parentNode);

console.log("---------------------------------------")

//child
console.log(d1.childNodes); //자식노드에 접근 d1_1 d1_2
console.log(d1.children);
console.log(d1.childNodes[3].innerHTML); //3번 div태그
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);
console.log(d1.children[1].children[0].children[0].innerHTML);

d1.addEventListener("click", function(){
    //li태그 삭제
    console.log("click");

    let li=d1.children[1].children[0].children;
    console.log(li);

    for(let i=0;i != li.length;) {
        li[0].remove();
    }

    // for(l of li){
    //     console.log(l);
    //     l.remove();
    // }
    //let li = document.querySelector("#d1");
    //li.parentNode.removeChild(li);

});

btn.addEventListener("click", function(){
    d1_2_1_2.parentNode.parentNode.remove();
})
