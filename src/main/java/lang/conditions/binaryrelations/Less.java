package lang.conditions.binaryrelations;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.IncomparableVariablesException;
import exceptions.NoVariableWithThisNameException;

public final class Less extends BinaryRelation {
    private static final String id = "LESS";
    public Less(String m_variable1, String m_variable2) {
        super(m_variable1, m_variable2);
    }
    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        try{
            return envi.getVarByName(variable1).isLessThan(envi.getVarByName(variable2));
        }
        catch (NoVariableWithThisNameException e){
            throw new EvaluationException("No variable with name: " + e.getName() + " (Less)");
        }
        catch (IncomparableVariablesException ex){
            throw new EvaluationException("Incomparable variables (Less)");
        }
    }

    @Override
    public String getId() {
        return id;
    }
}