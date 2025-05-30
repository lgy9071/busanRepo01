<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    width: 80%;
    max-width: 800px;
    margin: 20px auto;
    padding: 30px;
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
    display: flex;
    flex-direction: column;
    gap: 20px;
}

/* 입력 필드 스타일 */
input[type="text"], input[type="date"], textarea {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
}

/* 텍스트 영역 스타일 */
textarea {
    resize: vertical;
    min-height: 100px;
}

/* 버튼 스타일 */
button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
    width: 200px;
    align-self: center;
}

button:hover {
    background-color: #45a049;
}

/* 링크 스타일 */
a {
    color: #005f99;
    text-decoration: none;
    font-size: 16px;
    display: block;
    text-align: center;
    margin-top: 20px;
}

a:hover {
    text-decoration: underline;
    color: #003d66;
}
</style>
</head>
<body>
<div class="container">
    <h2>이벤트 등록</h2>

    <form action="/insertEvent" method="post">
        <p>
            제목: <input type="text" name="title" value="5월 회원 할인 이벤트" required>
        </p>
        <p>
            내용: <textarea name="content" required>이벤트에 응모하면 추첨을 통해 영화 할인권을 드립니다!</textarea>
        </p>
        <p>
            시작일: <input type="date" name="start_date" required>
        </p>
        <p>
            종료일: <input type="date" name="end_date" required>
        </p>
        <button type="submit">이벤트 등록</button>
    </form>

    <a href="/eventList">이벤트 목록으로</a>
</div>
</body>
</html>