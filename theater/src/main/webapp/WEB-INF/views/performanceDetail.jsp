<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>performanceDetail Page</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
    color: #333;
}

/* 컨테이너 스타일 */
.container {
    width: 80%;
    max-width: 900px;
    margin: 20px auto;
    padding: 30px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 제목 스타일 */
h2 {
    font-size: 28px;
    color: #333;
    margin-bottom: 15px;
    text-align: center;
}

h3 {
    font-size: 22px;
    color: #333;
    margin-bottom: 10px;
}

/* 설명 및 상태 텍스트 */
p {
    font-size: 16px;
    margin-bottom: 10px;
}

/* 예매 및 후기 작성 폼 */
form {
    margin-bottom: 20px;
}

button, select, textarea, input[type="text"], input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

/* 예매 링크 스타일 */
a {
    font-size: 18px;
    color: #4CAF50;
    text-decoration: none;
    padding: 10px;
    border: 2px solid #4CAF50;
    border-radius: 5px;
}

a:hover {
    background-color: #4CAF50;
    color: white;
}

/* 리뷰 목록 스타일 */
.review-list {
    margin-top: 20px;
    font-size: 16px;
    line-height: 1.6;
}

.review-list p {
    background-color: #f1f1f1;
    padding: 10px;
    border-radius: 5px;
    margin-bottom: 10px;
}

/* 홈으로 링크 스타일 */
a[href="/"] {
    display: inline-block;
    margin-top: 20px;
    font-size: 16px;
    text-align: center;
    color: #005f99;
}

a[href="/"]:hover {
    text-decoration: underline;
    color: #003d66;
}
</style>
</head>
<body>

	<div class="container">
    <h2>${performance.title}</h2>
    <p>${performance.description}</p>
    <p>상태: ${performance.status}</p>

    <c:if test="${sessionScope.loginId != null}">
        <!-- 예매 폼 -->
        <form action="/reserve" method="post">
            <input type="hidden" name="pid" value="${performance.pid}" />
            <input type="hidden" name="showTitle" value="${performance.showTitle}" />
            <a href="/reserveForm?pid=${performance.pid}">영화 예매하러 가기</a>
        </form>
	
        <!-- 후기 작성 폼 -->
        <h3>다른분들에게 후기를 알려주세요 😊</h3>
        <form action="/review" method="post">
            <input type="hidden" name="pid" value="${performance.pid}">
            별점: <select name="rating">
                <option value="5">★★★★★</option>
                <option value="4">★★★★☆</option>
                <option value="3">★★★☆☆</option>
                <option value="2">★★☆☆☆</option>
                <option value="1">★☆☆☆☆</option>
            </select><br> 댓글:<br>
            <textarea name="rcomment" rows="3" cols="50"></textarea>
            <br>
            <button type="submit">작성</button>
        </form>
    </c:if>
    <hr>
    <!-- 리뷰 목록 -->
    <h3>리뷰 목록</h3>
    <div class="review-list">
        <c:forEach var="rev" items="${reviewList}">
            <p>[${rev.rating}점] ${rev.rcomment} - ${rev.mid}</p>
        </c:forEach>
    </div>
	<a href="/performanceList">뒤로가기</a>
    <a href="/">홈으로</a>
</div>
</body>
</html>