//Program Name : PaintingCanvas.java
//Assignment No : 5
//Name : Edwin Rubio
//Date : 04/14/2011

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class CanvasFrame extends JFrame {
	private Point drawline = new Point();//to add the coordinates from the beginning to the end of the line. Uses Point class to save points.
	private DrawCanvas canvas;//to create an object for paint component. 
public CanvasFrame()
	{
		canvas = new DrawCanvas();//creates a paint component panel. 
		Container contentPane = getContentPane();//gets the painting component panel. 
		canvas.addMouseListener(new clicked());//listens to whenever there is a click on the panel. Then calls clicked method.
		canvas.addMouseMotionListener(new clickHold());//listens to whenever the mouse is being dragged. 
		contentPane.add(canvas);//add the paint component (canvas) to the frame. 
	}
//if the mouse is dragged it executes this class and creates the line. 
public class clickHold extends MouseMotionAdapter
	{
		@Override
		public void mouseDragged(MouseEvent hold){
			int xAxis = hold.getX();//gets the x-axis value. 
			int yAxis = hold.getY();//gets the y-axis value.
			Graphics dispanel = canvas.getGraphics();//gets the object that will be displayed. 
			dispanel.drawLine(drawline.x, drawline.y, xAxis, yAxis);//encapsulates two integer values,representing the x and y coordinates of a point.
			drawline.move(xAxis,yAxis);//makes the line more thicker.
			
		}
	}
//determines the beginning of the line. 
public class clicked extends MouseAdapter{
	public void mousePressed(MouseEvent click){
			int xAxis = click.getX();//gets the x-axis value. 
			int yAxis = click.getY();//gets the y-axis value.
			drawline.move(xAxis,yAxis);//encapsulates two integer values,representing the x and y coordinates of a point.
		}
	}
//create a canvas to paint on. 
public class DrawCanvas extends JPanel
	{
		public void paintComponent(Graphics graphics){
			graphics.setFont(new Font("Serif", Font.BOLD, 20));//set the font for label.
			graphics.drawString("HAVE FUN DRAWING!", 0, 20);//display label on the top left corner. 
			canvas.setBackground(Color.LIGHT_GRAY);//sets the panel to color light gray.
			setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));//changed the default mouse pointer to a crosshair pointer. 
		}
	}
}

public class PaintingCanvas {
public static void main(String[] args) {
		
		EventQueue.invokeLater(
		new Runnable () {
			@Override
			public void run() {
				CanvasFrame myFrame = new CanvasFrame();
				myFrame.setSize(600,300);
				myFrame.setTitle("Assignment 5");
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myFrame.setVisible(true);
			}

			});
}
}
