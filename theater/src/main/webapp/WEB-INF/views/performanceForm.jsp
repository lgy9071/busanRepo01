<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 70%;
        margin: 0 auto;
        padding: 40px 0;
    }

    h2 {
        font-size: 2.5em;
        color: #2c3e50;
        text-align: center;
        margin-bottom: 30px;
    }

    form {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        margin: 0 auto;
    }

    form input[type="text"],
    form textarea,
    form select {
        width: 100%;
        padding: 10px;
        margin: 15px 0;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 1em;
        box-sizing: border-box;
    }

    form textarea {
        height: 150px;
    }

    form button {
        width: 100%;
        padding: 12px;
        background-color: #3498db;
        color: white;
        font-size: 1.2em;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    form button:hover {
        background-color: #2980b9;
    }

    .back-link {
        display: block;
        text-align: center;
        margin-top: 30px;
        font-size: 1.1em;
        color: #3498db;
        text-decoration: none;
    }

    .back-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <h2>공연 등록</h2>
    <form action="/addPerformance" method="post">
        <label for="title">제목:</label>
        <input type="text" name="title" id="title" placeholder="공연 제목을 입력하세요" required><br>

        <label for="description">설명:</label>
        <textarea name="description" id="description" placeholder="공연에 대한 설명을 입력하세요" required></textarea><br>

        <label for="status">상태:</label>
        <select name="status" id="status" required>
            <option value="상영 예정">상영 예정</option>
            <option value="상영 중">상영 중</option>
            <option value="종료">종료</option>
        </select><br>

        <button type="submit">등록</button>
    </form>
    <a href="/" class="back-link">홈으로 돌아가기</a>
</div>

</body>
</html>