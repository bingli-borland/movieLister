import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class MyContainer implements Container {
	private Map<Class, Object> compMap = new HashMap<Class,Object>(0);

	@Override
	public void registerComponent(Class clazz) {
       if(compMap.get(clazz) != null) return;
       Constructor[] constructors = clazz.getConstructors();
       try {
		compMap.put(clazz, constructors[0].newInstance(null));
	} catch (InstantiationException | IllegalAccessException
			| IllegalArgumentException | InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       

	}

	@Override
	public Object getComponent(Class clazz) {
		// TODO Auto-generated method stub
		return compMap.get(clazz);
	}

}
