
import java.util.List;

/**
 *
 * @author subaochen
 */
public class Client {
    public static void main(String[] args){
        configure();
        MovieLister lister = new MovieLister();        
        List<Movie> movies = lister.moviesDirectedBy("zhang yi mou");
        
        for(Movie movie:movies)
            System.out.println(movie.getTitle());
    }
    
    private static void configure() {
        ServiceLocator.load(new ServiceLocator(new ColonDelimitedMovieFinder("movies.txt")));
    }
}
