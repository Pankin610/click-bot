package environments;

import program.Program;
import util.Bot.Bot;
import util.Coordinate;

import java.awt.*;
import java.io.IOException;

/**
 * Environment in which Bot implementation of Commands is used.
 */

public final class DesktopEnvironment extends AbstractEnvironment {
    private final Bot bot;

    public DesktopEnvironment(Program program) {
        super(program);
        this.bot = new Bot();
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
    public Coordinate getPosition() {
        Point pnt = MouseInfo.getPointerInfo().getLocation();
        return new Coordinate(pnt);
    }

    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = new Robot();
        for(int i=0;i<10;i++){
            System.in.read();
            Coordinate cord = new Coordinate(MouseInfo.getPointerInfo().getLocation());
            System.out.println(robot.getPixelColor(cord.x, cord.y).getRGB());
        }
    }
}
