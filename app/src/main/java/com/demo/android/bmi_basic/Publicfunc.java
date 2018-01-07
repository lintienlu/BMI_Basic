package com.demo.android.bmi_basic;

/**
 * Created by TienLu on 2018/1/6.
 */

public class Publicfunc  {

    public double calcBMI(double height,double weight){
        double BMI=weight/(height*height);
        return BMI;
    }
}
