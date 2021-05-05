package lang.commands.single;

public class ScrollUpCommand extends ScrollCommand {
    private static final String id = "SCROLL_UP";
    public ScrollUpCommand(int count) {
        super(-count);
        if (count < 0) {
            throw new IllegalArgumentException("A negative number of scrolls up?");
        }
    }
}
