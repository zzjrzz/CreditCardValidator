public class CreditCardRule implements Rule {
    private String [] startsWith;
    private int [] allowedLengths;
    private CreditCardType cardType;

    public CreditCardRule(String[] startsWith, int[] allowedLengths, CreditCardType cardType) {
        this.startsWith = startsWith;
        this.allowedLengths = allowedLengths;
        this.cardType = cardType;
    }

    @Override
    public boolean isValid(Long cardNumber) {
        return new LengthRule(allowedLengths).isValid(cardNumber) && new LuhnRule().isValid(cardNumber);
    }

    public CreditCardType getCardType(Long cardNumber) {
        if (new StartWithRule(startsWith).isValid(cardNumber))
            return cardType;
        return CreditCardType.Unknown;
    }
}
