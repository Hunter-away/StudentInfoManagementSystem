package com.rsw.dao.Imp;

import com.rsw.dao.CourseDao;
import com.rsw.entity.Course;
import com.rsw.entity.CourseInfo;
import com.rsw.entity.PageBean;
import com.rsw.entity.UserCourse;
import com.rsw.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CourseImp implements CourseDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public List<Course> findAllCourse(String teacher) {
        String sql;

        if ("1".equals(teacher)){
            sql = "select * from course";
            return template.query(sql,new BeanPropertyRowMapper<Course>(Course.class));
        }
        else {
            teacher = "%"+teacher+"%";
            sql = "select * from course where Teacher like ? ";
            return template.query(sql,new BeanPropertyRowMapper<Course>(Course.class),teacher);
        }


    }

    public int findTotal() {
        String sql = "select count(*) from course";
        return template.queryForObject(sql,Integer.class);
    }

    public List<Course> getUserCourse(String id) {
        String sql = "select Name,LessonPeriod  from course,userteacher WHERE  course.`Name`=userteacher.CName AND Uid = ? ";

        return template.query(sql,new BeanPropertyRowMapper<Course>(Course.class),id);
    }

    /**
     * delete courses through course name
     * @param course
     * @return
     */

    public int DelCourseInfo(String course) {
        String sql = "delete from userteacher where CName = ? ";

        return template.update(sql,course);
    }


    public static void main(String[] args) {

    }


}
