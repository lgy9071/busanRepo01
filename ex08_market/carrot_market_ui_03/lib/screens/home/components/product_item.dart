import 'package:flutter/material.dart';
import '../../../models/product.dart';
import 'product_detail.dart';

class ProductItem extends StatelessWidget {
  final Product product;
  ProductItem({required this.product});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(16.0),
      child: Row(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(10.0),
            child: Image.network(
              product.urlToImage,
              width: 115,
              height: 115,
              fit: BoxFit.cover,
              errorBuilder: (context, error, stackTrace) {
                return Container(
                  width: 115,
                  height: 115,
                  color: Colors.grey[300],
                  child: const Icon(Icons.broken_image, size: 40),
                );
              },
            ),
          ),
          const SizedBox(width: 16.0),
          Expanded(
            child: ProductDetail(product: product),
          ),
        ],
      ),
    );
  }
}