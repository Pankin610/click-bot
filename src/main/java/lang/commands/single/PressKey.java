package lang.commands.single;

import environments.Environment;
import lang.commands.Command;
import util.Bot.KeyTrie;
import util.Key;

import java.util.Arrays;
import java.util.Scanner;

public final class PressKey extends SingleCommand {
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
        return getId() + " " + Key.getKeyByIntegerCode(key).string_code;
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

