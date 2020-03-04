public class LengthRule implements Rule {
    int allowedLength;

    public LengthRule(int allowedLength){
        this.allowedLength = allowedLength;
    }

    @Override
    public boolean isValid(Long value) {
        return value.toString().length() == allowedLength;
    }
}
