package com.aallam.flappybird;

import com.aallam.flappybird.states.GameStateManager;
import com.aallam.flappybird.states.MenuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {

    public static final String TITLE = "Flappy Bird";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    private GameStateManager gameStateManager;
	private SpriteBatch spriteBatch;
    private MenuState menuState;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
        gameStateManager = new GameStateManager();
        menuState = new MenuState(gameStateManager);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        gameStateManager.push(menuState);
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(spriteBatch);
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}