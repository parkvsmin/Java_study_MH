const b1 = document.querySelector("#b1");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");

getCommentList();

b1.addEventListener("click", function(){

    
    let bookNum = b1.getAttribute("data-booknum");
    let wv = writer.value;
    let cv = contents.value;

    //-----ajax-----
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method URL 준비
    xhttp.open("POST","./commentAdd"); //POST

    //3. Enctype
    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 파라미터 전송 요청 발생 (메서드 post일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200) {
            let result = xhttp.responseText.trim();
            console.log(result.result)
            result = JSON.parse(result);
            writer.value="";
            contents.value="";

            if(result.result==1) {
                alert("댓글등록성공");
                getCommentList();
            }
        }
    }

}); //click Event 끝

function getCommentList(){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method URL 준비
    xhttp.open("GET","./commentList?page=1&bookNum=4888"); // GET

    //3. 요청 전송 enctype x
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4 && xhttp.status==200) {
            console.log(xhttp.responseText);
            //1. jsp 사용한 결과물
            //commentList.innerHTML=xhttp.responseText.trim();

            //2. JSON 결과물
            let ar = JSON.parse(xhttp.responseText.trim());
            for(let i=0;i<ar.length;i++){
                console.log(ar[i]);
                console.log(ar[i].contents);
                console.log(ar[i].writer);
            }

            
            let result = document.createElement("table")
            let resultAttr = document.createAttribute("class")
            resultAttr.value="table table-dark table-striped"; //<table class= ""
            result.setAttributeNode(resultAttr);

            for(let i=0;i<ar.length;i++) {
                let tr = document.createElement("tr")

                let td = document.createElement("td")
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                result.appendChild(tr);

            }
            commentList.append(result);

        }
    })
    
}