package tdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 11:31
 */
public class Schema {
    private Map<String,String> flagValueMap;
    public Schema(String params) {
        flagValueMap = new HashMap<String,String>();
        String[] split = params.split(",");
        Arrays.asList(split).stream().forEach(e ->{
            flagValueMap.put(e.split(":")[0],e.split(":")[1]);
        });
    }

    public Object value(String flag, String inputValue) {
        String value = flagValueMap.get(flag);
        switch (value) {
            case "boolean":
                return "true".equals(inputValue) || "".equals(inputValue);
            case "int":
                return Integer.parseInt(inputValue);
            case "str":
                return inputValue;
            default:
                return flag;
        }
    }
}
