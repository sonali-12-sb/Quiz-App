package com.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int received_marks;  // variable for storing the obtained marks for user
    TextView question1, question2, question3, question4, question5, question6, question7, question8, result, marks;              // Declaring TextViews
    CheckBox song1, song2, song3, song4, continents1, continents2, continents3, continents4;                               // Declaring CheckBoxes
    RadioButton artist_1, artist_2, artist_3, movie_1, movie_2, movie_3, wonders_3, wonders_7, wonders_12;                 // Declaring RadioButtons
    RadioGroup radioGroup1, radioGroup2, radioGroup3;                                                                   // Declaring RadioGroups
    ImageView taylor_img, shradha_img;                                                                              // Declaring ImageViews
    EditText independent_text, republic_text, christmas_text;                                                     // Declaring EditText View
    Button submit;                                                                                                  // Declaring Button View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling method
        initView();
    }

    // increment method to add the marks
    private void increment() {
        received_marks = received_marks + 1;
    }

    // method to initialize all the views
    private void initView() {

        question1 = findViewById(R.id.question_1);
        question2 = findViewById(R.id.question_2);
        question3 = findViewById(R.id.question_3);
        question4 = findViewById(R.id.question_4);
        question5 = findViewById(R.id.question_5);
        question6 = findViewById(R.id.question_6);
        question7 = findViewById(R.id.question_7);
        question8 = findViewById(R.id.question_8);

        song1 = findViewById(R.id.song_1);
        song2 = findViewById(R.id.song_2);
        song3 = findViewById(R.id.song_3);
        song4 = findViewById(R.id.song_4);

        continents1 = findViewById(R.id.asia);
        continents2 = findViewById(R.id.india);
        continents3 = findViewById(R.id.australia);
        continents4 = findViewById(R.id.maharashtra);

        radioGroup1 = findViewById(R.id.radio_group_artists);
        radioGroup2 = findViewById(R.id.radio_group_movies);
        radioGroup3 = findViewById(R.id.radio_group_continents);

        artist_1 = findViewById(R.id.justin);
        artist_2 = findViewById(R.id.bts);
        artist_3 = findViewById(R.id.taylor);

        movie_1 = findViewById(R.id.movie1);
        movie_2 = findViewById(R.id.movie2);
        movie_3 = findViewById(R.id.movie3);

        wonders_3 = findViewById(R.id.three);
        wonders_7 = findViewById(R.id.seven);
        wonders_12 = findViewById(R.id.tweleve);

        taylor_img = findViewById(R.id.artist);
        shradha_img = findViewById(R.id.actress);

        independent_text = findViewById(R.id.independance);
        republic_text = findViewById(R.id.republic);
        christmas_text = findViewById(R.id.christmas);

        submit = findViewById(R.id.submit);

        result = findViewById(R.id.results);
        marks = findViewById(R.id.obtained_marks);
    }

    // method to calculate the marks obtained by user
    public void calculateMarks() {

        received_marks = 0;

        // Checking if the correct radio button is selected in radioGroup1
        int selectedArtistId = radioGroup1.getCheckedRadioButtonId();
        if (selectedArtistId != -1 && selectedArtistId == artist_3.getId()) {
            // If the correct RadioButton in radioGroup1 is selected then call increment method to add marks
            increment();
        }

        // Checking if the correct radio button is selected in radioGroup2
        int selectedMovieId = radioGroup2.getCheckedRadioButtonId();
        if (selectedMovieId != -1 && selectedMovieId == movie_1.getId()) {
            // If the correct RadioButton in radioGroup2 is selected then call increment method to add marks
            increment();
        }

        // Checking if the correct radio button is selected in radioGroup3
        int selectedWondersId = radioGroup3.getCheckedRadioButtonId();
        if (selectedWondersId != -1 && selectedWondersId == wonders_7.getId()) {
            // If the correct RadioButton in radioGroup3 is selected then call increment method to add marks
            increment();
        }

        // checking if the correct checkboxes are checked and calling the increment method to add marks
        if (song1.isChecked() && !song3.isChecked() && song2.isChecked() && !song4.isChecked()) {
            increment();
        }

        // checking if the correct checkboxes are checked and calling the increment method to add marks
        if (continents1.isChecked() && !continents2.isChecked() && continents3.isChecked() && !continents4.isChecked()) {
            increment();
        }

        // checking if the correct answer is entered by user and calling increment method to add marks
        String independence = independent_text.getText().toString();
        if (independence.equals("15 August") || independence.equals("15th August")
                || independence.equals("15 august") || independence.equals("15th august")
                || independence.equals("15 AUGUST") || independence.equals("15th AUGUST")) {
            increment();
        }

        // checking if the correct answer is entered by user and calling increment method to add marks
        String republic = republic_text.getText().toString();
        if (republic.equals("26 January") || republic.equals("26th January")
                || republic.equals("26 january") || republic.equals("26th january")
                || republic.equals("26 JANUARY") || republic.equals("26th JANUARY")) {
            increment();
        }

        // checking if the correct answer is entered by user and calling increment method to add marks
        String christmas = christmas_text.getText().toString();
        if (christmas.equals("25 December") || christmas.equals("25th December")
                || christmas.equals("25 december") || christmas.equals("25th december")
                || christmas.equals("25 DECEMBER") || christmas.equals("25th DECEMBER")) {
            increment();
        }

        // finally setting the total marks
        if (received_marks >= 6) {
            marks.setText("Congratulations!.. You got " + String.valueOf(received_marks) + " out of 8 !..");
            // Toast message to display the result
            Toast.makeText(this, "Congratulations!.. You got " + received_marks + " out of 8 !..", Toast.LENGTH_SHORT).show();
        } else if (received_marks >= 4) {
            marks.setText("Good Work!.. You got " + String.valueOf(received_marks) + " out of 8 !..");
            // Toast message to display the result
            Toast.makeText(this, "Good Work!.. You got " + received_marks + " out of 8 !..", Toast.LENGTH_SHORT).show();
        } else {
            marks.setText("You got " + String.valueOf(received_marks) + " out of 8 !..");
            // Toast message to display the result
            Toast.makeText(this, "You got " + received_marks + " out of 8 !..", Toast.LENGTH_SHORT).show();
        }
    }

    public void Submit(View view) {
        calculateMarks();   // calling the method to display the results
    }

}