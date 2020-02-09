package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		String numBots = JOptionPane.showInputDialog("How many robots?");
		String rValue = JOptionPane.showInputDialog("What r Value??");
		String gValue = JOptionPane.showInputDialog("What g Value???");
		String bValue = JOptionPane.showInputDialog("What b Value??");
		String sidesShapes = JOptionPane.showInputDialog("How many sides per shape???");
		
		int botNum = Integer.parseInt(numBots);
		int sidesNum = Integer.parseInt(sidesShapes);
		
		Robot[] bots = new Robot[botNum];
		
		for (int i = 0; i < botNum; i++) {
			bots[i] = new Robot();
		}
		
		int counter = 0;
		int threadCounter = 0;
		for (Robot r: bots) {
			counter+=150;
			r.penDown();
			r.setSpeed(10);
			r.setX(counter);
			Thread thread = new Thread(() ->  {
				for (int i = 0; i < sidesNum; i++) {
					r.move(40);
					r.turn(360/sidesNum);
				}
			});
			thread.start();
			
			}
		}
	}

