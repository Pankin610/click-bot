package lang.conditions;

import environments.Environment;

import java.util.Scanner;

public class CheckMouseColor extends AbstractCondition {
    private static final String id = "CHECK_MOUSE_COLOR";
    private final int color;
    CheckMouseColor(int color){
        this.color = color;
    }
    @Override
    public boolean eval(Environment envi) {
        return envi.getPixelColor(envi.getPosition()).getRGB() == color;
    }

    @Override
    public String getStringRepresentation() {
        return getId() + ' ' + color;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Condition parseFromString(Scanner scanner) {
        return new CheckMouseColor(scanner.nextInt());
    }

    @Override
    public String getId() {
        return id;
    }
}
