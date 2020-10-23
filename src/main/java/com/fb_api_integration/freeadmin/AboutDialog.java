package com.fb_api_integration.freeadmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

/**
 * About Dialog Class
 */
public class AboutDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel homepageLabel;
    private JLabel licenseLabel;

    /**
     * About Dialog Constructor
     * @param parent the parent frame
     */
    public AboutDialog(JFrame parent) {
        super(parent, true);

        setContentPane(contentPane);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onOK();
            }
        });

        buttonOK.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        homepageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homepageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openHyperlink("https://github.com/IUS-CS/project-facebook-api-integration-software");
            }
        });

        licenseLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        licenseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openHyperlink("https://raw.githubusercontent.com/IUS-CS/project-facebook-api-integration-software/master/LICENSE");
            }
        });

        // call onOK() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Opens URL in web browser
     * @param url URL to open in browser
     */
    private void openHyperlink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e1) {
            JOptionPane.showMessageDialog(this,
                    "Could not open the hyperlink. Error: " + e1.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * OK Button Action
     */
    private void onOK() {
        dispose();
    }
}
