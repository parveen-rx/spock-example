package spock.example

class SpyUtil {

    ProfileService profileService = new ProfileService()

    BigDecimal calculateDiscount(User user, BigDecimal amount) {
        Integer discountPercentage = calculateUserDiscount(user)
        return ((amount * discountPercentage) / 100)
    }

    Integer calculateUserDiscount(User user) {
        // todo some heavy calculations and service calls
    }

}
