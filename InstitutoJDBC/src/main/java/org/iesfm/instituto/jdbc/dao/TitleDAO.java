package org.iesfm.instituto.jdbc.dao;

import com.mysql.cj.exceptions.AssertionFailedException;
import org.iesfm.instituto.jdbc.classes.Title;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleDAO {

    private final static String SELECT_TITLES = "SELECT * FROM title";

    private final static String SELECT_TITLE_BY_NAME = "SELECT * FROM title WHERE title_name=:name";

    private final static String SELECT_TITLE_BY_FAMILY = "SELECT * FROM title WHERE family=:family";

    private final static String INSERT_TITLE = "INSERT INTO title(" +
            "   title_name," +
            "   title_level," +
            "   family," +
            "   title_description" +
            ") " +
            "VALUES(" +
            "   :name," +
            "   :level," +
            "   :family," +
            "   :description" +
            ")";

    private static final RowMapper<Title> TITLE_ROW_MAPPER =
            (rs, rownum) ->
                    new Title(
                            rs.getInt("title_id"),
                            rs.getString("title_name"),
                            rs.getString("title_level"),
                            rs.getString("family"),
                            rs.getString("title_description")
                    );

    private NamedParameterJdbcTemplate jdbc;

    public TitleDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(Title title) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", title.getName());
        params.put("level", title.getLevel());
        params.put("family", title.getFamily());
        params.put("description", title.getDescription());
        jdbc.update(INSERT_TITLE, params);
    }

    public Title get(String name) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            return jdbc.queryForObject(
                    SELECT_TITLE_BY_NAME,
                    params,
                    TITLE_ROW_MAPPER
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Title> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_TITLES,
                params,
                TITLE_ROW_MAPPER
        );
    }

    public List<Title> list(String family) {
        Map<String, Object> params = new HashMap<>();
        params.put("family", family);
        return jdbc.query(
                SELECT_TITLE_BY_FAMILY,
                params,
                TITLE_ROW_MAPPER
        );
    }
}
