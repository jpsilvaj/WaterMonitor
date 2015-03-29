package br.edu.ifce.watermonitoring.client.utils;

import sensorNetwork.utils.*;

/**
 * Created by jp-desktop on 29/03/2015.
 */
public class FormatSensorValuesToNotification {

    public static String formatSensorValueByType(int valueSensor, SensorsTypes sensorType){

        switch (sensorType){
            case TEMPERATURE:
                return formatTemperatureValue(valueSensor);
            case PH:
                return formatPhValue(valueSensor);
            case COLOR:
                return formatColorValue(valueSensor);
        }
        return "N�o dispon�vel";
    }

    private static String formatTemperatureValue(int temperatureValue){
        RangeTemperature rangeTemperature = ProcessRangeOfSensors.verifyRangeFromTemperature(temperatureValue);
        switch (rangeTemperature){
            case COLD:
                return "Temperatura baixa";
            case NORMAL:
                return "Temperatura normal";
            case HOT:
                return "Temperatura alta";
        }
        return "N�o dispon�vel";
    }

    private static String formatPhValue(int phValue){
        RangePH rangePh = ProcessRangeOfSensors.verifyRangeFromPh(phValue);
        switch (rangePh){
            case ACID:
                return "�cida";
            case NEUTRAL:
                return "Neutra";
            case BASE:
                return "B�sica";
        }
        return "N�o dispon�vel";
    }

    private static String formatColorValue(int colorValue){
        RangeColor rangeColor = ProcessRangeOfSensors.verifyRangeFromColor(colorValue);
        switch (rangeColor){
            case POLLUTION:
                return "Polui��o por material org�nico";
            case NORMAL:
                return "Cor normal";
        }
        return "N�o dispon�vel";
    }

}
