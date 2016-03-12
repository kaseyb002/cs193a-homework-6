package edu.stanford.kaseypb.foodtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.initialize(this);
        setUserNameText("jim5@b.edu");
        setPasswordText("ralph");
    }

    public void login(View view) {
        ParseUser.logInInBackground(getUserNameText(), getPasswordText(), new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getBaseContext(), CurrentTimeSlotsActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();//http://stackoverflow.com/questions/18240779/correct-context-to-use-within-callbacks
                }
            }
        });
    }

    public void createAccount(View view) {//https://parse.com/docs/android/guide#users

        ParseUser user = new ParseUser();
        user.setUsername(getUserNameText());
        user.setPassword(getPasswordText());
        user.setEmail(getUserNameText());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {//success
                    Toast.makeText(LoginActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();//http://stackoverflow.com/questions/18240779/correct-context-to-use-within-callbacks
                } else {//error
                    Toast.makeText(LoginActivity.this, "Account Creation Failed!", Toast.LENGTH_SHORT).show();//http://stackoverflow.com/questions/18240779/correct-context-to-use-within-callbacks
                }
            }
        });
    }

    private void setUserNameText(String username) {
        EditText userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        userNameEditText.setText(username);
    }

    private String getUserNameText() {
        EditText userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        return userNameEditText.getText().toString();
    }

    private void setPasswordText(String password) {
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordEditText.setText(password);
    }

    private String getPasswordText() {
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        return passwordEditText.getText().toString();
    }



}
