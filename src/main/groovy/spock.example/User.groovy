package spock.example

class User {

    PasswordEncrypterService passwordEncrypterService = new PasswordEncrypterService()
    EmailService emailService = new EmailService()

    String username
    String password
    String firstName
    String lastName
    String gender = "Male"
    BigDecimal balance
    List<Product> purchasedProducts = []
    Boolean isSpecialCustomer
    BigDecimal incomePerMonth


    //Todo Simple example
    String getFullName() {
        return firstName + " " + lastName
    }

    // Todo Conditional example
    String displayName() {
        String prefix = (gender == "Male") ? 'Mr' : 'Ms'
        return prefix + fullName
    }

    Boolean isValidPassword(String pwd) {
        Boolean isValid = false
        if (pwd && pwd.length() > 0) {
            isValid = true
        }
        return isValid
    }

    //Todo Mock example
    String resetPasswordAndSendEmail() {
        String newPassword = "dummy_value"
        this.password = getEncryptPassword(newPassword)
        emailService.sendCancellationEmail(this, newPassword)
    }

    //Todo Stub example
    String getEncryptPassword(String pwd) {
        String encryptedPassword = passwordEncrypterService.encrypt(pwd)
        return encryptedPassword
    }


    String getIncomeGroup() {
        String group
        if (this.incomePerMonth <= 5000) {
            group = "MiddleClass"
        } else if (incomePerMonth > 5000 && incomePerMonth <= 1000) {
            group = "Higher MiddleClass"
        } else if (incomePerMonth > 10000) {
            group = "Higher MiddleClass"
        } else {
            group = "Lower MiddleClass"
        }
        return group
    }


    void purchase(Product p) {
        if (p) {
            purchasedProducts.add(p)
        }
    }

    void cancelPurchase(Product p) {
        if (p) {
            purchasedProducts.remove(p)
        }
    }

    List<String>getSortedInterestedInCategories(){
        List<String> interestedInCategories = getInterestedInCategories()
        interestedInCategories.sort()
    }

    List<String>getInterestedInCategories(){    //assumed to be a very complex method
        sleep(10000)
    }

}
