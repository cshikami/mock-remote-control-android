package shikamic.ShikamiC_remotecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static shikamic.ShikamiC_remotecontrol.R.id.b0;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CONFIGURE_CODE = 100;
    private static final int RESULT_OK2 = 50;
    private static final int RESULT_OK3 = 60;

    TextView currentChannelResult;
    String str = "";
    char op = ' ';
    int result = 0;
    int myNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bzero = (Button) findViewById(b0);
        Button bone = (Button) findViewById(R.id.b1);
        Button btwo = (Button) findViewById(R.id.b2);
        Button bthree = (Button) findViewById(R.id.b3);
        Button bfour = (Button) findViewById(R.id.b4);
        Button bfive = (Button) findViewById(R.id.b5);
        Button bsix = (Button) findViewById(R.id.b6);
        Button bseven = (Button) findViewById(R.id.b7);
        Button beight = (Button) findViewById(R.id.b8);
        Button bnine = (Button) findViewById(R.id.b9);
        Button bchplus = (Button) findViewById(R.id.bchplus);
        Button bchminus = (Button) findViewById(R.id.bchminus);
        Button bfavorite1 = (Button) findViewById(R.id.bfav1);
        Button bfavorite2 = (Button) findViewById(R.id.bfav2);
        Button bfavorite3 = (Button) findViewById(R.id.bfav3);
        currentChannelResult = (TextView) findViewById(R.id.tvcurrentchannelresult);
        Button bswitchdvr = (Button) findViewById(R.id.bswitchdvr);
        Button bconfigure = (Button) findViewById(R.id.bconfigure);

        bzero.setOnClickListener(this);
        bone.setOnClickListener(this);
        btwo.setOnClickListener(this);
        bthree.setOnClickListener(this);
        bfour.setOnClickListener(this);
        bfive.setOnClickListener(this);
        bsix.setOnClickListener(this);
        bseven.setOnClickListener(this);
        beight.setOnClickListener(this);
        bnine.setOnClickListener(this);
        bchplus.setOnClickListener(this);
        bchminus.setOnClickListener(this);
        bfavorite1.setOnClickListener(this);
        bfavorite2.setOnClickListener(this);
        bfavorite3.setOnClickListener(this);
        currentChannelResult.setOnClickListener(this);
        bswitchdvr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MydvrActivity.class);
                startActivity(intent);
            }
        });
        bconfigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyconfigureActivity.class);
                startActivityForResult(intent, CONFIGURE_CODE);
            }
        });
        pressToggleButton();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if (requestCode == CONFIGURE_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Your friend replied.\nThe answer is " + data.getCharSequenceExtra("labelentryline"), Toast.LENGTH_LONG).show();
                Button bfavorite1 = (Button) findViewById(R.id.bfav1);
                bfavorite1.setText("" + data.getCharSequenceExtra("labelentryline"));
                bfavorite1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentChannelResult = (TextView) findViewById(R.id.tvcurrentchannelresult);
                        currentChannelResult.setText("" + data.getCharSequenceExtra("channelline"));
                    }
                });
            }
            if (resultCode == RESULT_OK2) {
                Toast.makeText(this, "Your friend replied.\nThe answer is " + data.getCharSequenceExtra("labelentryline"), Toast.LENGTH_LONG).show();
                Button bfavorite2 = (Button) findViewById(R.id.bfav2);
                bfavorite2.setText("" + data.getCharSequenceExtra("labelentryline"));
                bfavorite2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentChannelResult = (TextView) findViewById(R.id.tvcurrentchannelresult);
                        currentChannelResult.setText("" + data.getCharSequenceExtra("channelline"));
                    }
                });
            }
            if (resultCode == RESULT_OK3) {
                Toast.makeText(this, "Your friend replied.\nThe answer is " + data.getCharSequenceExtra("labelentryline"), Toast.LENGTH_LONG).show();
                Button bfavorite3 = (Button) findViewById(R.id.bfav3);
                bfavorite3.setText("" + data.getCharSequenceExtra("labelentryline"));
                bfavorite3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentChannelResult = (TextView) findViewById(R.id.tvcurrentchannelresult);
                        currentChannelResult.setText("" + data.getCharSequenceExtra("channelline"));
                    }
                });
            } else {
                Toast.makeText(this, "You did not make any changes", Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public void onClick(View v) {
        final TextView currentChannelResult = (TextView) findViewById(R.id.tvcurrentchannelresult);
        final Switch powerToggle = (Switch) findViewById(R.id.powertoggle);
        if (powerToggle.isChecked()) {
            switch (v.getId()) {
                case R.id.b0:
                case R.id.b1:
                case R.id.b2:
                case R.id.b3:
                case R.id.b4:
                case R.id.b5:
                case R.id.b6:
                case R.id.b7:
                case R.id.b8:
                case R.id.b9:
                    if (str.length() < 3) {
                        String buttonInput = ((Button) v).getText().toString();
                        str += buttonInput;
                        currentChannelResult.setText(str);
                    } else {
                        String buttonInput = ((Button) v).getText().toString();
                        str = "";
                        currentChannelResult.setText(str);
                    }
                    break;

                case R.id.bfav1:
                    currentChannelResult.setText("123");
                    break;

                case R.id.bfav2:
                    currentChannelResult.setText("234");
                    break;

                case R.id.bfav3:
                    currentChannelResult.setText("345");
                    break;

                case R.id.bchplus:
                    String tvValues = currentChannelResult.getText().toString();
                    if (tvValues != "") {
                        int num1 = Integer.parseInt(tvValues);
                        int addedresults = num1 + 1;
                        String addedresultstrings = String.valueOf(addedresults);
                        currentChannelResult.setText(addedresultstrings);
                    } else {
                        tvValues = "0";
                        int num1 = Integer.parseInt(tvValues);
                        int addedresults = num1 + 1;
                        String addedresultstrings = String.valueOf(addedresults);
                        currentChannelResult.setText(addedresultstrings);
                    }
                    break;

                case R.id.bchminus:
                    String tvValue2 = currentChannelResult.getText().toString();
                    if (tvValue2 != "") {
                        int num2 = Integer.parseInt(tvValue2);
                        int subtractedresult = num2 - 1;
                        String subtractedresultstring = String.valueOf(subtractedresult);
                        currentChannelResult.setText(subtractedresultstring);
                    } else {
                        tvValue2 = "0";
                        int num2 = Integer.parseInt(tvValue2);
                        int subtractedresult = num2 - 1;
                        String subtractedresultstring = String.valueOf(subtractedresult);
                        currentChannelResult.setText(subtractedresultstring);
                    }
                    break;
            }
        } else {
            str = "";
        }
    }


    public void pressToggleButton() {
        Switch toggle = (Switch) findViewById(R.id.powertoggle);
        final TextView tvpowertextview = (TextView) findViewById(R.id.tvpowertextresult);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    // the textview would be set to “On"
                    dragSeekBar();
                    SeekBar volumeseekbar = (SeekBar) findViewById(R.id.volumeseekbar);
                    volumeseekbar.setClickable(true);
                    volumeseekbar.setEnabled(true);
                    tvpowertextview.setText("On");


                } else {
                    // The toggle is disabled
                    // The textview would be set to “Off"
                    SeekBar volumeseekbar = (SeekBar) findViewById(R.id.volumeseekbar);
                    tvpowertextview.setText("Off");
                    volumeseekbar.setClickable(false);
                    volumeseekbar.setEnabled(false);

                }
            }
        });
    }

    public void dragSeekBar() {
        SeekBar volumeseekbar = (SeekBar) findViewById(R.id.volumeseekbar);
        volumeseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView tvvolumetextview = (TextView) findViewById(R.id.tvvolumetextresult);
                tvvolumetextview.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}