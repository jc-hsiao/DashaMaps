public class DashaMapThree extends DashaMap{

    @Override
    public String hashFunction(String input) {
        if (input.length() > 1) {
            return String.valueOf(
                    asciiToAph(
                            aphToOrder(input.charAt(0)) +
                                    aphToOrder(input.charAt(1))
                    )).toLowerCase();
        }
        return null;
    }

    public int aphToOrder(char c){
        return c-'a';
    }

    public char asciiToAph(int ascii){
        return (char) ((ascii%26)+'a');
    }

}
