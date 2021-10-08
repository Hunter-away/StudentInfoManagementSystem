package com.rsw.dao.Imp;

import com.rsw.dao.TeacherDao;
import com.rsw.entity.Teacher;
import com.rsw.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherImp implements TeacherDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Teacher> findAllTeacher() {
        String sql = "select * from teacher ";

        return null;
    }

    public Teacher login(Teacher loginTeacher) {
        String sql = " select * from teacher where Tno = ? and Password = ? ";

        return template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class),loginTeacher.getTno(),loginTeacher.getPassword());
    }
}
