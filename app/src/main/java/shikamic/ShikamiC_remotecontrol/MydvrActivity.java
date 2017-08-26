package shikamic.ShikamiC_remotecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static shikamic.ShikamiC_remotecontrol.R.id.bswitchtotv;

public class MydvrActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyActivity";
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydvr);


        Button bplay = (Button) findViewById(R.id.bplay);
        Button bstop = (Button) findViewById(R.id.bstop);
        Button bpause = (Button) findViewById(R.id.bpause);
        Button bfastforward = (Button) findViewById(R.id.bfastforward);
        Button bfastrewind = (Button) findViewById(R.id.bfastrewind);
        Button brecord = (Button) findViewById(R.id.brecord);

        Button switchtotv = (Button) findViewById(bswitchtotv);
        Button bconfigure = (Button) findViewById(R.id.bconfigure);

        bplay.setOnClickListener(this);
        bstop.setOnClickListener(this);
        bpause.setOnClickListener(this);
        bfastforward.setOnClickListener(this);
        bfastrewind.setOnClickListener(this);
        brecord.setOnClickListener(this);
        switchtotv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MydvrActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        pressToggleButton();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();

    }

    @Override
    public void onClick(View v) {
        final TextView dvrFunctionResult = (TextView) findViewById(R.id.dvrstatetextresult);
        final Switch dvrpowerToggle = (Switch) findViewById(R.id.dvrpowertoggle);

        if (dvrpowerToggle.isChecked()) {
            Button bplay = (Button) findViewById(R.id.bplay);
            bplay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button bpause = (Button) findViewById(R.id.bpause);
                    bpause.setEnabled(true);
                    Log.d(TAG, "Pause enabled after play button clicked: " + bpause.isEnabled());

                }
            });

            Button bstop = (Button) findViewById(R.id.bstop);
            bstop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button brecord = (Button) findViewById(R.id.brecord);
                    brecord.setEnabled(true);
                    Log.d(TAG, "Record enabled after stop button clicked: " + brecord.isEnabled());
                }
            });

            Button brecord = (Button) findViewById(R.id.brecord);
            brecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button bplay = (Button) findViewById(R.id.bplay);
                    Button bpause = (Button) findViewById(R.id.bpause);
                    Button bfastforward = (Button) findViewById(R.id.bfastforward);
                    Button bfastrewind = (Button) findViewById(R.id.bfastrewind);
                    Button bstop = (Button) findViewById(R.id.bstop);

                    bstop.setEnabled(true);
                    bplay.setEnabled(false);
                    bpause.setEnabled(false);
                    bfastforward.setEnabled(false);
                    bfastrewind.setEnabled(false);

                    if (bfastforward.isSelected()) {
                        Toast.makeText(MydvrActivity.this, "Fast Forward cannot be selected while recording.",
                                Toast.LENGTH_LONG).show();
                    }

                    Log.d(TAG, "Outer OnClick section reached: \nbstop enabled?: " + bstop.isEnabled() +
                            "\nbplay enabled?: " + bplay.isEnabled() + "\nbpause enabled?: " + bpause.isEnabled() +
                            "\nbfastforward enabled?: " + bfastforward.isEnabled() +
                            "\nbfastrewind enabled?:" + bfastrewind.isEnabled());

                    bstop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Button brecord = (Button) findViewById(R.id.brecord);
                            Button bplay = (Button) findViewById(R.id.bplay);
                            Button bpause = (Button) findViewById(R.id.bpause);
                            Button bfastforward = (Button) findViewById(R.id.bfastforward);
                            Button bfastrewind = (Button) findViewById(R.id.bfastrewind);
                            Button bstop = (Button) findViewById(R.id.bstop);

                            bplay.setEnabled(true);
                            bstop.setEnabled(true);
                            bpause.setEnabled(true);
                            bfastforward.setEnabled(true);
                            bfastrewind.setEnabled(true);
                            brecord.setEnabled(true);
                            Log.d(TAG, "OnClick section reached.");
                        }});
                }
            });

            switch (v.getId()) {
                case R.id.bplay:
                case R.id.bstop:
                case R.id.bpause:
                case R.id.bfastforward:
                case R.id.bfastrewind:
                case R.id.brecord:
                    String buttonInput = ((Button) v).getText().toString();
                    str = buttonInput;
                    break;
            }
        }
            else{
                //dvrpowerToggle.setEnabled(false);
            }
            dvrFunctionResult.setText(str);

        }

    public void pressToggleButton() {
        Switch dvrpowertoggle = (Switch) findViewById(R.id.dvrpowertoggle);
        final TextView dvrpowertextview = (TextView) findViewById(R.id.dvrpowertextresult);
        dvrpowertoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    // the textview would be set to “On"
                    dvrpowertextview.setText("On");


                } else {
                    // The toggle is disabled
                    // The textview would be set to “Off"
                    dvrpowertextview.setText("Off");
                }
            }
        });
    }
}