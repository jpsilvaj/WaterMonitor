package br.edu.ifce.watermonitoring.client.view;

import br.edu.ifce.watermonitoring.client.handler.MenuListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jp-desktop on 28/03/2015.
 */
public class WaterMonitoringMenuPanel extends JPanel{

        private static final long serialVersionUID = -603714265252762724L;

        JMenuBar menuBar;

        public WaterMonitoringMenuPanel(){
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
            configureMenuBar();
        }

        private void configureMenuBar(){
            JMenuBar menuBar = new JMenuBar();
            menuBar.add(Box.createHorizontalGlue());
            JMenu file = new JMenu("File");
            file.setMnemonic(KeyEvent.VK_F);

            ImageIcon exitIcon = new ImageIcon("exit.png");
            JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
            eMenuItem.setMnemonic(KeyEvent.VK_E);
            eMenuItem.setToolTipText("Exit application");
            eMenuItem.setActionCommand("exit");
            eMenuItem.addActionListener( new MenuListener());

            JMenu sensor = new JMenu("Sensor");
            sensor.setMnemonic(KeyEvent.VK_R);
            ImageIcon sensorIcon = new ImageIcon("sensor.png");

            JMenuItem createSensorMenuItem = new JMenuItem("Create sensor", sensorIcon);
            createSensorMenuItem.setMnemonic(KeyEvent.VK_C);
            createSensorMenuItem.setToolTipText("Create sensor");
            createSensorMenuItem.setActionCommand("create_sensor");
            createSensorMenuItem.addActionListener(new MenuListener());

            JMenuItem deleteSensorMenuItem = new JMenuItem("Delete sensor", sensorIcon);
            deleteSensorMenuItem.setMnemonic(KeyEvent.VK_Q);
            deleteSensorMenuItem.setToolTipText("Delete sensor");
            deleteSensorMenuItem.setActionCommand("delete_sensor");
            deleteSensorMenuItem.addActionListener( new MenuListener());

            JMenu help = new JMenu("Help");
            help.setMnemonic(KeyEvent.VK_H);

            ImageIcon aboutIcon = new ImageIcon("about.png");
            JMenuItem aboutMenuItem = new JMenuItem("About", aboutIcon);
            aboutMenuItem.setMnemonic(KeyEvent.VK_A);
            aboutMenuItem.setToolTipText("About application");
            aboutMenuItem.setActionCommand("about");
            aboutMenuItem.addActionListener(new MenuListener());

            file.add(eMenuItem);
            sensor.add(createSensorMenuItem);
            sensor.add(deleteSensorMenuItem);
            help.add(aboutMenuItem);

            menuBar.add(file);
            menuBar.add(sensor);
            menuBar.add(help);

            this.add(menuBar);
            this.setVisible(true);
        }
}
