package command;

import java.io.IOException;

public class CheckOutCodeCommand implements ICommand {

    private final String shellCommand;

    public CheckOutCodeCommand() {
        shellCommand = "git clone git://github.com/khu/emptyrepo.git ";
    }

    public void execute(String path) {
        try {
            Process process = Runtime.getRuntime().exec(shellCommand + path);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
