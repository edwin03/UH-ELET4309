//Program Name : TemperatureConverter.java
//Assignment No : 4
//Name : Edwin Rubio
//Date : 04/10/2011

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class Frame extends JFrame{
	private JFrame frame;//to make a window
	private JPanel options;
	private JButton b1;//is a component
	private JLabel title;//is a component
	public JLabel input;
	public JLabel output;
	public JRadioButton toCelsius;
	public JTextField inputvalue;
	public JLabel outfield;
	public JRadioButton fromCelsius;
	public ButtonGroup buttonGroup;
	
	public Frame(){
		
		//main panel
		Container contentPane = getContentPane();
		
		//create frame(window)
		frame = new JFrame("Assignment 4");
		frame.setSize(600,300);
		frame.setVisible(true);
		
		//adding label to panel
		title = new JLabel("Temperture Converter");
		contentPane.add(title, BorderLayout.NORTH);
		
		//adding panel for options, input, and output.
		JPanel centerl = new JPanel();
		centerl.setLayout(new GridLayout(3,1));
		contentPane.add(centerl);
		
		//adding option's boarder
		options = new JPanel();
		options.setBorder(new TitledBorder("Option"));
		
		//create radio button for "to celsius" option.
		toCelsius = new JRadioButton("To Celsius", true);
		options.add(toCelsius);
		
		//create radio button for "from celsius" option.
		fromCelsius = new JRadioButton("From Celsius", false);
		options.add(fromCelsius);
		centerl.add(options);
		
		//add buttons to one group.
		buttonGroup = new ButtonGroup();
		buttonGroup.add(toCelsius);
		buttonGroup.add(fromCelsius);
		
		//create a panel for the input value field.
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		
		//label the text input field.
		input = new JLabel("                        Input a Fahrenheit Value", SwingConstants.RIGHT);
		inputvalue = new JTextField(20);
		inputvalue.requestFocus(); 
		inputvalue.addKeyListener(new pressedEnter());
		inputpanel.add(input, BorderLayout.EAST);
		inputpanel.add(inputvalue, BorderLayout.WEST);
		centerl.add(inputpanel);
	
		//panel for the output value.
		JPanel outputpanel = new JPanel();
		outputpanel.setLayout(new GridLayout(1,2));
		output = new JLabel("Celsius Value    ", SwingConstants.RIGHT);
		outfield = new JLabel();
		outputpanel.add(output);
		outputpanel.add(outfield);
		centerl.add(outputpanel);
		
		//add button for convert.
		JPanel bottom = new JPanel();
		b1 = new JButton("Convert");
		bottom.add(b1);
		contentPane.add(bottom, BorderLayout.SOUTH);//adding button to panel
		
		//commands for the options to used in the switch statement. 
		toCelsius.setActionCommand("1");
		toCelsius.addItemListener(new HandlerClasstc());
		fromCelsius.setActionCommand("2");
		fromCelsius.addItemListener(new HandlerClasstf());
		b1.addActionListener(new thehandler());
		
		//puts focus on the input textbox.
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
			inputvalue.requestFocusInWindow();}
			});
		
		//add the entire contents to the frame to be displayed.
		frame.add(contentPane);//add panel to frame
	}
	
	//listens to jradiobutton to convert UI to convert to farenhiet.
	private class HandlerClasstf implements ItemListener{
		
		public void itemStateChanged(ItemEvent event){
				input.setText("                              Input a Celcius Value");
				output.setText("Fahrenheit Value    ");			
		}
	}
	
	//listens to jradiobutton to convert UI to convert to celsius.
	private class HandlerClasstc implements ItemListener{
		
		public void itemStateChanged(ItemEvent event){
				input.setText("                        Input a Fahrenheit Value");
				output.setText("Celsius Value    ");		
		}
	}
	
	//listens when the convert button is pressed.
	private class thehandler implements ActionListener{
		public String string;
		public double actualVal;
		public double valc;
		public Thermometer thermoF;
		public Thermometer thermoC;
		public void actionPerformed(ActionEvent event){
			
			String selected = buttonGroup.getSelection().getActionCommand();
			int aInt = Integer.parseInt(selected);
			switch(aInt)
			{
			case 1:
				input.setText("                        Input a Fahrenheit Value");
				string = inputvalue.getText();
				actualVal = Double.parseDouble(string);
				thermoF = new Thermometer();
				thermoF.setFahrenheit(actualVal);
				valc = thermoF.getCelsius(); 
				output.setText("Celsius Value    ");
				outfield.setText(String.format("%.2f", valc));
				break;
			case 2:
				input.setText("                              Input a Celcius Value");
				string = inputvalue.getText();
				actualVal = Double.parseDouble(string);
				thermoC = new Thermometer();
				thermoC.setCelsius(actualVal);
				valc = thermoC.getFahrenheit();
				output.setText("Fahrenheit Value    ");
				outfield.setText(String.format(" %.2f", valc));
				break;
			}	
	}
	}
	
		//checks to see if the user pressed enter in order to convert.
		public class pressedEnter extends KeyAdapter {
			public String selected;
			public String string;
			public double actualVal;
			public double valc;
			public Thermometer thermoF;
			public Thermometer thermoC;
			public void keyPressed(KeyEvent ent){
				int entrar = ent.getKeyCode();
				if (entrar == 10){
				selected = buttonGroup.getSelection().getActionCommand();
				int aInt = Integer.parseInt(selected);
				switch(aInt)
				{
				case 1:
					input.setText("                        Input a Fahrenheit Value");
					string = inputvalue.getText();
					actualVal = Double.parseDouble(string);
					thermoF = new Thermometer();
					thermoF.setFahrenheit(actualVal);
					valc = thermoF.getCelsius(); 
					output.setText("Celsius Value    ");
					outfield.setText(String.format("%.2f", valc));
					break;
				case 2:
					input.setText("                              Input a Celcius Value");
					string = inputvalue.getText();
					actualVal = Double.parseDouble(string);
					thermoC = new Thermometer();
					thermoC.setCelsius(actualVal);
					valc = thermoC.getFahrenheit();
					output.setText("Fahrenheit Value    ");
					outfield.setText(String.format(" %.2f", valc));
					break;
				}	
				}
			}
		}
		
	//inner class temperature converter class.		
	public class Thermometer
	{
	private double degreesCelsius;
		
	public void setCelsius(double degrees){
		degreesCelsius = degrees;
		}
		
	public void setFahrenheit(double degrees){
		degreesCelsius = (degrees - 32.0) * 5.0 / 9.0;
		}
		
	public double getCelsius(){
		return degreesCelsius;
		}
		
	public double getFahrenheit(){
		return degreesCelsius * (9.0 / 5.0) + 32.0;
		}
		
	}
}

public class TemperatureConverter {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(
		new Runnable () {
			@Override
			public void run() {
				JFrame myFrame = new Frame();
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
		});
}
}
	
	