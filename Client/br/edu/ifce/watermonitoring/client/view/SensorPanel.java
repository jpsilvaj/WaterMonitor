package br.edu.ifce.watermonitoring.client.view;

import sensorNetwork.Sensor;

import javax.swing.*;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class SensorPanel extends JPanel{

    private Sensor sensor;
    private JLabel sensorIdLabel;
    private JLabel sensorTemperatureLabel;
    private JLabel sensorPhLabel;
    private JLabel sensorColorLabel;

    public SensorPanel(Sensor sensor){
        this.sensor = sensor;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        sensorIdLabel = new JLabel(new Integer(sensor.id).toString());
        sensorTemperatureLabel = new JLabel(new Integer(sensor.temperature).toString());
        sensorPhLabel = new JLabel(new Integer(sensor.ph).toString());
        sensorColorLabel = new JLabel(new Integer(sensor.color).toString());

        this.add(sensorIdLabel);
        this.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.add(sensorTemperatureLabel);
        this.add(sensorPhLabel);
        this.add(sensorColorLabel);
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
        this.sensorIdLabel.setText(new Integer(sensor.id).toString());
        this.sensorTemperatureLabel.setText(new Integer(sensor.temperature).toString());
        this.sensorPhLabel.setText(new Integer(sensor.ph).toString());
        this.sensorColorLabel.setText(new Integer(sensor.color).toString());
    }
}
