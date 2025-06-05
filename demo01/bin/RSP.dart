import 'dart:io';
import 'dart:math';

void main() {
  final List<String> choices = ['가위', '바위', '보'];
  final Random random = Random();

  while (true) {
    stdout.write('가위(0), 바위(1), 보(2) : ');
    String? input = stdin.readLineSync();

    int? userChoice = int.tryParse(input ?? '');
    if (userChoice == null || userChoice < 0 || userChoice > 2) {
      print('잘못된 입력.');
      continue;
    }

    int comChoice = random.nextInt(3);

    print('유저: ${choices[userChoice]}');
    print('컴퓨터: ${choices[comChoice]}');

    if (userChoice == comChoice) {
      print('비겼습니다!');
    } else if ((userChoice == 0 && comChoice == 2) ||
        (userChoice == 1 && comChoice == 0) ||
        (userChoice == 2 && comChoice == 1)) {
      print('이겼습니다!');
    } else {
      print('졌습니다...');
    }

    stdout.write('다시? (y/n): ');
    String? again = stdin.readLineSync();
    if (again == null || again != 'y') {
      print('게임 종료');
      break;
    }
    print('-----------------------------------');
  }
}
