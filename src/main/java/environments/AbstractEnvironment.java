package environments;

import exceptions.ExecException;
import exceptions.NoVariableWithThisNameException;
import lang.commands.Command;
import lang.variables.Mouse;
import lang.variables.Variable;
import program.Program;
import util.Coordinate;
import util.VariableContainer;

/**
 * Abstract environment contains default (Console) implementation of methods associated with instances of Command interface,
 * such as PushButton, Move, Hold, etc...
 */

public abstract class AbstractEnvironment implements Environment {
    protected final VariableContainer variables = new VariableContainer();
    protected Mouse myMouse = new Mouse("Mouse",0,0);
    protected AbstractEnvironment(Program program){
        variables.addAll(program.getVariables());
    }
    @Override
    public void runProgram(Program program) throws ExecException {
        for(Command com : program.getCommands()){
            com.execute(this);
        }
    }

    @Override
    public void pressKey(int key){
        System.out.println("Pushing key: " + key);
    }

    @Override
    public void moveMouseTo(Coordinate destination){
        myMouse.moveTo(destination);
        System.out.println("Moving mouse to:" + destination);
    }

    @Override
    public void moveMouseBy(Coordinate cords){
        myMouse.moveBy(cords);
        System.out.println("Moving mouse by:" + cords);
    }

    @Override
    public void wait(int tim){
        System.out.println("I'm waiting "+ tim + " time");
    }

    @Override
    public void clickLeft(){
        System.out.println("Clicking left");
    }

    @Override
    public void clickRight(){
        System.out.println("Clicking right");
    }

    @Override
    public void scroll(){
        System.out.println("Scrolling");
    }

    @Override
    public void hold(int tim) {
        System.out.println("Holding for "+tim + " time");
    }

    @Override
    public void drag(Coordinate where) {
        System.out.println("Dragging to: "+where);
    }

    @Override
    public Variable getVarByName(String name) throws NoVariableWithThisNameException {
        for(Variable var : variables)   if(var.getName().equals(name))  return var;
        throw new NoVariableWithThisNameException(name);
    }

    @Override
    public boolean isThereVariable(String varName) {
        if(variables == null)   return false;
        for(Variable var : variables)   if(varName.equals(var.getName()))  return true;
        return false;
    }

    @Override
    public Integer getPixel(Coordinate cords) {
        return 0;
    }


}
