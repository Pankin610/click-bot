package exceptions;

/**
 * Throw this exception, when something gone wrong during execution of Executable.
 */
@SuppressWarnings("serial")
public class ExecException extends RuntimeException {
  public ExecException() {
  }

  public ExecException(String s) {
    super(s);
  }

  public ExecException(Throwable t) {
    super(t);
  }

  public ExecException(String s, Throwable t) {
    super(s, t);
  }
}
