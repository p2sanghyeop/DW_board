<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/resources/static/css/login.css" />
    <title>게시판 로그인</title>
  </head>
  <body>
    <div class="container">
      <h1>Login</h1>
      <div class="login-form">
        <div class="txt-field">
          <input id="userId" type="text" required />
          <label>이름</label>
        </div>
        <div class="txt-field">
          <input id="userPassword" type="password" required />
          <label>비밀번호</label>
        </div>
        <input id="loginbtn" class="login-btn" type="butten" value="로그인" />
        <div class="signup-link">회원이 아닌가요? <a href="/join">회원가입</a></div>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script>
     
      $("#loginbtn").click(function(){
      var userId = $("#userId").val()
      var userPassword = $("#userPassword").val()
       if(userId == ''){
         alert('아이디를 입력해주세요')
         return 0;
       }
       if(userPassword == ''){
         alert('비밀번호를 입력해주세요')
         return 0;
       }
       var jsonData = {
        studentsName : userId,
        studentsPassword : userPassword
        }   
      $.ajax({
        url : '/api/v1/login',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
          console.log(response)
          if(response){
            location.href = '/board';//페이지 이동
          }
          else{
            alert('비밀번호혹은 이름이 틀렸습니다')
          }
        }
      })
      })    
   </script>
  </body>
</html>