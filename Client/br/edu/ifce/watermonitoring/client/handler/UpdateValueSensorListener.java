package br.edu.ifce.watermonitoring.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTextField;

import sensorNetwork.Sensor;
import br.edu.ifce.watermonitoring.client.controller.ClientControllerWaterMonitoring;
import br.edu.ifce.watermonitoring.client.utils.InputDialogWithForm;
import br.edu.ifce.watermonitoring.client.view.SensorPanel;

public class UpdateValueSensorListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JTextField textField = (JTextField) obj;
		JPanel panelOfParameter = (JPanel) textField.getParent();
		SensorPanel panelOfSensor = (SensorPanel) panelOfParameter.getParent();
		Sensor sensor= panelOfSensor.getSensor();
		HashMap<String, Integer> sensorValues = InputDialogWithForm.showInputDialogWithForm("Atualize o valor do sensor", sensor);
		int temperature = sensorValues.get("temperature");
    	int ph = sensorValues.get("ph");
    	int color = sensorValues.get("color");
    	ClientControllerWaterMonitoring.updateSensorValues(sensor,temperature, ph, color);
	}
}
