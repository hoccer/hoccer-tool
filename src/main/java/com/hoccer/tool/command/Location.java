package com.hoccer.tool.command;

import java.util.ArrayList;
import java.util.List;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.beust.jcommander.Parameter;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="location", description="Provide static location information for the current client")
public class Location extends ShellCommand {

	@Parameter(names={"-lat"},description="Latitude of position", required=false)
	String latitude;

	@Parameter(names={"-lon"},description="Longitude of position", required=false)
	String longitude;

	@Parameter(names={"-a"},description="Position accuracy in meters", required=false)
	String accuracy = "250";

	@Parameter(names={"-b"}, description="BSSID for wifi grouping", required=false)
	private List<String> bssids = new ArrayList<String>();

	@Override
	protected CommandResult innerExecute(ShellContext context) {

		if(latitude != null && longitude != null) {
			// parse parameters
			double lat = Double.parseDouble(latitude);
			double lon = Double.parseDouble(longitude);
			int acc = Integer.parseInt(accuracy);

			// propagate information to client
			context.getGPSProvider().updatePosition(lat, lon, acc);
		}
		
		if(bssids .size() > 0) {
			context.getWLANProvider().updateBSSIDs(bssids);
		}

		return CommandResult.OK;
	}

}
