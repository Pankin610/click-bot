package util.builders;

import exceptions.NoUniqueVariableNameException;
import files.reading.ReadFileObject;
import lang.commands.Command;
import lang.variables.Variable;

/**
 * Class used to build programs. Can be used later in Program's constructor.
 */

public final class ProgramBuilder {
    private final Builder<Variable> variables = new GeneralBuilder<>(Variable.class,Variable[].class);
    private final Builder<Command> commands = new GeneralBuilder<>(Command.class,Command[].class);
    public ProgramBuilder(){}

    /**
     * Creates ProgramBuilder basing on file description of program.
     * @param file with description of the program.
     */
    @SuppressWarnings("unused")
    public ProgramBuilder(ReadFileObject file){
        /* TODO: implementation of Program-parsing from file. */
    }

    /**
     * @return commands in form of array.
     */
    public Command[] getCommands(){
        return commands.toArray();
    }

    /**
     * @return variables in form of array.
     */
    public Variable[] getVariables() {
        return variables.toArray();
    }

    /**
     * Add Variable to the list of variables. Checks for uniqueness of variables' names.
     * @param variable variable to be added.
     */
    public void addVariable(Variable variable) throws NoUniqueVariableNameException {
        if(checkIfContains(variable.getName())) throw new NoUniqueVariableNameException(variable.getName());
        variables.append(variable);
    }

    private boolean checkIfContains(String name){
        for(Variable var : variables)   if(name.equals(var.getName()))  return true;
        return false;
    }

    /**
     * Add Commands to the end of list of Commands.
     * @param command commands to be appended.
     */
    public void addCommand(Command command){
        commands.append(command);
    }

    /**
     * View current list of Variables.
     */
    public void viewVariablesFull(){
        variables.viewContentFull();
    }


    /**
     * View id's of commands in the Builder.
     */
    public void viewVariablesId(){
        variables.viewContentId();
    }

    /**
     * View current list of Commands.
     */
    public void viewCommands(){
        commands.viewContentFull();
    }

    /**
     * View id's of commands in the Builder.
     */
    public void viewCommandsId(){
        commands.viewContentId();
    }
}
