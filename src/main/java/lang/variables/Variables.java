package lang.variables;

/**
 * Enum for all final implementation of Variable interface.
 */
public enum Variables {
    INTEGER_VARIABLE(new IntegerVariable("INTEGER_VARIABLE",0)),
    PIXEL(new Pixel("PIXEL",0,0)),
    STRING_VARIABLE(new StringVariable("STRING_VARIABLE",""));

    private final Variable var;
    Variables(Variable var){
        this.var = var;
    }

    public Variable get(){
        return var;
    }
}
