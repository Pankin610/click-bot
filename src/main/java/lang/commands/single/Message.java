package lang.commands.single;

import environments.Environment;

/**
 * This command should be used only in Console environment for testing purposes.
 */

public final class Message extends SingleCommand {
    private final String mess;
    public Message(String m_mess){
        mess = m_mess;
    }
    @Override
    public void execute(Environment envi){
        System.out.println(mess);
    }
}
