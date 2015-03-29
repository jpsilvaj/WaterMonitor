package br.edu.ifce.watermonitoring.client.handler;

/**
 * Created by jp-desktop on 28/03/2015.
 */

import br.edu.ifce.watermonitoring.client.controller.ClientControllerWaterMonitoring;
import br.edu.ifce.watermonitoring.client.utils.Constants;
import br.edu.ifce.watermonitoring.client.view.WaterMonitoringView;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;



public class MenuListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "exit"){
            try{
                //TODO:ClientControllerImpl.exit();
            }catch(Exception exception){
                exception.printStackTrace();
            }
            finally{
                System.exit(0);
            }
        }
        else if(e.getActionCommand() == "create_sensor"){
        	HashMap<String, Integer> sensorValues = showInputDialogWithForm("Informe o valor para os sensores");
        	int temperature = sensorValues.get("temperature");
        	int ph = sensorValues.get("ph");
        	int color = sensorValues.get("color");
        	ClientControllerWaterMonitoring.createSensor(temperature, ph, color);
        }
        else if(e.getActionCommand() == "delete_sensor"){
			//TODO:implement Delete_sensor
        }
        else if(e.getActionCommand() == "about"){
            JOptionPane.showMessageDialog(null, Constants.ABOUT);
        }
    }

    private String showInputDialog(String message) {
        String inputValue = JOptionPane.showInputDialog(message);
        if (inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")) {
            inputValue = showInputDialog(message);
        }
        return inputValue;
    }
    
    private HashMap<String, Integer> showInputDialogWithForm(String message){
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
    	
    	sensorValues.put("temperature", new Integer(temperature.getText()));
    	sensorValues.put("ph", new Integer(ph.getText()));
    	sensorValues.put("color", new Integer(color.getText()));
    	
    	return sensorValues;
   }
}