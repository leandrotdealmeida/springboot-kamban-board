package com.japa.kanboard.write.domain.core;

import java.util.UUID;

public class ListAgregate {

    private final ListRepository listRepository;

    public ListAgregate(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public void create(UUID id, int position, String name) {
        listRepository.create(id, position, name);
    }
}
