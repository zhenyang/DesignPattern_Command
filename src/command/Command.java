package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Command {
    private final String shellCommand;

    protected Command(String shellCommand) {
        this.shellCommand = shellCommand;
    }

    public CommandResult execute(String path) {
        try {
            Process process = Runtime.getRuntime().exec(shellCommand + path);
            process.waitFor();

            return generateResult(process);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return new CommandResult(false, e.getMessage());
        }
    }

    private CommandResult generateResult(Process process) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String result = "";
        String line;
        while ((line = in.readLine()) != null) {
            result += line + "\n";
        }
        return new CommandResult(true, result);
    }

}
