public interface HashMapX {

    void set(String key, Integer value);
    Integer delete(String key);
    Integer get(String key);
    boolean isEmpty();
    int size();
    String hashFunction(String input);
    // testing access
    int bucketSize(Character c); // used for tests

}