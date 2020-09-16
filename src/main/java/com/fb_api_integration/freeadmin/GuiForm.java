package com.fb_api_integration.freeadmin;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuiForm extends JFrame {
    private JPanel RootPanel;
    private JButton ExitButton;
    private JButton PostButton;
    private JButton SelectFileButton;
    private JLabel HoursLabel;
    private JTextField HoursField;
    private JFormattedTextField formattedTextField1;
    private ImageIcon icon;
    private JLabel background;
    private String str;


    public GuiForm() {

        //icon = new ImageIcon(this.getClass().getResource("/img.jpg"));              //Might be added later
        //background = new JLabel(icon);
        //background.setSize(1000,800);
        //add(background);

        add(RootPanel);
        setTitle("Free Admin");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


        ExitButton.addActionListener(new ActionListener() {                             //Action Listener to Exit button
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });//Exit button action listener

        SelectFileButton.addActionListener(new ActionListener() {                  //Action Listener to file button
            @Override
            public void actionPerformed(ActionEvent event) {

                jfc.showOpenDialog(null);
            }
        });//Select button action listener

        PostButton.addActionListener(new ActionListener() {                         //Action Listener to post button
            @Override
            public void actionPerformed(ActionEvent event) {
                String accessToken = "EAAXCZAYMmme4BAIUXvGREb5kvWUWzVGf7rt2EcCSdKv0ZAAPDCvtggmmiELxEaKriyPWxe3mgSLIiJlEGZCBPNZCM9Qyk7om0795AjjhSrSNCkm8yrclqDKcscICZBHwxWqs3lkd8EjqtBD1oyifQyQ8YmPvnXlJp6LluQnbyLBDj8pam2IV5t7ZBvOTiavs3iO44O4J9NiQZDZD";
                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);  //Creating facebook access token

                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(jfc.getSelectedFile()), "UTF8"));


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

                }//Try

                catch (UnsupportedEncodingException e)                      //Catch errors
                {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });//Post button action listener


    }//GuiForm()

}//GuiForm




