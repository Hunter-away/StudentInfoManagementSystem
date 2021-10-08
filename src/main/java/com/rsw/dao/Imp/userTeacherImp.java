package com.rsw.dao.Imp;

import com.rsw.dao.userTeacher;
import com.rsw.entity.UserCourse;
import com.rsw.entity.UserTeacher;
import com.rsw.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class userTeacherImp implements userTeacher {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public int insert(String id, String teacher, String Cname) {
        String sql = "insert into userteacher values(?,?,?,null,null)";

        return template.update(sql,id,teacher,Cname);
    }

    /**
     * 查询学生的老师通过学生的id
     * @param id
     * @return
     */
    public List<UserTeacher> queryTeacherById(String id) {
        String sql = "select DISTINCT Teacher from userteacher where Uid = ? ";

        return template.query(sql,new BeanPropertyRowMapper<UserTeacher>(UserTeacher.class),id);
    }


    /**
     * 判断数据库中是否已经存在老师
     * @param teacher
     * @param id
     * @return
     */
    public UserTeacher queryTeacherByNameAndId(String teacher, String id) {
        String sql = "select * from userteacher where Uid = ? and Teacher = ? ";

        return template.queryForObject(sql,new BeanPropertyRowMapper<UserTeacher>(UserTeacher.class),id,teacher);
    }

    public int queryFinish(String teacher) {
        String sql = "select count(*)  FROM userteacher WHERE Score is not null and Teacher = ? ";

        return template.queryForObject(sql,Integer.class,teacher);
    }

    public List<UserCourse> queryCourseById(String id) {
        String sql = "select DISTINCT CName from userteacher where Uid = ? ";

        return template.query(sql,new BeanPropertyRowMapper<UserCourse>(UserCourse.class),id);
    }

    public List<UserTeacher> queryStudentByTeacher(String teacher) {
        String sql = "SELECT * from userteacher WHERE Teacher = ? ";

        return template.query(sql,new BeanPropertyRowMapper<UserTeacher>(UserTeacher.class),teacher);
    }

    public int queryTotal(String teacher) {
        String sql = "select count(*) FROM userteacher where Teacher = ? ";

        return template.queryForObject(sql, Integer.class,teacher);
    }

    public static void main(String[] args) {
        List<UserTeacher> userTeachers = new userTeacherImp().queryStudentByTeacher("Alisa");
        for (UserTeacher userTeacher : userTeachers) {
            System.out.println(userTeacher);
        }
    }

}
