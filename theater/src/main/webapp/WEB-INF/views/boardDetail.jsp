<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세 정보</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* 컨테이너 */
.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 헤더 스타일 */
h2 {
	font-size: 24px;
	color: #333;
	margin-bottom: 20px;
	text-align: center;
}

/* 게시글 내용 */
p {
	font-size: 16px;
	line-height: 1.6;
	margin: 10px 0;
	color: #333;
}

/* 목록으로 돌아가기 링크 스타일 */
a {
	color: #005f99;
	text-decoration: none;
	font-size: 16px;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
	color: #003d66;
}

.modal {
	display: none; /* 기본적으로 숨김 */
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4); /* 반투명 배경 */
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	color: #aaa;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	top: 5px;
	right: 10px;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<h2>게시글 상세 보기</h2>
		<hr>
		<p>번호: ${board.bno}</p>
		<p>제목: ${board.title}</p>
		<p>
			내용:<br>${board.content}</p>
		<p>작성자: ${board.writer}</p>

		<!-- 수정 버튼 (모달 창 열기) -->
		<button id="openModalBtn">수정하기</button>

		<!-- 모달 창 -->
		<div id="editModal" class="modal">
			<div class="modal-content">
				<span class="close" id="closeModalBtn">&times;</span>
				<c:if test="${sessionScope.userId eq board.writer}">
					<h3>게시글 수정</h3>
					<form method="post" action="/boardUpdate">
						<input type="hidden" name="bno" value="${board.bno}"> 제목:
						<input type="text" name="title" value="${board.title}" required><br>
						<br> 내용:<br>
						<textarea name="content" rows="5" cols="30" required>${board.content}</textarea>
						<br> <input type="submit" value="수정">
					</form>
				</c:if>
				<c:if test="${sessionScope.userId ne board.writer}">
					<!-- 작성자가 아니면 알림 표시 -->
				<div class="alert">본인 작성 글만 수정할 수 있습니다.</div>
		</c:if>
			</div>
		</div>
		<h4>삭제하기</h4>
		<!-- 삭제 버튼 -->
		<c:if test="${sessionScope.userId eq board.writer}">
			<form method="post" action="/boardDelete">
				<input type="hidden" name="bno" value="${board.bno}"> <input
					type="submit" value="삭제하기">
			</form>
		</c:if>
		<c:if test="${sessionScope.userId ne board.writer}">
			<!-- 작성자가 아니면 알림 표시 -->
			<div class="alert">본인 작성 글만 삭제할 수 있습니다.</div>
		</c:if>

		<!-- 모달 창 열기/닫기 제어 (JavaScript) -->
		<script>
			// 모달 열기 버튼
			var openModalBtn = document.getElementById("openModalBtn");
			// 모달 창
			var modal = document.getElementById("editModal");
			// 모달 닫기 버튼
			var closeModalBtn = document.getElementById("closeModalBtn");

			// 수정하기 버튼 클릭 시 모달 열기
			openModalBtn.onclick = function() {
				modal.style.display = "block";
			}

			// 모달 닫기 버튼 클릭 시 모달 닫기
			closeModalBtn.onclick = function() {
				modal.style.display = "none";
			}

			// 모달 외부 클릭 시 모달 닫기
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>
		<br> <a href="/boardList">목록으로</a>
	</div>

</body>
</html>