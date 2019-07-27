package com.yulong.simpleFactory;

public class ChartClient {
    public static void main(String[] args) {
        Chart histogram = ChartFactory.getChart("Histogram");
        histogram.display();
        Chart pie = ChartFactory.getChart("Pie");
        pie.display();
        Chart line = ChartFactory.getChart("Line");
        line.display();
    }
}
