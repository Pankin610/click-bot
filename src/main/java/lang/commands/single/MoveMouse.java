package lang.commands.single;

import environments.Environment;
import lang.commands.Command;
import util.Coordinate;

import java.util.Scanner;

public final class MoveMouse extends AbstractSingleCommand {
    private static final String id = "MOVE";
    private final Coordinate destination;
    public MoveMouse(Coordinate destination) {
        this.destination = destination;
    }
    @Override
    public void execute(Environment envi) {
        envi.moveMouseTo(destination);
    }
    @Override
    public String getStringRepresentation() {
        return getId() + " " + destination;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new MoveMouse(new Coordinate(scanner.nextInt(), scanner.nextInt()));
    }
}
