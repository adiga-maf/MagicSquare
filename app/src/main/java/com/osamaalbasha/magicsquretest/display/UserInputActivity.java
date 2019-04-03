package com.osamaalbasha.magicsquretest.display;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.osamaalbasha.magicsquretest.R;
import com.osamaalbasha.magicsquretest.data.access.MagicSquareModel;

import static com.osamaalbasha.magicsquretest.display.MagicSquareActivity.EXTRA_MAGIC_SQUARE;

public class UserInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        final EditText userInput = findViewById(R.id.et_user_input);

        findViewById(R.id.btn_start_magic_square_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validate user input
                if (userInput.length() == 0 || Integer.parseInt(userInput.getText().toString()) % 2 == 0) {
                    Toast.makeText(UserInputActivity.this, getString(R.string.toast_empty_user_input), Toast.LENGTH_LONG).show();
                    return;
                }

                final MagicSquareModel model = new MagicSquareModel();
                model.setDimension(Integer.parseInt(userInput.getText().toString()));
                model.setMagicSquareArray();

                startActivity(new Intent(UserInputActivity.this,
                        MagicSquareActivity.class)
                        .putExtra(EXTRA_MAGIC_SQUARE, model));
            }
        });
    }
}
