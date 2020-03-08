
public abstract class DashaMap implements HashMapX{

    private DashaMap.Node[] buckets;

    public DashaMap(){
        buckets = new DashaMap.Node[27];
        int count = 0;
        for(int i = 0 ; i < 26; i++){
            Node node = new Node(String.valueOf( (char)("a".charAt(0) + count++) ),null , null );
            buckets[i] = node;
        }
        //trash can for null hash
        buckets[26] = new Node(null,null,null);
    }

    public void set(String key, Integer value) {
        int keyIndex = keyToIndex(key);
        Node entryNode = new Node(key, value, null);
        appendTo(buckets[keyIndex],entryNode);
    }

    private void appendTo(Node correctBucket, Node entryNode){
        for(Node n = correctBucket; n != null; n = n.next) {
            if (n.next == null) {
                n.next = entryNode;
                break;
            }
        }
    }

    public Integer delete(String key) {
        int keyIndex = keyToIndex(key);
        Node target = find1NodeB4(buckets[keyIndex], key);

        if( target == null )
            return null;

        Node bye = target.next;
        target.next = bye.next;

        return bye.v;
    }

    public Integer get(String key) {
        int keyIndex = keyToIndex(key);
        Node target = findNode(buckets[keyIndex], key);
        if(target == null){
            return null;
        }
        return target.v;
    }

    private Node findNode(Node correctBucket, String key){
        for(Node n = correctBucket.next; n != null; n = n.next) {
            if(n.k.equals(key))
                return n;
        }
        return null;
    }

    private Node find1NodeB4(Node correctBucket, String key){
        for(Node n = correctBucket; n != null; n = n.next) {
            if(n.next == null)
                return null;
            if(n.next.k.equals(key))
                return n;
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int sum = 0;
        for (int i = 0; i < buckets.length; i++) {
            //sum += bucketSize(  hkString.valueOf( (char) ('a'+i) ));
            sum += bucketSize((char) (i+'a'));
        }
        return sum;
    }
    public int keyToIndex(String key){
        String keyHash = hashFunction(key);
        if(keyHash == null)
            return getHashArraySize()-1;
        return keyHash.charAt(0) - 'a';
    }

    public int getHashArraySize(){
        return buckets.length;
    }

    public int bucketSize(Character c) {
        int counter = 0;
        int startIndex = 0;
        if(c==null){
            startIndex = buckets.length-1;
        }else
            startIndex = (int) c-'a';

        for(Node n = buckets[startIndex].next; n != null; n = n.next)
            counter++;

        return counter;
    }

    private static class Node {
        String k;
        Integer v;
        Node next;
        Node(String k, Integer v, Node next) {
            this.k = k;
            this.v =v;
            this.next = next;
        }
        @Override
        public String toString() {
            return k + " " + v + "/ " ;
        }
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node bucket : buckets) {
            for (Node n = bucket.next; n != null; n = n.next) {
                s.append(n.toString());
            }
            if(bucket.next!=null)
                s.append("\n");
        }
        return s.toString();
    }
}
