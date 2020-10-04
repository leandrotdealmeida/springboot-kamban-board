package com.japa.kanboard.write.domain.core;

import java.util.Optional;
import java.util.UUID;


public interface BucketRepository {

    void create(Bucket bucket);

    Optional<Bucket> findByUuid(UUID id);
}
