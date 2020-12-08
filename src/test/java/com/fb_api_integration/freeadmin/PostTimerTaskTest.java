package com.fb_api_integration.freeadmin;

import static org.mockito.Mockito.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostTimerTaskTest {

    @Mock
    private Post mockedPost;

    @InjectMocks
    private PostTimerTask test;

    @Test
    public void runPostTimerTest() {
        PostQueue queue = PostQueue.getInstance();
        queue.clear();

        PostTimerTask test = new PostTimerTask();
        test.run();

        // queue is empty, so mockedPost.publish method never executed
        verify(mockedPost, times(0)).publish();

        // set up queue with 2 mockedPost's for tests
        queue.enqueue(mockedPost);
        queue.enqueue(mockedPost);

        // make mocked published
        when(mockedPost.publish()).thenReturn("Post Successful");

        test.run();

        // queue is not empty, so mockedPost.publish method executed for the first time
        verify(mockedPost, times(1)).publish();

        // make mockedPost unpublished
        when(mockedPost.publish()).thenReturn(null);

        test.run();
        // queue is not empty, so mockedPost.publish method executed for the second time
        verify(mockedPost, times(2)).publish();

    }

}
