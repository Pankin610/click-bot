package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Coordinate;

import java.util.Scanner;

public class DragCommand extends AbstractSingleCommand {
    private static final String id = "DRAG";
    private final Coordinate where;
    public DragCommand(Coordinate m_where) {
        where = m_where;
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        envi.drag(where);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new DragCommand(new Coordinate(scanner.nextInt(), scanner.nextInt()));
    }
    @Override
    public String getId() {
        return id;
    }
}
