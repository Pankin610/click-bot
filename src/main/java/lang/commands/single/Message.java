package lang.commands.single;

import environments.Environment;
import lang.commands.SingleCommand;

public class Message extends SingleCommand {
    private final String mess;
    public Message(String m_mess){
        mess = m_mess;
    }
    @Override
    public void exec(Environment envi){
        System.out.println(mess);
    }
}
