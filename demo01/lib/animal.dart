
class Animal {
  String name;
  String type;

  Animal.nameOnly(this.name) : type = '알 수 없음';
  Animal.typeOnly(this.type) : name = '이름 없음';

  void showInfo() {
    print('이름: $name, 종류: $type');
  }

  void crying() {
    print('$name이(가) 웁니다.');
  }
}

class Tiger extends Animal {
  Tiger.nameOnly(super.name) : super.nameOnly();
  Tiger.typeOnly(super.type) : super.typeOnly();

  @override
  void crying() {
    print('호랑이가 으르렁!!');
  }

  void showInfo() {
    print('이름: $name');
    crying();
  }
}