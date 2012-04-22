package command;

public class CheckOutCodeCommand extends Command {
    public CheckOutCodeCommand() {
        super("git clone git://github.com/khu/emptyrepo.git ");
    }
}
