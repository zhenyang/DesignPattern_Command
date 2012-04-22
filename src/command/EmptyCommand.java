package command;

public class EmptyCommand extends Command {
    public EmptyCommand() {
        super("");
    }

    @Override
    public CommandResult execute(String path) {
        return new CommandResult(true,"");
    }
}
