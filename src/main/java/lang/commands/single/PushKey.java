package lang.commands.single;

import environments.Environment;
import lang.commands.SingleCommand;

public class PushKey extends SingleCommand {
    final private char let;
    public PushKey(char z){
        let = z;
    }
    public void exec(Environment envi){
        envi.pushKey(let);
    }
}
