package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		BodySegment segment = new BodySegment(deltaX, deltaY, 0.02);
		segments = new LinkedList<>();
		segments.add(segment);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		// Step 1: store current head position
	    double prevX = segments.get(0).getX();
	    double prevY = segments.get(0).getY();

	    // Step 2: move the head
	    double newX = prevX + deltaX;
	    double newY = prevY + deltaY;
	    segments.set(0, new BodySegment(newX, newY, SEGMENT_SIZE));

	    // Step 3: move each segment to the position of the one ahead of it
	    for (int i = 1; i < segments.size(); i++) {
	        // Save current segment's position
	        double tempX = segments.get(i).getX();
	        double tempY = segments.get(i).getY();

	        // Set current segment to previous position
	        segments.set(i, new BodySegment(prevX, prevY, SEGMENT_SIZE));

	        // Update prevX and prevY to use in next iteration
	        prevX = tempX;
	        prevY = tempY;
		}
	}
		
	
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for (BodySegment item : segments) {
			item.draw();
		}
		
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
	    double distance = Math.sqrt(Math.pow(f.getX() - head.getX(), 2) + Math.pow(f.getY() - head.getY(), 2));
	    double totalRadius = Food.FOOD_SIZE + head.getSize();
		if (distance < totalRadius) {
			BodySegment tail = segments.getLast();
	        BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
	        segments.addLast(newSegment);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		if ((segments.get(0).getX() > 1 || segments.get(0).getX() < 0) || (segments.get(0).getY()> 1 || segments.get(0).getY()<0)) {
			
		return false;
		

	}
		else {
			return true;
}
	}}
