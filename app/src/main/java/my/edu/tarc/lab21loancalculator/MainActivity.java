package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    public EditText editTextVehiclePrice, editTextDownPayment, editTextRepayment, editTextInterestRate, editTextSalary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextVehiclePrice = (EditText)findViewById(R.id.editTextVehiclePrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);

    }

    public void calculateLoan (View view) {
        //TODO: calculate repayment amount and determine
        double vehiclePrice, downPayment, repayment, interestRate, salary, totalInterest, totalLoan, monthlyPayment;

        vehiclePrice = Double.parseDouble(editTextVehiclePrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        repayment = Double.parseDouble(editTextRepayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        salary = Double.parseDouble(editTextSalary.getText().toString());

        totalInterest = (vehiclePrice - downPayment) * (interestRate / 100 ) * (repayment / 12);
        totalLoan = (vehiclePrice - downPayment) + totalInterest;
        monthlyPayment = totalLoan / repayment;

        if (monthlyPayment > (0.3 * salary)){
            monthlyPayment = totalLoan / repayment;
//
        }






        //the status of loan application
        double payment = 450.0;
        String status = "Approve";


        //Define an Intent object
        //This is an Explicit Intent
        Intent intent = new Intent(this, ResultActivity.class);
        //Use the putExtra method to pass data
        //format: putExtra (TAG, value)
        intent.putExtra(LOAN_PAYMENT, payment);
        intent.putExtra(LOAN_STATUS, status);


        startActivity(intent);
    }
}
