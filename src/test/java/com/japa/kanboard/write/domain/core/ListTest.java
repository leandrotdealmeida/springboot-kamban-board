package com.japa.kanboard.write.domain.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test
    void givenValidataMustRetrieveSameData() {

        // given
        var id = 1;
        UUID uuid = UUID.randomUUID();
        int position = 1;
        String name = "TODO";

        // when
        Bucket bucket = new Bucket()
                .setId(id)
                .setUuid(uuid)
                .setPosition(position)
                .setName(name);

        // then
        assertThat(bucket.getId()).isEqualTo(id);
        assertThat(bucket.getUuid()).isEqualTo(uuid);
        assertThat(bucket.getPosition()).isEqualTo(position);
        assertThat(bucket.getName()).isEqualTo(name);
    }
}
