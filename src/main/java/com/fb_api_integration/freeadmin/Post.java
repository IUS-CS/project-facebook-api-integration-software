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

    private FacebookClient fbClient;
    private PostType postType;
    private String message = "";
    private BinaryAttachment attachment = null;

    /**
     * Creates a new post
     * @param accessToken access token to use for publishing
     * @param postType type of post to publish
     */
    public Post(String accessToken, PostType postType) {
        fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);

        this.postType = postType;
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
        FacebookType publishMessageResponse = new FacebookType();

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

        return publishMessageResponse.getId();
    }
}
