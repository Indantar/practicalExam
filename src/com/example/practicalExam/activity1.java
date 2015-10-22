package com.example.practicalExam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by g00284823 on 22/10/2015.
 */
public class activity1 extends Activity {

    TextView txtFieldMax;
    TextView txtFieldMin;
    TextView txtFieldSum;
    TextView txtFieldMaxT;
    TextView txtFieldMinT;
    TextView txtFieldSumT;
    Button back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity1);
            txtFieldMax = (TextView) findViewById(R.id.maxVal);
            txtFieldMaxT = (TextView) findViewById(R.id.maxValTxt);
            txtFieldMin= (TextView) findViewById(R.id.minVal);
            txtFieldMinT = (TextView) findViewById(R.id.minValTxt);
            txtFieldSum = (TextView) findViewById(R.id.sumVal);
            txtFieldSumT = (TextView) findViewById(R.id.sumValTxt);
            back = (Button) findViewById(R.id.bckBtn);

            Intent IntentHandler = getIntent();
            Bundle recievedData = IntentHandler.getExtras();

            int reqCodeR = recievedData.getInt("requestCode1");
            int num1 = recievedData.getInt("number1");
            int num2 = recievedData.getInt("number2");
            int num3 = recievedData.getInt("number3");
            int num4 = recievedData.getInt("number4");
            int num5 = recievedData.getInt("number5");
            int[] nums = {num1,num2,num3,num4,num5};
            int max = 0,min = 5000,sum = 0;
            for(int y = 0; y < 4; y ++) {
                sum = sum + nums[y];
                if (nums[y] > max)
                    max = nums[y];
                if (nums[y] < min)
                    min = nums[y];
            }
            recievedData.putInt("max",max);
            recievedData.putInt("min",min);
            recievedData.putInt("sum",sum);
            IntentHandler.putExtras(recievedData);
            txtFieldSum.append(""+recievedData.getInt("sum"));
            txtFieldMin.append(""+recievedData.getInt("min"));
            txtFieldMax.append(""+recievedData.getInt("max"));

            setResult(Activity.RESULT_OK, IntentHandler);
        }
        catch(Exception e){
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void onClickActivity1Back(View v)
    {
        finish();
    }
}