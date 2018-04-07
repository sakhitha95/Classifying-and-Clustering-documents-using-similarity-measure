
import java.util.HashMap;
import java.util.Map;

public class Similarity{
    Similarity(){
        
    }
    float findsimilarity(Map<String,Integer> dc1,Map<String,Integer> dc2,Map<String,Float> std,String nam){
        float exm;
        float siml;
     float exl,nl,n2,ndstar=0,ndunion=0,sfun,smtp;
     int lambda=1;
    //Frequency ob3=new Frequency();
        // ob3.getfeatures();
     //Map<String, Integer> map = ob3.pasfeature(); 
     for(Map.Entry<String,Integer> entry:dc1.entrySet())
     {
         float f1=dc1.get(entry.getKey());
         //System.out.println(f1);
         float stdd=std.get(entry.getKey());
         float f2=dc2.get(entry.getKey());
         //System.out.println(f2);
         if((f1*f2)!=0)
         {
             exm=(((f1-f2)/stdd)*((f1-f2)/stdd));
                    exl=(float) Math.exp(-exm);

                    nl=           (float) (0.5 * (1 + exl));
         }
         else if(f1==0&&f2==0)
                {
                    nl=0;
                }
         else
                {
                    nl=-lambda;
                }
         ndstar=ndstar+nl;
         if(f1==0&&f2==0)
                {
                    n2=0;
                }
                else{
                    n2=1;
                }
                         ndunion=ndunion+n2;

     }
     sfun=ndstar/ndunion;
                smtp=(sfun+lambda)/(1+lambda);
                
                //System.out.println(smtp);
                //siml.put(nam, smtp);
                return smtp;
     
        
        
        
        
        
        

    }
}