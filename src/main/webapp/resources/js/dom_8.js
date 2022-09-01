const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const google = document.getElementById("google");

google.addEventListener("click", function(event){
    alert("Go Google");
    event.preventDefault();
});


d1.addEventListener("click", function(event){
    console.log("d1 click");
    console.log(event);
    console.log(event.currentTarget);
    console.log(event.target);

    if(event.target.className=='buttons') {
        alert("button");
        console.log("this : ",this);
        alert(event.target.innerHTML);
    }
    
}, false);
//-----
result.addEventListener("click", function(event){
    if(event.target.className=='c1') {
        alert(event.target.innerHTML);
    }
});



//true : 부모부터 false : 자식부터실행됨 이벤트버블링

btn.addEventListener("click", function(){
    for(let i=0;i<count.value;i++) {
        console.log(i); 
    
    let button = document.createElement("button");//버튼 <button></button>
    let t = document.createTextNode("CLICK"+i);//CLICK +i
    button.appendChild(t); // <button>CLICK</button>

    let c = document.createAttribute("class");//class=
    c.value="c1";//class="c1"

    button.setAttributeNode(c);
    result.append(button);
    }

});


for(c of c1) {
    c.addEventListener("click", function(){
        alert(c.innerHTML);
    })
}

// for(let i=0;i<c1.length;i++) {
//     c1[i].addEventListener("click", function(){
//         alert(c.innerHTML);
//     })
    
// }
    

