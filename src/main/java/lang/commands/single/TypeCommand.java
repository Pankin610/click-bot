package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Bot.KeyTrie;
import util.Key;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public final class TypeCommand extends SingleCommand {
    private static final String id = "TYPE";
    final Key[] key_list;
    public TypeCommand(String m_sequence) {
        key_list = (Key[]) KeyTrie.getKeys(m_sequence).toArray();
    }
    public TypeCommand(Collection<Key> m_key_list) {
        key_list = (Key[]) m_key_list.toArray();
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        for (Key key : key_list) {
            envi.pressKey(key.integer_code);
        }
    }
    @Override
    public String getStringRepresentation() {
        return getId() + " " + KeyTrie.getSequenceCode(Arrays.asList(key_list.clone()));
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new TypeCommand(scanner.next());
    }
}
