package com.teamtreehouse.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private FactBook mFactBook = new FactBook();
    private TextView mFactTextView;
    private Button mShowFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFactTextView.setText(mFactBook.getFact());
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }
}
