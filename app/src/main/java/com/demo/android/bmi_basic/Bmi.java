package com.demo.android.bmi_basic;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bmi extends AppCompatActivity {
    private Button calc_button;
    private EditText field_height;
    private EditText field_weight;
    private TextView view_result;
    private TextView view_suggest;
    private Publicfunc func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        setListenners();
        func =new Publicfunc();


    }

    private void findViews(){
        calc_button =(Button) findViewById(R.id.submit);
        field_height= (EditText)findViewById(R.id.height);
        field_weight= (EditText)findViewById(R.id.weight);
        view_result = (TextView)findViewById(R.id.result);
        view_suggest = (TextView)findViewById(R.id.suggest);

    }
    private void setListenners()
    {
        calc_button.setOnClickListener(listener);
    }

    private View.OnClickListener listener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //try {
                double BMI=calcBMI();
                showResult(BMI);
                openOptionDialog();
           // } catch (Exception e) {
          //      e.printStackTrace();
          //  }
        }
    };

    private void openOptionDialog(){
//        new AlertDialog.Builder(Bmi.this).setTitle("關於 Android BMI")
//                .setMessage("Android BMI Calc")
//                .show();
          new AlertDialog.Builder(Bmi.this).setTitle(R.string.dialog_title)
          .setMessage(R.string.dialog_button_confirm)
          .setPositiveButton(R.string.dialog_button_confirm,
                  new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                        System.out.println("你按下了");
                      }
                  })
          .setNegativeButton(R.string.dialog_button_cancel,null)
          .show();
    }

    public double calcBMI(){

        double height=Double.parseDouble(field_height.getText()+"") /100;
        double weight=Double.parseDouble(field_weight.getText()+"");
       // double BMI=weight/(height*height);
       // return BMI;

       return func.calcBMI(height,weight);

    }
    public void showResult(double BMI) {
        DecimalFormat nf = new DecimalFormat("0.00");
        view_result.setText("Your BMI is " + nf.format(BMI));
        if (BMI > 25) {
            view_suggest.setText(R.string.advice_heavy);
        } else if (BMI < 20) {
            view_suggest.setText(R.string.advice_light);
        } else {
            view_suggest.setText(R.string.advice_average);
        }
    }


}
