const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb");
const all = document.getElementById("all");

for(let i=0;i<ch.length;i++) {
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    });
}

all.addEventListener("click", function(){
    if(cb[i].value==all) {

    }
});

for(let i=0;i<cb.length;i++) {
    if(cb[i].value==all) {
        cb[i].selected=true;
    };
    cb[i].addEventListener("click", function(){

    });
}

if(cb.length == checked.length) {
    all.checked = true;
} else {
    all.checked = false;
}

