package com.test.testfactory.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.test.testfactory.TestFactory;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		//Sätter storlek på desktop-fönstret
		config.height = TestFactory.V_HEIGHT;
		config.width = TestFactory.V_WIDTH;

		new LwjglApplication(new TestFactory(), config);
	}
}
