package com.example.vlmebalok;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtText,edtHeight,edtLenght,edtWidth;
    private Button btnCalculate;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edtWidht);
        edtHeight = findViewById(R.id.edt_heightt);
        edtLenght = findViewById(R.id.edt_lengthh);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.btn_calculate){
            String inputLength = edtLenght.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLenght.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            Double lenght = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (lenght == null){
                isInvalidDouble = true;
                edtLenght.setError("field ini harus berupa nomor yang valid");
            }

            if (width == null){
                isInvalidDouble = true;
                edtWidth.setError("field ini harus berupa nomor yang valid");
            }

            if (height == null){
                isInvalidDouble = true;
                edtHeight.setError("field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume = lenght * width * height;
                tvResult.setText(String.valueOf(volume));
            }


        }
    }


    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

}
