package lang.commands.single;

import environments.Environment;

public final class PressKey extends SingleCommand {
    final private int key;
    public PressKey(int key) {
        this.key = key;
    }
    @Override
    public void execute(Environment envi){
        envi.pressKey(key);
    }
}

