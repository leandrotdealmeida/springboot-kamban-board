package com.japa.kanboard.write.adapter.out;

import com.japa.kanboard.write.domain.core.Bucket;
import com.japa.kanboard.write.domain.core.BucketRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

public class BucketRepositoryImpl implements BucketRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public BucketRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(Bucket bucket) {

        String sql = "INSERT INTO list(uuid, position, name) values (:uuid, :position, :name)" ;

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", bucket.getId())
                .addValue("position", bucket.getPosition())
                .addValue("name", bucket.getName());

        jdbcTemplate.update(sql, parameters);

    }

}
