//Button에 click event 등록
const btn = document.getElementById("btn");//button
const d1 = document.getElementById("d1");//div
const add = document.getElementById("add");//add button
const list = document.getElementById("list")//ul태그
const add2 = document.getElementById("add2");//add2버튼
const list2 = document.getElementById("list2");//ol태그
const d2 = document.getElementById("d2");
const add3 = document.getElementById("add3");//add3버튼
const d3 = document.getElementById("d3");
const add4 = document.getElementById("add4");//add4버튼
const add5 = document.getElementById("add5");//add5버튼


btn.addEventListener("click" , function(){
    d1.innerHTML='<img src="/resources/images/title1.jpg">'
});

add.addEventListener("click", function(){
    let li = document.createElement("li");//<li></li> 만듬
    let t = document.createTextNode("test");//추가한것
    li.appendChild(t);//부모밑에추가
    list.append(li); //밑에추가
});

add2.addEventListener("click" , function(){
    let li = document.createElement("li");//<li></li> 만듬
    let h = document.createElement("h3");//element생성
    let t = document.createTextNode("Hello"); //Hello
    h.appendChild(t);                       //<h3>Hello</h3>
    li.appendChild(h);                      //<li><h3>Heoll<h3></li>
    list2.prepend(li); //위에추가
});
//add3을 클릭하면 div#d2 내에 input Element를 Append
add3.addEventListener("click", function(){
    let input = document.createElement("input");//<input>
    let ch = document.createAttribute("type");  //type=
    ch.value="checkbox";                        //type="checkbox"
    input.setAttributeNode(ch);                 //<input type="checkbox">
    d2.appendChild(input);
});
//add4를 클릭하면 div#d3 before 적용
add4.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("Before");
    h.appendChild(t);
    d3.before(h);

});

//add5를 클릭하면 div#d3 after 적용
add5.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("After");
    h.appendChild(t);
    d3.after(h);
});
