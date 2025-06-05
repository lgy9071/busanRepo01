mixin Validator{
  bool isValidEmail(String email){
    return email.contains('@');
  }
}

//로거 믹스인 정의
mixin Logger{
  void log(String msg) {
    print('LOG: $msg'); 
  }
}

//UserManager 클래스 정의
class UserManager with Logger, Validator{
  void createUser(String email){

    if (isValidEmail(email)) {
      log('Creating user with email: $email');
    } else {
      log('Invalid email: $email');
    }

    //email에 문제가 없으면 'Creating user with email: 이메일주소' 출력
    //email에 문제가 있으면 'Invalid email: 이메일주소
  }
}

void main(){
  var userManager = UserManager();
  //정상적인 email로 User생성
  userManager.createUser('test@example.com');

  //비정상적인 email로 User생성
  userManager.createUser('invalid-email');

  //출력결과
  //LOG: Creating user with email: test@example.com
  //LOG: Invalid email: invalid-email
}