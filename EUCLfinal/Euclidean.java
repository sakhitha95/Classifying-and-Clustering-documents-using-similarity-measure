
import java.util.Map;

class Euclidean{
    float sum1;
    Euclidean(){
        
    }
    float euclid(Map<String,Integer> dc1,Map<String,Integer> dc2){
       float sum=0;
      
        try{
      
        for(Map.Entry<String,Integer> entry:dc1.entrySet())
     {
        
        float f1=dc1.get(entry.getKey());
         float f2=dc2.get(entry.getKey());
         sum=(f1-f2)*(f1-f2)+sum;
     }
        sum1=(float)Math.sqrt(sum);
        //System.out.println(sum1);
        
    }catch(Exception e){
        System.out.println(e);
    }
        return sum1;
    }
}