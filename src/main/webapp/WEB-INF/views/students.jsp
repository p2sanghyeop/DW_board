<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/resources/static/css/board.css">
</head>
<body>
    <div class="container">
        <div class="write-popup">
            <div class="editor">
                <div class="input-box">
                    <label for="studentsName">학생 이름 : </label>
                    <input id="studentsName" type="text" placeholder="이름을 입력하세요...">
                </div>
                <div class="input-box">
                    <label for="studentsPassword">학생 비밀번호 : </label>
                    <input id="studentsPassword" type="text" placeholder="비밀번호를 입력하세요...">
                </div>
                <div class="btn-area">
                    <a href="#" class="btn-cancel">취소</a>
                    <a id="studentsSubmit" href="#" class="btn-success">등록</a>
                </div>
            </div>
        </div>
        <!-- 학생 정보 수정 -->
        <div class="update-popup">
            <div class="editor">
                <div class="close">
                    <a href="#" class="btn-close">닫기</a>
                </div>
                <div class="input-box">
                    <label for="studentsId">학생 아이디 : </label>
                    <input id="studentsId" type="text" placeholder="아이디 입력하세요...">
                </div>
                <div class="input-box">
                    <label for="studentsName">학생 이름 : </label>
                    <input id="upt-studentsName" type="text" placeholder="이름을 입력하세요...">
                </div>
                <div class="input-box">
                    <label for="studentsPassword">학생 비밀번호 : </label>
                    <input id="upt-studentsPassword" type="text" placeholder="이름을 입력하세요...">
                </div>
                <div class="btn-area">
                    <input id="studentsIdHidden" type="hidden">
                    <a id="contentUpdate" href="#" class="btn-update">수정</a>
                    <a id="contentDelete" href="#" class="btn-delete">삭제</a>
                </div>
            </div>
        </div>
        <div class="navigation">
            <ul>
                <li>
                    <a href="#">
                        <span class="icon"><ion-icon name="logo-apple"></ion-icon></span>
                        <span class="title">DW Board</span>                
                    </a>
                </li>
                <li>
                    <a href="/board?pageNum=1&pageSize=10">
                        <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
                        <span class="title">Dashboard</span>                
                    </a>
                </li>
                <li>
                    <a href="/students?pageNum=1&pageSize=10">
                        <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                        <span class="title">Students</span>                
                    </a>
                </li>
                <li>
                    <a href="/logs?&pageNum=1&pageSize=10">
                        <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                        <span class="title">Logs</span>                
                    </a>
                </li>
                <li>
                    <a href="/logout">
                        <span class="icon"><ion-icon name="log-out-outline"></ion-icon></span>
                        <span class="title">Sign Out</span>                
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- main -->
    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <!-- toggle은 나중에 만들기 -->
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <!-- search -->
            <div class="search">
                <label>
                    <input id="searchBar" type="text" placeholder="학생이름을 검색하세요..." >
                </label>
            </div>
            <div>
                <a href="#" class="logout">Logout</a>
            </div>
        </div>
         <!-- table -->
         <div class="details">
             <div class="recentOrders">
                 <div class="cardHeader">
                     <h2>학생 명단</h2>
                     <a href="#" class="btn">학생 추가</a>
                 </div>
                 <table>
                     <thead>
                         <tr>
                            <th>학생 아이디</th>
                            <th>학생 이름</th>
                            <th>가입 날짜</th>
                        </tr>
                     </thead>
                     <tbody id="boardData">
                     	    <c:choose>
	                     	<c:when test="${fn:length(pageHelper.list)>0}">
                     				<c:forEach items="${pageHelper.list}" var="page">
				                     	<tr onclick="getStudents(${page.studentsId})">
				                     		<td>${page.studentsId}</td>
				                     		<td>${page.studentsName}</td>
				                     		<td>${page.createAt}</td>			                  
										</tr>
									</c:forEach>
							</c:when>
	                     	<c:otherwise>
	                     	<tr><td colspan=3 style="text-align: center;">학생이 없습니다</td></tr>
							</c:otherwise>          	
					</c:choose>
                         <!-- <tr>
                             <td>hyunsangwon</td>
                             <td>현상원</td>
                             <td>2022-05-19</td>
                         </tr>
                         <tr>
                            <td>hyunsangwon</td>
                            <td>현상원</td>
                            <td>2022-05-19</td>
                        </tr>
                        <tr>
                            <td>hyunsangwon</td>
                            <td>현상원</td>
                            <td>2022-05-19</td>
                        </tr> -->
                     </tbody>
                 </table>
                 <div class="pagination">
                 <c:if test="${path eq '/students'}">
                 <c:if test="${pageHelper.hasPreviousPage}">
                 		<a onclick="getStudentsList(${pageNum-1},10)">Previous</a>
					</c:if>
                 	<c:forEach begin="${pageHelper.navigateFirstPage}" end="${pageHelper.navigateLastPage}" var="pageNum">
                 		<a id="pageNum${pageNum}" onclick="getStudentsList(${pageNum},10)">${pageNum}</a>
					</c:forEach>
					<c:if test="${pageHelper.hasNextPage}">
						<a onclick="getStudentsList(${pageNum+1},10)">Next</a>
					</c:if>
                 </c:if>
					<c:if test="${path eq '/students/search'}">
						<c:if test="${pageHelper.hasPreviousPage}">
	                 		<a onclick="getFindList('${param.writer}', ${pageNum-1}, 10)">Previous</a>
						</c:if>
	                 	<c:forEach begin="${pageHelper.navigateFirstPage}" end="${pageHelper.navigateLastPage}" var="pageNum">
	                 		<a id="pageNum${pageNum}" onclick="getFindList('${param.writer}',${pageNum},10)">${pageNum}</a>
						</c:forEach>
						<c:if test="${pageHelper.hasNextPage}">
							<a onclick="getFindList('${param.writer}',${pageNum+1},10)">Next</a>
						</c:if>
					</c:if>
                    <input id="nowPageNum" type="hidden" value="${pageHelper.pageNum}">
                    <!-- <a href="#">Previous</a>
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">Next</a> -->
                 </div>
             </div>
         </div>
    </div>
</body>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
<script>
    let list = document.querySelectorAll('.navigation li');
    function activeLink(){
        list.forEach((item) => {item.classList.remove('hovered')});
        this.classList.add('hovered');
    }
    list.forEach((item) => {item.addEventListener('mouseover',activeLink)});

</script>
<script>
    $('.btn').click(function(){
        $('.write-popup').css('display', 'block');
    });
    $('.btn-cancel').click(function(){
        $('.write-popup').css('display', 'none');
    });
    $('.btn-close').click(function(){
        $('.update-popup').css('display', 'none');
    })
</script>
<script>
	function getStudentsList(pageNum, pageSize){
		location.href = "/students?pageNum="+pageNum+"&pageSize="+pageSize;
	}
	
	function getFindList(writer, pageNum, pageSize){
		location.href="/students/search?writer="+writer+"&pageNum="+pageNum+"&pageSize="+pageSize;
	}
	
	function getPageNum(){
		var pageNum = $('#nowPageNum').val();
		$('#pageNum'+pageNum).css('backgroundColor', '#287bf4')
		$('#pageNum'+pageNum).css('color', '#fff')
	}
	getPageNum()
	
	//학생 조회	
	function getStudents(studentsId){
        console.log(studentsId)
        $('.update-popup').css('display', 'block')
        $.ajax({
            url : '/api/v1/students/id/number/'+studentsId,
            type : 'GET',
            dataType : 'json',
            success : function(response){
                $('#studentsId').val(response.studentsId)
                $('#studentsIdHidden').val(response.studentsId)
                $('#upt-studentsName').val(response.studentsName)
                $('#upt-studentsPassword').val(response.studentsPassword)
            }
        })
    }
	
	 //학생 수정
    $('#contentUpdate').click(function(){
       //1. 게시판 번호 확인 
       var studentsId = $('#studentsIdHidden').val()
       //2. json생성
       var studentsName = $('#upt-studentsName').val()
       var studentsPassword = $('#upt-studentsPassword').val()
       var jsondata = {
           studentsId : studentsId,
           studentsName : studentsName,
           studentsPassword : studentsPassword
       }
       //3. ajax
       $.ajax({
       url : '/api/v1/students/id/'+studentsId,
       type : 'PATCH',
       contentType : 'application/json',
       dataType : 'json',
       data : JSON.stringify(jsondata),
       success : function(response){
           if(response>0){
               alert('수정완료')
               $('.update-popup').css('display', 'none')
               location.reload();
           }

       }
       
       })
   })
   
       //게시물 삭제
    $('#contentDelete').click(function(){
        if(confirm('학생을삭제하시겠습니까')){
            var studentsId = $('#studentsIdHidden').val()
            var studentsName = $('#upt-studentsName').val()
            var studentsPassword = $('#upt-studentsPassword').val()
            var jsondata = {
                studentsId :studentsId,
                studentsName :  studentsName,
                studentsPassword : studentsPassword
            }
            //3. ajax
            $.ajax({
            url : 'api/v1/students/id/'+studentsId,
            type : 'DELETE',
            contentType : 'application/json',
            dataType : 'json',
            data : JSON.stringify(jsondata),
            success : function(response){
                    alert('삭제완료')
                    $('.update-popup').css('display', 'none')
                    $('#boardData').children().remove();
                    $('#studentsName').val('');
                    $('#studentsPassword').val('');
                    getStudentsList(1,10)
            }
            
        })
        }
    })
    
    $('#searchBar').keyup(function(key){
        var pageSize = 10;
        var pageNum = 1;
        if(key.keyCode == 13){
            var search = $('#searchBar').val().trim();//input에 작성한 작성자를 가져옴
           	if(search != ''){
           		location.href="/students/search?writer="+search+"&pageNum="+pageNum+"&pageSize="+pageSize;	       	  	
           	}
        }
	});
</script>
</html>