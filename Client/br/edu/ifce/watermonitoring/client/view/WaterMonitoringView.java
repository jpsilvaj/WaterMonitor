package br.edu.ifce.watermonitoring.client.view;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import sensorNetwork.Sensor;
import br.edu.ifce.watermonitoring.client.Exception.SensorCannotFindException;
import br.edu.ifce.watermonitoring.client.controller.ClientControllerWaterMonitoring;
import br.edu.ifce.watermonitoring.client.handler.WaterMonitoringListener;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class WaterMonitoringView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -8069685429796289001L;
    private WaterMonitoringMenuPanel waterMonitoringMenuPanel = new WaterMonitoringMenuPanel();
    private NetworkSensorPanel networkSensorPanel = new NetworkSensorPanel();
    private ArrayList<Sensor> listOfSensors;

    public WaterMonitoringView(){
        super("Water Monitoring - CORBA");
        this.setSize(840,680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Water Monitoring - CORBA");
        this.addPanels();
        this.addWindowListener(new WaterMonitoringListener());
        this.pack();
        this.setVisible(true);
    }

    private void addPanels(){
        Container c = getContentPane();
        c.setLayout(new MigLayout("insets 15 15 15 15"));
        c.add(waterMonitoringMenuPanel, "dock north");
        c.add(networkSensorPanel, "dock center");
    }

    public WaterMonitoringMenuPanel getWaterMonitoringMenuPanel() {
        return waterMonitoringMenuPanel;
    }

    public void setWaterMonitoringMenuPanel(WaterMonitoringMenuPanel waterMonitoringMenuPanel) {
        this.waterMonitoringMenuPanel = waterMonitoringMenuPanel;
    }

    public NetworkSensorPanel getNetworkSensorPanel() {
        return networkSensorPanel;
    }

    public void setNetworkSensorPanel(NetworkSensorPanel networkSensorPanel) {
        this.networkSensorPanel = networkSensorPanel;
    }

    public void addSensorToPanel(int temperature, int ph, int color){
    	Sensor sensor = new Sensor(listOfSensors.size(), temperature, ph, color);
    	ClientControllerWaterMonitoring.addSensorToServer(sensor);
        this.listOfSensors.add(sensor);
        this.networkSensorPanel.addSensorPanel(sensor);
    }

    public void updateSensorValueInPanel(Sensor sensor) throws SensorCannotFindException {
        SensorPanel sensorPanel = networkSensorPanel.findSensorPanel(sensor);
        sensorPanel.setSensor(sensor);
    }

    public ArrayList<Sensor> listSensor(){
        return listOfSensors;
    }

    public void removeSensorPanel(Sensor sensor){
        try {
            SensorPanel sensorPanel = networkSensorPanel.findSensorPanel(sensor);
            networkSensorPanel.removeSensorPanel(sensorPanel);
            this.listOfSensors.remove(sensor);
        } catch (SensorCannotFindException e) {
            e.printStackTrace();
        }

    }
}