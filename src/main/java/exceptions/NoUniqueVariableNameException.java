package exceptions;

/**
 * This Exception should be thrown when invariant of name-uniques in Environment or Program was unkept.
 */
@SuppressWarnings("serial")
public class NoUniqueVariableNameException extends RuntimeException {
  private String name = "name";

  public NoUniqueVariableNameException() {
  }

  public NoUniqueVariableNameException(String name) {
    super("Multiple variables with name: " + name);
    this.name = name;
  }

  public NoUniqueVariableNameException(Throwable t) {
    super(t);
  }

  public NoUniqueVariableNameException(String name, Throwable t) {
    super("Multiple variables with name: " + name, t);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
