package com.japa.kanboard.write.domain.application;

import com.japa.kanboard.write.domain.core.ListAgregate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateListCommandHandlerTest {

    @Test
    void givenValidCommandMustDelegateToListAggregate() {
        // 1 - given : fixture
        UUID id = UUID.randomUUID();
        int position = 1;
        String name = "TODO";
        CreateListCommand command = new CreateListCommand(id, position, name);
        ListAgregate listAgregate = mock(ListAgregate.class);

        // 2 - when : exercise (execution)
        CreateListCommandHandler handler = new CreateListCommandHandler(listAgregate);
        handler.handle(command);

        // then
        verify(listAgregate).create(id, position, name);
    }
}
