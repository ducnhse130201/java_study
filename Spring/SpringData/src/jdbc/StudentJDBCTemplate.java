package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, Integer age){
        String SQL = "INSERT INTO Student (name, age) VALUES (?, ?)";
        jdbcTemplateObject.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = "+ age);
    }

    public Student getStudent(Integer id){
        String SQL = "SELECT * FROM Student WHERE id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());
        return student;
    }

    public List<Student> listStudents(){
        String SQL = "SELECT * FROM Student";
        List<Student> students = jdbcTemplateObject.query(SQL, new
                StudentMapper());
        return students;
    }

    public void delete(Integer id){
        String SQL = "DELETE FROM Student WHERE id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Delete Record with ID = " + id);
    }

    public void update(Integer id, Integer age){
        String SQL = "UPDATE Student SET age = ? WHERE id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Update Record with ID = " + id);
    }


}
