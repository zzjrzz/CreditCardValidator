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
            if (rule.isValid(creditCardNumber))
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
}