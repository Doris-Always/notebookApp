package com.notebookApp.data.models;



public class Entry {
    private int entryId;
    private String topic;
    private String entryBody;


    public Entry(int entryId, String topic, String entryBody) {
        this.entryId = entryId;
        this.topic = topic;
        this.entryBody = entryBody;
    }
    public Entry(){

    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEntryBody() {
        return entryBody;
    }

    public void setEntryBody(String entryBody) {
        this.entryBody = entryBody;
    }
}
