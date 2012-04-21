package command;

public class Server {
    private ICommand command;

    public Server(ICommand command) {
        this.command = command;
    }

    public Server() {
        this.command = new EmptyCommand();
    }

    public ICommand acceptRequest() {
        return command;
    }
}
