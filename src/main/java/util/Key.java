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
    Ctrl("CTRL", KeyEvent.VK_CONTROL);

    public final String string_code;
    public final int integer_code;
    Key(String m_string_code, int m_integer_code) {
        string_code = m_string_code;
        integer_code = m_integer_code;
    }
}
