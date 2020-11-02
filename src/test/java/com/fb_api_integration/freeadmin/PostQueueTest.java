package com.fb_api_integration.freeadmin;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostQueueTest {

    @Test
    public void EnqueueDequeueTest() {
        PostQueue queue = PostQueue.getInstance();

        Post post1 = new Post("0", PostType.FEED);
        queue.enqueue(post1);
        Post post2 = new Post("0", PostType.FEED);
        queue.enqueue(post2);
        Post post3 = new Post("0", PostType.FEED);
        queue.enqueue(post3);

        Post dequeuedPost = queue.dequeue();
        assertEquals(post1, dequeuedPost);

        dequeuedPost = queue.dequeue();
        assertEquals(post2, dequeuedPost);

        dequeuedPost = queue.dequeue();
        assertEquals(post3, dequeuedPost);
    }

    @Test
    public void DelayTest() {
        PostQueue queue = PostQueue.getInstance();
        Post post = new Post("0", PostType.FEED);
        post.setDelay(1234);
        queue.enqueue(post);

        assertEquals(1234, queue.getDelayBeforeNext());
    }

    @Test
    public void IsEmptyTest() {
        PostQueue queue = PostQueue.getInstance();

        assertTrue(queue.isEmpty());

        Post post = new Post("0", PostType.FEED);
        queue.enqueue(post);

        assertFalse(queue.isEmpty());

        queue.dequeue();

        assertTrue(queue.isEmpty());
    }
}
