package com.japa.kanboard.write.domain.core;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListAgregateTest {

    @Test
    void dummy() {
        // given
        UUID id = UUID.randomUUID();
        int position = 1;
        String name = "TODO";
        ListRepository repository = mock(ListRepository.class);

        // when
        ListAgregate listAgregate = new ListAgregate(repository);
        listAgregate.create(id, position, name);

        // then
        verify(repository).create(id, position, name);
        /*Optional<ListAgregate> listEntity = repository.findById(id);
        assertThat(listEntity.getId()).isEqualTo(id);
        assertThat(listEntity.getPosition()).isEqualTo(position);
        assertThat(listEntity.getName()).isEqualTo(name);*/

    }

}