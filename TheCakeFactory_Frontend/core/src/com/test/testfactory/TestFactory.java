package com.test.testfactory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.testfactory.screens.PlayScreen;

public class TestFactory extends Game {
	public static final int V_WIDTH = 462;
	public static final int V_HEIGHT = 260;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		//delegerar till klassen playscreen
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
