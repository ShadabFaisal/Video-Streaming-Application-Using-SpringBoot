package com.springboot.video_stream_app.payload;

public class CustomMessage {

    private String message;
    private boolean success=false;

    public CustomMessage() {
    }

    public CustomMessage(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
