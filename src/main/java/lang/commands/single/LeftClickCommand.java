package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Coordinate;

import java.util.Scanner;

public class LeftClickCommand extends AbstractSingleCommand {
    private static final String id = "LEFT_CLICK";
    @Override
    public void execute(Environment envi) throws ExecException {
        envi.clickLeft();
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
