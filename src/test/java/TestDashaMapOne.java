import org.junit.Assert;
import org.junit.Test;

public class TestDashaMapOne {
    @Test
    public void setTest(){
        DashaMap m = new DashaMapOne();
        m.set("apple",10);
        Assert.assertFalse(m.isEmpty());
        Assert.assertEquals(10, m.get("apple"), 0.01);
    }

    @Test
    public void setTest2(){
        DashaMap m = new DashaMapOne();
        int expected = 100;
        m.set("apple",10);
        m.set("arrow",222);
        m.set("amaterasu",expected);
        Assert.assertEquals(3,m.size());
        Assert.assertEquals(expected, m.get("amaterasu"), 0.01);
    }

    @Test
    public void keyToIndexTest(){
        DashaMap m = new DashaMapOne();
        int actual1 = m.keyToIndex("apple");
        int actual2 = m.keyToIndex("banana");
        int actual3 = m.keyToIndex("Zebra");

        Assert.assertEquals(0,actual1);
        Assert.assertEquals(1,actual2);
        Assert.assertEquals(25,actual3);
    }

    @Test
    public void deleteTest(){
        DashaMap m = new DashaMapOne();
        m.set("goose", 3);
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("quaker", 8);
        m.set("parakeet", 9);
        m.set("africanGrey", 10);
        m.set("lovebird", 11);
        Assert.assertEquals(8,m.size());
        m.delete("goose");
        Assert.assertEquals(7,m.size());
        Assert.assertNull(m.get("goose"));
    }

    @Test
    public void bucketSizeTest(){
        DashaMap m = new DashaMapOne();
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("cracker", 8);
        Assert.assertEquals(4,m.bucketSize('c'));
    }

    @Test
    public void getTest(){
        DashaMap m = new DashaMapOne();
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("cracker", 8);
        int expected = m.get("conure");
        Assert.assertEquals(7,expected);
    }


    @Test
    public void toStringTest(){
        DashaMap m = new DashaMapOne();
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("quaker", 8);
        m.set("parakeet", 9);
        m.set("africanGrey", 10);
        m.set("lovebird", 11);
        System.out.println(m.toString());
    }


}
