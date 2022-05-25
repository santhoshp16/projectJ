
import java.security.KeyStore.Entry;
import java.util.*;  
public class MapExample1 {  
public static void main(String[] args) {  
    Map<Integer,String> map=new HashMap<>();  
    //Adding elements to map  
    map.put(1,"Amit");  
    map.put(5,"Rahul");  
    map.put(2,"Jai");  
    map.put(6,"Amit");  
    //Traversing Map  
    Set<Map.Entry<Integer,String>> set=map.entrySet();//Converting to Set so that we can traverse  
    Iterator<Map.Entry<Integer,String>> itr=set.iterator();  
    while(itr.hasNext()){  
        //Converting to Map.Entry so that we can get key and value separately  
        
        Map.Entry entry=itr.next();  
        System.out.println(entry.getKey()+" "+entry.getValue());  
    //System.out.println(itr.next());
    }  
}  
}  