package command;

public class EmptyCommand implements ICommand {
    public EmptyCommand() {
    }

    public boolean execute(String path) {
        return true;
    }
}
