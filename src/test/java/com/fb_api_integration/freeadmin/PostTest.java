package com.fb_api_integration.freeadmin;

import com.restfb.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.restfb.types.FacebookType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PostTest {

    @Mock
    private FacebookType publishMessageResponse = new FacebookType();

    @Mock
    private FacebookClient fbClient = new DefaultFacebookClient("0", Version.LATEST);

    @InjectMocks
    private Post postMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAndSetDelayTest() {
        Post post = new Post(fbClient, PostType.FEED);
        post.setDelay(123);
        assertEquals(123, post.getDelay());
    }

    @Ignore
    @Test
    public void publishTest() {

        postMock = new Post(fbClient, PostType.PHOTOS);
        postMock.setMessage("test message");
        FacebookType publishResponse = new FacebookType();
        publishResponse.setId("Post Successful");

        when(fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", "test message"))).thenReturn(publishResponse);
        when(fbClient.publish(eq("me/photos"), any(), any())).thenReturn(new FacebookType());
        when(fbClient.publish("me/videos", FacebookType.class, attachment)).thenReturn(publishResponse);

        when(publishMessageResponse.getId()).thenReturn("Post Successful");

        assertEquals("Post Successful", postMock.publish());

    }

    @Test
    public void toStringTest() {
        String result;

        Post post1 = new Post(fbClient, PostType.FEED);
        post1.setMessage("test message");
        result = post1.toString();
        assertEquals("test message", result);

        Post post2= new Post(fbClient, PostType.PHOTOS);
        result = post2.toString();
        assertEquals("Photo", result);

        Post post3 = new Post(fbClient, PostType.VIDEOS);
        result = post3.toString();
        assertEquals("Video", result);
    }
}
