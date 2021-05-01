package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;

// executes a given command in the terminal
public class ExecuteCommand extends AbstractSingleCommand {
    private static final String id = "EXECUTE";

    String system_command;
    public ExecuteCommand(String m_system_command) {
        system_command = m_system_command;
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        envi.executeSystem(system_command);
    }
    @Override
    public String getId() {
        return id;
    }
}
