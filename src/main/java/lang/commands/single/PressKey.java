package lang.commands.single;

import environments.Environment;
import lang.commands.Command;

import java.util.Scanner;

public final class PressKey extends AbstractSingleCommand {
    private static final String id = "PRESS";
    final private int key;
    public PressKey(int key) {
        this.key = key;
    }
    @Override
    public void execute(Environment envi){
        envi.pressKey(key);
    }
    @Override
    public String getStringRepresentation() {
        return getId() + " " + key;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new PressKey(scanner.nextInt());
    }
}

