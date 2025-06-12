import 'package:flutter/material.dart';
import 'profile_multi_skillBar.dart'; // 새로 만든 MultiSkillBar 위젯 파일 import

class ProfileInfoTab extends StatelessWidget {
  const ProfileInfoTab({super.key});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            "👋 자기소개",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          const Text(
            "안녕하세요! 백엔드와 앱 개발에 관심이 많은 예비 개발자 이지용입니다.\n"
            "Spring, Flutter를 중심으로 풀스택 개발을 공부하고 있습니다.",
          ),
          const SizedBox(height: 24),
          const Text(
            "💡 기술 스택",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 12),
          MultiSkillBar(
            skill: 'Flutter',
            details: {
              '위젯 구조': 0.5,
              '상태관리': 0.35,
              '애니메이션': 0.15,
            },
          ),
          MultiSkillBar(
            skill: 'Dart',
            details: {
              '기본문법': 0.4,
              '비동기 처리': 0.4,
              '컬렉션 및 함수형': 0.2,
            },
          ),
          MultiSkillBar(
            skill: 'Spring',
            details: {
              'MVC 구조': 0.5,
              'REST API': 0.3,
              'JPA & DB 연동': 0.2,
            },
          ),
          MultiSkillBar(
            skill: 'Java',
            details: {
              'OOP': 0.4,
              'JSP/Servlet': 0.35,
              '컬렉션 및 예외처리': 0.25,
            },
          ),
          const SizedBox(height: 24),
          const Text(
            "📌 목표",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          const Text(
            "사용자에게 편리한 경험을 제공하는 개발자가 되는 것이 목표입니다.",
          ),
          const SizedBox(height: 16),
          const Text(
            "현재 Java, Spring, Flutter 등 다양한 기술을 학습하며\n"
            "개발자로 성장하고 있는 중입니다.\n\n"
            "주요 프로젝트:\n"
            "- 영화 예매 시스템\n"
            "- 놀이동산 예매 홈페이지\n"
            "- Flutter 자기소개 앱\n\n"
            "저는 문제 해결을 좋아하고,\n"
            "사용자 친화적인 UI/UX 설계에도 관심이 많습니다.",
            style: TextStyle(fontSize: 16, height: 1.5),
          ),
        ],
      ),
    );
  }
}