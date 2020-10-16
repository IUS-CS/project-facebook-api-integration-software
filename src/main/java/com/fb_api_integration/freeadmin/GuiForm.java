package com.fb_api_integration.freeadmin;

import com.restfb.*;
import com.restfb.types.FacebookType;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.*;

public class GuiForm extends JFrame {
    private JPanel RootPanel;
    private JButton ExitButton;
    private JButton SelectTextFileButton;
    private JButton SelectImageFilesButton;
    private JButton PostStatusButton;
    private JButton PostImagesButton;
    private JLabel HoursLabel;
    private JLabel AccessTokenLabel;
    private JTextField HoursField;
    private JTextField AccessTokenInput;
    private JButton SelectVideoFilesButton;
    private JButton PostVideosButton;
    private String str;

    public GuiForm() {

        add(RootPanel);
        setTitle("Free Admin");
        setSize(640, 480);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm();
            }
        });

        final JFileChooser OneFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        final JFileChooser multiFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        setupMenu();

        ExitButton.addActionListener(new ActionListener() {                             //Exit Button
            @Override
            public void actionPerformed(ActionEvent event) {
                exitForm();
            }
        });//Exit Button action listener


        SelectTextFileButton.addActionListener(new ActionListener() {                  //Select Text File Button
            @Override
            public void actionPerformed(ActionEvent event) {
                OneFileChooser.showOpenDialog(null);
            }
        });//Select Text File Button action listener


        PostStatusButton.addActionListener(new ActionListener() {                         //Post Status Button
            @Override
            public void actionPerformed(ActionEvent event) {

                String accessToken = AccessTokenInput.getText();
                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);  //Creating facebook access token

                try {

                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(OneFileChooser.getSelectedFile()), "UTF8"));

                    String hoursInString = HoursField.getText();                   //Getting hours input from user.
                    int hours = Integer.parseInt(hoursInString);                   //Parsing hours
                    int milliSecToHours = hours * 60 * 60 * 1000;                  //Converting hours to milliseconds

                    while ((str = in.readLine()) != null) {                        //While loop to read data line by line from selected file
                        FacebookType publishMessageResponse = fbClient.publish("me/feed", FacebookType.class,               //Post first line read
                                Parameter.with("message", str));
                        System.out.println("fb.com/" + publishMessageResponse.getId());

                        Thread.sleep(milliSecToHours);                        //Pause between each line
                    }//while

                    in.close();
                } //Try
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });//Post Status Button action listener


        SelectImageFilesButton.addActionListener(new ActionListener() {     //Select Image Files Button
            @Override
            public void actionPerformed(ActionEvent e) {
                multiFileChooser.setMultiSelectionEnabled(true);
                multiFileChooser.showOpenDialog(null);
            }
        });//Select Image Files Button action listener


        PostImagesButton.addActionListener(new ActionListener() {     //Post Images Button
            @Override
            public void actionPerformed(ActionEvent e) {

                String accessToken = AccessTokenInput.getText();
                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);  //Creating facebook access token
                File[] files = multiFileChooser.getSelectedFiles();                                //Store selected pictures in array

                String hoursInString = HoursField.getText();                   //Getting hours input from user.
                int hours = Integer.parseInt(hoursInString);                   //Parsing hours
                int milliSecToHours = hours * 60 * 60 * 1000;                  //Converting hours to milliseconds

                try {
                    for (int i = 0; i < files.length; i++) {                    //Go through each picture

                        FileInputStream fis = new FileInputStream(new File(String.valueOf(files[i])));      //File reader
                        FacebookType publishMessageResponse = fbClient.publish("me/photos", FacebookType.class,
                                BinaryAttachment.with("try", fis));

                        System.out.println("fb.com/" + publishMessageResponse.getId());                     //Post pictures

                        Thread.sleep(milliSecToHours);                                             //Pause between each picture
                    }
                }//try

                catch (FileNotFoundException | InterruptedException ex) {
                    ex.printStackTrace();
                }//catch
            }
        });//Post Images Button action listener


        SelectVideoFilesButton.addActionListener(new ActionListener() {    //Select Video Files Button
            @Override
            public void actionPerformed(ActionEvent e) {
                multiFileChooser.setMultiSelectionEnabled(true);
                multiFileChooser.showOpenDialog(null);
            }
        });//Select Video Files Button action listener


        PostVideosButton.addActionListener(new ActionListener() {       //Post Videos Button
            @Override
            public void actionPerformed(ActionEvent e) {

                String accessToken = AccessTokenInput.getText();
                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);  //Creating facebook access token
                File[] files = multiFileChooser.getSelectedFiles();                                //Store selected videos in array

                String hoursInString = HoursField.getText();                   //Getting hours input from user.
                int hours = Integer.parseInt(hoursInString);                   //Parsing hours
                int milliSecToHours = hours * 60 * 60 * 1000;                  //Converting hours to milliseconds

                try {
                    for (int i = 0; i < files.length; i++) {                    //Go through each video

                        FileInputStream fis = new FileInputStream(new File(String.valueOf(files[i])));      //File reader
                        FacebookType publishMessageResponse = fbClient.publish("me/videos", FacebookType.class,
                                BinaryAttachment.with("try.mp4", fis));

                        System.out.println("fb.com/" + publishMessageResponse.getId());                     //Post videos

                        Thread.sleep(milliSecToHours);                                             //Pause between each video
                    }
                }//try

                catch (FileNotFoundException | InterruptedException ex) {
                    ex.printStackTrace();
                }//catch
            }
        });//Post Videos Button action listener

    }//GuiForm()

    /**
     *  Initialize Menubar
     */
    private void setupMenu() {
        final JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> exitForm());
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> {
            AboutDialog aboutDialog = new AboutDialog(this);
            aboutDialog.pack();
            aboutDialog.setVisible(true);
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
    }

    /**
     * Action performed when exiting form
     */
    private void exitForm() {
        System.exit(0);
    }
}//GuiForm
