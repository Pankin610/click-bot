package lang.conditions.binaryrelations;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.NoVariableWithThisNameException;

public final class NotEqual extends BinaryRelation {
    private static final String id = "NOT_EQ";
    public NotEqual(String m_variable1, String m_variable2) {
        super(m_variable1, m_variable2);
    }
    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        try{
            return !(envi.getVarByName(variable1).getValue().equals(envi.getVarByName(variable2).getValue()));
        }
        catch(NoVariableWithThisNameException e){
            throw new EvaluationException("Variable with name: " + e.getName() + " not found (NotEqual)");
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
