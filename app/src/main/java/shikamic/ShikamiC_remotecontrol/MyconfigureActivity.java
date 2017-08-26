package shikamic.ShikamiC_remotecontrol;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MyconfigureActivity extends AppCompatActivity implements View.OnClickListener{

    String str = "";
    EditText labelentryline;
    TextView channelline;
    private static final int RESULT_OK2 = 50;
    private static final int RESULT_OK3 = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myconfigure);

        RadioButton leftradiobutton = (RadioButton) findViewById(R.id.leftradiobutton);
        RadioButton middleradiobutton = (RadioButton) findViewById(R.id.middleradiobutton);
        RadioButton rightradiobutton = (RadioButton) findViewById(R.id.rightradiobutton);

        Button bczero = (Button) findViewById(R.id.bc0);
        Button bcone = (Button) findViewById(R.id.bc1);
        Button bctwo = (Button) findViewById(R.id.bc2);
        Button bcthree = (Button) findViewById(R.id.bc3);
        Button bcfour = (Button) findViewById(R.id.bc4);
        Button bcfive = (Button) findViewById(R.id.bc5);
        Button bcsix = (Button) findViewById(R.id.bc6);
        Button bcseven = (Button) findViewById(R.id.bc7);
        Button bceight = (Button) findViewById(R.id.bc8);
        Button bcnine = (Button) findViewById(R.id.bc9);
        Button bcchplus = (Button) findViewById(R.id.bcchplus);
        Button bcchminus = (Button) findViewById(R.id.bcchminus);
        Button bccancel= (Button) findViewById(R.id.bccancel);
        Button bcsave = (Button) findViewById(R.id.bcsave);
        channelline = (TextView) findViewById(R.id.channelline);
        labelentryline = (EditText) findViewById(R.id.labelentryline);

        leftradiobutton.setOnClickListener(this);
        middleradiobutton.setOnClickListener(this);
        rightradiobutton.setOnClickListener(this);
        bczero.setOnClickListener(this);
        bcone.setOnClickListener(this);
        bctwo.setOnClickListener(this);
        bcthree.setOnClickListener(this);
        bcfour.setOnClickListener(this);
        bcfive.setOnClickListener(this);
        bcsix.setOnClickListener(this);
        bcseven.setOnClickListener(this);
        bceight.setOnClickListener(this);
        bcnine.setOnClickListener(this);
        bcchplus.setOnClickListener(this);
        bcchminus.setOnClickListener(this);
        labelentryline.setOnClickListener(this);
        channelline.setOnClickListener(this);
        bccancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        bcsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MyconfigureActivity.this, MainActivity.class);
                EditText labelentryline = (EditText) findViewById(R.id.labelentryline);
                TextView channelline = (TextView) findViewById(R.id.channelline);
                RadioButton leftbutton = (RadioButton) findViewById(R.id.leftradiobutton);
                RadioButton middlebutton = (RadioButton) findViewById(R.id.middleradiobutton);
                RadioButton rightbutton = (RadioButton) findViewById(R.id.rightradiobutton);
                //if ()
                Intent data = new Intent();

                String channelString = channelline.getText().toString();
                final int channelNumber = Integer.parseInt(channelString);

                if (labelentryline.getText().length() > 1 && labelentryline.getText().length() < 5 && leftbutton.isChecked() && channelNumber > 0 && channelNumber < 1000) {

                            data.putExtra("labelentryline", labelentryline.getText().toString());
                            data.putExtra("channelline", channelline.getText().toString());
                            setResult(RESULT_OK, data);
                            finish();
                }

                if (labelentryline.getText().length() < 2 ||  labelentryline.getText().length() > 4) {
                    Toast.makeText(MyconfigureActivity.this, "Label must be between 2-4 letters in length",
                            Toast.LENGTH_LONG).show();
                }

                if (channelNumber < 1 || channelNumber > 999) {
                    Toast.makeText(MyconfigureActivity.this, "Channel number must be between 1-999",
                            Toast.LENGTH_LONG).show();
                }

                if (labelentryline.getText().length() > 1 && labelentryline.getText().length() < 5 && middlebutton.isChecked() && channelNumber > 0 && channelNumber < 1000) {

                    data.putExtra("labelentryline", labelentryline.getText().toString());
                    data.putExtra("channelline", channelline.getText().toString());
                    //send to mainactivity class, look at intent+data project for clues
                    //comment out line 93 and 94 to get back to original result
                    setResult(RESULT_OK2, data);
                    finish();
                }
                if (labelentryline.getText().length() > 1 && labelentryline.getText().length() < 5 && rightbutton.isChecked()&& channelNumber > 0 && channelNumber < 1000) {

                    data.putExtra("labelentryline", labelentryline.getText().toString());
                    data.putExtra("channelline", channelline.getText().toString());
                    //send to mainactivity class, look at intent+data project for clues
                    //comment out line 93 and 94 to get back to original result
                    setResult(RESULT_OK3, data);
                    finish();
                }
                else {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (intent != null) {
            TextView labelresult = (TextView) findViewById(R.id.labelentryline);
        }
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bc0:
                case R.id.bc1:
                case R.id.bc2:
                case R.id.bc3:
                case R.id.bc4:
                case R.id.bc5:
                case R.id.bc6:
                case R.id.bc7:
                case R.id.bc8:
                case R.id.bc9:



                    String buttonInput = ((Button) v).getText().toString();
                    if (str.length() < 3) {
                        str+=buttonInput;
                        channelline.setText(str);
                    } else {
                        str="";
                        channelline.setText(str);

                    }
                    break;

                case R.id.bcchplus:
                    String tvValue = channelline.getText().toString();
                    if (tvValue != "") {
                        int num1 = Integer.parseInt(tvValue);
                        int addedresult = num1 + 1;
                        String addedresultstring = String.valueOf(addedresult);
                        channelline.setText(addedresultstring);
                    }
                    else {
                        tvValue = "0";
                        int num1 = Integer.parseInt(tvValue);
                        int addedresult = num1 + 1;
                        String addedresultstring = String.valueOf(addedresult);
                        channelline.setText(addedresultstring);
                    }
                    break;

                case R.id.bcchminus:
                    String tvValue2 = channelline.getText().toString();
                    if (tvValue2 != "") {

                        int num2 = Integer.parseInt(tvValue2);
                        int subtractedresult = num2 - 1;
                        String subtractedresultstring = String.valueOf(subtractedresult);
                        channelline.setText(subtractedresultstring);
                    }
                    else {
                        tvValue2 = "0";
                        int num2 = Integer.parseInt(tvValue2);
                        int subtractedresult = num2 - 1;
                        String subtractedresultstring = String.valueOf(subtractedresult);
                        channelline.setText(subtractedresultstring);
                    }
                    break;
            }
        }
    }
