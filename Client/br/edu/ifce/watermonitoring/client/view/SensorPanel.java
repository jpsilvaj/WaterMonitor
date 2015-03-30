package br.edu.ifce.watermonitoring.client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sensorNetwork.Sensor;
import sensorNetwork.utils.ProcessRangeOfSensors;
import sensorNetwork.utils.SensorsTypes;
import br.edu.ifce.watermonitoring.client.handler.UpdateValueSensorListener;
import br.edu.ifce.watermonitoring.client.utils.FormatSensorValuesToNotification;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class SensorPanel extends JPanel{

    private Sensor sensor;
    private JLabel sensorIdLabel;
    private JTextField sensorIdTextField;
    private JLabel sensorTemperatureLabel;
    private JTextField sensorTemperatureTextField;
    private JLabel sensorPhLabel;
    private JTextField sensorPhTextField;
    private JLabel sensorColorLabel;
    private JTextField sensorColorTextField;

    private JPanel panelOfTemperature;
    private JPanel panelOfPh;
    private JPanel panelOfColor;
    
    public SensorPanel(Sensor sensor){
        this.sensor = sensor;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setAlignmentY(LEFT_ALIGNMENT);
        this.setAlignmentX(LEFT_ALIGNMENT);
        sensorIdLabel = new JLabel(new Integer(sensor.id).toString());
        
        sensorTemperatureLabel = new JLabel("Temperatura: ");
        String notificationTemperature = FormatSensorValuesToNotification.formatSensorValueByType(sensor.temperature, SensorsTypes.TEMPERATURE);
        sensorTemperatureTextField = new JTextField(notificationTemperature);
        sensorTemperatureTextField.setPreferredSize(new Dimension(120, 25));
        sensorTemperatureTextField.addActionListener(new UpdateValueSensorListener());
        panelOfTemperature = new JPanel();
        panelOfTemperature.setLayout(new FlowLayout());
        panelOfTemperature.add(sensorTemperatureLabel);
        panelOfTemperature.add(sensorTemperatureTextField);
        
        sensorPhLabel = new JLabel("PH: ");
        String notificationPh = FormatSensorValuesToNotification.formatSensorValueByType(sensor.ph, SensorsTypes.PH);
        sensorPhTextField = new JTextField(notificationPh);
        sensorPhTextField.setPreferredSize(new Dimension(175, 25));
        sensorPhTextField.addActionListener(new UpdateValueSensorListener());
        panelOfPh = new JPanel();
        panelOfPh.setLayout(new FlowLayout());
        panelOfPh.add(sensorPhLabel);
        panelOfPh.add(sensorPhTextField);
        
        
        sensorColorLabel = new JLabel("Cor: ");
        String notificationColor = FormatSensorValuesToNotification.formatSensorValueByType(sensor.color, SensorsTypes.COLOR);
        sensorColorTextField = new JTextField(notificationColor);
        sensorColorTextField.setPreferredSize(new Dimension(175, 25));
        sensorColorTextField.addActionListener(new UpdateValueSensorListener());
        panelOfColor = new JPanel();
        panelOfColor.setLayout(new FlowLayout());
        panelOfColor.add(sensorColorLabel);
        panelOfColor.add(sensorColorTextField);
        
        this.add(sensorIdLabel);
        this.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.add(panelOfTemperature);
        this.add(panelOfPh);
        this.add(panelOfColor);
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
        String temperatureFormat = FormatSensorValuesToNotification.formatSensorValueByType(sensor.temperature, SensorsTypes.TEMPERATURE);
        this.sensorTemperatureTextField.setText(temperatureFormat);
        String phFormat = FormatSensorValuesToNotification.formatSensorValueByType(sensor.ph, SensorsTypes.PH);
        this.sensorPhTextField.setText(phFormat);
        String colorFormat = FormatSensorValuesToNotification.formatSensorValueByType(sensor.color, SensorsTypes.COLOR);
        this.sensorColorTextField.setText(colorFormat);
        this.repaint();
    }
}
