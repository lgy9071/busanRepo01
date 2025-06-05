import 'dart:io';
import 'dart:math';

void main() {
  print('가위바위보로 묵찌빠 게임을 시작합니다!');
  
  // 먼저 가위바위보로 공격권 결정
  String attacker = playRPS();
  
  print('$attacker 가 공격권을 가져갑니다.');
  
  while (true) {
    String attackerChoice = getMukJjiPpaChoice(attacker);
    String defender = attacker == '유저' ? '컴퓨터' : '유저';
    String defenderChoice = getMukJjiPpaChoice(defender);
    
    print('$attacker: $attackerChoice');
    print('$defender: $defenderChoice');
    
    if (attackerChoice == defenderChoice) {
      print('$attacker 가 이겼습니다! 묵찌빠 끝!');
      break;
    } else {
      // 누가 이겼는지 판단
      String winner = decideMukJjiPpaWinner(attackerChoice, defenderChoice);
      if (winner == 'attacker') {
        print('공격자가 승리, 계속 공격권 유지');
      } else {
        print('방어자가 승리, 공격권 교체');
        attacker = defender;
      }
    }
  }
}

// 가위바위보 먼저 플레이해서 공격권 결정
String playRPS() {
  List<String> choices = ['가위', '바위', '보'];
  while (true) {
    stdout.write('가위(1), 바위(2), 보(3) 중 하나를 입력하세요: ');
    String? userInput = stdin.readLineSync();

    if (userInput == null || !['1', '2', '3'].contains(userInput.trim())) {
      print('잘못된 입력입니다.');
      continue;
    }
    int userIndex = int.parse(userInput.trim()) - 1;
    String userChoice = choices[userIndex];

    final random = Random();
    String computerChoice = choices[random.nextInt(3)];

    print('유저: $userChoice');
    print('컴퓨터: $computerChoice');

    if (userChoice == computerChoice) {
      print('비겼습니다! 다시 선택하세요.');
      continue;
    } else if ((userChoice == '가위' && computerChoice == '보') ||
        (userChoice == '바위' && computerChoice == '가위') ||
        (userChoice == '보' && computerChoice == '바위')) {
      print('유저가 이겼습니다! 공격권 획득!');
      return '유저';
    } else {
      print('컴퓨터가 이겼습니다! 공격권 획득!');
      return '컴퓨터';
    }
  }
}

// 묵찌빠 선택 입력 (묵:1, 찌:2, 빠:3)
String getMukJjiPpaChoice(String player) {
  List<String> choices = ['묵', '찌', '빠'];
  if (player == '유저') {
    while (true) {
      stdout.write('묵(1), 찌(2), 빠(3) 중 하나를 입력하세요: ');
      String? input = stdin.readLineSync();
      if (input == null || !['1', '2', '3'].contains(input.trim())) {
        print('잘못된 입력입니다.');
        continue;
      }
      return choices[int.parse(input.trim()) - 1];
    }
  } else {
    final random = Random();
    return choices[random.nextInt(3)];
  }
}

// 묵찌빠 승자 판단 (attackerChoice vs defenderChoice)
// 이기면 'attacker', 지면 'defender'
String decideMukJjiPpaWinner(String attackerChoice, String defenderChoice) {
  // 묵(바위) > 빠(보), 빠(보) > 찌(가위), 찌(가위) > 묵(바위)
  if ((attackerChoice == '묵' && defenderChoice == '빠') ||
      (attackerChoice == '빠' && defenderChoice == '찌') ||
      (attackerChoice == '찌' && defenderChoice == '묵')) {
    return 'attacker';
  } else {
    return 'defender';
  }
}