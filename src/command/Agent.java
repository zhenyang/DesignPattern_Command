package command;

public class Agent {

    public void executeTaskFrom(Server server) {
        ICommand command = server.acceptRequest();
        command.execute("target");

    }
}
