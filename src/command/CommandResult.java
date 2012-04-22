package command;

public class CommandResult {
    private boolean isSuccess;
    private String output;

    public CommandResult(boolean success, String output) {
        isSuccess = success;
        this.output = output;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getOutput() {
        return output;
    }
}
