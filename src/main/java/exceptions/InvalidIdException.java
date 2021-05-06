package exceptions;

@SuppressWarnings("serial")
public class InvalidIdException extends RuntimeException {
  private String ID;

  public InvalidIdException() {
    super();
  }

  public InvalidIdException(String ID) {
    super("invalid ID: " + ID);
    this.ID = ID;
  }

  public InvalidIdException(String ID, Throwable cause) {
    super("invalid ID: " + ID, cause);
    this.ID = ID;
  }

  public InvalidIdException(Throwable cause) {
    super(cause);
  }

  public String getID() {
    return ID;
  }
}
