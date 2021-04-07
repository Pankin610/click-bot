package util;

import java.awt.event.KeyEvent;

public enum Key {
    A("a", KeyEvent.VK_A),
    B("b", KeyEvent.VK_B),
    C("c", KeyEvent.VK_C),
    D("d", KeyEvent.VK_D),
    E("e", KeyEvent.VK_E),
    F("f", KeyEvent.VK_F),
    G("g", KeyEvent.VK_G),
    H("h", KeyEvent.VK_H),
    I("i", KeyEvent.VK_I),
    J("j", KeyEvent.VK_J),
    K("k", KeyEvent.VK_K),
    L("l", KeyEvent.VK_L),
    M("m", KeyEvent.VK_M),
    N("n", KeyEvent.VK_N),
    O("o", KeyEvent.VK_O),
    P("p", KeyEvent.VK_P),
    Q("q", KeyEvent.VK_Q),
    R("r", KeyEvent.VK_R),
    S("s", KeyEvent.VK_S),
    T("t", KeyEvent.VK_T),
    U("u", KeyEvent.VK_U),
    V("v", KeyEvent.VK_V),
    W("w", KeyEvent.VK_W),
    X("x", KeyEvent.VK_X),
    Y("y", KeyEvent.VK_Y),
    Z("z", KeyEvent.VK_Z),
    Enter("ENTER", KeyEvent.VK_ENTER),
    Alt("ALT", KeyEvent.VK_ALT),
    Space(" ", KeyEvent.VK_SPACE),
    Esc("ESC", KeyEvent.VK_ESCAPE),
    Shift("SHIFT", KeyEvent.VK_SHIFT),
    Ctrl("CTRL", KeyEvent.VK_CONTROL),
    CapsLock("CAPS_LOCK", KeyEvent.VK_CAPS_LOCK),
    _1("1", KeyEvent.VK_1),
    _2("2", KeyEvent.VK_2),
    _3("3", KeyEvent.VK_3),
    _4("4", KeyEvent.VK_4),
    _5("5", KeyEvent.VK_5),
    _6("6", KeyEvent.VK_6),
    _7("7", KeyEvent.VK_7),
    _8("8", KeyEvent.VK_8),
    _9("9", KeyEvent.VK_9),
    _0("0", KeyEvent.VK_0),
    F1("F1", KeyEvent.VK_F1),
    F2("F2", KeyEvent.VK_F2),
    F3("F3", KeyEvent.VK_F3),
    F4("F4", KeyEvent.VK_F4),
    F5("F5", KeyEvent.VK_F5),
    F6("F6", KeyEvent.VK_F6),
    F7("F7", KeyEvent.VK_F7),
    F8("F8", KeyEvent.VK_F8),
    F9("F9", KeyEvent.VK_F9),
    F10("F10", KeyEvent.VK_F10),
    F11("F11", KeyEvent.VK_F11),
    F12("F12", KeyEvent.VK_F12);

    public final String string_code;
    public final int integer_code;
    Key(String m_string_code, int m_integer_code) {
        string_code = m_string_code;
        integer_code = m_integer_code;
    }

    public static Key getKeyByIntegerCode(int code) {
        for (Key key : values()) {
            if (key.integer_code == code) {
                return key;
            }
        }
        return null;
    }
}
