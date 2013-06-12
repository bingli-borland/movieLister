
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subaochen
 */
public class SqliteMovieFinder implements MovieFinder {

    @Override
    public List<Movie> findAll() {
        List<Movie> list = new ArrayList<Movie>(0);
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:movies.db");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from movies;"); 

            while (rs.next()) {
                Movie movie = new Movie(rs.getString(1),rs.getString(2));
                list.add(movie);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
