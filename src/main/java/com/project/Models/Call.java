package com.project.Models;

public class Call extends BaseEntitie {
    private String time;
    private String callState;
    private int duration;
    private String phoneNumber;
    private boolean savedContact;

    public Call() {
    }
    public Call(String time, String callState, int duration, String phoneNumber, boolean savedContact) {
        this.time = time;
        this.callState = callState;
        this.duration = duration;
        this.phoneNumber = phoneNumber;
        this.savedContact = savedContact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSavedContact() {
        return savedContact;
    }

    public void setSavedContact(boolean savedContact) {
        this.savedContact = savedContact;
    }

    @Override
    public String toString() {
        return "Call{" +
                "time='" + time + '\'' +
                ", callState='" + callState + '\'' +
                ", duration=" + duration +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", savedContact=" + savedContact +
                '}';
    }
}
