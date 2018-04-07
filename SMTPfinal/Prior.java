import java.io.*;
public class Prior {
    int smooth=1;
    float condtp[];
    float condtn[];
    float priort[];
    float priortn[];
    public Prior()
    {
        
    }
    public void calculatecond(String[] docs,int numlab,int numdoc)
    {
        int condtemp=0;
        int cond1=0;
        float condp[]=new float[numlab];
        float condn[]=new float[numlab];
     
        try
        {
            File storage=new File("train");
            File list1[] = storage.listFiles();
            //int totaldoc=7;
        float[] prior = new float[numlab];
        int[][] labels=new int[numdoc][numlab];
        
        //float[] priorN = new float[labels.length];
        File lab=new File("labels.txt");
        BufferedReader br=new BufferedReader(new FileReader(lab));
        int tem=-1;
        String temp=null;
        String cat;
            while((cat=br.readLine())!=null)
            {
                String lstr[]=cat.split(" ");
                
                for(int k=0;k<lstr.length;k++){
                    //System.out.println("dasdfads");
                    if(k==0){
                        
                    for(int i=0;i<docs.length;i++){
                        String l1=lstr[k];
                        String l2=docs[i];
                        //System.out.println(lstr[k]);
                        //System.out.println(l2);
                        if(l1.equals(l2)){
                            //System.out.println("dasdfads");
                            temp=lstr[k];
                            //System.out.println(temp);
                            tem++;
                        }
                        
                    }
                    }
                    else if(lstr[0].equals(temp))
                    {
                    labels[tem][k-1]=Integer.parseInt(lstr[k]);
                    //System.out.println(lstr[k]+"DFSG");
                    }
                    
                }
            }
           /* for(int i=0;i<numdoc;i++){
                for(int j=0;j<numlab;j++)
            System.out.println(labels[i][j]);}*/
            
            for(int i=0;i<numlab;i++)
            {
            
            for(int j=0;j<numdoc;j++)
            {

                if(labels[j][i]==1)
                {

                    condtemp=condtemp+1;
                }
                else{
                    cond1=cond1+1;
                }
            }
            
            
            
            }
            /*System.out.println("no of documents with label i"+condtemp);
            System.out.println("no of documents with out label i"+cond1);*/
            
            
            
            
            
        int temp_ci=0;
        int tempn_ci=0;
        for(int i=0;i<numlab;i++)
        {
            //int temp_ci=0;
            for(int j=0;j<numdoc;j++)
            {

                if(labels[j][i]==1)
                {

                    temp_ci=temp_ci+1;
                }
                else{
                    tempn_ci=tempn_ci+1;
                }
            }
            //System.out.println(temp_ci);
            //System.out.println(list1.length);
        //prior[i]=(float) (smooth + temp_ci) / (smooth *2+list1.length);
        condp[i]=(float)(smooth+temp_ci)/(smooth*(numdoc+1)+condtemp);
        condn[i]=(float)(smooth+tempn_ci)/(smooth*(numdoc+1)+cond1);
        temp_ci=0;
        tempn_ci=0;
        //priorN[i]=1-prior[i];
/*System.out.println("prior value"+condp[i]);
System.out.println("condn"+condn[i]);*/
//System.out.println("priorN value"+priorN[i]);
        }
        condtp=condp;
        condtn=condn;
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    void calculateprior(int totaldoc,int numlab,String[] docs){
        float priorp[]=new float[numlab];
        float priorn[]=new float[numlab];
        
        try{
             
        float[] prior = new float[numlab];
        int[][] labels=new int[totaldoc][numlab];
        
        //float[] priorN = new float[labels.length];
        File lab=new File("labels.txt");
        BufferedReader br=new BufferedReader(new FileReader(lab));
        
       
        String cat;
        int count=0;
        String temp=null;
        
            while((cat=br.readLine())!=null)
            {
                String lstr[]=cat.split(" ");
                for(int i=0;i<lstr.length;i++){
                    if(i==0){
                        
                    }
                    else{
                        labels[count][i-1]=Integer.parseInt(lstr[i]);
                    }
                }
                count++;
            }
                
            //System.out.println(i);
            for(int j=0;j<totaldoc;j++){
                for(int k=0;k<numlab;k++){
                //System.out.println(labels[j][k]);
                }
            }
            int temp1=0;
            int temp2=0;
            for(int l=0;l<numlab;l++){
                for(int n=0;n<totaldoc;n++){
                    if(labels[n][l]==1)
                    {
                        temp1=temp1+1;
                    }
                   
                }
                priorp[l]=(float)(smooth+temp1)/(smooth*2+totaldoc);
                priorn[l]=1-priorp[l];
                temp2=0;
                temp1=0;
            }
            
               /* for(int j=0;j<numlab;j++){
                    
                    System.out.println(priorp[j]);
                    System.out.println(priorn[j]);
                }*/
            priort=priorp;
            priortn=priorn;
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        //return float(0);
    }
    
    
    public static void main(String[] args)
    {
       
    }
    
    
}
