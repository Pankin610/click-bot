package environments;

import exceptions.ExecException;
import program.Program;
import util.Bot;
import util.Coordinate;

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
        super.clickLeft();
    }

    @Override
    public void clickRight() {
        super.clickRight();
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
    public Integer getPixel(Coordinate cords) {
        return super.getPixel(cords);
    }
    //Overrode methods (desktop implementation, using real mouse and keyboard)
}
