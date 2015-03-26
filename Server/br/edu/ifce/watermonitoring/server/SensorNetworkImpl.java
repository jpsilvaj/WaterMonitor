package br.edu.ifce.watermonitoring.server;

import sensorNetwork.Sensor;

import java.util.Map;

/**
 * Created by jp-desktop on 26/03/2015.
 */
public class SensorNetworkImpl extends sensorNetwork.SensorNetworkPOA{

    private int id;
    private Map<Integer,Sensor> sensors;


    public SensorNetworkImpl(){
        super();
    }

    @Override
    public void addSensorToNetwork(Sensor sensor) {
        this.sensors.put(sensor.id,sensor);
    }

    @Override
    public void deleteSensorFromNetwork(Sensor sensor) {
        this.sensors.remove(sensor.id);
    }

    @Override
    public void updateTemperatureValueToSensor(Sensor sensor, int temperature) {
        this.sensors.get(sensor.id).temperature = temperature;
    }

    @Override
    public void updatePhValueToSensor(Sensor sensor, int ph) {
        this.sensors.get(sensor.id).ph = ph;
    }

    @Override
    public void updateColorValueToSensor(Sensor sensor, int color) {
        this.sensors.get(sensor.id).color = color;
    }

    @Override
    public Sensor[] getSensors() {
        return new Sensor[0];
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void start() {

    }

}
