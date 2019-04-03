package com.osamaalbasha.magicsquretest.display;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.osamaalbasha.magicsquretest.R;
import com.osamaalbasha.magicsquretest.construction.MagicSquare;
import com.osamaalbasha.magicsquretest.data.access.MagicSquareModel;

public class MagicSquareActivity extends AppCompatActivity {

    public static final String EXTRA_MAGIC_SQUARE = "magic_square";

    private MagicSquareModel model;

    private TextView tvMagicSquareResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_square);

        setUpView();
        parseIntentData();
        fillView();
    }

    private void parseIntentData() {
        final Bundle bundle = getIntent().getExtras();

        if (null == bundle)
            return;

        model = (MagicSquareModel) bundle.getSerializable(EXTRA_MAGIC_SQUARE);
    }

    private void setUpView() {
        tvMagicSquareResult = findViewById(R.id.tv_magic_square_result);
    }

    private void fillView() {
        final MagicSquare magicSquare = new MagicSquare();
        magicSquare.setSize(model.getDimension());
        magicSquare.setMagicSquareArray(model.getMagicSquareArray());
        magicSquare.generateMagicSquare();

        tvMagicSquareResult.setText(magicSquare.printMagicSquareArray());
    }
}
