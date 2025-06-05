mixin MyMixin{ //기존 클래스에 도움을 주는 mixin
  void sayHello(){ //dart는 implements, extends 상관 없음.. mixin 쓸때는 with
    print('Hello Mixin....'); //구현되어있는 메서드를 쓰면 됨
  }
}

class MyClass with MyMixin {} //공통적인 기능에서 쓰면 좋음

void main() {
  var obj = MyClass();
  obj.sayHello();
}