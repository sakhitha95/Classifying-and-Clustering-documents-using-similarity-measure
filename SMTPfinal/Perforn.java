
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Perforn{
    int TP,TN,FP,FN;
    void Perforn(){
        
    }
    void calulateperf(int[]labe,String docnam){
        int tp=0;
        int tn=0;
        int fp=0;
        int fn=0;
        try{
        File lab=new File("labels1.txt");
        BufferedReader br=new BufferedReader(new FileReader(lab));
        int tem=-1;
        String temp=null;
        String cat;
        int[] labels=new int[4];
            while((cat=br.readLine())!=null)
            {
                String lstr[]=cat.split(" ");
                
                for(int k=0;k<lstr.length;k++){
                    //System.out.println("perform");
                    if(k==0){
                        
                    
                        
                        if(lstr[k].equals(docnam)){
                            //System.out.println("dasdfads");
                            temp=lstr[k];
                            //System.out.println(temp);
                            tem++;
                        }
                        
                    
                    }
                    else if(lstr[0].equals(temp))
                    {
                    labels[k-1]=Integer.parseInt(lstr[k]);
                    //System.out.println(lstr[k]+"DFSG");
                    }
                    
                }
            }
            for(int i=0;i<labe.length;i++){
                if(labe[i]==labels[i]){
                    if(labe[i]==1){
                    tp=tp+1;}
                    else{
                        tn=tn+1;
                    }
                }
                else{
                    if(labe[i]==1){
                        fp=fp+1;
                    }
                    else if(labels[i]==1){
                    fn=fn+1;
                }
                }
            }
            TP=tp;
            TN=tn;
            FP=fp;
            FN=fn;
            Perforn p=new Perforn();
            //p.calF1();
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
    void calF1(){
        float microp;
        microp=(float)TP/(TP+FP);
        //System.out.println("microp is"+microp);
        float micror;
        micror=(float)TP/(TP+FN);
        float F1=(float)(2*microp*micror)/(microp+micror);
        System.out.println("f1 value"+F1);
    }
}