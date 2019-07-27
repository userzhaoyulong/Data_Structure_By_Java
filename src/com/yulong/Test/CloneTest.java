package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description: 克隆
 * @author: Dragon
 * @create: 2019-07-25 08:50
 */
public class CloneTest implements Cloneable{

    public static void main(String[] args) {
        CloneTest cloneTest = new CloneTest();
        try {
            Object clone = cloneTest.clone();
            CloneTest cloneTest1 = (CloneTest) clone;
            //cloneTest1.setaInt(3);
            System.out.println("克隆前：" + cloneTest.getInta() + "克隆后：" + cloneTest1.getInta());
            System.out.println(cloneTest==cloneTest1);
            System.out.println(cloneTest.getClass() == cloneTest1.getClass());
            System.out.println(cloneTest.getClass());
            System.out.println(cloneTest.clone().equals(cloneTest));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private int aInt = 0;

    public int getInta(){
        return aInt;
    }

    public void setaInt(int int1){
        this.aInt = int1;
    }
}
