<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Regist Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 50%;
        margin: 50px auto;
        padding: 30px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #3498db;
        margin-bottom: 20px;
    }

    hr {
        border: 0;
        border-top: 1px solid #ccc;
        margin: 20px 0;
    }

    label {
        font-size: 1.2em;
        margin-bottom: 8px;
        display: inline-block;
        color: #333;
    }

    input[type="text"],
    input[type="password"],
    select,
    button {
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    input[type="text"],
    input[type="password"] {
        font-size: 1em;
    }

    button {
        background-color: #3498db;
        color: white;
        font-size: 1.2em;
        cursor: pointer;
        border: none;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #2980b9;
    }

    .result {
        color: #e74c3c;
        font-weight: bold;
    }

    .id-result,
    .pw-result {
        font-size: 0.9em;
        color: #e74c3c;
    }

    .hidden {
        display: none;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group span {
        font-size: 0.9em;
        color: #e74c3c;
    }

</style>
</head>
<body>
	<div class="container">
    <h2>회원가입</h2>
    <hr>
    <form action="/regist2" id="frm">
        <div class="form-group">
            <label for="id">사용할 아이디:</label>
            <input type="text" name="id" id="id" placeholder="아이디를 입력해주세요">
            <button type="button" onclick="idCheck()">아이디 중복 확인</button>
            <span id="idResult" class="id-result">-------------------------------</span>
        </div>
        <div class="form-group">
            <label for="pw">사용할 비밀번호:</label>
            <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요">
        </div>
        <div class="form-group">
            <label for="pwcheck">비밀번호 확인:</label>
            <input type="password" name="pwcheck" id="pwcheck" placeholder="비밀번호를 한 번 더 입력해주세요">
            <span id="pwResult" class="pw-result">-------------------------------</span>
        </div>
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" name="name" id="name" placeholder="이름을 입력해주세요">
        </div>
        <div class="form-group">
            <label for="grade">등급:</label>
            <input type="text" name="grade" id="grade" placeholder="등급을 입력해주세요">
        </div>
        <input type="hidden" id="hid" value="0"> <!--1이면 중복확인 필요 -->
        <input type="hidden" id="hpw" value="0"> <!--1이면 비밀번호 확인 필요 -->

        <button type="button" id="submitBtn">회원가입</button>
        <div id="result" class="result"></div>
    </form>
</div>
	
	<script>
	let idChecked = false;
	const frm = document.getElementById('frm');
	const hid = document.getElementById('hid');
	const hpw = document.getElementById('hpw');

	document.getElementById('id').addEventListener('input', function() {
		idChecked = false;
		hid.value = "0";
		document.getElementById('idResult').innerText = "아이디를 다시 확인해주세요.";
	});

	document.getElementById("submitBtn").addEventListener("click", function() {
		const id = document.getElementById('id').value;
		const pw = document.getElementById('pw').value;
		const pwcheck = document.getElementById('pwcheck').value;
		const name = document.getElementById('name').value;
		const grade = document.getElementById('grade').value;

		const idRegex = /^[a-zA-Z][a-zA-Z0-9]{7,}$/;
		const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+~`<>?:{}])[A-Za-z\d!@#$%^&*()_+~`<>?:{}]{8,}$/;

		if (!idRegex.test(id)) {
			document.getElementById('idResult').innerText = "아이디는 영문으로 시작하고 8자 이상이어야 합니다.";
			return;
		}
		
		if (hid.value !== "1") {
			alert("아이디 중복 확인을 해주세요.");
			return;
		}

		if (!pwRegex.test(pw)) {
			document.getElementById("pwResult").innerText = "비밀번호는 영문, 숫자, 특수문자를 포함한 8자 이상이어야 합니다.";
			hpw.value = "0";
			return;
		}
		
		if (pw !== pwcheck) {
			document.getElementById("pwResult").innerText = "비밀번호가 일치하지 않습니다.";
			hpw.value = "0";
			return;
		} else {
			document.getElementById("pwResult").innerText = "";
			hpw.value = "1";
		}

		if (hid.value === "1" && hpw.value === "1") {
			const params = new URLSearchParams();
			params.append("id", id);
			params.append("pw", pw);
			params.append("name", name);
			params.append("grade", grade);

			const xhr = new XMLHttpRequest();
			xhr.onload = function() {
				const response = xhr.responseText;
				document.getElementById("result").innerHTML = response;

				if (response.includes("회원가입 성공")) {
					setTimeout(() => {
						window.location.href = "list";
					}, 2000);
				}
			};
			xhr.open("POST", "/member/regist2");
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(params);
		} else {
			alert("내용 확인 요함!!");
		}
	});

	function idCheck() {
		const id = document.getElementById('id').value;
		const idRegex = /^[a-zA-Z][a-zA-Z0-9]{7,}$/;
		
		if (!idRegex.test(id)) {
			document.getElementById('idResult').innerText = "아이디는 영문으로 시작하고 8자 이상이어야 합니다.";
			return;
		}

		const xhr = new XMLHttpRequest();
		xhr.onload = function() {
			const response = xhr.responseText;
			document.getElementById('idResult').innerText = response;

			if (response.includes("사용 가능")) {
				hid.value = "1";
			} else {
				hid.value = "0";
			}
		};
		xhr.open("GET", "/member/idCheck?id=" + id);
		xhr.send();
	}
</script>
</body>
</html>