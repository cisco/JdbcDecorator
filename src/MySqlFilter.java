import com.cisco.dvbu.ps.jdbcdecorator.SqlFilter;
import java.sql.SQLException;

public class MySqlFilter extends SqlFilter {
    public String filterExecute(String sqlTxt)
        throws SQLException
    {
        System.out.println(sqlTxt);
        return "SELECT DISTINCT User FROM user";
    }
}
