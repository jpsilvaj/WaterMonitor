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

            JMenu note = new JMenu("Sensor");
            note.setMnemonic(KeyEvent.VK_R);
            ImageIcon noteIcon = new ImageIcon("sensor.png");

            JMenuItem createNoteMenuItem = new JMenuItem("Create sensor", noteIcon);
            createNoteMenuItem.setMnemonic(KeyEvent.VK_C);
            createNoteMenuItem.setToolTipText("Create sensor");
            createNoteMenuItem.setActionCommand("create_sensor");
            createNoteMenuItem.addActionListener(new MenuListener());

            JMenuItem deleteNoteMenuItem = new JMenuItem("Delete sensor", noteIcon);
            deleteNoteMenuItem.setMnemonic(KeyEvent.VK_Q);
            deleteNoteMenuItem.setToolTipText("Delete sensor");
            deleteNoteMenuItem.setActionCommand("delete_sensor");
            deleteNoteMenuItem.addActionListener( new MenuListener());

            JMenu help = new JMenu("Help");
            help.setMnemonic(KeyEvent.VK_H);

            ImageIcon aboutIcon = new ImageIcon("about.png");
            JMenuItem aboutMenuItem = new JMenuItem("About", aboutIcon);
            aboutMenuItem.setMnemonic(KeyEvent.VK_A);
            aboutMenuItem.setToolTipText("About application");
            aboutMenuItem.setActionCommand("about");
            aboutMenuItem.addActionListener(new MenuListener());

            file.add(eMenuItem);
            note.add(createNoteMenuItem);
            note.add(deleteNoteMenuItem);
            help.add(aboutMenuItem);

            menuBar.add(file);
            menuBar.add(note);
            menuBar.add(help);

            this.add(menuBar);
            this.setVisible(true);
        }
}
