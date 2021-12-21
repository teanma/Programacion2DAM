package org.iesfm.examen1accesodatos.dao.jdbc;


import org.iesfm.examen1accesodatos.Movement;
import org.iesfm.examen1accesodatos.dao.MovementDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCMovementDAO implements MovementDAO {

    private List<Movement> movement;

    private static final String DELETE_MOVEMENT = "DELETE FROM Movement WHERE id = :id";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCMovementDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean delete(int id) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return  jdbc.update(DELETE_MOVEMENT, params) == 1;
    }
}
