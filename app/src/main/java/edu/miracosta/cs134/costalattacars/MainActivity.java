package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);
    }

    public void generateReport(View v)
    {
        double carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        double downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        int loanTerm;
        switch (loanTermRadioGroup.getCheckedRadioButtonId())
        {

            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            default:
                loanTerm = 5;
                break;

        }

        //instantiate the intent and navigate to loan summary activity

        Intent intent = new Intent(this, LoanSummaryActivity.class);
        intent.putExtra("CarPrice",carPrice);
        intent.putExtra("DownPayment",downPayment);
        intent.putExtra("LoanTerm",loanTerm);

        startActivity(intent);
    }
}
