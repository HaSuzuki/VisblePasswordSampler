package com.example.hakutosuzuki.visiblepassword;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pattern 1
        TextInputEditText password = (TextInputEditText)findViewById(R.id.password);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        CheckBox passwordVisibilityCheckBox = (CheckBox) findViewById(R.id.password_visibility);

        // Pattern 2
        TextInputEditText password2 = (TextInputEditText)findViewById(R.id.password2);
        password2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

        TextView password3 = (TextView) findViewById(R.id.password3);

        // パスワード切り替えチェックボックス
        passwordVisibilityCheckBox.setOnClickListener((View v) -> {

            // パスワードのカーソル位置保存
            int cursorPos = password.getSelectionStart();

            boolean checked = passwordVisibilityCheckBox.isChecked();
            if (checked) {
                // パスワード可視化
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                // カーソル位置セット
                password.setSelection(cursorPos);
            } else {
                // パスワード不可視化
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                password.setSelection(cursorPos);
            }
        });

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password3.setText(password2.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
