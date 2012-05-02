package com.hoccer.tool.command;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="start", description="Start the current client")
public class Start extends ShellCommand {

	@Override
	protected CommandResult innerExecute(ShellContext context) {
		// start the client
		context.getCurrentClient().start();
		
		// we don't currently fail
		return CommandResult.OK;
	}

}
