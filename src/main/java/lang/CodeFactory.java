package lang;

import lang.commands.Command;
import lang.commands.group.IfCondition;
import lang.commands.group.IfElse;
import lang.commands.group.Repeat;
import lang.commands.group.While;
import lang.conditions.False;
import lang.conditions.Not;
import lang.conditions.True;
import lang.conditions.binaryconditions.And;
import lang.conditions.binaryconditions.Or;
import lang.conditions.binaryrelations.*;
import lang.variables.IntegerVariable;
import lang.variables.Pixel;

import java.util.HashMap;

/**
 * Factory of final implementations of CodeFragment interface.
 * Used in Identifier, necessary for parsing CodeFragment from String.
 * Should contain static instance of every CodeFragment final implementation.
 * These instances can be used also for testing (as they are cached, and assertSame works for them).
 */

public final class CodeFactory {
    private CodeFactory(){}
    /**
     * @param ID of wanted instance.
     * @return instance of final implementation of CodeFragment with given ID.
     */
    public static CodeFragment getInstanceByID(String ID){
        return myMap.get(ID);
    }
    /* Variables */
    public static final IntegerVariable INTEGER_VARIABLE = new IntegerVariable("INTEGER_VARIABLE",0);
    public static final Pixel PIXEL = new Pixel("PIXEL",0,0);
    /* Conditions */
    public static final True TRUE = new True();
    public static final False FALSE = new False();
    public static final Not NOT = new Not(TRUE);
    public static final And AND = new And(TRUE,TRUE);
    public static final Or OR = new Or(TRUE,TRUE);
    public static final Equal EQUAL = new Equal(null, null);
    public static final NotEqual NOT_EQUAL = new NotEqual(null,null);
    public static final Less LESS = new Less(null,null);
    public static final LessOrEqual LESS_OR_EQUAL = new LessOrEqual(null,null);
    public static final Greater GREATER = new Greater(null,null);
    public static final GreaterOrEqual GREATER_OR_EQUAL = new GreaterOrEqual(null,null);
    /* Commands */
    public static final Command NOTHING = Command.NOTHING;
    public static final IfCondition IF_CONDITION = new IfCondition(new Command[]{NOTHING},TRUE);
    public static final IfElse IF_ELSE = new IfElse(new Command[]{NOTHING}, new Command[]{NOTHING},TRUE);
    public static final Repeat REPEAT = new Repeat(new Command[]{NOTHING},0);
    public static final While WHILE = new While(new Command[]{NOTHING},TRUE);
    /* To be continued */
    private static final HashMap<String, CodeFragment> myMap = new HashMap<>();
    static{
        /* Every static instance should be put into myMap */
        myMap.put(INTEGER_VARIABLE.getId(),INTEGER_VARIABLE);
        myMap.put(PIXEL.getId(),PIXEL);
        myMap.put(TRUE.getId(),TRUE);
        myMap.put(FALSE.getId(),FALSE);
        myMap.put(NOT.getId(),NOT);
        myMap.put(AND.getId(),AND);
        myMap.put(OR.getId(),OR);
        myMap.put(EQUAL.getId(),EQUAL);
        myMap.put(LESS.getId(),LESS);
        myMap.put(LESS_OR_EQUAL.getId(),LESS_OR_EQUAL);
        myMap.put(GREATER.getId(),GREATER);
        myMap.put(GREATER_OR_EQUAL.getId(),GREATER_OR_EQUAL);
        myMap.put(NOTHING.getId(),NOTHING);
        myMap.put(IF_CONDITION.getId(), IF_CONDITION);
        myMap.put(IF_ELSE.getId(),IF_ELSE);
        myMap.put(REPEAT.getId(),REPEAT);
        myMap.put(WHILE.getId(),WHILE);
        /* To be continued */
    }
}
