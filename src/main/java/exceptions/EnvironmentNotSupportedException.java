package exceptions;

import environments.Environment;
import lang.commands.Executable;

public class EnvironmentNotSupportedException extends RuntimeException {
  public final Environment environment;
  public final Executable executable;

  public EnvironmentNotSupportedException(Environment m_environment, Executable m_executable) {
    super("Environment " + m_environment + " not supported by Executable " + m_executable);
    environment = m_environment;
    executable = m_executable;
  }
}
