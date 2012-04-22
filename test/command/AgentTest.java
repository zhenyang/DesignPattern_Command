package command;

import org.apache.commons.io.FileUtils;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class AgentTest {

    private Agent agent;
    private Server server;

    @Before
    public void setUp() throws Exception {
        agent = new Agent();
        server = new Server();
    }

    @After
    public void tearDown() throws Exception {
        File targetDir = new File("./target");
        FileUtils.deleteDirectory(targetDir);
    }

    @Test
    public void should_do_nothing_when_receive_empty_command_from_server() throws Exception {
        server.setCommand(new EmptyCommand());

        File fileBefore = new File(".");
        agent.executeTaskFrom(server);
        File fileAfter = new File(".");

        assertThat(fileBefore.list(), Is.is(fileAfter.list()));
    }

    @Test
    public void should_clone_git_repo_when_receive_check_out_code_command() throws Exception {
        server.setCommand(new CheckOutCodeCommand());

        agent.executeTaskFrom(server);

        File file = new File("./target");
        assertThat(file.list(), notNullValue());
    }

    @Test
    public void should_remove_directory_when_receive_delete_command() throws Exception {
        server.setCommand(new CheckOutCodeCommand());
        agent.executeTaskFrom(server);

        server.setCommand(new DeleteCommand());
        agent.executeTaskFrom(server);

        File file = new File("./target");
        assertThat(file.list(), nullValue());
    }

    @Test
    public void should_return_false_when_command_fail_to_execute() throws Exception {
        server.setCommand(new ErrorCommand());
        CommandResult result = agent.executeTaskFrom(server);

        assertThat(result.isSuccess(), is(false));
    }

    @Test
    public void should_report_result_and_output_to_server() throws Exception {
        server.setCommand(new CheckOutCodeCommand());
        agent.executeTaskFrom(server);

        server.setCommand(new ListDirectoryCommand());
        CommandResult result = agent.executeTaskFrom(server);

        assertThat(result.isSuccess(), is(true));
        assertThat(result.getOutput(), notNullValue());
    }
}
