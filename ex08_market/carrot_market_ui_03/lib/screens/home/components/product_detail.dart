import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../../../models/product.dart';
import '../../../theme.dart';

class ProductDetail extends StatelessWidget {
  final Product product;

  const ProductDetail({required this.product});

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(product.title, style: textTheme().bodyLarge),
        const SizedBox(height: 4.0),
        Text('${product.address} • ${product.publishedAt}',
            style: textTheme().bodySmall),
        const SizedBox(height: 4.0),
        Text(
          '${numberFormat(product.price)}원',
          style: textTheme().displayMedium,
        ),
        const SizedBox(height: 8.0),
        Row(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            if (product.commentsCount > 0)
              _buildIcons(product.commentsCount, CupertinoIcons.chat_bubble_2),
            if (product.commentsCount > 0) const SizedBox(width: 8.0),
            if (product.heartCount > 0)
              _buildIcons(product.heartCount, CupertinoIcons.heart),
          ],
        ),
      ],
    );
  }

  String numberFormat(String price) {
    final formatter = NumberFormat('#,###');
    return formatter.format(int.tryParse(price) ?? 0);
  }

  Widget _buildIcons(int count, IconData iconData) {
    return Row(
      children: [
        Icon(iconData, size: 14.0, color: Colors.grey[700]),
        const SizedBox(width: 4.0),
        Text('$count'),
      ],
    );
  }
}