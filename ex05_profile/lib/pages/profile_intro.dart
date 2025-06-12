// lib/pages/intro_app_page.dart
import 'package:flutter/material.dart';

class IntroAppPage extends StatelessWidget {
  const IntroAppPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Flutter 자기소개 앱")),
      body: const Padding(
        padding: EdgeInsets.all(16.0),
        child: Text(
          "Flutter와 Dart를 사용해 개발한 자기소개 앱입니다.\n"
          "사진, 소개글, 프로젝트 목록 등 다양한 정보를 담고 있어요.",
          style: TextStyle(fontSize: 16),
        ),
      ),
    );
  }
}