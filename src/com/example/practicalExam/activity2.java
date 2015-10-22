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


public class activity2 extends Activity {

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
            setContentView(R.layout.activity2);
            txtFieldMax = (TextView) findViewById(R.id.maxVal);
            txtFieldMaxT = (TextView) findViewById(R.id.maxValTxt);
            txtFieldMin= (TextView) findViewById(R.id.minVal);
            txtFieldMinT = (TextView) findViewById(R.id.minValTxt);
            txtFieldSum = (TextView) findViewById(R.id.sumVal);
            txtFieldSumT = (TextView) findViewById(R.id.sumValTxt);
            back = (Button) findViewById(R.id.bckBtn);

            Intent IntentHandler2 = getIntent();
            Bundle recievedData = IntentHandler2.getExtras();

            int reqCodeR = recievedData.getInt("requestCode1");
            double[] numsRecieved = recievedData.getDoubleArray("numbersArray");
            double max = 0,min = 5000,sum = 0;
            for( int x = 0; x < 4;x++)
            {
                sum = sum + numsRecieved[x];
                if(numsRecieved[x] > max)
                    max = numsRecieved[x];
                if (numsRecieved[x] < min)
                    min = numsRecieved[x];
            }
            recievedData.putDouble("max", max);
            recievedData.putDouble("min", min);
            recievedData.putDouble("sum", sum);
            IntentHandler2.putExtras(recievedData);

            txtFieldSum.append(""+recievedData.getDouble("sum"));
            txtFieldMin.append(""+recievedData.getDouble("min"));
            txtFieldMax.append(""+recievedData.getDouble("max"));

            setResult(Activity.RESULT_OK, IntentHandler2);
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