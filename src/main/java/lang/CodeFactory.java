package lang;

import lang.commands.Command;
import lang.commands.group.IfCondition;
import lang.commands.group.IfElse;
import lang.commands.group.Repeat;
import lang.commands.group.While;
import lang.commands.single.Wait;
import lang.conditions.Condition;
import lang.conditions.False;
import lang.conditions.Not;
import lang.conditions.True;
import lang.conditions.binaryconditions.And;
import lang.conditions.binaryconditions.Or;
import lang.conditions.binaryrelations.*;
import lang.variables.IntegerVariable;
import lang.variables.Pixel;
import lang.variables.StringVariable;
import lang.variables.Variable;

import java.util.HashMap;
import java.util.Scanner;

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
    public static Variable getVariableByID(String ID){
        return varMap.get(ID);
    }
    public static Condition getConditionByID(String ID) {
        return condMap.get(ID);
    }
    public static Command getCommandByID(String ID){
        return commMap.get(ID);
    }
    public static Variable parseVariable(Scanner scanner){
        return getVariableByID(scanner.next()).parseFromString(scanner);
    }
    public static Condition parseCondition(Scanner scanner){
        return getConditionByID(scanner.next()).parseFromString(scanner);
    }
    public static Command parseCommand(Scanner scanner){
        return getCommandByID(scanner.next()).parseFromString(scanner);
    }
    /* Variables */
    public static final IntegerVariable INTEGER_VARIABLE = new IntegerVariable("INTEGER_VARIABLE",0);
    public static final Pixel PIXEL = new Pixel("PIXEL",0,0);
    public static final StringVariable STRING_VARIABLE = new StringVariable("STRING_VARIABLE","");
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
    public static final Wait WAIT = new Wait(1000);
    /* To be continued */
    private static final HashMap<String, Variable> varMap = new HashMap<>();
    private static final HashMap<String, Condition> condMap = new HashMap<>();
    private static final HashMap<String, Command> commMap = new HashMap<>();
    static {
        /* Every static instance should be put in corresponding map */
        /* VARIABLES */
        varMap.put(INTEGER_VARIABLE.getId(),INTEGER_VARIABLE);
        varMap.put(PIXEL.getId(),PIXEL);
        varMap.put(STRING_VARIABLE.getId(),STRING_VARIABLE);
        /* CONDITIONS */
        condMap.put(TRUE.getId(),TRUE);
        condMap.put(FALSE.getId(),FALSE);
        condMap.put(NOT.getId(),NOT);
        condMap.put(AND.getId(),AND);
        condMap.put(OR.getId(),OR);
        condMap.put(EQUAL.getId(),EQUAL);
        condMap.put(NOT_EQUAL.getId(),NOT_EQUAL);
        condMap.put(LESS.getId(),LESS);
        condMap.put(LESS_OR_EQUAL.getId(),LESS_OR_EQUAL);
        condMap.put(GREATER.getId(),GREATER);
        condMap.put(GREATER_OR_EQUAL.getId(),GREATER_OR_EQUAL);
        /* COMMANDS */
        commMap.put(NOTHING.getId(),NOTHING);
        commMap.put(IF_CONDITION.getId(), IF_CONDITION);
        commMap.put(IF_ELSE.getId(),IF_ELSE);
        commMap.put(REPEAT.getId(),REPEAT);
        commMap.put(WHILE.getId(),WHILE);
        commMap.put(WAIT.getId(),WAIT);
        /* To be continued */
    }
}
