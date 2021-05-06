package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

import java.util.Scanner;

public class RightClickCommand extends AbstractSingleCommand {
    private static final String id = "RIGHT_CLICK";
    @Override
    public void execute(Environment envi) throws ExecException {
        envi.clickRight();
    }
    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new RightClickCommand();
    }
    @Override
    public String getId() {
        return id;
    }
}
