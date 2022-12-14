const b1 = document.querySelector("#b1");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");
const update = document.querySelector("#update");


//page 번호 담는 변수
let page=1; 
// bookNum을 담을 변수
const bookNum = b1.getAttribute("data-booknum");
getCommentList(page , bookNum);

b1.addEventListener("click", function(){

    
    //let bookNum = b1.getAttribute("data-booknum");
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
            result = JSON.parse(result);
            writer.value="";
            contents.value="";

            if(result.result==1) {
                alert("댓글등록성공");

                for(let i=0;i<commentList.children.length;) {
                    commentList.children[0].remove();
                }

                // if(commentList.children.length !=0) {
                //     commentList.children[0].remove();
                // }

                page=1;

                getCommentList(page, bookNum);
            }
        }
    }

}); //click Event 끝

function getCommentList(p, bn){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method URL 준비
    xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn); // GET

    //3. 요청 전송 enctype x
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4 && xhttp.status==200) {
            console.log(xhttp.responseText);
            //1. jsp 사용한 결과물
            //commentList.innerHTML=xhttp.responseText.trim();

            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // for(let i=0;i<ar.length;i++){
            //     console.log(ar[i]);
            //     console.log(ar[i].contents);
            //     console.log(ar[i].writer);
            // }

            
            // let result = document.createElement("table")
            // let resultAttr = document.createAttribute("class")
            // resultAttr.value="table table-success table-striped"; //<table class= ""
            // result.setAttributeNode(resultAttr);

            let pager = result.pager; //commentPager
            let ar = result.list;     //댓글리스트

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
                // //날짜 format변경
                // let date = new Date(ar[i].regDate);
                // console.log(date);
                // let year = date.getFullYear();
                // let month = date.getMonth()+1;
                // let d = date.getDate();
                // console.log(year);
                // console.log(month);
                // console.log(d);


                // tdText = document.createTextNode(year+"-"+month+"-"+d);

                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class")
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                tdAttr = document.createAttribute("data-commentnum");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class")
                tdAttr.value="delete";
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                
                tdAttr = document.createAttribute("data-commentnum");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage) {
                    more.classList.add("disabled");
                }else {
                    more.classList.remove("disabled");
                }

            }
            // console.log(result);
            // console.log(commentList.children);
            
            // let t = commentList.children;

            // if(t.length !=0) {
            //     commentList.children[0].remove();
            // }
            // try {
            //     console.log(commentList.children());
            //     throw new Error("에러");
            // }catch(exeception){

            // }finally {

            // }
            //commentList.append(result);

        }
    })
    
}

//------------------------------더보기------------------------------

more.addEventListener("click",function(){
    page++;
    //const bookNum = b1.getAttribute("data-booknum");

    getCommentList(page, bookNum);
})

//------------------------------수정 삭제------------------------------
//-----update-----
commentList.addEventListener("click",function(event){

    if(event.target.className=="update") {
        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // //console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML="<textarea>"+v+"</textarea>";
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-commentnum");
       
        document.querySelector("#updateContents").value=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#num").value=num;

        document.querySelector("#up").click();

    }


    //-----delete-----
    if(event.target.className=="delete") {
        let check = window.confirm("삭제할래???");
        if(check) {
            let num=event.target.getAttribute("data-commentnum");


            //1. XMLHTTPRequest
            const xhttp = new XMLHttpRequest();

            //2. 요청 정보
            xhttp.open("POST", "commentDelete");

            //3. Header
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 (파라미터와 함께)
            xhttp.send("num="+num);

            //5. 응답처리
            xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4 && xhttp.status==200) {
                    let result = xhttp.responseText.trim();
                    if(result==1) {
                        alert("삭제 성공");
                        page=1;

                        for(let i=0;i<commentList.children.length;) {
                            commentList.children[0].remove();
                        }

                        getCommentList(page, bookNum);
                    }else {
                        alert("삭제 실패");
                    }
                }
            }
        }
    }
})

//------------------------------Modal Update button------------------------------
update.addEventListener("click", function(){
    // modal 에서 num , contents 가져오기
    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;
    // XMLHTTPRequest 
    const xhttp = new XMLHttpRequest();
    // 요청 정보
    xhttp.open("POST", "commentUpdate"); //메서드 url
    // 요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // 요청 실행
    xhttp.send("num="+num+"&contents="+contents);
    // 응답 처리
    xhttp.onreadystatechange=function() {
        if(xhttp.readyState==4 && this.status==200) {
            let result = xhttp.responseText.trim();
            
            if(result>0) {
                alert("댓글 수정 성공!!!");

                for(let i=0;i<commentList.children.length;) {
                    commentList.children[0].remove();
                }

                page=1;

                getCommentList(page, bookNum)

            }else {
                alert("댓글 수정 실패!!!");
            }

        }
    }
})
