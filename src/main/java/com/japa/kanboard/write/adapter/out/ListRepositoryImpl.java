package com.japa.kanboard.write.adapter.out;

import com.japa.kanboard.write.domain.core.ListAgregate;
import com.japa.kanboard.write.domain.core.ListRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.UUID;

public class ListRepositoryImpl implements ListRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public ListRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(UUID id, int position, String name) {

        String sql = "INSERT INTO list(uuid, position, name) values (:uuid, :position, :name)" ;

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", id)
                .addValue("position", position)
                .addValue("name", name);

        jdbcTemplate.update(sql, parameters);

    }

    public boolean hasList(UUID id) {

        String sql = "SELECT count(*) FROM list WHERE uuid = :uuid";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", id);

        return jdbcTemplate.queryForObject(sql, parameters, Boolean.class);
    }
}
