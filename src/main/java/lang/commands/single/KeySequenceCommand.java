package lang.commands.single;

import util.Bot.KeyTrie;
import util.Key;

import java.util.Collection;

/**
 * All commands that work with a coded sequence of keys should extend
 * this abstract class.
 */
public abstract class KeySequenceCommand extends AbstractSingleCommand {
    final Collection<Key> key_sequence;
    public KeySequenceCommand(Collection<Key> m_key_sequence) {
        key_sequence = m_key_sequence;
    }
    public KeySequenceCommand(String code) {
        key_sequence = KeyTrie.getKeys(code);
    }
    @Override
    public String getStringRepresentation() {
        return getId() + KeyTrie.getSequenceCode(key_sequence);
    }
}
