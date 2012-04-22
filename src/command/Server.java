package command;

public class Server {
    private Command command;

    public Server(Command command) {
        this.command = command;
    }

    public Server() {
        this.command = new EmptyCommand();
    }

    public Command acceptRequest() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
