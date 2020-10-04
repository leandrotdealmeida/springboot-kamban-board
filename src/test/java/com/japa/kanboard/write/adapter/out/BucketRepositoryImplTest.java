package com.japa.kanboard.write.adapter.out;

import com.japa.kanboard.write.domain.core.Bucket;
import com.japa.kanboard.write.domain.core.BucketRepository;
import helper.DataSourceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BucketRepositoryImplTest extends DataSourceHelper {

    private BucketRepository bucketRepository;

    @BeforeEach
    void setup() {
        bucketRepository = new BucketRepositoryImpl(dataSource);
    }

    @ParameterizedTest
    @MethodSource("validDataProvider")
    void given_ValidBucket_Must_PersistOnDatabase(UUID id,
                                                  int position,
                                                  String name) {

        // given
        Bucket expected = new Bucket()
                .setUuid(id)
                .setPosition(position)
                .setName(name);


        // when
        bucketRepository.create(expected);

        // then
        Optional<Bucket> actual = bucketRepository.findByUuid(id);
        assertThat(actual.get()).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("invalidDataProvider")
    void given_AlreadyExistenBucket_Must_ThrowException (UUID id,
                                                         int position,
                                                         String name) {

        // given

        Bucket expected = new Bucket()
                .setUuid(id)
                .setPosition(position)
                .setName(name);


        // then
        assertThrows(RuntimeException.class, () -> bucketRepository.create(expected));


    }

    private static Stream<Arguments> validDataProvider() {
        return Stream.of(
                Arguments.arguments(UUID.randomUUID(), 1, "TODO"),
                Arguments.arguments(UUID.randomUUID(), 2, "DOING"),
                Arguments.arguments(UUID.randomUUID(), 3, "DONE")
        );
    }

    private static Stream<Arguments> invalidDataProvider() {
        return Stream.of(
                Arguments.arguments(UUID.fromString("cb5b7ae2-6346-45f6-a1ae-0969b7abc129"), 1 , "TODO"),
                Arguments.arguments(UUID.randomUUID(), 100, "DOING"),
                Arguments.arguments(UUID.randomUUID(), 2, "EXISTENT")
        );
    }




}