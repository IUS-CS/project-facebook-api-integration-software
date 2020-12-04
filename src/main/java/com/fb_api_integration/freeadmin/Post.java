package com.fb_api_integration.freeadmin;

import com.restfb.*;
import com.restfb.types.FacebookType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Represents a post to be published to facebook
 */
public class Post {

    private final FacebookClient fbClient;
    private final PostType postType;
    private FacebookType publishMessageResponse;
    private String message = "";
    private BinaryAttachment attachment = null;
    private long delay = 0;

    /**
     * Creates a new post
     * @param fbClient Facebook Client to use for publishing
     * @param postType type of post to publish
     */
    public Post(FacebookClient fbClient, PostType postType) {
        this.fbClient = fbClient;
        this.postType = postType;
    }

    /**
     * Set the delay before posting
     * @param delay delay before posting
     */
    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Get the delay before posting
     * @return delay before posting
     */
    public long getDelay() {
        return delay;
    }

    /**
     * Set message/status for the post
     * @param message message to appear
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Set attachment for the post
     * @param file attachment to use
     */
    public void setAttachment(File file) {
        try {
            this.attachment = BinaryAttachment.with(file.getName(), Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Publishes the post
     * @return ID of the post
     */
    public String publish() {
        publishMessageResponse = new FacebookType();
        try {
            switch (postType) {
                case FEED:
                    publishMessageResponse = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", message));
                    break;
                case PHOTOS:
                    publishMessageResponse = fbClient.publish("me/photos", FacebookType.class, attachment);
                    break;
                case VIDEOS:
                    publishMessageResponse = fbClient.publish("me/videos", FacebookType.class, attachment);
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return publishMessageResponse.getId();
    }

    /**
     * Gets the post as a string
     * @return representation of post as a string
     */
    @Override
    public String toString() {
        String s = "";

        switch (postType) {
            case FEED:
                s = message;
                break;
            case PHOTOS:
                s = "Photo";
                break;
            case VIDEOS:
                s = "Video";
                break;
        }

        return s;
    }
}
