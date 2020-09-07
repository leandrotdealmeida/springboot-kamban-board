package com.japa.kanboard.write.domain.core;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bucket {
    private int id;
    private UUID uuid;
    private int position;
    private String name;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Bucket(){ }

    public int getId() {
        return id;
    }

    public Bucket setId(int id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Bucket setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Bucket setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bucket setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public Bucket setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
        return this;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public Bucket setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
        return this;
    }
}
