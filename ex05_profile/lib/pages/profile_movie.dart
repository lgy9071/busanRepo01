// lib/pages/reservation_app_page.dart
import 'package:flutter/material.dart';

class ReservationAppPage extends StatelessWidget {
  const ReservationAppPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("영화 예매 홈페이지")),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(16),
              child: Image.asset(
                'assets/movie_mainPage.png', // 이미지 경로
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(height: 20),
            const Text(
               "🎬프로젝트 내용 : Spring과 JSP를 활용하여 영화 예매 및 후기 작성 기능을 구현한 프로젝트입니다.\n"
              "💡구현한 기능 : 회원가입, 로그인, 영화 목록, 예매, 후기 작성 등 핵심 기능 포함.",
              style: TextStyle(fontSize: 16),
            ),
            ClipRRect(
              borderRadius: BorderRadius.circular(16),
              child: Image.asset(
                'assets/movie_reserveForm.png', // 이미지 경로
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(height: 20),
            const Text(
               "🎬코드 설명 : 영화 예매 관련 폼 코드 부분입니다.\n"
              "💡구현한 기능 : 아이디와 일치하다면 영화 예매를 할 수 있는 링크로 이동할 수 있도록 구현했습니다.\n아래는 리뷰 옵션을 클릭하면 별 모양 아이콘이 나온 후 원하는 별점을 클릭한 후 댓글까지 등록할 수 있는 기능을 구현하도록 했습니다.\n",
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}