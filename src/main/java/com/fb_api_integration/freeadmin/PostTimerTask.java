package com.fb_api_integration.freeadmin;

import java.util.TimerTask;

/**
 * Timer Task for Posting
 */
public class PostTimerTask extends TimerTask {

    long lastPostMs = 0;

    @Override
    public void run() {
        PostQueue queue = PostQueue.getInstance();

        if (queue.isEmpty()) {
            return;
        }

        long currentMs = System.currentTimeMillis();
        if (currentMs > lastPostMs + queue.getDelayBeforeNext()) {
            Post post = queue.dequeue();
            String id = post.publish();
            System.out.println("Published post " + id);

            lastPostMs = currentMs;
        }
    }
}
