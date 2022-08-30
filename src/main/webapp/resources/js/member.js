const btn=document.getElementById("btn");
const frm=document.getElementById("frm");
const userName=document.getElementById("userName");
const password=document.getElementById("password");

btn.addEventListener("click", function(){
    let u = userName.value;
    let p = password.value;
    console.log(u=="");
    console.log(u.length);

    if(u=="") {
        alert("ID는 필수입니다");
        return;
    }

    if(p=="") {
        alert("PW는 필수입니다");
        return;
    }

    frm.submit();
    // if(u.length>0 && p.length>0) {
    //     frm.submit();
    // } else {
    //     alert("id와pw는 필수입니다");
    // }
});
    




