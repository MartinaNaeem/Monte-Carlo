/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.util.Random;

/**
 *
 * @author marti
 */
public class Function {
            static int sum_ave;

    public void fun(String arr[][]){
        float sum=(float) 0;
            for(int i=0;i<=5;i++){
                 sum += Float.parseFloat(arr[i][1]);
            }
            for (int i = 0; i <= 5; i++) {
             arr[i][2] = ((Float.parseFloat(arr[i][1]))/sum)+"";

            }
            arr[0][3] = Float.parseFloat(arr[0][2])+"";
            for(int i=0;i<=4;i++){
              float num = (Float.parseFloat(arr[i][3]+""))+
                          (Float.parseFloat(arr[i+1][2]+""));
              arr[i+1][3]=num+"";
            }
            arr[0][4] = 1 +" to "+(Float.parseFloat(arr[0][2])*100)+"";
            for (int i = 0; i <=4; i++) {
             arr[i+1][4] =(Float.parseFloat(arr[i][3])*100+1) +" to "+
                           (Float.parseFloat(arr[i+1][3])*100);
   
            }
    }
    public int func2(String arr1[][]){
        
         Random r=new Random();
               sum_ave =0;
            for (int i = 0; i < 10; i++) {
                arr1[i][0]=(i+1)+"";
                arr1[i][1]=r.nextInt(100)+"";
                sum_ave++;
            } 
            return sum_ave;  
    }
    public float[] fun3(String arr[][], String  arr1[][]){
         for (int i = 0; i < 10; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (Float.parseFloat(arr1[i][1]) < (Float.parseFloat(arr[j][3])*100)) {
                        if (Float.parseFloat(arr1[i][1]) >(Float.parseFloat(arr[j-1][3])*100)) {
                           arr1[i][2]=arr[j][0];
                        }
                    }
                }
            }
           
            float ave = 0;
            for (int i = 0; i < 10; i++) {
                ave+=Float.parseFloat(arr1[i][2]);
            } 
             float expexteddailydemaand = 0;

              for (int i = 0; i < 6; i++) {
                expexteddailydemaand+=(Float.parseFloat(arr[i][0])*Float.parseFloat(arr[i][2]));
            } 
            
              float total= ave/sum_ave;
              
              float temp[]={total,expexteddailydemaand};
              
               return temp;    
    }
    
}
