package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-05 13:56
 */
public class proxy {

    public static void main(String[] args) {
        //手机要打电话
        Phone phone = new IPhone();
        phone.call();
        System.out.println("------------------------------");
        //如果要听歌
        Music music = new Music(phone);
        music.call();


    }
}

class IPhone implements Phone {

    @Override
    public void call() {
        System.out.println("手机可以打电话");
    }

}

interface Phone {

    //打电话
    void call();
}

class Music implements Phone {

    private Phone i;
    public Music(Phone p){
        this.i=p;
    }

    @Override
    public void call() {
        i.call();
        System.out.println("手机可以听歌");

    }

}
