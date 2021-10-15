package org.javaweb.openfire.plugin;

import java.io.File;

import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;

public class SyncWorld implements Plugin {

	private XMPPServer server;

	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
		server = XMPPServer.getInstance();
		System.out.println("init Plugin!");
	}

	@Override
	public void destroyPlugin() {
		System.out.println("destroy Plugin!");
	}
}
