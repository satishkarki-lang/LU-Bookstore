package com.example.lubookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> book = new ArrayList<String>();
    private ArrayList<String> book1 = new ArrayList<String>();
    private ArrayList<String> book2 = new ArrayList<String>();
    private ArrayList<String> book3 = new ArrayList<String>();

    private TableLayout table;

    EditText id1,id2,id3,id4,id5,id6;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id1 = findViewById(R.id.id1);
        id2 = findViewById(R.id.id2);
        id3 = findViewById(R.id.id3);

        id4 = findViewById(R.id.sub);
        id5 = findViewById(R.id.cash1);
        id6 = findViewById(R.id.change1);

        button = findViewById(R.id.button1);

        id5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int sub = Integer.parseInt(id4.getText().toString());
                int cash = Integer.parseInt(id5.getText().toString());
                int change = cash - sub;
                id6.setText(String.valueOf(change));

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();

            }
        });

    }

    public void calculate(){
        int total;
        String bookname = id1.getText().toString();
        int price = Integer.parseInt(id2.getText().toString());
        int quantity = Integer.parseInt(id3.getText().toString());

        total = price * quantity;

        book.add(bookname);
        book1.add(String.valueOf(price));
        book2.add(String.valueOf(quantity));
        book3.add(String.valueOf(total));

       TableLayout table = (TableLayout) findViewById(R.id.table1);
        TableRow row = new TableRow(this);
        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);
        TextView text3 = new TextView(this);
        TextView text4 = new TextView(this);

        String tot;
        int sum = 0;

        for(int i = 0; i<book.size(); i++)
        {
            String bookn = book.get(i);
            String pri = book1.get(i);
            String qnt = book2.get(i);
            tot = book3.get(i);

            text1.setText(bookn);
            text2.setText(pri);
            text3.setText(qnt);
            text4.setText(tot);

            sum = sum + Integer.parseInt(book3.get(i).toString());

        }

        row.addView(text1);
        row.addView(text2);
        row.addView(text3);
        row.addView(text4);
        table.addView(row);

        id4.setText(String.valueOf(sum));
        id1.setText("");
        id2.setText("");
        id3.setText("");
        id1.requestFocus();





    }
}
