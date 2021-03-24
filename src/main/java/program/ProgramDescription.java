package program;

import environments.Environment;
import exceptions.ExecException;
import files.reading.ReadFileObject;
import files.writing.WriteFileObject;
import lang.commands.Command;
import lang.variables.Variable;
import util.builders.ProgramBuilder;

import java.io.FileNotFoundException;

/**
 * Implementation of Program functionality. Instances of this class are immutable, with all fields 'final' (and private),
 * Whole part of constructing is handled by ProgramBuilder class.
 */

public final class ProgramDescription implements Program {
    private final Command[] commands;
    private final Variable[] variables;
    private final String name;

    /**
     * Creating Program instance basing on ProgramBuilder.
     * @param program description of Program in ProgramBuilder.
     */
    public ProgramDescription(ProgramBuilder program){
        name = "dummy"; /* naming possibility will be added later */
        final Variable[] vars = program.getVariables();
        final Command[] comms = program.getCommands();
        variables = new Variable[vars.length];
        System.arraycopy(vars, 0, variables, 0, vars.length);
        commands = new Command[comms.length];
        System.arraycopy(comms, 0, commands, 0, comms.length);
    }

    /**
     * Creating Program instance basing on file description.
     * @param file with program description.
     */
    public ProgramDescription(ReadFileObject file){
        this(new ProgramBuilder(file));
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        for(Command command : commands) command.execute(envi);
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Variable[] getVariables() {
        return variables;
    }

    @Override
    public Command[] getCommands() {
        return commands;
    }

    public void saveToFile(WriteFileObject file) throws FileNotFoundException {
        file.saveToFile(this);
    }
}
