package com.hoccer.tool.command;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.hoccer.client.HoccerClient;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="status", description="Show the status of the current client")
public class Status extends ShellCommand {

	@Override
	protected CommandResult innerExecute(ShellContext context) {
		
		HoccerClient client = context.getCurrentClient();
		
		System.out.println("Environment: " + client.getEnvJSON());
		
		return CommandResult.OK;
	}

}
