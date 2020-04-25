package tdd;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;

/**
 * @author ：ls05
 * @date ：Created in 2020/4/25 13:07
 */
public class Command {
    private HashMap<String, String> map;

    public Command(@NotNull String strCommand) {
        map = new HashMap<String, String>();
        ListIterator<String> elementIter = Arrays.asList(strCommand.split(" ")).listIterator();
        while (elementIter.hasNext()) {
            String name = elementIter.next();
            if (name.charAt(0) =='-' ) {
                String value = elementIter.next();
                if(isValue(value)){
                    map.put(name.substring(1), value);
                }else{
                    map.put(name.substring(1), "");
                    elementIter.previous();
                }
            }
        }
    }

    private boolean isValue(String value) {
        if(value.charAt(0) == '-') {
            if(value.length()>2){
                return true;
            }else{
                if(value.charAt(1)>'0' && value.charAt(1)<'9'){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String   valueOf(String name) {
        return this.map.get(name);
    }
}
