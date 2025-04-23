package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = 0.1 + Math.random() * (0.9);
		this.y = 0.1 + Math.random() * (0.9);
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(200,0,0);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
