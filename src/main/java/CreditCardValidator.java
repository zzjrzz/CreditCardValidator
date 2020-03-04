class CreditCardValidator {
    public boolean isValidNumber(Long creditCardNumber) {
        return isRightLength(creditCardNumber) && isValidLuhn(creditCardNumber);
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

    public boolean isValidLuhn(Long creditCardNumber)
    {
        int numberOfDigits = creditCardNumber.toString().length();
        int sumOfDoubledAndUntouched = 0;
        boolean isSecondDigit = false;
        for (int i = numberOfDigits - 1; i >= 0; i--)
        {
            int digit = creditCardNumber.toString().charAt(i) - '0';

            if (isSecondDigit == true)
                digit = digit * 2;

            sumOfDoubledAndUntouched += digit / 10;
            sumOfDoubledAndUntouched += digit % 10;

            isSecondDigit = !isSecondDigit;
        }
        return (sumOfDoubledAndUntouched % 10 == 0);
    }
}