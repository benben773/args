import org.junit.Test;
import tdd.Schema;

import static org.junit.Assert.assertEquals;


/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 11:29
 */
public class SchemaTest {
    @Test
    public void test() {
        Schema schema = new Schema("l:boolean,p:int,d:str");
        assertEquals(true, schema.value("l","true"));
        assertEquals(8080, schema.value("p","8080"));
        assertEquals(-8080, schema.value("p","-8080"));
        assertEquals("/data/logs", schema.value("d","/data/logs"));
    }
    @Test
    public void test_null() {
        Schema schema = new Schema("l:boolean,p:int,d:str");
        assertEquals(true, schema.value("l",""));
        assertEquals(8080, schema.value("p","8080"));
        assertEquals(-8080, schema.value("p","-8080"));
        assertEquals("/data/logs", schema.value("d","/data/logs"));
    }
}
