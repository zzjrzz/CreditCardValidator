public class StartWithRule implements Rule {
    private String[] startsWith;

    public StartWithRule(String[] startsWith) {
        this.startsWith = startsWith;
    }

    @Override
    public boolean isValid(Long value) {
        for (String starting : startsWith) {
            if (value.toString().startsWith(starting))
                return true;
        }
        return false;
    }
}
