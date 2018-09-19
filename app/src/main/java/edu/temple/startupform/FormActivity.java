package edu.temple.startupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    EditText mNameEntry;
    EditText mEmailEntry;
    EditText mPasswordEntry;
    EditText mConfirmPasswordEntry;
    Button mSubmitButton;
    String mUser_Name;
    String mUser_Email;
    String mUser_Password;
    String mUser_Confirm_Password;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getViewReferences();
        setOnClickListeners();
    }

    private void getViewReferences() {
        mNameEntry            = findViewById(R.id.name_entry);
        mEmailEntry           = findViewById(R.id.email_entry);
        mPasswordEntry        = findViewById(R.id.password_entry);
        mConfirmPasswordEntry = findViewById(R.id.confirm_password_entry);
        mSubmitButton         = findViewById(R.id.button);
    }

    private void setOnClickListeners() {
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser_Name = mNameEntry.getText().toString();
                mUser_Email = mEmailEntry.getText().toString();
                mUser_Password = mPasswordEntry.getText().toString();
                mUser_Confirm_Password = mConfirmPasswordEntry.getText().toString();

                if (validInputs()) {
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);

                    intent.putExtra(Utilities.NAME_EXTRA, mUser_Name);
                    intent.putExtra(Utilities.EMAIL_EXTRA, mUser_Email);
                    intent.putExtra(Utilities.PASSWORD_EXTRA, mUser_Password);
                    startActivity(intent);
                } else {
                    Log.e(this.getClass().getSimpleName(), "User input not valid");
                }
            }
        });
    }

    private boolean validInputs() {
        if (!isFilledOut()) {
            Toast.makeText(this,
                    "You must fill out everything", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!passwordsMatch()) {
            Toast.makeText(this,
                    "The passwords must match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean passwordsMatch() {
        return TextUtils.equals(mPasswordEntry.getText(), mConfirmPasswordEntry.getText());
    }

    private boolean isFilledOut() {
        if (mNameEntry.getText().length()            == 0)    return false;
        if (mEmailEntry.getText().length()           == 0)    return false;
        if (mPasswordEntry.getText().length()        == 0)    return false;
        if (mConfirmPasswordEntry.getText().length() == 0)    return false;

        return true;
    }
}
