package command;

import java.io.IOException;

public class DeleteCommand implements ICommand {
    private final String shellCommand;

    public DeleteCommand() {
        shellCommand = "rm -rf ";
    }

    public boolean execute(String path) {
        try {
            Process process = Runtime.getRuntime().exec(shellCommand + path);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
        return true;
    }
}
