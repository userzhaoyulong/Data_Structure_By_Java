package com.yulong.simpleFactory;

public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("创建柱状图。");
    }

    @Override
    public void display() {
        System.out.println("展示柱状图。");
    }
}
