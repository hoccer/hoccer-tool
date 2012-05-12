package com.hoccer.tool;

import net.dharwin.common.tools.cli.api.EntryPoint;

/**
 * Main entry point for hoccer-tool
 * 
 * This is a wrapper around the cli-api EntryPoint class,
 * allowing uses of the tool other than the default shell.
 * 
 * @author ingo
 */
public class Main {

	/**
	 * Main entry point
	 * 
	 * This redirects to the CLI entrypoint so we have
	 * the choice to start something other than the CLI.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EntryPoint.main(args);
	}

}
