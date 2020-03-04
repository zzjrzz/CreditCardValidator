class CreditCardValidator {
    public boolean isValidNumber(Long creditCardNumber) {
        return isRightLength(creditCardNumber);
    }

    public boolean isRightLength(Long creditCardNumber) {
        switch (creditCardNumber.toString().length()) {
            case 13:
                return true;
            case 15:
                return true;
            case 16:
                return true;
            default:
                return false;
        }
    }
}