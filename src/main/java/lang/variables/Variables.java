package lang.variables;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/**
 * Enum for all final implementation of Variable interface.
 */
public enum Variables {
    INTEGER_VARIABLE(new IntegerVariable("INTEGER_VARIABLE",0)),
    PIXEL(new Pixel("PIXEL",0,0)),
    STRING_VARIABLE(new StringVariable("STRING_VARIABLE",""));
    private static final Map<Variables, String> IdMap = new EnumMap<>(Variables.class);
    private final Variable var;
    Variables(Variable var){
        this.var = var;
    }
    static{
        for(Variables element : Variables.values()) IdMap.put(element,element.var.getId());
    }
    public Variable get(){
        return var;
    }

    public static Collection<String> getIds(){
        return IdMap.values();
    }
}
