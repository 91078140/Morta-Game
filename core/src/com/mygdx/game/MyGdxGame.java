package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	SpriteBatch batch;
	Texture morta, grid, sand;
	int x1 = 165, x2 = 165, x3 = 165, y1 = 97, y2 = 97, y3 = 97;

	@Override
	public void create () {
		batch = new SpriteBatch();
		morta = new Texture("morta.png");
		grid = new Texture("grid.png");
		sand = new Texture("sand.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sand, 0, 0, 800, 600);
		batch.draw(grid, 20, 45, 600, 400);
		batch.draw(morta, x1, y1, 70, 70);// 1
		batch.draw(morta, x2, y2, 70, 70);// 2
		batch.draw(morta, x3, y3, 70, 70);// 3
		batch.end();

		{

		}
	}


	@Override
	public void dispose () {
		batch.dispose();
		morta.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.DOWN)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
