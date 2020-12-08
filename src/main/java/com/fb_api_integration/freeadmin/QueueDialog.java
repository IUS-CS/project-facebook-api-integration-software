package com.fb_api_integration.freeadmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.Timer;

/**
 * Queue Dialog class
 */
public class QueueDialog extends JDialog {

    private final DefaultTableModel defaultTableModel = new DefaultTableModel();

    /**
     * Queue Dialog Constructor
     * @param parent the parent frame
     */
    public QueueDialog(JFrame parent) {
        super(parent);

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JTable queueTable = new JTable(defaultTableModel);
        queueTable.setDefaultEditor(Object.class, null);

        defaultTableModel.addColumn("Position");
        defaultTableModel.addColumn("Content");
        defaultTableModel.addColumn("Delay");

        Timer refreshTimer = new Timer();
        refreshTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refreshTable();
            }
        }, 0, 500);

        JScrollPane scrollPane = new JScrollPane(queueTable);
        add(scrollPane);
        setSize(640, 480);
    }

    /**
     * Refresh the queue table
     */
    public void refreshTable() {
        // If the sizes are the same, the table is most likely up to date
        if (PostQueue.getInstance().getSize() == defaultTableModel.getRowCount()) {
            return;
        }

        // Clear Table
        int rowCount = defaultTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            defaultTableModel.removeRow(0);
        }

        Iterator<Post> it = PostQueue.getInstance().getIterator();
        int i = 1;
        long previousDelay = 0;

        while (it.hasNext()) {
            Post post = it.next();

            long millis = previousDelay + post.getDelay();
            int minutes = (int)((millis / (60*1000)) % 60);
            int hours = (int)((millis / (60*60*1000)) % 24);

            defaultTableModel.addRow(new Object[]{i, post.toString(), hours + " hour(s) " + minutes + " minute(s)"});
            previousDelay += post.getDelay();
            i++;
        }
    }
}
