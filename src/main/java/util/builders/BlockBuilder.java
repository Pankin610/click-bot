package util.builders;

import lang.CodeFactory;
import lang.commands.Command;

import java.util.Iterator;
import java.util.Scanner;

/**
 * This class can be used to created blocks of Commands, which later can be used to initialize subclass of AbstractGroupCommand.
 */

public final class BlockBuilder implements Builder<Command> {
    private final GeneralBuilder<Command> commands = new GeneralBuilder<>(Command.class,Command[].class);

    /**
     * Default constructor, if list is empty, then block will by default contain NOTHING command,
     * to ensure non-emptiness of CommandBlock - this may be changed later, depends on logic used in GUI.
     * @param comms list of commands.
     */
    public BlockBuilder(Command... comms){
        for(Command com : comms != null ? comms : new Command[]{Command.NOTHING})    commands.append(com);
    }

    /**
     * Casts content of Builder into regular array.
     * @return array of Commands inside Builder.
     */
    @Override
    public Command[] toArray(){
        return commands.toArray();
    }

    /**
     * Append single Command to the end of the block.
     * @param command Command to be appended.
     */
    @Override
    public void append(Command command){
        commands.append(command);
    }

    /**
     * Insert Command at given index.
     * @param command Command to be inserted.
     * @param ind index.
     */
    @Override
    public void insertInto(Command command, int ind){
        commands.insertInto(command,ind);
    }

    /**
     * @return number of commands inside Builder.
     */
    @Override
    public int size(){
        return commands.size();
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    /**
     * Method showing string representation of elements in Builder.
     */
    @Override
    public void viewContentFull(){
        for(Command element : commands){
            System.out.println(element.getStringRepresentation());
        }
    }

    /**
     * Method showing IDs of elements in Builder.
     */
    @Override
    public void viewContentId(){
        for(Command element : commands){
            System.out.println(element.getId());
        }
    }

    /**
     * Creating BlockBuilder from file description.
     * @param scanner from ReadFileObject.
     * @param num number of Commands to parse.
     */
    public void parseFromString(Scanner scanner, int num){
        for(int i=0;i<num;i++){
            append(CodeFactory.parseCommand(scanner));
        }
    }
}
