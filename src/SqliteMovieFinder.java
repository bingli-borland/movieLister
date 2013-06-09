
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

    public static final String DB_FILE = "movies.db";

    @Override
    public List<Movie> findAll() {
        List<Movie> list = new ArrayList<Movie>(0);
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:movies.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("select * from movies;"); //查询数据

            while (rs.next()) { //将查询到的数据打印出来
                Movie movie = new Movie(rs.getString(1),rs.getString(2));
                list.add(movie);
            }
            rs.close();
            conn.close(); //结束数据库的连接

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
