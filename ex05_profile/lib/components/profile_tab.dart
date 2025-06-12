import 'package:flutter/material.dart';
import 'package:ex05_profile/pages/profile_movie.dart';
import 'package:ex05_profile/pages/profile_nol.dart';
import 'package:ex05_profile/pages/profile_intro.dart';
import 'profile_info_tab.dart';
import 'profile_guest_bookTab.dart'; 

class ProfileTab extends StatefulWidget {
  const ProfileTab({Key? key}) : super(key: key);

  @override
  State<ProfileTab> createState() => _ProfileTabState();
}

class _ProfileTabState extends State<ProfileTab> with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, vsync: this); 
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        _buildTabBar(),
        Expanded(child: _buildTabBarView()),
      ],
    );
  }

  Widget _buildTabBar() {
    return TabBar(
      controller: _tabController,
      labelColor: Colors.blue,
      tabs: const [
        Tab(text: "🖥 프로젝트"),
        Tab(text: "📃 정보"),
        Tab(text: "📝 방명록"), 
      ],
    );
  }

  Widget _buildTabBarView() {
    return TabBarView(
      controller: _tabController,
      children: [
        _buildProjectList(),
        const ProfileInfoTab(),
        const GuestBookTab(), 
      ],
    );
  }

  Widget _buildProjectList() {
    return ListView(
      padding: const EdgeInsets.all(16),
      children: [
        _buildProjectCard(
          title: "공연 예매 시스템",
          description: "Spring과 JSP를 활용한 공연 예매 및 후기 작성 기능 구현",
          page: const ReservationAppPage(),
        ),
        _buildProjectCard(
          title: "놀이동산 예매 홈페이지",
          description: "놀이기구 정보 및 예매 등 기능 구현",
          page: const AmusementAppPage(),
        ),
        _buildProjectCard(
          title: "Flutter 자기소개 앱",
          description: "Flutter를 사용해 만든 자기 PR 앱",
          page: const IntroAppPage(),
        ),
      ],
    );
  }

  Widget _buildProjectCard({
    required String title,
    required String description,
    required Widget page,
  }) {
    return Card(
      elevation: 4,
      margin: const EdgeInsets.symmetric(vertical: 8),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: ListTile(
        title: Text(title, style: const TextStyle(fontWeight: FontWeight.bold)),
        subtitle: Text(description),
        trailing: const Icon(Icons.arrow_forward_ios),
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => page),
          );
        },
      ),
    );
  }
}