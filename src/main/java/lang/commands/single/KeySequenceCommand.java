package lang.commands.single;

import util.Key;
import util.bot.KeyTrie;

import java.util.Collection;

/**
 * All commands that work with a coded sequence of keys should extend
 * this abstract class.
 */
public abstract class KeySequenceCommand extends AbstractSingleCommand {
  final Collection<Key> key_sequence;

  public KeySequenceCommand(Collection<Key> key_sequence) {
    this.key_sequence = key_sequence;
  }

  public KeySequenceCommand(String code) {
    key_sequence = KeyTrie.getKeys(code);
  }

  @Override
  public String getStringRepresentation() {
    return getId() + ' ' + KeyTrie.getSequenceCode(key_sequence);
  }
}
