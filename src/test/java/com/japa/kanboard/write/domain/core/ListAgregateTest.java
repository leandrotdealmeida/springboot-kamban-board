package com.japa.kanboard.write.domain.core;

import com.japa.kanboard.write.adapter.out.ListRepositoryImpl;
import helper.DataSourceHelper;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListAgregateTest extends DataSourceHelper {

    @Test
    void dummy() {
        // given
        UUID id = UUID.randomUUID();
        int position = 1;
        String name = "TODO";
       // ListRepository repository = mock(ListRepository.class);
        ListRepository repository = new ListRepositoryImpl(dataSource);

        // when
        ListAgregate listAgregate = new ListAgregate(repository);
        listAgregate.create(id, position, name);

        // then
        assertThat(repository.hasList(id)).isTrue();


    }

}