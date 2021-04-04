package util.Bot;

import exceptions.TrieStructureViolatedException;

import java.util.Map;
import java.util.TreeMap;

/*
    Basic TrieNode for the KeyTrie.
    For more information go to the KeyTrie class.
 */
class TrieNode {
    private Integer key_code = null; // the code is null if the node isn't a leaf
    private Map<Character, TrieNode> sons = new TreeMap<>();
    // adding a new son with a corresponding character edge, if none
    void addSon(Character edge) {
        if (key_code != null) {
            throw new TrieStructureViolatedException("The " + this + " node is a leaf, therefore a son" +
                    "cannot be added.");
        }
        if (sons.containsKey(edge)) {
            return;
        }
        sons.put(edge, new TrieNode());
    }
    boolean isLeaf() {
        return  key_code != null;
    }
    Integer getKeyCode() {
        return key_code;
    }
    TrieNode getSon(Character c) {
        if (c == null) {
            throw new NullPointerException("A code character cannot be null");
        }
        return sons.getOrDefault(c, null);
    }
    void setKeyCode(int code) {
        if (sons.size() > 0) {
            throw new TrieStructureViolatedException("The " + this + " node is not a leaf, therefore a key code cannot" +
                    "be assigned to it.");
        }
        key_code = code;
    }
}
