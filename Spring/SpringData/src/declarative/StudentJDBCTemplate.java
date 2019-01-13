package declarative;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, Integer age, Integer marks,
                       Integer year){
        try{
            String SQL1 = "INSERT INTO Student(name, age) VALUES (?, ?)";
            jdbcTemplateObject.update(SQL1, name, age);

            String SQL2 = "SELECT max(id) FROM Student";
            int sid = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

            String SQL3 = "INSERT INTO Marks(sid, marks, year) VALUES (?, ?, ?)";
            jdbcTemplateObject.update(SQL3, sid, marks, year);
            System.out.println("Created Name = " + name +
                    ", Age = " + age);

            throw  new RuntimeException("simulate Error condition");
        }catch (DataAccessException e){
            System.out.println("Error in creating record, rolling back");
            throw e;
        }
    }

    public List<StudentMarks> listStudents(){
        String SQL = "SELECT * FROM Student, Marks where Student.id = Marks.sid";
        List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
                new StudentMarksMapper());
        return studentMarks;
    }


}
