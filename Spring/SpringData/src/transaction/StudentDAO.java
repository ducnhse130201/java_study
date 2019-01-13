package transaction;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    public void setDataSource(DataSource ds);

    public void create(String name, Integer age, Integer marks, Integer years);

    public List<StudentMarks> listStudents();

}
