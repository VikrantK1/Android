package com.example.intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView textView=null;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView=findViewById(R.id.textview1);
        editText=findViewById(R.id.editText);
       changeText(editText,textView);
    }
  public  void changeText(EditText editText12, final TextView textView23)
  {


      editText12.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               textView23.setText(charSequence);
          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
      });

  }
    public void back(View v)
    {
       String message=editText.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("MESSAGE",message);
        setResult(2,intent);
        finish();
    }
}
