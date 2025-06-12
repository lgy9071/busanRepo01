import 'package:flutter/material.dart';

 class ProfileHeader extends StatelessWidget {
  const ProfileHeader({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
      child: Row(
        children: [
          CircleAvatar(
            radius: 50,
            backgroundImage: AssetImage("assets/idPicture.jpg"),
          ),
          SizedBox(width: 20),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  "JiYong Lee",
                  style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
                ),
                Text(
                  "Developer",
                  style: TextStyle(fontSize: 20),
                ),
                Text(
                  "JiYong Programming",
                  style: TextStyle(fontSize: 15, color: Colors.grey),
                ),
                SizedBox(height: 10),
                Text(
                  "안녕하세요! Java 개발자 JiYong Lee입니다.",
                  style: TextStyle(fontSize: 14, color: Colors.black87),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildHeaderAvatar() {
    return SizedBox(
      width: 100,
      height: 100,
      child: CircleAvatar(
        backgroundImage: AssetImage("assets/idPicture.jpg"),
      ),
    );
  }

  Widget _buildHeaderProfile() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "JiYong Lee",
          style: TextStyle(
            fontSize: 25,
            fontWeight: FontWeight.w700,
          ),
        ),
        Text(
          "Developer",
          style: TextStyle(
            fontSize: 20,
          ),
        ),
        Text(
          "JiYong Programming",
          style: TextStyle(
            fontSize: 15,
          ),
        ),
      ],
    );
  }
 }
