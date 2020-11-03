package com.fb_api_integration.freeadmin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue for Posts
 */
public class PostQueue {

    private static PostQueue instance = null;
    private final Queue<Post> queue = new LinkedList<>();

    /**
     * Private Constructor
     */
    private PostQueue() {}

    /**
     * Get current instance of queue
     * @return current instance of queue
     */
    public static PostQueue getInstance() {
        if (instance == null) {
            instance = new PostQueue();
        }

        return instance;
    }

    /**
     * Add post to the queue
     * @param post post to be added to queue
     */
    public void enqueue(Post post) {
        synchronized (queue) {
            queue.add(post);
        }
    }

    /**
     * Dequeue head of the queue
     * @return head of the queue
     */
    public Post dequeue() {
        synchronized (queue) {
            return queue.remove();
        }
    }

    /**
     * Determine if queue is empty
     * @return true if queue is empty, false if there are posts in queue.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Get delay before next post
     * @return delay before next post
     */
    public long getDelayBeforeNext() {
        if (queue.isEmpty()) {
            return 0;
        }

        return queue.peek().getDelay();
    }
}
