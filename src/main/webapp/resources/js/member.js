function loginCheck() {

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

const passWord = document.getElementsById("passWord");
const passwordResult = document.getElementById("passwordResult");

const passwordCheck = document.getElementById("passwordCheck");
const pwResult = document.getElementById("pwResult");

const name = document.getElementsById("name");
const nameResult = document.getElementById("nameResult");

const email = document.getElementsById("email");
const emailResult = document.getElementById("emailResult");

const phone = document.getElementsById("phone");
const phoneResult = document.getElementById("phoneResult");

userName.addEventListener("blur", function(){

    if(userName.value.length>1) {
        userNameResult.innerHTML="";
        idCheck=true;
    }else {
        idCheck=false;
        userNameResult.innerHTML="최소 2글자 이상 입력";
    }


});


passWord.addEventListener("change", function(){
    if(passWord.value.length>5) {
        pwCheck=true;
        passwordResult.innerHTML="";
        pwResult.value="";
    }else {
        pwCheck=false;
        passwordResult.innerHTML="최소 6글자 이상";
    }


});
//pw 같은지 확인
passwordCheck.addEventListener("blur", function(){
    if(passWord.value == passwordCheck.value) {
        pwEqualCheck=true;
        pwResult.innerHTML="일치";

    }else {
        pwEqualCheck=false;
        passwordCheck.value="";
        pwResult.innerHTML="불일치";
    }


});

name.addEventListener("blur", function(){
    if(name.value.length>1) {
        nameCheck=true;
        nameResult.innerHTML="";

    }else {
        nameResult.innerHTML="2글자 이상";
        nameCheck=false;
    }

});

email.addEventListener("blur", function(){
    if(email.value.length>1) {
        emailCheck=true;
        emailResult.innerHTML="";
    }else {
        emailResult.innerHTML="2글자 이상";
        emailCheck=false;
    }
 
});

phone.addEventListener("blur", function(){
    if(phone.value.length>1) {
        phoneCheck=true;
        phoneResult.innerHTML="";
    }else {
        phoneResult.innerHTML="2글자 이상";
        phoneCheck=false;
    }

});


} //joinCheck 끝

    




