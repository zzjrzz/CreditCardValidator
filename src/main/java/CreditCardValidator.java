import java.util.LinkedList;
import java.util.List;

class CreditCardValidator {
    List<CreditCardRule> creditCardRules = new LinkedList<>();

    public CreditCardValidator() {
        creditCardRules.add(new CreditCardRule(new String[]{"34", "37"}, new int[]{15}, CreditCardType.AMEX));
        creditCardRules.add(new CreditCardRule(new String[]{"6011"}, new int[]{10}, CreditCardType.Discover));
        creditCardRules.add(new CreditCardRule(new String[]{"51", "52", "53", "54", "55"}, new int[]{10}, CreditCardType.MasterCard));
        creditCardRules.add(new CreditCardRule(new String[]{"4"}, new int[]{13, 16}, CreditCardType.VISA));
    }

    public boolean isValidNumber(Long creditCardNumber) {
        for (CreditCardRule rule : creditCardRules) {
            if (rule.isValid(creditCardNumber) && isValidLuhn(creditCardNumber))
                return true;
        }
        return false;
    }

    public CreditCardType getCardType(Long creditCardNumber){
        for (CreditCardRule rule : creditCardRules) {
            if (rule.getCardType(creditCardNumber) != CreditCardType.Unknown)
                return rule.getCardType(creditCardNumber);
        }
        return CreditCardType.Unknown;
    }

    public String validateCard(Long creditCardNumber){
        StringBuilder cardOutputBuilder = new StringBuilder();
        cardOutputBuilder.append(getCardType(creditCardNumber) + ": ");
        cardOutputBuilder.append(creditCardNumber + "    ");
        if(isValidNumber(creditCardNumber))
            cardOutputBuilder.append("(valid)");
        else
            cardOutputBuilder.append("(invalid)");
        return cardOutputBuilder.toString();
    }

    public boolean isValidLuhn(Long creditCardNumber) {
        int numberOfDigits = creditCardNumber.toString().length();
        int sumOfDoubledAndUntouched = 0;
        boolean isSecondDigit = false;
        for (int i = numberOfDigits - 1; i >= 0; i--) {
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