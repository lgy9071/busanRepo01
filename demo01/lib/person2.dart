import 'package:intl/intl.dart';

class Person {
  late String name;
  late int age;
  DateTime? birth;

  Person();

  Person.create({required this.name, required this.age}); //required : 필수 파라미터

  Person.onlyName(this.name) {
    age = 20;
  }

  Person.onlyAge({this.age = 20}) {
    
  }

  Person.full(this.name, {this.age = 20, this.birth});

  void showInfo(){
    var year = DateTime.now().year - age;
    var birth = 
        DateFormat('yyyy/MM/dd').format(this.birth ?? DateTime(year, 1, 1));
    print('name : $name, age : $age, birth : $birth');
  }

}