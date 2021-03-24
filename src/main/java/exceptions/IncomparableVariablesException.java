package exceptions;

/**
 * Throw this exception, when comparing method is used on incomparable variables
 * (use the names of variables in the constructor).
 */
@SuppressWarnings("serial")
public class IncomparableVariablesException extends Exception {
    private String name1="name1";
    private String name2="name2";
    public IncomparableVariablesException(){}
    public IncomparableVariablesException(String s){
        super(s);
    }
    public IncomparableVariablesException(String name1, String name2){
        super("Variable " + name1 + " is incomparable with variable " + name2);
        this.name1 = name1;
        this.name2 = name2;
    }
    public IncomparableVariablesException(Throwable t) {
        super(t);
    }
    public IncomparableVariablesException(String name1, String name2, Throwable t){
        super("Variable " + name1 + " is incomparable with variable " + name2, t);
        this.name1 = name1;
        this.name2 = name2;
    }
    public IncomparableVariablesException(String s, Throwable t){
        super(s,t);
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
}