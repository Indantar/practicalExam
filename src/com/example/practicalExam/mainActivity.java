package com.example.practicalExam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    TextView txtField1;
    Button btnActivity1;
    TextView txtField2;
    Button btnActivity2;
    TextView txtField3;
    Button btnActivity3;
    TextView num1Ac2;
    TextView num2Ac2;
    TextView num3Ac2;
    TextView num4Ac2;
    TextView num5Ac2;
    TextView num1Ac3;
    TextView num2Ac3;
    TextView num3Ac3;
    TextView num4Ac3;
    TextView num5Ac3;
    private final int REQ = (int) (10001 * Math.random());
    private final int REQ2 = (int) (10001 * Math.random());
    private final int REQ3 = (int) (10001 * Math.random());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            setContentView(R.layout.main);
            txtField1 = (TextView) findViewById(R.id.textField1);
            btnActivity1 = (Button) findViewById(R.id.activity1Btn);
            txtField2 = (TextView) findViewById(R.id.textField2);
            btnActivity2 = (Button) findViewById(R.id.activity2Btn);
            txtField3 = (TextView) findViewById(R.id.textField3);
            btnActivity3 = (Button) findViewById(R.id.activity3Btn);
            num1Ac3 = (EditText) findViewById(R.id.editText);
            num2Ac3 = (EditText) findViewById(R.id.editText2);
            num3Ac3 = (EditText) findViewById(R.id.editText3);
            num4Ac3 = (EditText) findViewById(R.id.editText4);
            num5Ac3 = (EditText) findViewById(R.id.editText5);
        }
        catch(Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void onClick1(View v)
    {
        try {
            Intent i = new Intent(mainActivity.this, activity1.class);
            Bundle numbers1 = new Bundle();
            numbers1.putInt("requestCode1", REQ);
            numbers1.putInt("number1", 100);
            numbers1.putInt("number2", 356);
            numbers1.putInt("number3", 1587);
            numbers1.putInt("number4", 4589);
            numbers1.putInt("number5", 3300);
            i.putExtras(numbers1);
            startActivityForResult(i, REQ);
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

    }

    public void onClickActivity2(View v)
    {
        try {
            Intent i2 = new Intent(mainActivity.this, activity1.class);
            Bundle numbers1 = new Bundle();
            int[] nums = {Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())};
            numbers1.putInt("requestCode1", REQ2);
            numbers1.putIntArray("numbersArray",nums);
            i2.putExtras(numbers1);
            System.out.println(nums);
            startActivityForResult(i2, REQ2);
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
    public void onClickActivity3(View v)
    {
        try{
            Uri uri = Uri.parse("mdp://gmit.computer.ie/pe1");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            Bundle numbers1 = new Bundle();
            int[] nums = {Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())
                    ,Integer.parseInt(num1Ac2.getText().toString())};
            numbers1.putInt("requestCode1", REQ3);
            numbers1.putIntArray("numbersArray",nums);
            intent.putExtras(numbers1);
            System.out.println(nums);
            startActivityForResult(intent, REQ3);
        }
        catch(Exception e)
        {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
    protected void onActivityResult(int reqCode,int resultCode, Intent data)
    {
        super.onActivityResult(reqCode, resultCode, data);
        try{
            if(REQ == reqCode)
            {
                if(resultCode == Activity.RESULT_OK)
                {
                    Bundle returnNumbers1 = data.getExtras();
                    int max = returnNumbers1.getInt("max");
                    int min = returnNumbers1.getInt("min");
                    int sum = returnNumbers1.getInt("sum");
                    txtField1.setText("Max:"+max+" Min:"+min+" Sum:"+sum);
                }
            }
            else if(REQ2 == reqCode)
            {
                if(resultCode == Activity.RESULT_OK)
                {
                    Bundle returnNumbers2 = data.getExtras();
                    int max = returnNumbers2.getInt("max");
                    int min = returnNumbers2.getInt("min");
                    int sum = returnNumbers2.getInt("sum");
                    txtField2.setText("Max:"+max+" Min:"+min+" Sum:"+sum);
                }
            }
            else if(REQ3 == reqCode)
            {
                if(resultCode == Activity.RESULT_OK)
                {
                    Bundle returnNumbers2 = data.getExtras();
                    int max = returnNumbers2.getInt("max");
                    int min = returnNumbers2.getInt("min");
                    int sum = returnNumbers2.getInt("sum");
                    txtField3.setText("Max:"+max+" Min:"+min+" Sum:"+sum);
                }
            }
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }

}
