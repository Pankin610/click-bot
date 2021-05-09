package lang.conditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.CodeFragment;

public interface Condition extends CodeFragment {
  boolean eval(Environment envi) throws EvaluationException;
}
