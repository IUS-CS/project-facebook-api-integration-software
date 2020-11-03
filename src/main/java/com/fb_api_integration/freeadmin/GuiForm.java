package com.fb_api_integration.freeadmin;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.*;

public class GuiForm extends JFrame {
    private JPanel RootPanel;
    //private JButton ExitButton;
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
        setResizable(false); //make the frame not resizable

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm();
            }
        });

        final JFileChooser OneFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        final JFileChooser multiFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        setupMenu();

        //ExitButton.addActionListener(new ActionListener() {                             //Exit Button
        //    @Override
        //    public void actionPerformed(ActionEvent event) {
        //        exitForm();
        //    }
        //});//Exit Button action listener


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

                long delay = convertHoursToMillis(Integer.parseInt(HoursField.getText()));

                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(OneFileChooser.getSelectedFile()), "UTF8"));

                    while ((str = in.readLine()) != null) {                        //While loop to read data line by line from selected file
                        Post post = new Post(accessToken, PostType.FEED);
                        post.setMessage(str);

                        if (!PostQueue.getInstance().isEmpty()) { // No delay for the first post
                            post.setDelay(delay);
                        }

                        PostQueue.getInstance().enqueue(post);
                    } //while

                    in.close();
                } //Try
                catch (IOException e) {
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

                long delay = convertHoursToMillis(Integer.parseInt(HoursField.getText()));

                File[] files = multiFileChooser.getSelectedFiles();                                //Store selected pictures in array

                for (int i = 0; i < files.length; i++) {                    //Go through each picture
                    Post post = new Post(accessToken, PostType.PHOTOS);
                    post.setAttachment(files[i]);

                    if (!PostQueue.getInstance().isEmpty()) { // No delay for the first post
                        post.setDelay(delay);
                    }

                    PostQueue.getInstance().enqueue(post);
                }
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

                long delay = convertHoursToMillis(Integer.parseInt(HoursField.getText()));

                File[] files = multiFileChooser.getSelectedFiles();                                //Store selected videos in array

                for (int i = 0; i < files.length; i++) {                    //Go through each video
                    Post post = new Post(accessToken, PostType.VIDEOS);
                    post.setAttachment(files[i]);

                    if (!PostQueue.getInstance().isEmpty()) { // No delay for the first post
                        post.setDelay(delay);
                    }

                    PostQueue.getInstance().enqueue(post);
                }
            }
        });//Post Videos Button action listener

    }//GuiForm()

    /**
     * Convert hours to milliseconds
     * @param hours hours to convert
     */
    private long convertHoursToMillis(int hours) {
        return hours * 60 * 60 * 1000;
    }

    /**
     *  Initialize Menubar
     */
    private void setupMenu() {
        final JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                exitForm();
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog aboutDialog = new AboutDialog(GuiForm.this);
                aboutDialog.pack();
                aboutDialog.setVisible(true);
            }
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
