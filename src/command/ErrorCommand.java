package command;

import java.io.IOException;

class ErrorCommand implements ICommand {
    public boolean execute(String path) {
        try {
            Process process = Runtime.getRuntime().exec("badcommand "+ path);
            process.waitFor();
            return true;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
    }
}
