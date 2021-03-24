package lang.commands.single;

import environments.Environment;
import util.Coordinate;

public final class MoveMouse extends SingleCommand {
    private final Coordinate destination;
    public MoveMouse(Coordinate destination) {
        this.destination = destination;
    }
    @Override
    public void execute(Environment envi) {
        envi.moveMouseTo(destination);
    }
}
