package edu.temple.startupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    User mUser;
    TextView mWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mWelcomeMessage = findViewById(R.id.welcome_message);

        Intent intent = getIntent();
        String username = intent.getStringExtra(Utilities.NAME_EXTRA);
        String email    = intent.getStringExtra(Utilities.EMAIL_EXTRA);
        String password = intent.getStringExtra(Utilities.PASSWORD_EXTRA);

        mUser = new User(username, email, password);

        String message = "Welcome %s, to the sign up app";

        mWelcomeMessage.setText(String.format(message, mUser.getName()));
    }


}
