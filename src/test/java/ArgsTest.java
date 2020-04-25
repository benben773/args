import org.junit.Test;
import tdd.Args;

import static org.junit.Assert.assertEquals;

/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 10:52
 */
public class ArgsTest {
    @Test
    public void should_get_value_when_input_string(){
        Args args = new Args("l:boolean,p:int,d:str","-l -p 8080 -d /usr/logs");
        assertEquals(true,args.value("l"));
        assertEquals(8080,args.value("p"));
        assertEquals("/usr/logs",args.value("d"));
    }
    @Test
    public void should_negative_number_when_input_negative_integer(){
        Args args = new Args("l:boolean,p:int,d:str","-l -p -8080 -d /usr/logs");
        assertEquals(true,args.value("l"));
        assertEquals(-8080,args.value("p"));
        assertEquals("/usr/logs",args.value("d"));
    }
}
