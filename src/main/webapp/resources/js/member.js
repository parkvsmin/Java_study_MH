function check() {

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

}

function check(){

const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");
const join = document.getElementById("join");
const frm=document.getElementById("frm");
const req=document.getElementsByClassName("req");


join.addEventListener("click", function(){
    let result=true;
    for(let i=0;i<req.length;i++){
        if(!req[i].checked){
            result=false;
            break;
        }
    }
    if(result){
        frm.submit();
    }else {
        alert("필수 동의");
    }
    // if(all.checked){
    //     frm.submit();
    // }else {
    //     alert("약관에 동의 해야 합니다")
    // }
});

all.addEventListener("click", function(){
    for(i=0;i<cb.length;i++){
        cb[i].check=all.checked;
    }
})
 
    for(i=0;i<cb.length;i++) {
        cb[i].addEventListener("click" , function(){
            let result=true;
            for(let j=0;j<cb.length;j++){
                if(!cb[j].checked) {
                    result=false;
                    break;
                }
            }
            all.checked=result;
        })
    }
}


function joinCheck(){

//선택자
const joinForm = document.getElementsById("joinForm");
const joinButton = document.getElementsById("joinButton");

//Check 결과
let idCheck=false;
let pwCheck=false;
let pwEqualCheck=false;
let nameCheck=false;
let emailCheck=false;
let phoneCheck=false;


//joinButton click
joinButton.addEventListener("click", function(){
    if(idCheck&&pwCheck&&pwEqualCheck&&nameCheck&&emailCheck&&phoneCheck) {
        joinForm.submit();
    }else {
        alert("필수 입력 사항 입력");
    }

})


const userName = document.getElementsById("userName");
const userNameResult = document.getElementById("userNameResult");

const password = document.getElementsById("password");
const passwordResult = document.getElementById("passwordResult");

const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");

const name = document.getElementsById("name");
const email = document.getElementsById("email");
const phone = document.getElementsById("phone");

userName.addEventListener("blur", function(){

    if(userName.value.length>1){
        userNameResult.innerHTML="";
        idCheck=true;
    }else {
        idCheck=false;
        userNameResult.innerHTML="최소 2글자 이상 입력";
    }

    // let u = userName.value
    // if(u == '' || u.length<3) {
    //     alert("id는 2글자 이상 입력");
    //     userName.focus();
    // }
});


password.addEventListener("change", function(){
    if(password.value.length>5) {
        pwCheck=true;
        passwordResult.innerHTML="";
        pwResult.value="";
    }else {
        pwCheck=false;
        passwordResult.innerHTML="최소 6글자 이상";
    }
    // let p = password.value
    // if(p.length>=6) {
    //     alert("최소 6글자 이상");
    //     password.focus();
    // }

});
//pw 같은지 
pw.addEventListener("blur", function(){
    if(password.value == pw.value){
        pwEqualCheck=true;
        pwResult.innerHTML="";

    }else {
        pwEqualCheck=false;
        pw.value="";
        pwResult.innerHTML="불일치";
    }
    // let pw = pw.value
    // if(pw.length>=6) {
    //     alert("최소 6글자 이상");
    // }else (p.value != pw.value); {
    //     alert("pw불일치");
    //     password.focus();
    //     pw.focus();
    //     return false;
    // }

});

name.addEventListener("blur", function(){
    let n = name.value
    if(n.length>=1) {
    }else {
        n = name.value;
        name.focus();
    }

});

email.addEventListener("blur", function(){
    let e = email.value
    if(e.length>=1) {
    }else {
        e = email.value;
        email.focus();
    }

});

phone.addEventListener("blur", function(){
    let p = phone.value
    if(p.length>=1) {
    }else {
        p = phone.value;
        phone.focus();
    }
});


}

    




