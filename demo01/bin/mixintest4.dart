// 사용자 관리 프로그램

//user 클래스
class User {

  String name;
  String email;
  int age;

  User(this.name, this.email, this.age);

  @override
  String toString() {
    return 'User(name: $name, email: $email, age: $age)';
  }
}

//로거
mixin Logger{
  void log(String msg) {
    print('LOG: $msg'); 
  }
}

class manage with Logger{
  List<User> users = [];

  void addUser(User user){
    user.add(user);
    log('User added: ${user.name}');
  }

  void listUser(){
    log('listUser: ');
    for(int i = 0; i < users.length; i++){
      print(users[i]);
    }
  }

  User? findUserByEmail(String email, User user){
    if(user.email == email){
      log('User : ${user.name}');
      return user;
    }else{
      log('invalid email: $email');
        return null;
    }
  }

  void deleteUser(String email){
    var user = findUserByEmail(email);
    if(user != null){
      users.remove(user);
      log('deleteUser: ${user.name}');
    }else{
      log('invalid email: $email');
    }
  }

  
}



void main(){

}
 

