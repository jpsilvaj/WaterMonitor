package br.edu.ifce.watermonitoring.client.utils;

import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sensorNetwork.Sensor;

public class InputDialogWithForm {

    public static HashMap<String, Integer> showInputDialogWithForm(String message){
    	JTextField temperature = new JTextField();
    	JTextField ph = new JTextField();
    	JTextField color = new JTextField();
    	HashMap<String, Integer> sensorValues = new HashMap<String,Integer>();
    	final JComponent[] inputs = new JComponent[] {
    			new JLabel("Temperatura"),
    			temperature,
    			new JLabel("PH"),
    			ph,
    			new JLabel("Cor"),
    			color
    	};
 
       	JOptionPane.showMessageDialog(null, inputs, message, JOptionPane.PLAIN_MESSAGE);
    	//TODO: Insert validation to fields
    	sensorValues.put("temperature", new Integer(temperature.getText()));
    	sensorValues.put("ph", new Integer(ph.getText()));
    	sensorValues.put("color", new Integer(color.getText()));
    	
    	return sensorValues;
   }
    
    public static HashMap<String, Integer> showInputDialogWithForm(String message, Sensor sensor){
    	JTextField temperature = new JTextField(sensor.temperature);
    	JTextField ph = new JTextField(sensor.ph);
    	JTextField color = new JTextField(sensor.color);
    	HashMap<String, Integer> sensorValues = new HashMap<String,Integer>();
    	final JComponent[] inputs = new JComponent[] {
    			new JLabel("Temperatura"),
    			temperature,
    			new JLabel("PH"),
    			ph,
    			new JLabel("Cor"),
    			color
    	};
 
       	JOptionPane.showMessageDialog(null, inputs, message+"-ID: "+sensor.id, JOptionPane.PLAIN_MESSAGE);
    	//TODO: Insert validation to fields
    	sensorValues.put("temperature", new Integer(temperature.getText()));
    	sensorValues.put("ph", new Integer(ph.getText()));
    	sensorValues.put("color", new Integer(color.getText()));
    	
    	return sensorValues;
   }
	
}
