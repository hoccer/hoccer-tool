package com.hoccer.tool.command;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.beust.jcommander.Parameter;
import com.hoccer.client.action.Action.Mode;
import com.hoccer.client.action.SendAction;
import com.hoccer.client.action.SendListener;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name = "send", description = "Send data with the current client")
public class Send extends ShellCommand {

    @Parameter(names = { "-m" }, description = "Message to send", required = true)
    String message;

    @Parameter(names = { "-o" }, description = "Use one-to-one transmission mode instead of one-to-many", required = false)
    boolean useOneToOne;

    @Override
    protected CommandResult innerExecute(ShellContext context) {

        SendListener listener = new SendListener() {

            @Override
            public void actionFailed(SendAction pArg0) {
            }

            @Override
            public void actionExpired(SendAction pArg0) {
            }

            @Override
            public void actionCollided(SendAction pArg0) {
            }

            @Override
            public void actionAborted(SendAction pArg0) {
            }

            @Override
            public void sendSucceeded(SendAction pAction) {
                System.out.println("sendSucceeded");
            }
        };

        Mode mode = useOneToOne ? Mode.ONE_TO_ONE : Mode.ONE_TO_MANY;
        SendAction send = new SendAction(message, mode, listener);

        context.getCurrentClient().perform(send);

        return CommandResult.OK;
    }

}
