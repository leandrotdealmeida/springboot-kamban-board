package com.japa.kanboard.write.domain.application;

import com.japa.kanboard.write.domain.core.ListAgregate;

public class CreateListCommandHandler {

    private final ListAgregate listAgregate;

    public CreateListCommandHandler(ListAgregate listAgregate) {
        this.listAgregate = listAgregate;
    }

    public void handle(CreateListCommand command) {
        listAgregate.create(command.getId(), command.getPosition(), command.getName());

    }
}
