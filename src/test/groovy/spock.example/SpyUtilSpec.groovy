package spock.example

import spock.lang.Specification

class SpyUtilSpec extends Specification {

    void "Check if discount is calculated correctly based on user profile"(){
        given:
        def spyUtil = Spy(SpyUtil)

        and:
        User user = new User()

        when:
        BigDecimal discount = spyUtil.calculateDiscount(user, 100.0)

        then:
        1 * spyUtil.calculateUserDiscount(user) >> 7
        discount == 7
    }

}
