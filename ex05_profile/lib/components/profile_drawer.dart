import 'package:flutter/material.dart';

class ProfileDrawer extends StatelessWidget {
  const ProfileDrawer({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          const DrawerHeader(
            decoration: BoxDecoration(
              color: Colors.blue,
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                CircleAvatar(
                  radius: 30,
                  backgroundImage: AssetImage("assets/idPicture.jpg"),
                ),
                SizedBox(height: 8),
                Text(
                  "이지용",
                  style: TextStyle(color: Colors.white, fontSize: 18),
                ),
                Text(
                  "Flutter & Spring Developer",
                  style: TextStyle(color: Colors.white70, fontSize: 14),
                ),
              ],
            ),
          ),
          const ListTile(
            leading: Icon(Icons.email),
            title: Text("Email"),
            subtitle: Text("lgy990711@naver.com"),
          ),
          const ListTile(
            leading: Icon(Icons.web),
            title: Text("GitHub"),
            subtitle: Text("github.com/lgy9071"),
          ),
          const ListTile(
            leading: Icon(Icons.star),
            title: Text("주요 기술"),
            subtitle: Text("Java, Spring, Flutter, Github"),
          ),
          const ListTile(
            leading: Icon(Icons.info_outline),
            title: Text("자기소개"),
            subtitle: Text("문제 해결과 사용자 경험에 관심 많은 예비 개발자입니다."),
          ),
        ],
      ),
    );
  }
}