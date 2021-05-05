package lang.commands.single;

public final class ScrollDownCommand extends ScrollCommand {
    private static final String id = "SCROLL_DOWN";
    public ScrollDownCommand(int count) {
        super(count);
        if (count < 0) {
            throw new IllegalArgumentException("A negative number of scrolls down?");
        }
    }
}
