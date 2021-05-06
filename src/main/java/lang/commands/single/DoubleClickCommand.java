package lang.commands.single;

import environments.DesktopEnvironment;
import environments.Environment;
import exceptions.EnvironmentNotSupportedException;
import exceptions.ExecException;
import lang.commands.Command;

import java.util.Scanner;

public class DoubleClickCommand extends AbstractSingleCommand {
    private static final String id = "DOUBLE_CLICK";
    @Override
    public void execute(Environment envi) throws ExecException {
        if (envi instanceof DesktopEnvironment desktop_envi) {
            desktop_envi.doubleClick();
        }
        else {
            throw new EnvironmentNotSupportedException(envi, this);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new LeftClickCommand();
    }
    @Override
    public String getId() {
        return id;
    }
}
