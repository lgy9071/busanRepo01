import 'package:flutter/material.dart';

class AmusementAppPage extends StatelessWidget {
  const AmusementAppPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("놀이동산 예매 홈페이지")),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(16),
              child: Image.asset(
                'assets/nol_mainPage.png', // 이미지 경로
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              "🎡프로젝트 내용 : 놀이기구 정보 확인, 온라인 티켓 예매, 후기 등 다양한 기능을 제공하는 웹 애플리케이션입니다."
              "💡구현한 기능 : 회원가입, 로그인, 놀이기구 목록, 예매, 이벤트, QnA, 후기 작성 등 핵심 기능을 포함하게 했습니다.",
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}