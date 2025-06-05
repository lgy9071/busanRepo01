class Person {
  String _name; // private : _
  int _age;

  //생성자
  Person.init() : _name = 'nobody', _age = 0;

  Person.xxx() : this(name: '홍길동', age: 32);

  //생성자
  //Person(String name, int age) : _name = name, _age = age;
  Person({required String name, required int age})
    : _name = name == '' ? 'unknown' : name,
      _age = age < 0 ? 0 : age;

  //getter
  String get name => _name;
  int get age => _age;

  //setter
  set name(String name) {
    if (name == '') {
      _name = 'unknown';
    } else {
      _name = name;
    }
  }

  set age(int age) => _age = age < 0 ? 0 : age;

  void showInfo() {
    print('name : $name');
    print('age : $age');
  }
}

void main() {
  //var person = Person.init();

  var person = Person.xxx();

  //var person = Person(name: '', age: -30);

  //person.name = '';
  //person.age = -20;

  //print(person.name);
  //print(person.age);

  person.showInfo();
}
