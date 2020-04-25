import org.junit.Test;
import tdd.Command;

import static org.junit.Assert.assertEquals;

/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 13:06
 */
public class CommandTest {
    @Test
    public void Test_command() {
        Command command = new Command("-l true -p 8080 -d /usr/logs");
        assertEquals(command.valueOf("l"),"true");
        assertEquals(command.valueOf("p"),"8080");
        assertEquals(command.valueOf("d"),"/usr/logs");
    }
    @Test
    public void Test_null_command() {
        Command command = new Command("-l -p 8080 -d /usr/logs");
        command.getMap().forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        assertEquals(command.valueOf("l"),"");
        assertEquals(command.valueOf("p"),"8080");
        assertEquals(command.valueOf("d"),"/usr/logs");
    }
    @Test
    public void Test_negative_command() {
        Command command = new Command("-l -p -8080 -d /usr/logs");
        command.getMap().forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        assertEquals(command.valueOf("l"),"");
        assertEquals(command.valueOf("p"),"-8080");
        assertEquals(command.valueOf("d"),"/usr/logs");
    }
}
