package transaction;

import jdbc2.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private PlatformTransactionManager transactionManager;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        TransactionDefinition def = new DefaultTransactionAttribute();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String SQL1 = "INSERT INTO Student (name, age) values (?, ?)";
            jdbcTemplateObject.update(SQL1, name, age);

            String SQL2 = "SELECT max(id) FROM Student";
            int sid = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

            String SQL3 = "INSERT INTO Marks(sid, marks, year) VALUES (?, ?, ?)";
            jdbcTemplateObject.update(SQL3, sid, marks, year);

            System.out.println("Created Name = " + name + ", Age = " + age);
            transactionManager.commit(status);


        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
        }

    }


    public List<StudentMarks> listStudents(){
        String SQL = "SELECT * FROM Student, Marks WHERE Student.id = Marks.sid";
        List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
                new StudentMarksMapper());
        return  studentMarks;
    }


}
