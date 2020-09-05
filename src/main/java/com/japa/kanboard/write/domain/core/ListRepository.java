package com.japa.kanboard.write.domain.core;

import java.util.Optional;
import java.util.UUID;

public interface ListRepository {

    void create(UUID id, int position, String name);

    boolean hasList(UUID id);
}
