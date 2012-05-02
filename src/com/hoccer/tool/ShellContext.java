package com.hoccer.tool;

import net.dharwin.common.tools.cli.api.CLIContext;

import com.hoccer.api.ClientConfig;
import com.hoccer.client.HoccerClient;
import com.hoccer.client.environment.StaticGPSProvider;
import com.hoccer.client.environment.StaticWifiProvider;

/**
 * Global context for a shell instance
 * 
 * Keeps a reference to the hoccer client used by the shell.
 * 
 * @author ingo
 */
public class ShellContext extends CLIContext {

	ClientConfig config = null;
	HoccerClient currentClient = null;
	
	StaticWifiProvider wlanProvider = null;
	StaticGPSProvider gpsProvider = null;
	
	ShellContext(Shell shell) {
		super(shell);
		
		ClientConfig.useExperimentalServers();
		
		config = new ClientConfig(
				"hoccer-tool",
				"b3b03410159c012e7b5a00163e001ab0",
				"ROOCiND4FPqDDwP1taRmdyBejEs=");
		
		wlanProvider = new StaticWifiProvider();
		gpsProvider = new StaticGPSProvider();
		
		currentClient = new HoccerClient();
		currentClient.configure(config);
		currentClient.registerEnvironmentProvider(wlanProvider);
		currentClient.registerEnvironmentProvider(gpsProvider);
		currentClient.start();
	}
	
	public HoccerClient getCurrentClient() {
		return currentClient;
	}
	
	public StaticGPSProvider getGPSProvider() {
		return gpsProvider;
	}
	
	public StaticWifiProvider getWLANProvider() {
		return wlanProvider;
	}
	
}
