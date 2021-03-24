package exceptions;

/**
 * Throw this exception, when non-existing variable is searched for in some environment
 * (use name of this variable in the constructor).
 */
@SuppressWarnings("serial")
public class NoVariableWithThisNameException extends Exception {
    private String name="name";
    public NoVariableWithThisNameException(){}
    public NoVariableWithThisNameException(String name){
        super("There is no variable with name " + name);
        this.name = name;
    }
    public NoVariableWithThisNameException(Throwable t){
        super(t);
    }
    public NoVariableWithThisNameException(String name, Throwable t){
        super("There is no variable with name " + name, t);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}