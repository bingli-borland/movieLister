
import java.util.List;

/**
 *
 * @author subaochen
 */
public class Client {
    public static void main(String[] args){
        Container container = configureContainer();
        MovieLister lister = (MovieLister)container.getComponent(MovieLister.class);
        List<Movie> movies = lister.moviesDirectedBy("zhang yi mou");
        
        for(Movie movie:movies)
            System.out.println(movie.getTitle());
    }
    
    public static Container configureContainer(){
        Container container = new MyContainer();
        container.registerComponent(MovieFinder.class, SqliteMovieFinder.class, null);
        container.registerComponent(MovieLister.class);
        return container;
    }
}
