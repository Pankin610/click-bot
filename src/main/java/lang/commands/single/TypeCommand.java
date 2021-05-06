package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Key;

import java.util.Collection;
import java.util.Scanner;

public final class TypeCommand extends KeySequenceCommand {
    private static final String id = "TYPE";

    public TypeCommand(Collection<Key> m_key_sequence) {
        super(m_key_sequence);
    }
    public TypeCommand(String code) {
        super(code);
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        for (Key key : key_sequence) {
            envi.pressKey(key.integer_code);
        }
    }
    @Override
    public String getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Command parseFromString(Scanner scanner) {
        return new TypeCommand(scanner.nextLine());
    }
}
