package com.example.pizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSummary = findViewById(R.id.tvSummary);
        TextView PizzaPrice = findViewById(R.id.PizzaPrice);

        String size = getIntent().getStringExtra("size");
        String crust = getIntent().getStringExtra("crust");
        int price = getIntent().getIntExtra("price", 0);
        tvSummary.setText("your order " + size +" pizza, "+ crust + " crust");
        PizzaPrice.setText("the price is "+price);
        Button btnBack  = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        Button btnPay  = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, PaymentActivity.class);
                intent.putExtra("size", size);
                intent.putExtra("crust", crust);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });

    }
}