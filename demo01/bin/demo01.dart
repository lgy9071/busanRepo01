
import 'package:demo01/animal.dart';
import 'package:demo01/demo01.dart' as demo01;

// void main(List<String> arguments) {
//   print('Hello world: ${demo01.calculate()}!');
// }

void main() {
  var dog = Animal.nameOnly('강아지');
  dog.showInfo();

  var cat = Animal.typeOnly('고양이과');
  cat.showInfo();
}