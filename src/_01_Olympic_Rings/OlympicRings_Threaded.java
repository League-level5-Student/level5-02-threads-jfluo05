package _01_Olympic_Rings;

import java.awt.Color;
import java.util.Iterator;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot one = new Robot(100, 300);
		Robot two = new Robot(500, 300);
		Robot three = new Robot(900, 300);
		Robot four = new Robot(300, 500);
		Robot five = new Robot(700, 500);
		
		one.setSpeed(100);
		two.setSpeed(100);
		three.setSpeed(100);
		four.setSpeed(100);
		five.setSpeed(100);
		
		one.penDown();
		one.setPenWidth(10);
		one.setPenColor(Color.blue);
		
		two.penDown();
		two.setPenWidth(10);
		two.setPenColor(Color.black);
		
		three.penDown();
		three.setPenWidth(10);
		three.setPenColor(Color.red);
		
		four.penDown();
		four.setPenWidth(10);
		four.setPenColor(Color.yellow);
		
		five.penDown();
		five.setPenWidth(10);
		five.setPenColor(Color.green);
		
		
		
		
		Thread r1 = new Thread(()->{
			for (int i = 0; i < 360; i++) {
			one.move(3); 
			one.turn(1);
			}
		});
		
		Thread r2 = new Thread(()->{
			for (int i = 0; i < 360; i++) {
			two.move(3); 
			two.turn(1);
			}
		});
		
		Thread r3 = new Thread(()->{
			for (int i = 0; i < 360; i++) {
			three.move(3); 
			three.turn(1);
			}
		});
		
		Thread r4 = new Thread(()->{
			for (int i = 0; i < 360; i++) {
			four.move(3); 
			four.turn(1);
			}
		});
		
		Thread r5 = new Thread(()->{
			for (int i = 0; i < 360; i++) {
			five.move(3); 
			five.turn(1);
			}
		});

	
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		
}
}

