
import java.util.List;

/**
 *
 * @author subaochen
 */
public class Client {
    public static void main(String[] args){
        List<Movie> movies = new MovieLister("movies.txt").moviesDirectedBy("zhang yi mou");
        
        for(Movie movie:movies)
            System.out.println(movie.getTitle());
    }
}
