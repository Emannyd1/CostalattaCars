package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        //extract data from the intent
        double carPrice, downPayment;
        int loanTerm;
        Intent intent = getIntent();
        carPrice = intent.getDoubleExtra("CarPrice",0);
        downPayment = intent.getDoubleExtra("DownPayment", 0);
        loanTerm = intent.getIntExtra("LoanTerm",0);

        // send data to the model CarLoan
        carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        //populate with the text views with the data from the carloan

    }

}
