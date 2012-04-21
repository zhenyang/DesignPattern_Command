import command.Agent;
import command.CheckOutCodeCommand;
import command.Server;
import org.apache.commons.io.FileUtils;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AgentTest {

    private Agent agent = new Agent();

    @After
    public void tearDown() throws Exception {
        File targetDir = new File("./target");
        System.out.println("In After: about to delete:" + Arrays.toString(targetDir.list()));
        FileUtils.deleteDirectory(targetDir);
    }

    @Test
    public void should_do_nothing_when_receive_empty_command_from_server() throws Exception {
        Server server = new Server();

        File fileBefore = new File(".");
        agent.executeTaskFrom(server);
        File fileAfter = new File(".");

        assertThat(fileBefore.list(), Is.is(fileAfter.list()));
    }

    @Test
    public void should_clone_git_repo_when_ask_server_for_command() throws Exception {
        Server server = new Server(new CheckOutCodeCommand());

        agent.executeTaskFrom(server);

        File file = new File("./target");
        assertThat(file.list(), notNullValue());
    }
//
//    @Test
//    public void test_command_fail_should_return_false() throws Exception {
//        agent.askForCommand(new Server(new PullCode(1, "impossible command")));
//        assertThat(agent.execute(), is(false));
//    }
}
