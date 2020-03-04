public class LuhnRule implements Rule {
    @Override
    public boolean isValid(Long value) {
        int numberOfDigits = value.toString().length();
        int sumOfDoubledAndUntouched = 0;
        boolean isSecondDigit = false;
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            int digit = value.toString().charAt(i) - '0';

            if (isSecondDigit == true)
                digit = digit * 2;

            sumOfDoubledAndUntouched += digit / 10;
            sumOfDoubledAndUntouched += digit % 10;

            isSecondDigit = !isSecondDigit;
        }
        return (sumOfDoubledAndUntouched % 10 == 0);
    }
}
