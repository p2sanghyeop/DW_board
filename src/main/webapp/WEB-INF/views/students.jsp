<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
                    <label for="studentsName">íì ì´ë¦ : </label>
                    <input id="studentsName" type="text" placeholder="ì´ë¦ì ìë ¥íì¸ì...">
                </div>
                <div class="input-box">
                    <label for="studentsPassword">íì ë¹ë°ë²í¸ : </label>
                    <input id="studentsPassword" type="text" placeholder="ë¹ë°ë²í¸ë¥¼ ìë ¥íì¸ì...">
                </div>
                <div class="btn-area">
                    <a href="#" class="btn-cancel">ì·¨ì</a>
                    <a id="studentsSubmit" href="#" class="btn-success">ë±ë¡</a>
                </div>
            </div>
        </div>
        <!-- íì ì ë³´ ìì  -->
        <div class="update-popup">
            <div class="editor">
                <div class="close">
                    <a href="#" class="btn-close">ë«ê¸°</a>
                </div>
                <div class="input-box">
                    <label for="studentsId">íì ìì´ë : </label>
                    <input id="studentsId" type="text" placeholder="ìì´ë ìë ¥íì¸ì...">
                </div>
                <div class="input-box">
                    <label for="studentsName">íì ì´ë¦ : </label>
                    <input id="upt-studentsName" type="text" placeholder="ì´ë¦ì ìë ¥íì¸ì...">
                </div>
                <div class="input-box">
                    <label for="studentsPassword">íì ë¹ë°ë²í¸ : </label>
                    <input id="upt-studentsPassword" type="text" placeholder="ì´ë¦ì ìë ¥íì¸ì...">
                </div>
                <div class="btn-area">
                    <input id="studentsIdHidden" type="hidden">
                    <a id="contentUpdate" href="#" class="btn-update">ìì </a>
                    <a id="contentDelete" href="#" class="btn-delete">ì­ì </a>
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
                        <span class="title" onclick="goPage(dashboard)">Dashboard</span>                
                    </a>
                </li>
                <li>
                    <a href="/students">
                        <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                        <span class="title" onclick="goPage(students)">Students</span>                
                    </a>
                </li>
                <li>
                    <a href="/logs">
                        <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                        <span class="title" onclick="goPage(logs)">Logs</span>                
                    </a>
                </li>
                <li>
                    <a href="#">
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
                <!-- toggleì ëì¤ì ë§ë¤ê¸° -->
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <!-- search -->
            <div class="search">
                <label>
                    <input id="searchBar" type="text" placeholder="íìì´ë¦ì ê²ìíì¸ì..." >
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
                     <h2>íì ëªë¨</h2>
                     <a href="#" class="btn">íì ì¶ê°</a>
                 </div>
                 <table>
                     <thead>
                         <tr>
                            <th>íì ìì´ë</th>
                            <th>íì ì´ë¦</th>
                            <th>ê°ì ë ì§</th>
                        </tr>
                     </thead>
                     <tbody id="boardData">
                         <!-- <tr>
                             <td>hyunsangwon</td>
                             <td>íìì</td>
                             <td>2022-05-19</td>
                         </tr>
                         <tr>
                            <td>hyunsangwon</td>
                            <td>íìì</td>
                            <td>2022-05-19</td>
                        </tr>
                        <tr>
                            <td>hyunsangwon</td>
                            <td>íìì</td>
                            <td>2022-05-19</td>
                        </tr> -->
                     </tbody>
                 </table>
                 <div class="pagination">
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
    //íì´ì§ë° ê²ìí ë¦¬ì¤í¸ í¸ì¶
    function getStudentsList(pageNum, pageSize){
        $.ajax({
             url : 'http://localhost:8080/api/v1/students/map?pageNum='+pageNum+'&pageSize='+pageSize,
             type : 'GET',
             dataType : 'json',
            success : function(response){
                console.log(response)
                var html =''
                if(response.list.length>0){
                    for(var i=0; i<response.list.length; ++i){
                        html += '<tr onclick="getStudents('+response.list[i].studentsId+')"><td>'+response.list[i].studentsId+'</td><td>'+response.list[i].studentsName+'</td><td>'+response.list[i].createAt +'</td></tr>'
                    }
                    
                    var paginationHtml = '';
                    if(response.hasPreviousPage){ //ì´ì  íì´ì§ê° true ë¼ë©´
                        paginationHtml += '<a onclick="getStudentsList('+(response.pageNum-1)+','+pageSize+')" href="#">Previous</a>';
                    }
                    for(var i=0; i<response.navigatepageNums.length; i++){ //íì´ì§ ë²í¸ ê¸¸ì´ ë§í¼ forë¬¸ ì¤í
                        paginationHtml += '<a id="pageNum'+response.navigatepageNums[i]+'"onclick="getStudentsList('+response.navigatepageNums[i]+','+pageSize+')"href="#">'+response.navigatepageNums[i]+'</a>';
                    }
                    if(response.hasNextPage){ //ë¤ì íì´ì§ê° true ë¼ë©´
                        paginationHtml += '<a onclick="getStudentsList('+(response.pageNum+1)+','+pageSize+')" href="#">Next</a>';
                    }
                    $('.pagination').children().remove()
                    $('.pagination').append(paginationHtml);
                    //íì´ì§ ë²í¸ì ë§ê² css ìì 
                    $('#pageNum'+pageNum).css('backgroundColor','#287bff')
                    $('#pageNum'+pageNum).css('color','#fff')
                }
                
                else{
                    html += '<tr><td colspan=3 style="text-align: center;">íìì´ ììµëë¤</td></tr>'
                }
                $('#boardData').children().remove()
                $('#boardData').append(html)
            },
         })
    }
    getStudentsList(1,10);


    function getRearch(pageNum,pageSize){
        $('#searchBar').keyup(function(key){
            //ìí°ë¥¼ ëë¥¼ë ì¶ë ¥ hello wordë¥¼ ì¶ë ¥íê³  ì¶ì
            //13ì ìí°ìë¯¸
            if(key.keyCode ==13){
                //1. input ê° ê°ì ¸ì´
                var search = $('#searchBar').val();//inpuì ìì±í ìì±ìë¥¼ ê°ì ¸ì´
                console.log(search)
                //2. ajax í¸ì¶
                $.ajax({
            url : 'http://localhost:8080/api/v1/students/search?studentsName='+search+'&pageNum='+pageNum+'&pageSize='+pageSize,
            type : 'GET',
            dataType : 'json',
            success : function(response){
                console.log(response)
                var html ='';
                if(response.list.length>0){
                    for(var i=0; i<response.list.length; ++i){             
                        html += '<tr onclick="getStudents('+response.list[i].studentsId+')"><td>'+response.list[i].studentsId+'</td><td>'+response.list[i].studentsName+'</td><td>'+response.list[i].createAt+'</td></tr>'
                    }
                    var paginationHtml = '';
                    if(response.hasPreviousPage){ //ì´ì  íì´ì§ê° true ë¼ë©´
                        paginationHtml += '<a onclick="getSearchList('+(response.pageNum-1)+','+pageSize+')" href="#">Previous</a>';
                    }
                    for(var i=0; i<response.navigatepageNums.length; i++){ //íì´ì§ ë²í¸ ê¸¸ì´ ë§í¼ forë¬¸ ì¤í
                        paginationHtml += '<a id="pageNum'+response.navigatepageNums[i]+'"onclick="getSearchList('+response.navigatepageNums[i]+','+pageSize+')"href="#">'+response.navigatepageNums[i]+'</a>';
                    }
                    if(response.hasNextPage){ //ë¤ì íì´ì§ê° true ë¼ë©´
                        paginationHtml += '<a onclick="getSearchList('+(response.pageNum+1)+','+pageSize+')" href="#">Next</a>';
                    }
                    $('.pagination').children().remove()
                    $('.pagination').append(paginationHtml);
                    //íì´ì§ ë²í¸ì ë§ê² css ìì 
                    $('#pageNum'+pageNum).css('backgroundColor','#287bff')
                    $('#pageNum'+pageNum).css('color','#fff')
                }
                else{
                    html += '<tr><td colspan=3 style="text-align: center;">íìì´ ììµëë¤</td></tr>'
                }
                $('#boardData').children().remove()
                $('#boardData').append(html)
            },
        })
            }
        })
    }
    getRearch(1,10)

    function getSearchList(pageNum, pageSize){
        var search = $('#searchBar').val();
       $.ajax({
           url : 'http://localhost:8080/api/v1/students/search?studentsName='+search+'&pageNum='+pageNum+'&pageSize='+pageSize,
           type : 'GET',
           dataType : 'json',
           success : function(response){
               console.log(response)
               var html ='';
               if(response.list.length>0){
                   for(var i=0; i<response.list.length; ++i){             
                       html += '<tr onclick="getStudents('+response.list[i].studentsId+')"><td>'+response.list[i].studentsId+'</td><td>'+response.list[i].studentsName+'</td><td>'+response.list[i].createAt+'</td></tr>'
                   }
                   var paginationHtml = '';
                   if(response.hasPreviousPage){ //ì´ì  íì´ì§ê° true ë¼ë©´
                       paginationHtml += '<a onclick="getSearchList('+(response.pageNum-1)+','+pageSize+')" href="#">Previous</a>';
                   }
                   for(var i=0; i<response.navigatepageNums.length; i++){ //íì´ì§ ë²í¸ ê¸¸ì´ ë§í¼ forë¬¸ ì¤í
                       paginationHtml += '<a id="pageNum'+response.navigatepageNums[i]+'"onclick="getSearchList('+response.navigatepageNums[i]+','+pageSize+')"href="#">'+response.navigatepageNums[i]+'</a>';
                   }
                   if(response.hasNextPage){ //ë¤ì íì´ì§ê° true ë¼ë©´
                       paginationHtml += '<a onclick="getSearchList('+(response.pageNum+1)+','+pageSize+')" href="#">Next</a>';
                   }
                   $('.pagination').children().remove()
                   $('.pagination').append(paginationHtml);
                   //íì´ì§ ë²í¸ì ë§ê² css ìì 
                   $('#pageNum'+pageNum).css('backgroundColor','#287bff')
                   $('#pageNum'+pageNum).css('color','#fff')
               }
               else{
                   html += '<tr><td colspan=3 style="text-align: center;">íìì´ ììµëë¤</td></tr>'
               }
               $('#boardData').children().remove()
               $('#boardData').append(html)
           },
       })
           }
       
   getSearchList(1,10)
    //íìì¶ê°
    $('#studentsSubmit').click(function(){
        if(confirm('íìì ì¶ê°íìê² ìµëê¹?')){
        var studentsName = $('#studentsName').val();
        var studentsPassword = $('#studentsPassword').val()
        if(studentsName == ''){
            alert('ì´ë¦ìë ¥')
            return 0;
        }
        if(studentsPassword == ''){
            alert('ë¹ë°ë²í¸ìë ¥')
            return 0;
        }
        jsondata = {
            studentsName : studentsName,
            studentsPassword : studentsPassword
        }
        $.ajax({
        url : 'http://localhost:8080/api/v1/students',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsondata),
        success : function(response){
          console.log(response)
          if(response>0){
            $('.write-popup').css('display', 'none');
            $('#studentsName').val('');
            $('#studentsPassword').val('');
            $('#boardData').children().remove();
            getStudentsList(1,10)
            
                }
            }     
        })
    }

        });
    //í´ë¦­í ê²ìë¬¼ íì¸
    function getStudents(studentsId){
        console.log(studentsId)
        $('.update-popup').css('display', 'block')
        $.ajax({
            url : 'http://localhost:8080/api/v1/students/id/number/'+studentsId,
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

     //ê²ìë¬¼ ìì íë í¨ì
     $('#contentUpdate').click(function(){
        //1. ê²ìí ë²í¸ íì¸ 
        var studentsId = $('#studentsIdHidden').val()
        //2. jsonìì±
        var studentsName = $('#upt-studentsName').val()
        var studentsPassword = $('#upt-studentsPassword').val()
        var jsondata = {
            studentsId : studentsId,
            studentsName : studentsName,
            studentsPassword : studentsPassword
        }
        //3. ajax
        $.ajax({
        url : 'http://localhost:8080/api/v1/students/id/'+studentsId,
        type : 'PATCH',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsondata),
        success : function(response){
            if(response>0){
                alert('ìì ìë£')
                $('.update-popup').css('display', 'none')
                location.reload();
            }

        }
        
        })
    })

    //ê²ìë¬¼ ì­ì 
    $('#contentDelete').click(function(){
        if(confirm('íììì­ì íìê² ìµëê¹')){
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
            url : 'http://localhost:8080/api/v1/students/id/'+studentsId,
            type : 'DELETE',
            contentType : 'application/json',
            dataType : 'json',
            data : JSON.stringify(jsondata),
            success : function(response){
                    alert('ì­ì ìë£')
                    $('.update-popup').css('display', 'none')
                    $('#boardData').children().remove();
                    $('#studentsName').val('');
                    $('#studentsPassword').val('');
                    getStudentsList(1,10)
            }
            
        })
        }
    })
</script>
</html>