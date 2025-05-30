<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>극장 메인 페이지</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: #f9f9f9;
	margin: 0;
	padding: 0;
	color: #333;
}

h1 {
	text-align: center;
	background-color: #222;
	color: #fff;
	padding: 20px;
	margin: 0;
}

/* 헤더 */
header {
	background-color: #222;
	padding: 10px 0;
}

header nav {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 20px;
}

header a {
	color: #fff;
	text-decoration: none;
	font-size: 1.2em;
	padding: 10px 20px;
	border-radius: 6px;
	background-color: #005f99;
	transition: background-color 0.3s ease;
}

header a:hover {
	background-color: #003f66;
}

/* 로그인 상태 메시지 */
.login-status {
	text-align: center;
	margin-top: 20px;
	font-size: 1.2em;
}

/* 주요 콘텐츠 영역 (메인) */
main {
	padding: 40px 20px;
	text-align: center;
}

main a {
	display: inline-block;
	margin-top: 20px;
	padding: 15px 25px;
	text-decoration: none;
	background-color: #005f99;
	color: white;
	border-radius: 6px;
	transition: background-color 0.3s ease;
}

main a:hover {
	background-color: #003f66;
}

/* 푸터 */
footer {
	background-color: #222;
	color: #fff;
	text-align: center;
	padding: 20px 0;
	position: fixed;
	width: 100%;
	bottom: 0;
}

/* 메뉴 바 (네비게이션 바) */
.navbar {
	background-color: #333;
	overflow: hidden;
	position: sticky;
	top: 0;
}

.navbar a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
	font-size: 18px;
	transition: background-color 0.3s ease;
}

.navbar a:hover {
	background-color: #575757;
}

.navbar a.active {
	background-color: #004080;
}

.movie-poster {
	text-align: center; /* 가운데 정렬 */
	margin: 20px;
}

.movie-poster img {
	border-radius: 8px; /* 이미지에 둥근 모서리 추가 */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 그림자 효과 */
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<header>
		<h1>Korea Movie</h1>
		<nav>
			<a href="/performanceList">영화 목록</a> <a href="/reserveList">예매 목록</a>
			<a href="/boardList">자유게시판</a> <a href="/eventList">이벤트(회원 전용)</a>
		</nav>
	</header>

	<!-- 로그인 상태 메시지 -->
	<div class="login-status">
		<c:choose>
			<c:when test="${not empty sessionScope.loginId}">
				<p>${sessionScope.loginName}님환영합니다!</p>
				<a href="/member/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<p>로그인이 필요합니다.</p>
				<a href="/member/login">로그인</a>
			</c:otherwise>
		</c:choose>
		<a href="/member/regist">회원가입</a>
	</div>

	<!-- 메인 콘텐츠 -->
	<main>
		<p>다양한 영화 및 예매 서비스를 이용하실 수 있습니다.</p>

		<!-- WEB-INF/views/example.jsp -->
		<div class="movie-poster">
			<h3>듄</h3>
			<img src="${pageContext.request.contextPath}/images/dune.jpg"
				alt="듄 포스터" width="200" height="300" />
		</div>
	</main>

	<!-- 푸터 -->
	<footer>
		<p>&copy; 2025 극장 홈페이지 | All Rights Reserved</p>
	</footer>

</body>
</html>