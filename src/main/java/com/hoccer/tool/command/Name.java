package com.hoccer.tool.command;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.beust.jcommander.Parameter;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="name", description="Set the name of the current client")
public class Name extends ShellCommand {

	@Parameter(names={"-n"},description="Name to set",required=true)
	String name;
	
	@Override
	protected CommandResult innerExecute(ShellContext context) {
		// set the client name
		context.getCurrentClient().setClientName(name);
		
		// we don't currently fail
		return CommandResult.OK;
	}

}
