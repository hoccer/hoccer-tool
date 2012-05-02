package com.hoccer.tool;

import net.dharwin.common.tools.cli.api.CLIContext;
import net.dharwin.common.tools.cli.api.CommandLineApplication;
import net.dharwin.common.tools.cli.api.annotations.CLIEntry;
import net.dharwin.common.tools.cli.api.exceptions.CLIInitException;

/**
 * Shell entrypoint class
 * 
 * Takes care of context creation and shell lifecycle.
 * 
 * @author ingo
 */
@CLIEntry
public class Shell extends CommandLineApplication<ShellContext> {

	public Shell() throws CLIInitException {
		super();
	}
	
	@Override
	public void start() {
		super.start();
	}

	@Override
	protected void shutdown() {
	}

	@Override
	protected CLIContext createContext() {
		return new ShellContext(this);
	}
	
}
