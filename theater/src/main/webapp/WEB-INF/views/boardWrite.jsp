<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>글쓰기 화면</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    min-height: 100vh;
}

/* 컨테이너 스타일 */
.container {
    width: 70%;
    margin: 30px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 제목 스타일 */
h2 {
    font-size: 24px;
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

/* 폼 스타일 */
form {
    font-size: 16px;
    color: #333;
}

/* 입력 필드 스타일 */
input[type="text"], textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 16px;
}

/* 텍스트 영역 스타일 */
textarea {
    resize: vertical;
}

/* 제출 버튼 스타일 */
input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

/* 구분선 */
hr {
    margin-bottom: 20px;
}

/* 링크 스타일 */
a {
    color: #005f99;
    text-decoration: none;
    font-size: 16px;
}

a:hover {
    text-decoration: underline;
    color: #003d66;
}
</style>
</head>
<body>

<div class="container">
    <h2>게시글 작성</h2>
    <hr>
    <c:if test="${sessionScope.userId eq board.writer}">
    <form method="post" action="/boardWrite">
        제목: <input type="text" name="title" required><br>
        내용:<br>    
        <textarea name="content" rows="5" cols="30" required></textarea><br> 
        <input type="submit" value="작성">
    </form>
    </c:if>
</div>



</body>
</html>