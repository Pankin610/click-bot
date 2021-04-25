package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Key;

import java.util.Collection;
import java.util.Scanner;

public final class HoldKeysCommand extends KeySequenceCommand {
    private static final String id = "HOLD";

    public HoldKeysCommand(Collection<Key> m_key_sequence) {
        super(m_key_sequence);
    }
    public HoldKeysCommand(String code) {
        super(code);
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        for (Key key : key_sequence) {
            envi.holdKey(key.integer_code);
        }
    }
    @Override
    public String getId() {
        return id;
    }

    // basic parsing
    // TODO problem with spaces, scanner does not read the entire line
    @SuppressWarnings("unchecked")
    public Command parseFromString(Scanner scanner) {
        return new HoldKeysCommand(scanner.next());
    }
}