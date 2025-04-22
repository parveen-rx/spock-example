package spock.example

class SuffixReverser {

    String reverseSuffix(String s) {
        String result = null
        if (s) {
            result = s.substring(0,s.size()-3) + s.substring(s.size()-3).reverse()
        }
        return result
    }

}
