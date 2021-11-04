package org.iesfm.restexample.dao.jdbc;

import org.iesfm.restexample.Department;
import org.iesfm.restexample.dao.DepartmentDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDepartmentDAO implements DepartmentDAO {

    private final static String SELECT_DEPARTMENTS = "SELECT * FROM Department";

    private final static String INSERT_DEPARTMENT = "INSERT INTO Department(" +
            "   name," +
            "   description" +
            ") " +
            "VALUES(" +
            "   :name," +
            "   :description" +
            ")";

    private final static String GET_DEPARTMENT = "SELECT * FROM Department WHERE name = :name";

    private final static String DELETE_DEPARTMENT = "DELETE FROM Department WHERE name = :name";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCDepartmentDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Department> list() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_DEPARTMENTS,
                params,
                (rs, rownum) ->
                        new Department(
                                rs.getString("name"),
                                rs.getString("description")
                        )
        );
    }

    @Override
    public Department get(String departmentName) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", departmentName);
        return jdbc.queryForObject(
                GET_DEPARTMENT,
                params,
                (rs, rowNum) ->
                        new Department(
                                rs.getString("name"),
                                rs.getString("description")
                        )
        );
    }

    @Override
    public void insert(Department department) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", department.getName());
        params.put("description", department.getDescription());
        jdbc.update(INSERT_DEPARTMENT, params);
    }

    @Override
    public void delete(String departmentName) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", departmentName);
        jdbc.update(DELETE_DEPARTMENT, params);
    }
}
