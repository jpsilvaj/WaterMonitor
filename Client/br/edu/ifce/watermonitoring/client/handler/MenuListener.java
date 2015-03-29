package br.edu.ifce.watermonitoring.client.handler;

/**
 * Created by jp-desktop on 28/03/2015.
 */

import br.edu.ifce.watermonitoring.client.utils.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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

        }
        else if(e.getActionCommand() == "delete_sensor"){

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
}