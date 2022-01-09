/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtypes;

/**
 *
 * @author aliro
 */
public class SearchTypes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jumpSearch(new int[]{1,2,6,8,9,11,100}, 6);
    }
    
    public static void linearSearch(int array[],int value){
        int count = 0;
        if(array.length==0){
            System.out.println("the array is empty");
            return;
        }
        for (int index = 0; index < array.length; index++) {
            if(array[index]==value){
                System.out.println("value found\nindex: "+ count++);
                System.out.println("steps: "+ count);
                return;
            }
            count++;
        }
        System.out.println("couldn't find value\nsteps: "+ count);
    }
    
    public static void binarySearch(int array[],int value){
        int count = 0;
        int left=0,right=array.length;
        int recent;
        if(array.length==0){
            System.out.println("the array is empty");
            return;
        }
        while(left<right){//once they are equal or less there is no more element
            count++;
            recent = (int)((left+right)/2);
            if(array[recent]==value){
                System.out.println("value found\nindex: "+ recent);
                System.out.println("steps: "+count);
                return;
            }
            else if(array[recent]<value){
                left = recent;
                continue;
            }
            right = recent;
        }
        System.out.println("couldn't find value\nsteps: "+ count);
    }
    
    public static void jumpSearch(int array[],int value){
        int count = 0;
        int step = (int)(Math.sqrt(array.length));
        int previous = 0;
        int recent=step;
        if(array.length==0){
            System.out.println("the array is empty");
            return;
        }
        while(recent < array.length){
            count++;
            if(array[recent]==value){
                System.out.println("value found\nindex: "+ recent);
                System.out.println("steps: "+ count);
                return;
            }
            else if(array[recent]>value){//if value is less than recent, it's possible to be somewhere between recent and previous
                for (int index = previous; index < recent; index++) {
                    count++;
                    if(array[index]==value){
                        System.out.println("value found\nindex: "+ index);
                        System.out.println("steps: "+ --count);
                        return;
                    }
                }
                break;
            }
            previous = recent;
            if(recent+step>array.length||recent < array.length-1){
                recent=array.length-1;
                continue;
            }
            recent+=step;
        }
        System.out.println("couldn't find value\nsteps: "+ count);
    }
    
}
