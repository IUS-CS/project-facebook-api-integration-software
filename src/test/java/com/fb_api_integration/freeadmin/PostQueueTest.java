package com.fb_api_integration.freeadmin;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostQueueTest {

    @Test
    public void EnqueueDequeueTest() {
        PostQueue queue = PostQueue.getInstance();
        FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);

        Post post1 = new Post(fbClient, PostType.FEED);
        queue.enqueue(post1);

        Post post2 = new Post(fbClient, PostType.PHOTOS);
        queue.enqueue(post2);

        Post post3 = new Post(fbClient, PostType.VIDEOS);
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
        FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);

        Post post = new Post(fbClient, PostType.FEED);
        post.setDelay(1234);
        queue.enqueue(post);

        assertEquals(1234, queue.getDelayBeforeNext());
    }

    @Test
    public void IsEmptyTest() {
        PostQueue queue = PostQueue.getInstance();

        assertTrue(queue.isEmpty());

        FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);
        Post post = new Post(fbClient, PostType.FEED);
        queue.enqueue(post);

        assertFalse(queue.isEmpty());

        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void getSizeTest() {
        PostQueue queue = PostQueue.getInstance();
        FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);
        assertEquals(0, queue.getSize());

        Post post1 = new Post(fbClient, PostType.FEED);
        queue.enqueue(post1);
        assertEquals(1, queue.getSize());

        Post post2 = new Post(fbClient, PostType.PHOTOS);
        queue.enqueue(post2);
        assertEquals(2, queue.getSize());

        Post post3 = new Post(fbClient, PostType.VIDEOS);
        queue.enqueue(post3);
        assertEquals(3, queue.getSize());

        Post dequeuedPost = queue.dequeue();
        assertEquals(post1, dequeuedPost);
        assertEquals(2, queue.getSize());

        dequeuedPost = queue.dequeue();
        assertEquals(post2, dequeuedPost);
        assertEquals(1, queue.getSize());

        dequeuedPost = queue.dequeue();
        assertEquals(post3, dequeuedPost);
        assertEquals(0, queue.getSize());
    }

    @Test
    public void ClearTest() {
        PostQueue queue = PostQueue.getInstance();
        FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);

        Post post1 = new Post(fbClient, PostType.FEED);
        queue.enqueue(post1);

        Post post2 = new Post(fbClient, PostType.PHOTOS);
        queue.enqueue(post2);

        queue.clear();

        assertEquals(0, queue.getSize());
    }
}
