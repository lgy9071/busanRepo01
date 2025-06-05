import 'package:demo01/person2.dart';
import 'package:intl/intl.dart';

class Student extends Person{
  late int studentId;

  Student(this.studentId, String name, int age, DateTime birth)
    : super.full(name, birth: birth, age: age);

    @override
    void showInfo(){
    var name = '철수';
    var year = DateTime.now().year - age;
    var birth = 
        DateFormat('yyyy/MM/dd').format(this.birth ?? DateTime(year, 1, 1));
    print('studentId: $studentId, name : ${super.name}, age : $age, birth : $birth');
    }
}