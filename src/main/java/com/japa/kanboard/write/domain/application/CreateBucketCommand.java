package com.japa.kanboard.write.domain.application;

import java.util.UUID;

public class CreateBucketCommand {

    private UUID id;
    private int position;
    private String name;

    public CreateBucketCommand(UUID id, int position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}