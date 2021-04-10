package util.Bot;

import org.junit.Test;
import util.Key;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KeyTrieTest {
    @Test
    public void codingTest() {
        String test_string = "abcdSHIFTesjiENTERALT";
        ArrayList<Key> result = KeyTrie.getKeys(test_string);
        for (Key i : result) {
            System.out.println(i.string_code);
        }
        assertEquals(test_string, KeyTrie.getSequenceCode(result));
    }
}
