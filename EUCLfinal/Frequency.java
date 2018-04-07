
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class Frequency{
    Frequency(){
        
    }
    Map<String,Integer> frequen(Map<String,Integer> samp,File f){
        int count=0;
        
        //System.out.println(f.getName());
        
        try
        {
        for(Map.Entry<String,Integer> entry:samp.entrySet())
        {
            samp.put(entry.getKey(),0);
            //System.out.println(entry.getKey()+"  "+entry.getValue());
            
            BufferedReader br=new BufferedReader(new FileReader(f));
            
            
    String strLine;
    while ((strLine = br.readLine())!= null)
    {
        String m[]=strLine.split(" ");
        int i;
        
        for(i=0;i<m.length;i++)
        {
            if(m[i].equals(entry.getKey())){
                count=count+1;
                //System.out.println(count);
            }
        }
            }
    
    //System.out.println(count);
    samp.put(entry.getKey(),count);
    count=0;
        }
        }
        catch(Exception e)
        {
            
        }
        for(Map.Entry<String,Integer> entry1:samp.entrySet())
                        {
                           // System.out.println(entry1.getKey()+"fre"+entry1.getValue());
                        }
        return samp;
        
    }
}