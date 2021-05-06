package exceptions;

/**
 * Throw this exception, when something gone wrong during evaluation of Condition.
 */
@SuppressWarnings("serial")
public class EvaluationException extends RuntimeException {
  public EvaluationException() {
  }

  public EvaluationException(String s) {
    super(s);
  }

  public EvaluationException(Throwable t) {
    super(t);
  }

  public EvaluationException(String s, Throwable t) {
    super(s, t);
  }
}
