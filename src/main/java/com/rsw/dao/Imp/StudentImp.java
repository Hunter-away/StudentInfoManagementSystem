package com.rsw.dao.Imp;

import com.rsw.dao.StudentDao;
import com.rsw.entity.Course;
import com.rsw.entity.Student;
import com.rsw.utils.JDBCUtils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentImp implements StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录
     * @param student
     * @return
     */
    public Student login(Student student) {
        try {
            String sql = "select * from student where sno = ? and password = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),student.getSno(),student.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> findAllStudent(String student, String teacher) {
        String sql;

        if ("1".equals(student)){
            sql = "select student.*,userteacher.Score from student,userteacher WHERE student.Sno = userteacher.Uid AND userteacher.Teacher = ? ";
            return template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),teacher);
        }
        else {
            student = "%"+student+"%";
            sql = "select student.*,userteacher.Score from student,userteacher WHERE student.Sno = userteacher.Uid AND userteacher.Teacher = ? and Sname like ?";
            return template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),teacher,student);
        }
    }

    public int insertScore(String id, String score, String teacher) {
        String sql = "update userteacher set Score = ? where Teacher = ? and Uid = ? ";

        return template.update(sql,score,teacher,id);
    }

    /**
     * Query Student By id
     * @param uid
     * @return
     */

}
