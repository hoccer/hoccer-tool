package com.hoccer.tool.command;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.hoccer.client.HoccerClient;
import com.hoccer.client.HoccerPeer;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="peers", description="Show peers of the current client")
public class Peers extends ShellCommand {

	@Override
	protected CommandResult innerExecute(ShellContext context) {
		// get a convenient reference to the out stream
		PrintStream o = System.out;
		
		// retrieve list of peers
		HoccerClient client = context.getCurrentClient();
		Vector<HoccerPeer> peers = client.getPeers();

		// show list of peers
		if(peers.size() < 1) {
			o.println("Client " + client.getClientName() + " has no peers.");
		} else {
			o.println("Client " + client.getClientName() + " has " + peers.size() + " peers:");

			Enumeration<HoccerPeer> e = peers.elements();
			while(e.hasMoreElements()) {
				HoccerPeer p = e.nextElement();
				o.println("   " + p.getPublicId() + " - " + p.getName());
			}
		}

		// we don't fail
		return CommandResult.OK;
	}

}
