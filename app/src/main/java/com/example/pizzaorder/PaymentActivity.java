package com.example.pizzaorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentActivity extends AppCompatActivity {

    RadioGroup rgPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RadioGroup rgPayment = findViewById(R.id.rgPayment);
                int selectedId = rgPayment.getCheckedRadioButtonId();


                if (selectedId != -1) {

                    RadioButton selcted = findViewById(selectedId);
                    String paymentMethod = selcted.getText().toString();

                    Toast.makeText(PaymentActivity.this, "שולם ב" + paymentMethod + ". תודה!", Toast.LENGTH_LONG).show();
                    finish();

                } else {
                    Toast.makeText(PaymentActivity.this, "אנא בחר אמצעי תשלום", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView Things = findViewById(R.id.Things);
        String size = getIntent().getStringExtra("size");
        String crust = getIntent().getStringExtra("crust");
        int price = getIntent().getIntExtra("price", 0);
        Things.setText("your order " + size +" pizza, "+ crust + " crust"+", the price is "+price);
    }
}