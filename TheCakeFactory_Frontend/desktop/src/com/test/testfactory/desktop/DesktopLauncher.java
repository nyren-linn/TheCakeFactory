package com.test.testfactory.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.test.testfactory.TestFactory;
import com.test.testfactory.scenes.Hud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DesktopLauncher {
	public static void main (String[] arg) {
		try {
			URL url = new URL("http://localhost:8080/players/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

/*            BufferedReader br = new BufferedReader((new InputStreamReader((conn.getInputStream()))));

            String output;
            System.out.println("----------- Output from server ------------");
            while((output = br.readLine()) != null){
                System.out.println(output);
            }*/

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));

			StringBuilder response = new StringBuilder();
			String currentLine, name;

			while ((currentLine = in.readLine()) != null)
				response.append(currentLine);

			String[] strings = response.toString().split("\"");
			for(String s : strings){
				System.out.println(s);
			}

			name = strings[5];
			com.test.testfactory.scenes.Hud.player = name;
			in.close();


			conn.disconnect();

			System.out.println("name: " + name);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		//Sätter storlek på desktop-fönstret
		config.height = TestFactory.V_HEIGHT;
		config.width = TestFactory.V_WIDTH;

		new LwjglApplication(new TestFactory(), config);
	}
}
