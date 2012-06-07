package com.hoccer.tool.command;

import org.json.JSONObject;

import net.dharwin.common.tools.cli.api.CommandResult;
import net.dharwin.common.tools.cli.api.annotations.CLICommand;

import com.hoccer.client.action.Action.Mode;
import com.hoccer.client.action.ReceiveAction;
import com.hoccer.client.action.ReceiveListener;
import com.hoccer.tool.ShellCommand;
import com.hoccer.tool.ShellContext;

@CLICommand(name="receive", description="Receive data with the current client")
public class Receive extends ShellCommand {

	@Override
	protected CommandResult innerExecute(ShellContext context) {
		ReceiveListener l = new ReceiveListener() {
			
			@Override
            public void actionFailed(ReceiveAction pAction) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
            public void actionExpired(ReceiveAction pAction) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
            public void actionCollided(ReceiveAction pAction) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
            public void actionAborted(ReceiveAction pAction) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void receiveSucceeded(JSONObject pResult,
					ReceiveAction pAction) {
				// TODO Auto-generated method stub
				
			}
		};
		
		ReceiveAction r = new ReceiveAction(Mode.ONE_TO_MANY, l);
		
		context.getCurrentClient().perform(r);
		
		return CommandResult.OK;
	}

}
