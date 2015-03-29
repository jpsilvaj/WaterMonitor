package br.edu.ifce.watermonitoring.client.Exception;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class SensorCannotFindException extends Exception {
    public SensorCannotFindException(){
        super("Cannot find sensor in network");
    }
}
