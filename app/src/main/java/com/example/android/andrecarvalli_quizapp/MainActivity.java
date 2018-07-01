package com.example.android.andrecarvalli_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int gradeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*****
     @PARAMS boolean independenceTrue, independenceFalse, PresidentTrue1, PresidentFalse, numberOfStatesTrue, numberOfStatesFalse,
     countryAboveUsaTrue, countryAboveUsaFalse, originOfPresidentTrue, originOfPresidentFalse
      * */
    private String checkAnswers(boolean independenceTrue, boolean independenceFalse, boolean PresidentTrue1, boolean PresidentFalse, boolean PresidentTrue2,
                                boolean numberOfStatesTrue, boolean numberOfStatesFalse,
                                boolean countryAboveUsaTrue, boolean countryAboveUsaFalse, boolean originOfPresidentTrue,
                                boolean originOfPresidentFalse) {

        /* CHECKS ALL USER INPUTS AND MATCHES THAT TO CORRECT VALUE*/
        String results = "\n";

        /*question 1*/
        if (independenceTrue) {
            gradeCount += 1;
            results += "4th of July 1776 : \t\t\tcorrect\n";
        }
        if (independenceFalse) {
            results += "4th of July 1775 : \t\t\t incorrect\n";
        }
        /*question 2*/
        if (PresidentTrue1) {
            gradeCount += 1;
            results += "Thomas Jefferson : \t\t\tcorrect\n";
        } else if (!PresidentTrue1 && (PresidentTrue2 || PresidentFalse)) {
            results += "Thomas Jefferson : \t\t\t\twould be right\n";
        }
        if (PresidentFalse) {
            results += "Thomas Edison : \t\t\t\t\tincorrect\n";
        }
        if (PresidentTrue2) {
            gradeCount += 1;
            results += "Abraham Lincoln : \t\t\t\tcorrect\n";
        } else if (!PresidentTrue2 && (PresidentTrue1 || PresidentFalse)) {
            results += "Abraham Lincoln : \t\t\t\twould be right\n";
        }
        /*question 3*/
        if (numberOfStatesTrue) {
            gradeCount += 1;
            results += "50 States : \t\t\t\t correct\n";
        }
        if (numberOfStatesFalse) {
            results += "49 States : \t\t\t\t incorrect\n";
        }
        /*question 4*/
        if (countryAboveUsaTrue) {
            gradeCount += 1;
            results += "Canada : \t\t\t\t\t\t\t correct\n";
        }
        if (countryAboveUsaFalse) {
            results += "North America : \t\t\t\tincorrect\n";
        }
        /*question 5*/
        if (originOfPresidentTrue) {
            gradeCount += 1;
            results += "Kenyan : \t\t\t\t correct\n";
        }
        if (originOfPresidentFalse) {
            results += "American : \t\t\t\tincorrect\n";
        }

        /* * Display the result and Reset gradeCount value to 0 for next cycle
         */
        String displayScore = "" + gradeCount;
        results += "\nSCORE POINTS: " + displayScore + "/6";
        gradeCount = 0;// Reset grade counter after every button click
        return results;
    }

    /***
     * GET TEST RESULTS AND DISPLAY THEM ON A TOAST MESSAGE***/
    public void submit_answer(View view) {

        RadioButton independenceCorrect = findViewById(R.id.american_independence_true);
        Boolean correctDate = independenceCorrect.isChecked();

        RadioButton independenceWrong = findViewById(R.id.american_independence_false);
        Boolean wrongDate = independenceWrong.isChecked();

        CheckBox PresidentCorrect1 = findViewById(R.id.american_president_true1);
        Boolean correctPresident1 = PresidentCorrect1.isChecked();

        CheckBox PresidentWrong = findViewById(R.id.american_president_false);
        Boolean wrongPresident = PresidentWrong.isChecked();

        CheckBox PresidentCorrect2 = findViewById(R.id.american_president_true2);
        Boolean correctPresident2 = PresidentCorrect2.isChecked();

        RadioButton numberOfStatesCorrect = findViewById(R.id.american_number_of_states_true);
        Boolean correctStateNumber = numberOfStatesCorrect.isChecked();

        RadioButton numberOfStatesWrong = findViewById(R.id.american_number_of_states_false);
        Boolean wrongStateNumber = numberOfStatesWrong.isChecked();

        RadioButton countryAboveUsaCorrect = findViewById(R.id.country_above_USA_true);
        Boolean correctCountryAboveUsa = countryAboveUsaCorrect.isChecked();

        RadioButton countryAboveUsaWrong = findViewById(R.id.country_above_USA_false);
        Boolean wrongCountryAboveUsa = countryAboveUsaWrong.isChecked();

        RadioButton originOfFatherCorrect = findViewById(R.id.origin_of_father_true);
        Boolean correctFatherOrigin = originOfFatherCorrect.isChecked();

        RadioButton originOfFatherWrong = findViewById(R.id.origin_of_father_false);
        Boolean wrongFatherOrigin = originOfFatherWrong.isChecked();

        String results = checkAnswers(correctDate, wrongDate, correctPresident1, wrongPresident, correctPresident2, correctStateNumber, wrongStateNumber,
                correctCountryAboveUsa, wrongCountryAboveUsa, correctFatherOrigin, wrongFatherOrigin);

        /*Get the user`s name from the app and store it in a variable called storeUsername*/
        EditText username = findViewById(R.id.username_etxt);
        String storeUsername = username.getText().toString();

        if (storeUsername.isEmpty()) {
            Toast.makeText(this, "Please Enter your user name to continue", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Hello:  " + storeUsername + " \nHERE ARE YOUR QUIZ RESULTS" + results, Toast.LENGTH_LONG).show();
        }
    }
}
