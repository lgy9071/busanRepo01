void f(int n1, [int n2 = 0]) {
  print('n1+n2 = ${n1 + n2}');
}

void f2(int a, {required int b, int c = 10}) {
  print('a + b + c = ${a + b + c}');
}

// void main() {
//   f2(5, b: 3);    
//   f2(2, b: 4, c: 1); 
// }

void printUserInfo(String name, {required int age, String gender = 'unknown'}) {
  print('name: $name, age: $age, gender: $gender');
}

// void main() {
//   printUserInfo('홍길동', age: 25);
//   printUserInfo('김민수', age: 30, gender: 'male');
// }

void add(int n1, int n2){
  print('n1+n2 = ${n1+n2}');
}

void sub(int n1, int n2){
  print('n1-n2 = ${n1-n2}');
}

void div(int n1, int n2){
  if(n2 == 0){
    print('0으로 나눌 수 없습니다!');
  }else{
    print('n1/n2 = ${n1/n2}');
  }
}

void mul(int n1, int n2){
  print('n1*n2 = ${n1*n2}');
}

List<Function> calc = [add, sub, div, mul];

// void main(){
//   for(int i = 0; i < calc.length; i++){
//     calc[i](17,0);
//   }
// }

void printEvenNumber(int n) {
  print('$n is evenNumber');
}

void printOddNumber(int n) {
  print('$n is oddNumber');
}

// 전달받은 함수와 숫자를 이용해 출력
void printNumber(Function func, int num) {
  func(num);
}

// void main() {
//   int num = 3;

//   // 삼항 연산자로 함수 선택
//   Function(int) function = num.isEven ? printEvenNumber : printOddNumber;

//   // 선택한 함수와 숫자를 함께 넘김
//   printNumber(function, num);
// }

// void main(){
//   String? nullAbleString;

//   print(nullAbleString != null ? nullAbleString : 'aaa'); // ?? : null 대체 연산자
  
//   //nullAbleString = 'bbb';

//   nullAbleString = nullAbleString != null ? nullAbleString : 'bbb';

//   nullAbleString ??= 'bbb'; // null 일때 bbb를 저장
// }

// int? length(String? s) {
//   return s?.length;
// }

// person.dart의 main

class Person{
  String name; // late String name; : 초기화를 지연
  int age;

  Person(this.name, this.age); //생성자를 만드는 표기법...nullable이 아니라고 표시하면 반드시 생성자 사용해야함

  // Person(String name, int age){
  //   print('Person constructor called..');
  //   this.name = name;
  //   this.age = age;
  // }
  
  void showInfo(){
    print('name : $name');
    print('age : $age');
  }
}

// void main(){
//   var person = Person.init();

  //var person = Person(name : 'James', age : -10);
  //person.name = "James";
  //person.age = -10; //변수가 아니고 setter age임

  //print(person.name); //여기 name은 getter를 의미
  // print(person.age);

  //person.showInfo();
//}

void main() {
  var person1 = Person.init();
  person1.showInfo();

  var person2 = Person('James', -10);
  person2.showInfo();

  var person3 = Person.xxx();
  person3.showInfo();

  person3.name = '';
  person3.age = -50;
  person3.showInfo();
}