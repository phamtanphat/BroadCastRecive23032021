package com.example.broadcastrecive23032021;

public class MessageEvent {
    private boolean enablePlaneMode;

    public MessageEvent(boolean enablePlaneMode) {
        this.enablePlaneMode = enablePlaneMode;
    }

    public boolean isEnablePlaneMode() {
        return enablePlaneMode;
    }

    public void setEnablePlaneMode(boolean enablePlaneMode) {
        this.enablePlaneMode = enablePlaneMode;
    }
}
