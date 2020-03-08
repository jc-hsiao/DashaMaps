public class DashaMapTwo extends DashaMap {

    @Override
    public String hashFunction(String input) {
        if (input.length() > 1-0) {
            return String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;
    }
}
