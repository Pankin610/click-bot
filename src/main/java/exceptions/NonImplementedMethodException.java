package exceptions;

@SuppressWarnings("serial")
public class NonImplementedMethodException extends RuntimeException {
  public NonImplementedMethodException() {
  }

  public NonImplementedMethodException(String s) {
    super(s);
  }

  public NonImplementedMethodException(Throwable t) {
    super(t);
  }

  public NonImplementedMethodException(String s, Throwable t) {
    super(s, t);
  }
}
