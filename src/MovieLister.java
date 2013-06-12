

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author subaochen
 */
public class MovieLister {
    @Inject @TextMovieStore MovieFinder finder;
    
    public List<Movie> moviesDirectedBy(String director){
        List<Movie> movies = new ArrayList<Movie>(0);
        List<Movie> allMovies = finder.findAll();
        for(Movie movie:allMovies)
            if(movie.getDirector().equalsIgnoreCase(director))
                movies.add(movie);
        
        return movies;
    }
}
