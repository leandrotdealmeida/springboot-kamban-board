package com.japa.kanboard.write.domain.application;

import com.japa.kanboard.write.adapter.out.BucketRepositoryImpl;
import com.japa.kanboard.write.domain.core.Bucket;
import com.japa.kanboard.write.domain.core.BucketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateBucketCommandHandlerTest {

    @Test
    void givenValidCommandMustDelegateToListAggregate() {

        ArgumentCaptor<Bucket> captor = ArgumentCaptor.forClass(Bucket.class);

        // 1 - given : fixture
        UUID id = UUID.randomUUID();
        int position = 1;
        String name = "TODO";
        CreateBucketCommand command = new CreateBucketCommand(id, position, name);
        BucketRepository repository = mock(BucketRepositoryImpl.class);

        // 2 - when : exercise (execution)
        CreateBucketCommandHandler handler = new CreateBucketCommandHandler(repository);
        handler.handle(command);

        // then
        verify(repository).create(captor.capture());
        Bucket bucket = captor.getValue();
        assertThat(bucket.getUuid()).isEqualTo(id);
        assertThat(bucket.getPosition()).isEqualTo(position);
        assertThat(bucket.getName()).isEqualTo(name);

    }
}
