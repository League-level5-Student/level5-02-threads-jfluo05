package _02_Advanced_Robot_Race;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static int winner=0;
	
	public static void main(String[] args) {
		Robot one = new Robot(100, 700);
		Robot two = new Robot(300, 700);
		Robot three = new Robot(500, 700);
		Robot four = new Robot(700, 700);
		Robot five = new Robot(900, 700);
		
		
		one.setSpeed(5);
		two.setSpeed(5);
		three.setSpeed(5);
		four.setSpeed(5);
		five.setSpeed(5);
		
		Random ran1= new Random ();
		int random= ran1.nextInt(100);
		
		Thread r1 = new Thread(()->{
			for (int i = 0; i < 360; i++) {

			one.move(random); 
			if (one.getY()<=10) {
				System.out.println("Robot 1 wins!");
			}
			}
		});
		
		Thread r2 = new Thread(()->{
			for (int i = 0; i < 360; i++) {

			two.move(random); 
			if (two.getY()<=10) {
				System.out.println("Robot 2 wins!");
			}
			}
		});		
		
		Thread r3 = new Thread(()->{
			for (int i = 0; i < 360; i++) {

			three.move(random); 
			if (three.getY()<=10) {
				System.out.println("Robot 3 wins!");
			}

			}
		});
		
		Thread r4 = new Thread(()->{
			for (int i = 0; i < 360; i++) {

			four.move(random); 
		if (four.getY()<=10) {
			System.out.println("Robot 4 wins!");
		}
			}
		});
		
		Thread r5 = new Thread(()->{
			for (int i = 0; i < 360; i++) {

			five.move(random); 
			if (five.getY()<=10) {
				System.out.println("Robot 5 wins!");
			}

			}
		});

	
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		
		
}
}
