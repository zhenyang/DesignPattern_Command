package command;

public class Agent {

    public CommandResult executeTaskFrom(Server server) {
        Command command = server.acceptRequest();
        return command.execute("target");
    }
}
