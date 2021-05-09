package lang.conditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.CodeFragment;
import util.gui.CodeItem;

public interface Condition extends CodeFragment {
  boolean eval(Environment envi) throws EvaluationException;
  CodeItem getCodeItem();
}
