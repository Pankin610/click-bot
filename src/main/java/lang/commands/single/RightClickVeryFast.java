package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

import java.awt.event.InputEvent;
import java.util.Scanner;

public class RightClickVeryFast extends AbstractSingleCommand{
    private static final String id = "RIGHT_CLICK_FAST";
    private final long time;

    public RightClickVeryFast(long time_in_milliseconds){
        this.time = time_in_milliseconds;
    }

    @Override
    public String getStringRepresentation() {
        return id + ' ' + time;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Command parseFromString(Scanner scanner) {
        return new RightClickVeryFast(scanner.nextLong());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        envi.clickFast(time,InputEvent.BUTTON3_DOWN_MASK);
    }

    @Override
    public String getPattern() {
        return id + " time";
    }
}

