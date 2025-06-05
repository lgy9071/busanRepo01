import 'package:demo01/person2.dart';
import 'package:demo01/student.dart';

void main(){
  var person = Person();
  person.name = 'James Dean';
  person.age = 24;
  //person.birth = DateTime.now();
  //var date = DateTime(2000, 1, 3, 14, 53, 12);
  //print(date);

  //print(person.name);
  //print(person.age);
  person.showInfo();

  var person1 = Person.create(name: 'Bruce Lee', age: 30);
  person1.showInfo();
  // var date = DateTime.now().year - person.age;
  // print(date);
  var person2 = Person.onlyName('Ann');
  person2.age = 40;
  person2.showInfo();

  var person3 = Person.onlyAge(age: 33);
  person3.name = '마이콜';
  person3.showInfo();

  var person4 = Person.full('고길동', birth: DateTime(2002, 5, 7),);
  person4.showInfo();

  var student = Student(1, "Jane", 22, DateTime(2002, 3, 14));
  student.showInfo();
}
