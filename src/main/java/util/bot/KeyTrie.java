package util.bot;

/*

    The Bot uses this class to decode and encode a sequence of keys it needs to type.
    Each Key has a specific string assigned to it, we shall call it as the key's code.

    Letters a-z as well as numbers and the space have themselves as their codes.
    For example the code for a is 'a', the code for 9 is '9', the code for space is ' ', etc.

    All the special keys, that don't produce a symbol, but do something else, have their name
    in all caps as the code.

    Examples:
    ENTER
    CTRL_LEFT
    CTRL_RIGHT
    ALT
    etc.

    Conveniently, none of these strings is a prefix of another, so we can use a similar approach
    as the one used in the Huffman encoding algorithm (https://en.wikipedia.org/wiki/Huffman_coding).
    To code a sequence of keys, we just concatenate the codes of the keys within. To encode a given
    string, we traverse, while maintaining a current Trie node, and add a key to the end of the
    sequence when a leaf is encountered.

    This breeds a very simple way to encode key sequences, both for the developer and for the user.
    The Trie traversing also allows to achieve the fastest possible encoding complexity, linear of
    the coded string's length, in case of large texts being printed by the bot.

 */


import exceptions.InvalidKeyCodeException;
import util.Key;

import java.util.ArrayList;
import java.util.Collection;

/*
    For now it's just a class with static-only fields and classes, representing a Trie of the most
    basic keys. But in the future in can be expanded to add arbitrary keys and methods.
 */
public class KeyTrie {
  static TrieNode root = new TrieNode();

  static void addKey(Key key) {
    TrieNode current = root;
    for (int i = 0; i < key.string_code.length(); i++) {
      current.addSon(key.string_code.charAt(i));
      current = current.getSon(key.string_code.charAt(i));
    }
    current.setKey(key);
  }

  // just adding all the keys defined in the Key enum
  static {
    for (Key key : Key.values()) {
      addKey(key);
    }
  }

  // code a sequence
  public static String getSequenceCode(Collection<Key> sequence) {
    StringBuilder res = new StringBuilder();
    for (Key key : sequence) {
      res.append(key.string_code);
    }
    return res.toString();
  }

  // get an integer sequence of codes for a coded string
  public static Collection<Key> getKeys(String s) {
    ArrayList<Key> result = new ArrayList<>();
    TrieNode current = root;
    for (int i = 0; i < s.length(); i++) {
      TrieNode next = current.getSon(s.charAt(i));
      if (next == null) {
        throw new InvalidKeyCodeException(s, i);
      }
      current = next;
      if (current.isLeaf()) {
        result.add(current.getKey());
        current = root;
      }
    }
    if (current != root) {
      throw new InvalidKeyCodeException(s, s.length() - 1);
    }
    return result;
  }
}
