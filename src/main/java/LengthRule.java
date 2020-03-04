public class LengthRule implements Rule {
    int[] allowedLength;

    public LengthRule(int[] allowedLength) {
        this.allowedLength = allowedLength;
    }

    @Override
    public boolean isValid(Long value) {
        for (int length : allowedLength) {
            if (value.toString().length() == length)
                return true;
        }
        return false;
    }
}
