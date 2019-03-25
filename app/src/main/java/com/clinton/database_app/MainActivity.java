package com.clinton.database_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_name)
    EditText input_name;

    @BindView(R.id.input_number)
    EditText input_number;

    @BindView(R.id.input_balance)
    EditText input_balance;

    @BindView(R.id.textViewCount)
    TextView txtcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void save(View view) {
        String name = input_name.getText().toString().trim();
        String number = input_number.getText().toString().trim();
        String bal = input_balance.getText().toString().trim();

        if (name.isEmpty() || number.isEmpty() || bal.isEmpty())
        {
            return;
        }

        //converting String bal to double balance
        double balance = Double.parseDouble(bal);
        Account x = new Account();

        x.setName(name);
        x.setAccNumber(number);
        x.setBalance(balance);

        //save db
        OurDatabase.getInstance(this).accountDao().insertAccount(x);

        //int count = OurDatabase.getInstance(this).accountDao().getAllAccounts().size();

        //txtcount.setText("Count is " + count);

        txtcount.setText("Account Successfuly saved");
        //clear
        input_name.setText("");
        input_number.setText("");
        input_balance.setText("");

    }

    public void accounts(View view) {
        Intent x = new Intent(this,DisplayActivity.class);
        startActivity(x);
    }
}
