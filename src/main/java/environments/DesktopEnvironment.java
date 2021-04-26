package environments;

import program.Program;
import util.Bot.Bot;
import util.Coordinate;

import java.awt.*;

/**
 * Environment in which Bot implementation of Commands is used.
 */

public final class DesktopEnvironment extends AbstractEnvironment {
    private final Bot bot;

    public DesktopEnvironment(Program program, Bot bot) {
        super(program);
        this.bot = bot;
    }

    @Override
    public void pressKey(int key) {
        bot.pressKey(key);
    }

    @Override
    public void moveMouseTo(Coordinate destination) {
        myMouse.moveTo(destination);
        bot.moveMouse(destination.x, destination.y);
    }

    @Override
    public void moveMouseBy(Coordinate cords) {
        super.moveMouseBy(cords);
    }

    @Override
    public void wait(int tim) {
        bot.wait(tim);
    }

    @Override
    public void clickLeft() {
        bot.leftClick();
    }

    @Override
    public void clickRight() {
        bot.rightClick();
    }

    @Override
    public void scroll() {
        super.scroll();
    }

    @Override
    public void hold(int tim) {
        super.hold(tim);
    }

    @Override
    public void drag(Coordinate where) {
        super.drag(where);
    }

    @Override
    public Color getPixelColor(Coordinate cords) {
        return bot.getPixelColor(cords);
    }

    @Override
    public void errorNoise() {
        Toolkit.getDefaultToolkit().beep();
        bot.delay();
    }
}
