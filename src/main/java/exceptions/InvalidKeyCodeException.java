package exceptions;

// a useful exception that occurs when decoding key sequence codes
public class InvalidKeyCodeException extends RuntimeException {
  public String code;
  public int error_index;

  public InvalidKeyCodeException(String m_code, int m_error_index) {
    super("Error encoding " + m_code + " at " + m_error_index + ".");
    code = m_code;
    error_index = m_error_index;
  }
}
