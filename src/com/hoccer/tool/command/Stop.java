package com.hoccer.tool.command;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="stop", description="Stop the current client")
public class Stop extends ShellCommand {

	@Override
	protected CommandResult innerExecute(ShellContext context) {
		// stop the client
		context.getCurrentClient().stop();
		
		// we don't currently fail
		return CommandResult.OK;
	}

}
