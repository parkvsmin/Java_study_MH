const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb");
const all = document.getElementById("all");

for(let i=0;i<ch.length;i++) {
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    });
}
//-----
all.addEventListener("click", function(){
    console.log(all.checked);
    for(let i=0;i<cb.length;i++) {
    cb[i].checked=all.checked;
    }
})
//-----
for(let i=0;i<cb.length;i++) {
    // cb[i].addEventListener("click", function(){
    //     check(1)
    // });
    cb[i].addEventListener("click", check);
  
}

function check() {
    let result = true;
    for(let i=0;i<cb.length;i++) {
        if(!cb[i].checked){
            result=false;
            break;
        }
    }
    all.checked=result;
}




