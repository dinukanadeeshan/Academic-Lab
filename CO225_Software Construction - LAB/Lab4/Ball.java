/* E/13/234 */

import java.util.ArrayList;
public class Ball{
	private static double time;
	private static ArrayList<Ball> ballList = new ArrayList<>();

	private double x;
	private double y;
	private double speed;
	private double angleOfSpeedWithX;

	public Ball(double x, double y, double speed, double angleOfSpeedWithX){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angleOfSpeedWithX = angleOfSpeedWithX;
		ballList.add(this);
	}

	public void setX(double x){
		this.x = x;
	}

	public void show(int ballNo){
		System.out.println("Ball "+ballNo+": ("+x+","+y+")");
	}

	public void setY(double y){
		this.y = y;
	}

	public void setSpeed(double speed){
		this.speed = speed;
	}

	public void setAngleOfSpeedWithX(double angleOfSpeedWithX){
		this.angleOfSpeedWithX = angleOfSpeedWithX;
	}

	public void setPosition(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void updatePosition(double time){
		/*
			Change ball position respect to the Time;
			
		*/

		x += Math.cos(angleOfSpeedWithX) * speed * time;
		y += Math.sin(angleOfSpeedWithX) * speed * time;



	}
	public double getX(){
		return x;
	}


	public double getY(){
		return y;
	}

	public double getSpeed(){
		return speed;
	}

	public double getAngleOfSpeedWithX(){
		return angleOfSpeedWithX;
	}


	public Boolean willCollide(Ball ball) { 
		//System.out.println("Implement me!!!");
		return this.x == ball.x && this.y == ball.y;
		
    }


	public static void updateTime(double time){
		Ball.time += time;

		for (Ball b : ballList) {
			b.updatePosition(time);
		}
	}

	public static void showAll(){
		int i=0;
		for (Ball b : ballList) {
			b.show(i);
			i++;
		}
	}

	public static void main(String [] args) { 
	
	/*
	Ball b1 = new Ball(0.0, 1.0, 10.0, 45.0); 
	Ball.updateTime(10.0); 

	Ball b2 = new Ball(10.0, 20.0, 2.0, 30.0);
	if(b1.willCollide(b2))
	    System.out.println("B1 and B2 will collide");
	*/
	
	//Test 1 - B1 & B2 will collide
	Ball b1 = new Ball(0.0, 0.0, 2.0, 0.0);
	Ball b2 = new Ball(10.0, 0.0, 1.0, 0.0);
	Ball b3 = new Ball(20.0, 0.0, 10.0, 0.0);
	Ball.updateTime(10.0); 
	if(b2.willCollide(b1))
	    System.out.println("B1 and B2 will collide");
	if(b3.willCollide(b1))
	    System.out.println("B1 and B3 will collide");
	if(b3.willCollide(b2))
	    System.out.println("B2 and B3 will collide");
	
    /*
	//Test 2, will collide
	Ball b21 = new Ball(0.0, 0.0, 10.0, 0.0); 
	Ball.updateTime(10.0); 

	Ball b22 = new Ball(100, 0.0, 2.0, 30.0);
	if(b21.willCollide(b22))
	    System.out.println("B21 and B22 will collide");
	*/
	/*
	//Test3, will collide
	Ball b31 = new Ball(0.0, 1.0, 5.0, 0.0); 
	Ball.updateTime(10.0); 
	Ball b32 = new Ball(75.0, 1.0, 2.5, 0.0);
	Ball.updateTime(10.0); 
	if(b31.willCollide(b32))
	    System.out.println("B31 and B32 will collide");
	*/	
	/* call showAll in a suitable manner */
    }
}