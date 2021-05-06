package exceptions;

public class WrongFileFormatException extends RuntimeException {
  public WrongFileFormatException() {
  }

  public WrongFileFormatException(String message) {
    super(message);
  }

  public WrongFileFormatException(String message, Throwable cause) {
    super(message, cause);
  }

  public WrongFileFormatException(Throwable cause) {
    super(cause);
  }
}
