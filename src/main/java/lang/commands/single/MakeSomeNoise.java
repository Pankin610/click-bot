package lang.commands.single;

import environments.Environment;
import lang.commands.Command;
import util.gui.CodeItem;

import java.awt.*;
import java.util.Scanner;

/**
 * Simple command which makes noise.
 */
public final class MakeSomeNoise extends AbstractSingleCommand {
    private static final String id = "MAKE_SOME_NOISE";
    private static final MakeSomeNoise MAKE_SOME_NOISE = new MakeSomeNoise();
    @Override
    public void execute(Environment envi) {
        Toolkit.getDefaultToolkit().beep();
    }

    @Override
    public String getStringRepresentation() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Command parseFromString(Scanner scanner) {
        return MAKE_SOME_NOISE;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public CodeItem getTreeRepresentation() {
        return new CodeItem(MAKE_SOME_NOISE);
    }
}
