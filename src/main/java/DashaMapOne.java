public class DashaMapOne extends DashaMap{

    @Override
    public String hashFunction(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

}