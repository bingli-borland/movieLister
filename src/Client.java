
import java.util.List;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 *
 * @author subaochen
 */
public class Client {
    @Inject MovieLister movieLister;
    
    public void movieFinder(@Observes ContainerInitialized event,
                    @Parameters List<String> parameters){
        List<Movie> movies = movieLister.moviesDirectedBy("zhang yi mou");
        
        for(Movie movie:movies)
            System.out.println(movie.getTitle());        
    }    

}
