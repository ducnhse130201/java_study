package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentJDBCTemplate {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
    }

    public void create(String name, Integer age){
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "INSERT INTO student (name, age) VALUES (?, ?)";
        jdbcTemplateObject.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
    }

    public Student getStudent(Integer id){
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);

        Student student = new Student();
        student.setId(id);
        student.setName((String) out.get("out_name"));
        student.setAge((Integer) out.get("out_age"));

        return student;
    }

    public List<Student> listStudents(){
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "SELECT * FROM Student";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }




}
