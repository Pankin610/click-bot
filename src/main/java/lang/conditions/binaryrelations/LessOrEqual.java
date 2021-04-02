package lang.conditions.binaryrelations;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.IncomparableVariablesException;
import exceptions.NoVariableWithThisNameException;
import lang.conditions.Condition;
import lang.variables.Variable;

import java.util.Scanner;

public final class LessOrEqual extends BinaryRelation {
    private static final String id = "LESS_EQ";
    public LessOrEqual(String m_variable1, String m_variable2) {
        super(m_variable1, m_variable2);
    }
    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        try{
            Variable var1 = envi.getVarByName(variable1);
            Variable var2 = envi.getVarByName(variable2);
            return var1.isLessThan(var2) || var1.getValue().equals(var2.getValue());
        }
        catch (NoVariableWithThisNameException e){
            throw new EvaluationException("No variable with name: " + e.getName() + " (LessOrEqual)");
        }
        catch (IncomparableVariablesException ex){
            throw new EvaluationException("Incomparable variables (LessOrEqual)");
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Condition parseFromString(Scanner scanner) {
        String name1 = scanner.next();
        String name2 = scanner.next();
        return new LessOrEqual(name1,name2);
    }
}
