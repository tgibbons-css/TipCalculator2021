package css.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextBill;
    EditText editTextNumInParty;
    TextView textViewTotalTip;
    TextView textViewTipPerPerson;
    Button buttonCalculate;
    CheckBox checkBoxService;
    SeekBar seekBarNumInParty;
    double tipPercent = 0.15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBill = findViewById(R.id.editTextBillAmount);
        editTextNumInParty = findViewById(R.id.editTextNumInParty);
        textViewTotalTip = findViewById(R.id.textViewTotalTip);
        textViewTipPerPerson = findViewById(R.id.textViewTipPerPerson);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        checkBoxService = findViewById(R.id.checkBoxService);
        seekBarNumInParty = findViewById(R.id.seekBarNumInParty);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double  bill = Double.parseDouble(editTextBill.getText().toString());
                Integer numInParty = Integer.parseInt(editTextNumInParty.getText().toString());
                if (checkBoxService.isChecked()) {
                    tipPercent = 0.20;
                }
                Double tip = bill * tipPercent;
                textViewTotalTip.setText(NumberFormat.getCurrencyInstance().format(tip));
                textViewTipPerPerson.setText(NumberFormat.getCurrencyInstance().format(tip/numInParty));
            }
        });

        seekBarNumInParty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editTextNumInParty.setText(Integer.toString(progress+1));
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