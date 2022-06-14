function getBoardList(pageNum, pageSize) {
	location.href = "/board?pageNum=" + pageNum + "&pageSize=" + pageSize;
}



/* function getSearchList(pageNum, pageSize){
	var search = $('#searchBar').val().trim();
	$('#keyword').val(search);
	var keyword = $('#keyword').val(); 
	location.href="/board/search?writer="+keyword+"&pageNum="+pageNum+"&pageSize="+pageSize;
} */

function getFindList(writer, pageNum, pageSize) {
	location.href = "/board/search?writer=" + writer + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
}

function getPageNum() {
	var pageNum = $('#nowPageNum').val();
	$('#pageNum' + pageNum).css('backgroundColor', '#287bf4')
	$('#pageNum' + pageNum).css('color', '#fff')
}
getPageNum()

function getBoard(boardId) {
	console.log(boardId)
	$('.update-popup').css('display', 'block')
	//ajax작성
	$.ajax({
		url: '/api/v1/board/boardid/' + boardId,
		type: 'GET',
		dataType: 'json',
		success: function(response) {
			console.log(response);
			//input에 date set 해주기
			$('#upt-title').val(response.title)
			$('#upt-content').val(response.content)
			$('#boardIdHidden').val(response.boardId)
			setBoardViews(boardId) //조회수 함수
		}
	})
}


function setBoardViews(boardId) {//게시판번호 증가함수
	$.ajax({
		url: '/api/v1/board/views/boardid/' + boardId,
		type: 'PATCH',
		dataType: 'json',
		success: function(response) {
			if (response > 0) {
				//추후로직예정
				//$('#boardData').children().remove();//tbody id
				// getBoardList(1,10);
			}
		}

	})
};

$('#contentSubmit').click(function() {
	if (confirm('게시글을 작성하시겠습니까?')) {
		var studentsName = $('#studentsName').val();
		var title = $('#title').val();
		var content = $('#content').val();
		var studentsId = $('#studentsId').val();
		if (title == '') {
			alert('제목입력')
			return 0;
		}
		if (content == '') {
			alert('내용작성')
			return 0;
		}
		jsondata = {
			studentsId: studentsId,
			title: title,
			content: content
		}

		$.ajax({
			url: '/api/v1/board',
			type: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(jsondata),
			success: function(response) {
				console.log(response)
				if (response > 0) {
					var pageNum = $('#nowPageNum').val();
					getBoardList(pageNum, 10);
				}
			}
		})
	}
});

$('#contentUpdate').click(function() {
	//1. 게시판 번호 확인 
	var boardId = $('#boardIdHidden').val()//hidden에 숨겨운 boardId가져오기
	//2. json생성
	var title = $('#upt-title').val()
	var content = $('#upt-content').val()
	var jsondata = {
		boardId: boardId,
		title: title,
		content: content
	}
	//3. ajax
	$.ajax({
		url: '/api/v1/board/boardid/' + boardId,
		type: 'PATCH',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(jsondata),
		success: function(response) {
			if (response > 0) {
				alert('수정완료')
				$('.update-popup').css('display', 'none');
				var pageNum = $('#nowPageNum').val();
				getBoardList(pageNum, 10);
			}

		}

	})
})

//게시물 삭제
$('#contentDelete').click(function() {
	var boardId = $('#boardIdHidden').val()
	var title = $('#upt-title').val()
	var content = $('#upt-content').val()
	var jsondata = {
		boardId: boardId,
		title: title,
		content: content
	}

	$.ajax({
		url: '/api/v1/board/boardid/' + boardId,
		type: 'DELETE',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(jsondata),
		success: function(response) {
			alert('삭제완료')
			var pageNum = $('#nowPageNum').val();
			getBoardList(pageNum, 10);
		}

	})
})

function getBoardStartList() {
	$.ajax({
		url: '/api/v1/board/startlist',
		type: 'GET',
		dataType: 'json',
		success: function(response) {
			//text() or html() input을 제회한 태그를 컨트롤 할때 사용
			//val()은 input 컨트롤할때 사용
			console.log(response)
			$('#boardcnt').text(response.boardcnt)
			$('#studentscnt').text(response.studentscnt)
			$('#writecnt').text(response.writecnt)
			$('#viewcnt').text(response.viewcnt)
		}

	})
}
getBoardStartList()





$('#searchBar').keyup(function(key) {
	var pageSize = 10;
	var pageNum = 1;
	if (key.keyCode == 13) {
		var search = $('#searchBar').val().trim();//input에 작성한 작성자를 가져옴
		if (search != '') {
			location.href = "/board/search?writer=" + search + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
		}
	}
});
