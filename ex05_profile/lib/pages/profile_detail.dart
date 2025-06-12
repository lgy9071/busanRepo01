// lib/pages/profile_detail_page.dart
import 'package:flutter/material.dart';

class ProfileDetailPage extends StatelessWidget {
  const ProfileDetailPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("자기소개 상세"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: const [
              Text(
                "👋 자기소개",
                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 12),
              Text(
                "안녕하세요! 백엔드와 앱 개발에 관심이 많은 예비 개발자 이지용입니다.\n"
                "Spring, Flutter를 중심으로 풀스택 개발을 공부하고 있어요.\n\n"
                "현재 Java, Spring, Flutter 등 다양한 기술을 학습하며 개발자로 성장하는 중이며,\n"
                "문제 해결과 사용자 친화적인 UI/UX 설계에 많은 관심을 가지고 있습니다.\n\n"
                "주요 프로젝트:\n"
                "- 영화 예매 시스템\n"
                "- 놀이동산 예매 홈페이지\n"
                "- Flutter 자기소개 앱\n\n"
                "목표는 사용자에게 편리한 경험을 제공하는 개발자가 되는 것입니다.",
                style: TextStyle(fontSize: 16, height: 1.5),
              ),
            ],
          ),
        ),
      ),
    );
  }
}