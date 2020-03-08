import org.junit.Assert;
import org.junit.Test;

public class TestDashaMap {

    @Test
    public void constructorTest(){
        DashaMap m = new DashaMapOne();
        Assert.assertTrue(m.isEmpty());
        Assert.assertNull(m.get("apple"));
    }

    @Test
    public void isEmptyTest(){
        DashaMap m = new DashaMapOne();
        m.set("rat", 5);
        Assert.assertFalse(m.isEmpty());
    }

    @Test
    public void sizeTest(){
        DashaMap m = new DashaMapOne();
        m.set("swan", 1);
        m.set("bird", 2);
        m.set("duck", 3);
        m.set("goose", 4);

        Assert.assertEquals(4,m.size());
    }


}
