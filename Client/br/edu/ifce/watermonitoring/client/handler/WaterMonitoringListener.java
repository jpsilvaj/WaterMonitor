package br.edu.ifce.watermonitoring.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by jp-desktop on 28/03/2015.
 */

public class WaterMonitoringListener implements ActionListener, WindowListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "set_temperature_value"){
        }
        else if(e.getActionCommand() == "set_ph_value"){
        }
        else if(e.getActionCommand() == "set_color_value"){
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Implement address of the URI RMI
    }

    @Override
    public void windowClosing(WindowEvent e) {
        windowClosed(e);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        try{
            //TODO:ClientControllerImpl.exit();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        finally{
            System.exit(0);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}