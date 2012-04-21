package command;

public class Agent {

    public boolean executeTaskFrom(Server server) {
        ICommand command = server.acceptRequest();
        return command.execute("target");
    }
}
