import 'package:flutter/material.dart';

class MultiSkillBar extends StatelessWidget {
  final String skill;
  final Map<String, double> details;

  const MultiSkillBar({
    required this.skill,
    required this.details,
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    final total = details.values.fold(0.0, (sum, e) => sum + e);

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(skill, style: const TextStyle(fontWeight: FontWeight.bold)),
        const SizedBox(height: 4),
        Row(
          children: details.entries.map((entry) {
            final widthFactor = entry.value / total;
            return Expanded(
              flex: (widthFactor * 1000).round(),
              child: Container(
                height: 18,
                color: _getColor(entry.key),
                alignment: Alignment.center,
                child: Text(
                  entry.key,
                  style: const TextStyle(fontSize: 10, color: Colors.white),
                  overflow: TextOverflow.ellipsis,
                ),
              ),
            );
          }).toList(),
        ),
        const SizedBox(height: 4),
        Text(
          details.entries.map((e) => '${e.key} ${(e.value * 100).toStringAsFixed(0)}%').join(', '),
          style: const TextStyle(fontSize: 12, color: Colors.grey),
        ),
        const SizedBox(height: 12),
      ],
    );
  }

  Color _getColor(String key) {
    final colors = [
      Colors.blue,
      Colors.green,
      Colors.orange,
      Colors.purple,
      Colors.red,
      Colors.teal
    ];
    return colors[key.hashCode % colors.length];
  }
}