package spock.example

class PasswordEncrypterService {

   String encrypt(String password){
       return password.bytes.encodeBase64().toString()

   }

}
