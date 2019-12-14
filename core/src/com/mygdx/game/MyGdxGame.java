package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	SpriteBatch batch;
	Texture morta, morter, grid, sand, white;
	private int[] drop = new int[5];
	private int x1 = 165, y1 = 100, xm = 173, ym = 700;
	private double count = 0;
	private Rectangle bombBounds, mortaBounds;




	@Override
	public void create () {
		batch = new SpriteBatch();
		morta = new Texture("morta.png");
		morter = new Texture("morter.png");
		grid = new Texture("grid.png");
		sand = new Texture("sand.jpg");
		white = new Texture("white.jpeg");
		for(int i = 0; i < drop.length; i++)
		{
			drop[i] = 173 + (72 * i);
		}
	}

	@Override
	public void render () {

		//checks for a collision between morta and the bombs
		if(drop[0] >= x1 - 20 && drop[0] <= x1 + 20 && ym >= y1 - 20 && ym <= y1 + 20 ||
				drop[1] >= x1 - 20 && drop[1] <= x1 + 20 && ym >= y1 - 20 && ym <= y1 + 20 ||
				drop[2] >= x1 - 20 && drop[2] <= x1 + 20 && ym >= y1 - 20 && ym <= y1 + 20 ||
				drop[3] >= x1 - 20 && drop[3] <= x1 + 20 && ym >= y1 - 20 && ym <= y1 + 20 ||
				drop[4] >= x1 - 20 && drop[4] <= x1 + 20 && ym >= y1 - 20 && ym <= y1 + 20)
		{
				x1 = 165;
				y1 = 100;
				xm = 173;
				ym = 700;
				count = 0;
		}
			ym -= 3; // drops the bomb
		//count += .01; time survived
		System.out.println(count);
			if(ym < 0)
			{
				ym = 700;
			}// end of if that resets the bombs to the top
		// detects the arrow keys and moves the character
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
				if (x1 > 165) {
					x1 -= 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
				if (x1 < 455) {
					x1 += 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
				if (y1 > 100) {
					y1 -= 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
				if (y1 < 310) {
					y1 += 5;
				}
			}
		    bombBounds = new Rectangle(xm, ym, 60, 60);
		    mortaBounds = new Rectangle(x1, y1, 60, 60);
			Gdx.gl.glClearColor(1, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(sand, 0, 0, 800, 600);
			batch.draw(grid, 20, 45, 600, 400);
			batch.draw(white, 240, 180, 60, 60);
			batch.draw(morta, x1, y1, 60, 60);
			batch.draw(morter, drop[0], ym, 60, 60);// 1
			batch.draw(morter, drop[1], ym, 60, 60);// 1
			batch.draw(morter, drop[2], ym, 60, 60);// 1
			batch.draw(morter, drop[3], ym, 60, 60);// 1
			batch.draw(morter, drop[4], ym, 60, 60);// 1
			batch.end();

	}


	@Override
	public void dispose () {
		batch.dispose();
		morta.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {

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
