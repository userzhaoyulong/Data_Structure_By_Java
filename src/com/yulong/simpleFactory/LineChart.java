package com.yulong.simpleFactory;

public class LineChart implements Chart {

    public LineChart() {
        System.out.println("创建折线图。");
    }

    @Override
    public void display() {
        System.out.println("展示折线图。");
    }
}
