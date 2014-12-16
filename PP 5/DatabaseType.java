/**@Author
  * Stephanie Collins
  */
import java.util.*;
public interface DatabaseType<T>{
 
  Comparator<T> getComparatorByTrait(String trait);
  
}