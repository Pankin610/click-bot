package lang.commands.single;

import environments.Environment;

public abstract class ScrollCommand extends AbstractSingleCommand {
  private static final String id = "SCROLL";
  protected final Integer where;

  public ScrollCommand(int where) {
    this.where = where;
  }

  @Override
  public void execute(Environment envi) {
    envi.scroll(where);
  }

  @Override
  public String getPattern() {
    return id + " number";
  }
}
