import org.junit.Assert;
import org.junit.Test;

public class TestDashaMapTwo {
    @Test
    public void setTest(){
        DashaMap m = new DashaMapTwo();
        m.set("apple",10);
        Assert.assertFalse(m.isEmpty());
        Assert.assertEquals(10, m.get("apple"), 0.01);
    }

    @Test
    public void setTest2(){
        DashaMap m = new DashaMapTwo();
        int expected = 100;
        m.set("apple",10);
        m.set("arrow",222);
        m.set("amaterasu",expected);
        Assert.assertEquals(3,m.size());
        Assert.assertEquals(expected, m.get("amaterasu"), 0.01);
    }

    @Test
    public void keyToIndexTest(){
        DashaMap m = new DashaMapTwo();
        int actual1 = m.keyToIndex("apple");
        int actual2 = m.keyToIndex("banana");
        int actual3 = m.keyToIndex("Zebra");

        Assert.assertEquals(15,actual1);
        Assert.assertEquals(0,actual2);
        Assert.assertEquals(4,actual3);
    }

    @Test
    public void deleteTest(){
        DashaMap m = new DashaMapTwo();
        m.set("goose", 3);
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("quaker", 8);
        m.set("parakeet", 9);
        m.set("africanGrey", 10);
        m.set("lovebird", 11);
        Assert.assertEquals(8,m.size());
        int deletedVal = m.delete("goose");
        Assert.assertEquals(7,m.size());
        Assert.assertEquals(3,deletedVal);
        Assert.assertNull(m.get("goose"));
    }

    @Test
    public void bucketSizeTest(){
        DashaMap m = new DashaMapTwo();
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("cracker", 8);
        Assert.assertEquals(3,m.bucketSize('o'));
    }


    @Test
    public void bucketSizeNullTest(){
        DashaMap m = new DashaMapTwo();
        m.set("z", 0);
        m.set("b", -10);
        m.set("a", 999);
        Assert.assertEquals(3,m.bucketSize(null));
    }

    @Test
    public void getTest(){
        DashaMap m = new DashaMapTwo();
        m.set("cockatiel", 5);
        m.set("cockatoo", 6);
        m.set("conure", 7);
        m.set("cracker", 8);
        int expected = m.get("conure");
        Assert.assertEquals(7,expected);
    }


    @Test
    public void toStringTest(){
        DashaMap m = new DashaMapTwo();
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
