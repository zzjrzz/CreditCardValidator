public class AmexRule implements Rule {
    String[] startsWith = new String[]{"34", "37"};
    int[] allowedLength = new int[]{16};

    @Override
    public boolean isValid(Long cardNumber) {
        return new LengthRule(allowedLength).isValid(cardNumber);
    }

    public CreditCardType isCardType(Long cardNumber) {
        if (new StartWithRule(startsWith).isValid(cardNumber))
            return CreditCardType.AMEX;
        return CreditCardType.Unknown;
    }
}
