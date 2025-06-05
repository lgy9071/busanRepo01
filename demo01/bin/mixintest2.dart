mixin Logger{
  void log(String msg){
    print('LOG:  $msg');
  }
}

class FileManager with Logger{
  void saveFile(String fileName){
    log('Saving file: $fileName');
  }
  void deleteFile(String fileName){
    log('Delete file: $fileName');
  }
}

void main(){
  FileManager filemanager = FileManager();
  filemanager.saveFile('test.txt');     
  filemanager.deleteFile('test.txt');  
}