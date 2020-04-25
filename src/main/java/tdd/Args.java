package tdd;

import java.util.Map;

/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 10:57
 */
public class Args {
    private final Schema scheam;
    private final Command command;

    public Args(String schema, String conmand) {
        this.scheam = new Schema(schema);
        this.command = new Command(conmand);
    }


    public Object value(String flag) {
        String strValue = command.valueOf(flag);
        return scheam.value(flag, strValue);
    }
}
