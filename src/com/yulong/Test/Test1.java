package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-15 22:33
 */
public class Test1 {
    public static void main(String[] args) {
        //4,2,6,7,1,5,8,9,12
        int[] array = {1,2,3,4,5,6,7};
        /*ArrayList<Integer> preArray = new ArrayList<>();
        ArrayList<Integer> postArray = new ArrayList<>();*/
        int[] tempArray = array.clone();
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 !=0)
                temp++;
        }
        //System.out.println(temp);
        int a = 0, b = temp;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] % 2 == 1){
                System.out.println(a);
                array[a++] = tempArray[i];
            }else {
                System.out.println(b);
                array[b++] = tempArray[i];
            }
        }
        /*for (int num : tempArray) {
            if (num % 2 == 1){
                System.out.println(a);
                array[a++] = num;
            }else {
                System.out.println(b);
                array[b++] = num;
            }
        }*/

        /*for (int i : tempArray) {
            System.out.print(i);
        }*/
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            if (i != array.length - 1){
                System.out.print(array[i] + ",");
            }else {
                System.out.print(array[i] + "]");
            }
        }

        /*double base = 2;
        int exponent = -3;
        double sum = 1.0;
        if(exponent < 0){
            for(int i = 0; i < exponent; i++){
                sum = base * sum;
                System.out.print(sum);
            }
//            return 1/sum;
            System.out.println(1/sum);
        }else{
            for(int i = 0; i < exponent; i++){
                sum = base * sum;
            }
//            return sum;
            System.out.println(sum);
        }*/
    }
}
