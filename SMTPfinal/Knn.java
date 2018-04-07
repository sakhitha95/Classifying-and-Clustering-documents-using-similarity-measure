
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Knn{
    Map<String,Integer> feature=new HashMap<String, Integer>();
    Map<String,Float> standeviation=new HashMap<String, Float>();
    float st1,st2;
    float sum;
    public Knn(){
        File category=new File("category_list");
        File list[]=category.listFiles();
        try{
        for(int i=0;i<list.length;i++)
        {
            
                
            BufferedReader br=new BufferedReader(new FileReader(list[i]));
            //System.out.println(list[i].getName());
            String cat;
            while((cat=br.readLine())!=null)
            {
                String feat[]=cat.split(" ");
                for(int k=0;k<feat.length;k++)
                {
                   //System.out.println(feat[k]);
                feature.put(feat[k],0);
                }
            }
            }
       
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
  
    void standard_deviation()
    {
        Map<String,Integer> sin;
        sin=feature;
        
        for(Map.Entry<String,Integer> ent:sin.entrySet()){
            sin.put(ent.getKey(),0);
            feature.put(ent.getKey(),0);
        }
        try{
            int count=0;
            
        File storage=new File("train");
        File list[] = storage.listFiles();
        for(int p=0;p<list.length;p++)
     {
         File f=list[p];
           
        
       // System.out.println(f.getName());
        
        
        for(Map.Entry<String,Integer> entry:feature.entrySet())
        {
            
            //System.out.println(entry.getKey());
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
    feature.put(entry.getKey(),entry.getValue()+count);
    //System.out.println(feature.get(entry.getKey()));
    count=0;
        }
     }
        
        
        for(Map.Entry<String,Integer> entry1:sin.entrySet())
        {
           // sin.put(entry1.getKey(),0);
            for(int v=0;v<list.length;v++)
        {
            File f=list[v];
            //System.out.println(f.getName());
       /* for(Map.Entry<String,Integer> entry1:sin.entrySet())
        {
            System.out.println(entry1.getKey()+"value"+entry1.getValue());
        }*/
            
            //System.out.println(entry1.getKey());
            BufferedReader br=new BufferedReader(new FileReader(f));
            
            
    String strLine;
    while ((strLine = br.readLine())!= null)
    {
        String m[]=strLine.split(" ");
        int i;
        
        for(i=0;i<m.length;i++)
        {
            if(m[i].equals(entry1.getKey())){
                count=count+1;
                //System.out.println(count);
            }
        }
    }
    //System.out.println(count);
    //sin.put(entry.getKey(),count);
   // System.out.println(feature.get(entry1.getKey()));
    float c1=((float)feature.get(entry1.getKey()))/list.length;
    //System.out.println(c1);
    sum=((count-(feature.get(entry1.getKey())/list.length))*(count-(feature.get(entry1.getKey())/list.length)))+sum;
    //System.out.println(sum);
    count=0;
        }
        
        st1=sum/list.length;
        st2=(float) Math.sqrt(st1);
        standeviation.put(entry1.getKey(),st2);
        sum=0;
    
    }
       /*for(Map.Entry<String,Float> entry1:standeviation.entrySet())
        {
            System.out.println(entry1.getKey()+"sd"+entry1.getValue());
        }*/
        
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
        
 }
    
    
    public static void main(String[] args)
    {
        Knn obj=new Knn();
        //obj.readfeatures();
        //System.out.println(obj.feature.get("market"));
        Similarity obsim=new Similarity();
        Frequency objf=new Frequency();
        obj.standard_deviation();
        Map<Integer,String> fin=new HashMap<Integer,String>();
        fin.put(1,"Economics");
        fin.put(2,"Marketing");
        fin.put(3,"Government");
        fin.put(4,"Corporate");
        File category=new File("news_articles");
        File list[]=category.listFiles();
        try{
            Map<String,Integer> sample;
            sample=obj.feature;
            Map<String,Integer> sample1;
            sample1=obj.feature;
            Map<String,Integer> tst;
            Map<String,Integer> trn;
            Map<String,Integer> tst1=new HashMap<String,Integer>();
            Map<String,Integer> trn1=new HashMap<String,Integer>();
            for(Map.Entry<String,Integer> ent:sample.entrySet()){
            sample.put(ent.getKey(),0);
            sample1.put(ent.getKey(),0);
            }
         //System.out.println("asdfasdf"+list.length);
        for(int i=0;i<list.length;i++)
        {
            
                
            //BufferedReader br=new BufferedReader(new FileReader(list[i]));
            System.out.println(list[i].getName());
            File storage=new File("train");
            File list1[] = storage.listFiles();
            //System.out.println("asdfa"+list1.length);
            Map<Float,String> sim=new HashMap<Float,String>();
            Map<Float,String> sim2=new TreeMap<Float,String>();
            for(int p=0;p<list1.length;p++)
                {
                    
                    tst=objf.frequen(sample,list[i]);
                    for(Map.Entry<String,Integer> entry1:tst.entrySet())
                        {
                            tst1.put(entry1.getKey(),entry1.getValue());
                            //System.out.println(entry1.getKey()+"fre"+tst1.get(entry1.getKey()));
                        }
                    trn=objf.frequen(sample1,list1[p]);
                    
                    for(Map.Entry<String,Integer> entry1:trn.entrySet())
                        {
                            trn1.put(entry1.getKey(),entry1.getValue());
                            //System.out.println(entry1.getKey()+"fre"+trn1.get(entry1.getKey()));
                        }
                   /* for(Map.Entry<String,Integer> entry1:tst.entrySet())
                        {
                            System.out.println(entry1.getKey()+"fre"+entry1.getValue());
                        }*/
                    //Map<Float,String> sim=new HashMap<Float,String>();
                    float sim1;
                    
                    sim1=obsim.findsimilarity(tst1,trn1,obj.standeviation,list1[p].getName());
                    System.out.println("simialrity with"+list1[p].getName()+"is"+sim1);
                    sim.put(sim1,list1[p].getName());
                    
                    
                            
                       
                        
                        
                }
             Map<Float, String> treeMap = new TreeMap<Float, String>(sim);

                        /*for (Float str : treeMap.keySet()) {
                            
                                System.out.println(str);
                                }*/
                        for(Map.Entry<Float,String> entry1:treeMap.entrySet())
                            {
                                sim2.put(entry1.getKey(),entry1.getValue());
                //System.out.println(entry1.getKey()+"is simmilarity of"+entry1.getValue());
                             }
            InputStreamReader r=new InputStreamReader(System.in);  
            BufferedReader br=new BufferedReader(r); 
            System.out.println("enter niegbours");
            int noneig=Integer.parseInt(br.readLine());
            int siz=sim.size();
            //System.out.println(siz);
            int c=siz-noneig;
            Map<Float, String> temp = new HashMap<Float, String>();
            String []a; 
            a=new String[noneig];
            String[] tdoc=new String[list1.length];
            int ctemp=0;int ctemp2=0;
            int x=0;
            for(Map.Entry<Float,String> entry1:sim2.entrySet())
            {
                //System.out.println(entry1.getValue());
                tdoc[x]=entry1.getValue();
                if(ctemp>=c)
                {
                    temp.put(entry1.getKey(), entry1.getValue());
                    a[ctemp2]=entry1.getValue();
                    ctemp2++;
                }
                ctemp++;
                x++;
            }
            /*for(Map.Entry<Float,String> entry1:sim2.entrySet())
            {
                System.out.println(entry1.getKey()+"ada"+entry1.getValue());
            }*/
            Prior obp=new Prior();
         //=new float[numlabels];
            int numlabels=4;
            float priorp[];
            float priorn[];
            float cond[];
            float condn[];
            for(int v=0;v<a.length;v++){
                System.out.println(a[v]);
            }
            
            obp.calculatecond(a,numlabels,noneig);
            obp.calculateprior(list1.length,numlabels,tdoc);
            priorp=obp.priort;
            priorn=obp.priortn;
            cond=obp.condtp;
            condn=obp.condtn;
            float[] prob_in=new float[numlabels];
            float[] prob_out=new float[numlabels];
            float[] conf=new float[numlabels];
            for(int s=0;s<numlabels;s++){
                prob_in[s]=(float)priorp[s]*cond[s];
                prob_out[s]=(float)priorn[s]*condn[s];
                conf[s]=(float)prob_in[s]/(prob_in[s]+prob_out[s]);
                
            }
            int[]namlab=new int[numlabels];
            for(int s=0;s<numlabels;s++){
                if(conf[s]>0.5){
                    namlab[s]=1;
                    System.out.println(conf[s]+fin.get(s+1));
                
                }
                else{
                    namlab[s]=0;
                }
            }
            //System.out.println("call");
            Perforn obpp=new Perforn();
            obpp.calulateperf(namlab,list[i].getName());
            obpp.calF1();
            sim=null;
            sim2=null;
            treeMap=null;
            
            
            /*for(int z=0;z<priorp.length;z++){
                System.out.println(priorp[z]);
            }*/
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
            
    
}