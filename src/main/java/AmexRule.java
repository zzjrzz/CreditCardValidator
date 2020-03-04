public class AmexRule implements Rule {
    String[] startsWith = new String[]{"34", "37"};
    int allowedLength = 16;

    @Override
    public boolean isValid(Long cardNumber) {
        return new LengthRule(allowedLength).isValid(cardNumber);
    }

    public CreditCardType isCardType(Long cardNumber) {
        for (String starting : startsWith) {
            if (cardNumber.toString().startsWith(starting))
                return CreditCardType.AMEX;
        }
        return CreditCardType.Unknown;
    }
}
