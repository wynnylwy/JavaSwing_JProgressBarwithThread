package com.wynnylwy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar {

    private JFrame mainFrame;
    private JButton startButton;
    private JProgressBar progressBar;
    private Task task;

    public ProgressBar(){

        /* Create window */
        mainFrame = new JFrame("Progress Bar Example");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);

        /* Create start button */
        startButton = new JButton("Start");
        startButton.setBounds(50,50,100,50);
        startButton.addActionListener(new ActionListener() {

            /* Add button's action */
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();
                //JOptionPane.showMessageDialog(null, "Finish");
            }
        });

        /* Create progress bar */
        progressBar = new JProgressBar(0,100);  //set min & max progress value
        progressBar.setBounds(50,150,500,30);
        progressBar.setStringPainted(true);   //show progress value

        /* Add components into frame */
        mainFrame.add(progressBar);
        mainFrame.add(startButton);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
	    new ProgressBar();
    }

    private class Task extends Thread{
        public void run(){
            for (int i=0; i<=100; i++){
                progressBar.setValue(i);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
