import 'package:flutter/material.dart';

class ProfileButtons extends StatefulWidget {
  const ProfileButtons({Key? key}) : super(key: key);

  @override
  State<ProfileButtons> createState() => _ProfileButtonsState();
}

class _ProfileButtonsState extends State<ProfileButtons> {
  bool isFollowing = false; // Follow 상태 저장

  void _toggleFollow() {
    setState(() {
      isFollowing = !isFollowing;
    });
  }

  void _showMessageDialog(BuildContext context) {
    showDialog(
      context: context,
      builder: (_) => AlertDialog(
        title: Text("메시지 보내기"),
        content: Text("이 기능은 준비 중입니다."),
        actions: [
          TextButton(onPressed: () => Navigator.pop(context), child: Text("닫기")),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceAround,
      children: [
        _buildFollowButton(),
        _buildMessageButton(),
      ],
    );
  }

  Widget _buildFollowButton() {
    return InkWell(
      onTap: _toggleFollow,
      child: Container(
        alignment: Alignment.center,
        width: 150,
        height: 45,
        decoration: BoxDecoration(
          color: isFollowing ? Colors.grey : Colors.blue,
          borderRadius: BorderRadius.circular(10),
        ),
        child: Text(
          isFollowing ? "Following" : "Follow",
          style: TextStyle(color: Colors.white),
        ),
      ),
    );
  }

  Widget _buildMessageButton() {
    return InkWell(
      onTap: () => _showMessageDialog(context),
      child: Container(
        alignment: Alignment.center,
        width: 150,
        height: 45,
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(10),
          border: Border.all(),
        ),
        child: Text(
          "Message",
          style: TextStyle(color: Colors.black),
        ),
      ),
    );
  }
}