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
	private int[] dropy = new int[5];
	private int x1 = 0, y1 = 0, xm = 0, ym = 600, ym1, xm1;
	private double count = 1;
	private Rectangle bombBounds, mortaBounds;



// creates textures and sets the missiles parameters
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
			xm1 = 0;
			while(xm1 < 100)
			{
				xm1 += (int) (Math.random() * 100);
			}
			drop[i] = (xm1) * i - 100;
		}
		for(int i = 0; i < dropy.length; i++)
		{
			dropy[i] = ym;
		}
	}

	@Override
	public void render () {

		//checks for a collision between morta and the bombs
		if(drop[0] >= x1 - 25 && drop[0] <= x1 + 25 && dropy[0] >= y1 - 25 && dropy[0] <= y1 + 25 ||
				drop[1] >= x1 - 25 && drop[1] <= x1 + 25 && dropy[1] >= y1 - 25 && dropy[1] <= y1 + 25 ||
				drop[2] >= x1 - 25 && drop[2] <= x1 + 25 && dropy[2] >= y1 - 25 && dropy[2] <= y1 + 25 ||
				drop[3] >= x1 - 25 && drop[3] <= x1 + 25 && dropy[3] >= y1 - 25 && dropy[3] <= y1 + 25 ||
				drop[4] >= x1 - 25 && drop[4] <= x1 + 25 && dropy[4] >= y1 - 25 && dropy[4] <= y1 + 25)
		{
				x1 = 0;
				y1 = 0;
				xm = 173;
			for(int i = 0; i < dropy.length; i++)
			{
				dropy[i] = ym;
			}
				count = 1;
		}
		dropy[0] -= 2 * count;
		dropy[1] -= 2 * count;
		dropy[2] -= 2 * count;
		dropy[3] -= 2 * count;
		dropy[4] -= 2 * count;// drops the bomb
		//count += .01; time survived
		//System.out.println(count);

			if(dropy[0] < 0)
			{
				ym1 = 0;
				xm1 = 0;
				while(ym1 < 500)
				{
					ym1 += (int) (Math.random() * 100);
				}
				dropy[0] = ym + ym1;

				while(xm1 < 100)
				{
					xm1 += (int) (Math.random() * 100);
				}
				drop[0] = xm1;

				count += .05;
			}// end of if that resets the bombs to the top

			if(dropy[1] < 0)
			{
			ym1 = 0;
			xm1 = 0;
			while(ym1 < 500)
			{
				ym1 += (int) (Math.random() * 100);
			}
			dropy[1] = ym + ym1;

			while(xm1 < 100)
			{
				xm1 += (int) (Math.random() * 100);
			}
			drop[1] = xm1 - 100;
			count += .05;
		}// end of if that resets the bombs to the top

		if(dropy[2] < 0)
		{
			ym1 = 0;
			while(ym1 < 500)
			{
				ym1 += (int) (Math.random() * 100);
			}
			dropy[2] = ym + ym1;
			xm1 = 0;
			while(xm1 < 100)
			{
				xm1 += (int) (Math.random() * 100);
			}
			drop[2] = (xm1) * 2 - 100;
			count += .05;
		}// end of if that resets the bombs to the top

		if(dropy[3] < 0)
		{
			ym1 = 0;
			while(ym1 < 500)
			{
				ym1 += (int) (Math.random() * 100);
			}
			dropy[3] = ym + ym1;
			xm1 = 0;
			while(xm1 < 100)
			{
				xm1 += (int) (Math.random() * 100);
			}
			drop[3] = (xm1) * 3 - 100;
			count += .05;
		}// end of if that resets the bombs to the top

		if(dropy[4] < 0)
		{
			ym1 = 0;
			while(ym1 < 500)
			{
				ym1 += (int) (Math.random() * 100);
			}
			dropy[4] = ym + ym1;
			xm1 = 0;
			while(xm1 < 100)
			{
				xm1 += (int) (Math.random() * 100);
			}
			drop[4] = (xm1) * 4 - 100;
			count += .05;
		}// end of if that resets the bombs to the top

		// detects the arrow keys and moves the character
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
				if (x1 > 0) {
					x1 -= 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
				if (x1 < 580) {
					x1 += 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
				if (y1 > 0) {
					y1 -= 5;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
				if (y1 < 420) {
					y1 += 5;
				}
			}

		    bombBounds = new Rectangle(xm, ym, 60, 60);
		    mortaBounds = new Rectangle(x1, y1, 60, 60);
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			//batch.draw(sand, 0, 0, 800, 600);
			//batch.draw(grid, 20, 45, 600, 400);
			//batch.draw(white, 0, 0, 800, 600);
			batch.draw(morta, x1, y1, 60, 60);
			batch.draw(morter, drop[0], dropy[0], 60, 60);// 1
			batch.draw(morter, drop[1], dropy[1], 60, 60);// 2
			batch.draw(morter, drop[2], dropy[2], 60, 60);// 3
			batch.draw(morter, drop[3], dropy[3], 60, 60);// 4
			batch.draw(morter, drop[4], dropy[4], 60, 60);// 5
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
