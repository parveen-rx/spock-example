package spock.example

import spock.lang.Specification

class ExceptionSpec extends Specification {
    void "First test"(){
        expect:
        true
    }


    void "Stack throws an exception if popped when empty"(){
        given: "An empty stack"
        List <String> items = []

        when: "When an empty stack is popped"
        items.pop()

        then: "Exception is thrown"
        thrown(NoSuchElementException)
    }
}
