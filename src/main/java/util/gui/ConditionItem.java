package util.gui;

import javafx.scene.control.TreeItem;
import lang.conditions.Condition;

public class ConditionItem extends TreeItem<String> {
    private final Condition condition;

    public ConditionItem(Condition condition){
        this.condition = condition;
        setValue(condition.getId());
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return condition.getStringRepresentation();
    }
}
