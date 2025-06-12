import 'package:flutter/material.dart';

class GuestBookTab extends StatefulWidget {
  const GuestBookTab({super.key});

  @override
  State<GuestBookTab> createState() => _GuestBookTabState();
}

class _GuestBookTabState extends State<GuestBookTab> {
  final _nameController = TextEditingController();
  final _commentController = TextEditingController();
  final List<Map<String, String>> _comments = [];

  void _addComment() {
    if (_nameController.text.isEmpty || _commentController.text.isEmpty) return;

    setState(() {
      _comments.insert(0, {
        'name': _nameController.text,
        'comment': _commentController.text,
      });
      _nameController.clear();
      _commentController.clear();
    });
  }

  @override
  void dispose() {
    _nameController.dispose();
    _commentController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            "✍ 방명록",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 12),
          TextField(
            controller: _nameController,
            decoration: const InputDecoration(labelText: '이름'),
          ),
          const SizedBox(height: 8),
          TextField(
            controller: _commentController,
            decoration: const InputDecoration(labelText: '내용'),
            maxLines: 2,
          ),
          const SizedBox(height: 12),
          ElevatedButton(
            onPressed: _addComment,
            child: const Text("작성"),
          ),
          const SizedBox(height: 24),
          Expanded(
            child: _comments.isEmpty
                ? const Text("아직 방명록이 없습니다.")
                : ListView.builder(
                    itemCount: _comments.length,
                    itemBuilder: (context, index) {
                      final comment = _comments[index];
                      return Card(
                        margin: const EdgeInsets.symmetric(vertical: 4),
                        child: ListTile(
                          title: Text(comment['name'] ?? ''),
                          subtitle: Text(comment['comment'] ?? ''),
                        ),
                      );
                    },
                  ),
          ),
        ],
      ),
    );
  }
}