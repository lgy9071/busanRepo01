import 'package:flutter/material.dart';
import 'package:ex05_profile/components/profile_buttons.dart';
import 'package:ex05_profile/components/profile_drawer.dart';
import 'package:ex05_profile/components/profile_header.dart';
import 'package:ex05_profile/components/profile_tab.dart';
import 'package:ex05_profile/theme.dart';
import 'components/profile_guest_bookTab.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  bool _isDarkMode = false;

  void _toggleTheme() {
    setState(() {
      _isDarkMode = !_isDarkMode;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: _isDarkMode ? darkTheme() : theme(),
      home: ProfilePage(
        toggleTheme: _toggleTheme,
        isDarkMode: _isDarkMode,
      ),
    );
  }
}

class ProfilePage extends StatelessWidget {
  final VoidCallback toggleTheme;
  final bool isDarkMode;

  const ProfilePage({
    Key? key,
    required this.toggleTheme,
    required this.isDarkMode,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      endDrawer: const ProfileDrawer(),
      appBar: _buildProfileAppBar(),
      body: SingleChildScrollView(
        padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Icon(isDarkMode ? Icons.dark_mode : Icons.light_mode),
                Switch(value: isDarkMode, onChanged: (_) => toggleTheme()),
              ],
            ),
            const ProfileHeader(),
            const SizedBox(height: 20),
            // const ProfileCountInfo(), // 사용 안 할 경우 주석 유지
            const SizedBox(height: 20),
            const ProfileButtons(),
            const SizedBox(height: 20),
            SizedBox(
              height: 500, // Tab 내용 높이 고정
              child: const ProfileTab(), // 방명록 탭 포함됨
            ),
          ],
        ),
      ),
    );
  }

  AppBar _buildProfileAppBar() {
    return AppBar(
      leading: const Icon(Icons.arrow_back_ios),
      title: const Text("🍀Welcome JiYong Profile"),
      centerTitle: true,
    );
  }
}