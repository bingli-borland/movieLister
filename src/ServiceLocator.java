/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author subaochen
 */
public class ServiceLocator {
    private static ServiceLocator soleInstance;
    private MovieFinder movieFinder;

    public static MovieFinder movieFinder(){
        return soleInstance.movieFinder;
    }
    
    public static void load(ServiceLocator arg){
        soleInstance = arg;
    }
    
    public ServiceLocator(MovieFinder movieFinder){
        this.movieFinder = movieFinder;
    }
    
}
