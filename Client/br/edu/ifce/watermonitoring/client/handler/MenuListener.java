package br.edu.ifce.watermonitoring.client.handler;

/**
 * Created by jp-desktop on 28/03/2015.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sensorNetwork.Sensor;
import br.edu.ifce.watermonitoring.client.controller.ClientControllerWaterMonitoring;
import br.edu.ifce.watermonitoring.client.utils.Constants;
import br.edu.ifce.watermonitoring.client.utils.InputDialogWithForm;



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
        	HashMap<String, Integer> sensorValues = InputDialogWithForm.showInputDialogWithForm("Informe o valor para os sensores");
        	int temperature = sensorValues.get("temperature");
        	int ph = sensorValues.get("ph");
        	int color = sensorValues.get("color");
        	ClientControllerWaterMonitoring.createSensor(temperature, ph, color);
        }
        else if(e.getActionCommand() == "delete_sensor"){
        	Integer idSensorToDelete = inputSensorSelected("Selecione o sensor a ser deletado");
        	if (idSensorToDelete != null){
        		ClientControllerWaterMonitoring.removeSensorById(idSensorToDelete);
        		ClientControllerWaterMonitoring.updateValueToNetworkSensorPanel();
        	}
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
       
    private Integer inputSensorSelected(String message){
    	Integer[] sensorsId = ClientControllerWaterMonitoring.getSensorId();
		JList listOfSensorsId = new JList(sensorsId);
		JOptionPane.showMessageDialog(null, listOfSensorsId, message, JOptionPane.PLAIN_MESSAGE);
		Integer sensorSelected = (Integer) listOfSensorsId.getSelectedValue();
		return sensorSelected;
	}
}