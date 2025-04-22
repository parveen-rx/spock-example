package spock.example

import spock.lang.Specification


/**
 * Write program which reverses last three letters in a word
 */

class TDDSpec extends Specification {

    SuffixReverser sf

    def setup() {
        sf = new SuffixReverser()
    }

    void "Suffix Reverser class is present"() {
        expect:
        SuffixReverser
    }

//    void "There is a method in suffix reverser which reverses the suffix of a word"() {
//        expect:
//        sf.reverseSuffix("abcdef")
//
//
//        then:
//        notThrown(MissingMethodException)
//    }

    void "Suffix Reversal should work correctly"() {
        expect:
        sf.reverseSuffix(input) == result

        where:
        input || result
        "def" || "fed"
//        ""    || ""
//        null  || ""
    }


}
