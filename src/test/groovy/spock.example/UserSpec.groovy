package spock.example

import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification {

    User user

    def setup(){
        user = new User()
    }

    def "First test"() {
        expect:
        true
    }

   /* @Unroll("#description")
    void "Test something #description"() {
        given: "User with firstname and lastname set"
        user.firstName = firstName
        user.lastName = lastName

        expect:
        user.getFullName() == result

        where:
        description   | firstName | lastName || result
      //  "Valid input" | "Shubham" | "Sharma" || "Shubham Sharma"
        //"All blanks"  | ""        | ""       || " "
        //"With blank"  | ""        | "Sharma" || "Sharma"
    }*/


    void "Password is reset to dummy and cancellation email is sent"(){
        given: "A user object"
        EmailService emailService = Mock(EmailService)
        PasswordEncrypterService passwordEncrypterService = Mock(PasswordEncrypterService)

        and:
        user.emailService = emailService
        user.passwordEncrypterService = passwordEncrypterService


        when:
        user.resetPasswordAndSendEmail()

        then:
        1 * passwordEncrypterService.encrypt(_ as String) >> "DUMMY"
        then:
        1 * emailService.sendCancellationEmail(user, "dummmmmmmy")
        user.password == "DUMMY"

    }


}
