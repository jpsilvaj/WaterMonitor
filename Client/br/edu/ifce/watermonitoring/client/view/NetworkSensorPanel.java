package br.edu.ifce.watermonitoring.client.view;

import br.edu.ifce.watermonitoring.client.Exception.SensorCannotFindException;
import sensorNetwork.Sensor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class NetworkSensorPanel extends JPanel {
    public NetworkSensorPanel(){
        this.setLayout(new FlowLayout());
    }

    public void addSensorPanel(Sensor sensor){
        SensorPanel sensorPanel = new SensorPanel(sensor);
        this.add(sensorPanel);
    }

    public void removeSensorPanel(SensorPanel sensorPanel){
        this.remove(sensorPanel);
    }

    public SensorPanel findSensorPanel(Sensor sensor) throws SensorCannotFindException {
        Component[] components = this.getComponents();
        for(Component component :components){
            if(component instanceof SensorPanel){
                SensorPanel sensorPanel = (SensorPanel)component;
                if(sensorPanel.getSensor().equals(sensor)){
                    return sensorPanel;
                }
            }
        }
        throw new SensorCannotFindException();
    }
}
