package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //To get the intent
        Intent intent = getIntent(); //Asking "who called me"
        double payment = intent.getDoubleExtra(MainActivity.LOAN_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: display outputs
    }

    public void closeActivity (View view) {
        //Terminate an activity
        finish();
    }
}
