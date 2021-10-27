package org.iesfm.instituto.jdbc.dao;

import org.iesfm.instituto.jdbc.classes.Title;
import org.iesfm.instituto.jdbc.classes.TitleGroup;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleGroupDAO {

    private final static String SELECT_TITLES = "SELECT * FROM titleGroup";

    private final static String INSERT_TITLE = "INSERT INTO titleGroup(" +
            "   group_id," +
            "   course," +
            "   letter," +
            "   title" +
            "   group_year" +
            ") " +
            "VALUES(" +
            "   :id," +
            "   :course," +
            "   :letter," +
            "   :title," +
            "   :year" +
            ")";

    private NamedParameterJdbcTemplate jdbc;

    public TitleGroupDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(TitleGroup titleGroup) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", titleGroup.getId());
        params.put("course", titleGroup.getCourse());
        params.put("letter", titleGroup.getLetter());
        params.put("title", titleGroup.getTitle());
        params.put("year", titleGroup.getYear());
        jdbc.update(INSERT_TITLE, params);
    }

    public List<TitleGroup> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_TITLES,
                params,
                (rs, rownum) ->
                        new TitleGroup(
                                rs.getInt("group_id"),
                                rs.getString("course"),
                                rs.getString("letter"),
                                rs.getString("title"),
                                rs.getInt("group_year")
                        )
        );
    }
}
