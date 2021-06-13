package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

import java.awt.event.InputEvent;
import java.util.Scanner;

/**
 * Command for fast clicking (even 3000 CPS).
 */
public class LeftClickVeryFast extends AbstractSingleCommand{
    private static final String id = "LEFT_CLICK_FAST";
    private final long time;

    public LeftClickVeryFast(long time_in_milliseconds){
        this.time = time_in_milliseconds;
    }

    @Override
    public String getStringRepresentation() {
        return id + ' ' + time;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Command parseFromString(Scanner scanner) {
        return new LeftClickVeryFast(scanner.nextLong());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        envi.clickFast(time,InputEvent.BUTTON1_DOWN_MASK);
    }

    @Override
    public String getPattern() {
        return "LEFT_CLICK_FAST time";
    }
}
