package com.japa.kanboard.write.domain.application;

import com.japa.kanboard.write.domain.core.Bucket;
import com.japa.kanboard.write.domain.core.BucketRepository;
import com.japa.kanboard.write.domain.core.ListAgregate;

public class CreateBucketCommandHandler {

    private final BucketRepository repository;

    public CreateBucketCommandHandler(BucketRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateBucketCommand command) {

        Bucket bucket = new Bucket()
                .setUuid(command.getId())
                .setPosition(command.getPosition())
                .setName(command.getName());

        repository.create(bucket);

    }
}
