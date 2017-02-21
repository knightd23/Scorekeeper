package com.example.android.scorekeeper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.scorekeeper.R.id.team_b_ycardscore_value;

public class FootballActivity extends AppCompatActivity {

    String TeamA_name="Team A";
    String TeamB_name="Team B";
    int scoreTeamA=0;
    int scoreTeamB=0;
    int scorefoulA=0;
    int scorefoulB=0;
    int scoreycardA=0;
    int scoreycardB=0;
    int scorercardA=0;
    int scorercardB=0;

    @Override
    public void onSaveInstanceState(Bundle save){

        /**Store values*/
        save.putString("TeamA_name",TeamA_name);
        save.putString("TeamB_name",TeamB_name);
        save.putInt("scoreTeamA",scoreTeamA);
        save.putInt("scoreTeamB",scoreTeamB);
        save.putInt("scorefoulA",scorefoulA);
        save.putInt("scorefoulB",scorefoulB);
        save.putInt("scoreycardA",scoreycardA);
        save.putInt("scoreycardB",scoreycardB);
        save.putInt("scorercardA",scorercardA);
        save.putInt("scorercardB",scorercardB);

        super.onSaveInstanceState(save);
    }

    /**
     * Restore UI state from the savedInstanceState.
     * This bundle has also been passed to onCreate.
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TeamA_name = savedInstanceState.getString("TeamA_name");
        TeamB_name = savedInstanceState.getString("TeamB_name");
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        scorefoulA = savedInstanceState.getInt("scorefoulA");
        scorefoulB = savedInstanceState.getInt("scorefoulB");
        scoreycardA = savedInstanceState.getInt("scoreycardA");
        scoreycardB = savedInstanceState.getInt("scoreycardB");
        scorercardA = savedInstanceState.getInt("scorercardA");
        scorercardB = savedInstanceState.getInt("scorercardB");

        displayTeamA_name(TeamA_name);
        displayTeamB_name(TeamB_name);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayfoulsTeamA(scorefoulA);
        displayfoulsTeamB(scorefoulB);
        displayycardTeamA(scoreycardA);
        displayycardTeamB(scoreycardB);
        displayrcardTeamA(scorercardA);
        displayrcardTeamB(scorercardB);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.FootballTheme);
        setContentView(R.layout.activity_football);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    /**
     * Displays the given name of the Team A.
     */
    public void displayTeamA_name(String name) {
        TextView team_nameView = (TextView) findViewById(R.id.txt_TeamA_name);
        team_nameView.setText(String.valueOf(name));
    }

    /**
     * Displays the given name of the Team B.
     */
    public void displayTeamB_name(String name) {
        TextView team_nameView = (TextView) findViewById(R.id.txt_TeamB_name);
        team_nameView.setText(String.valueOf(name));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul for Team A.
     */
    public void displayfoulsTeamA(int score) {
        TextView foulsView = (TextView) findViewById(R.id.team_a_foulscore_value);
        foulsView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul for Team B.
     */
    public void displayfoulsTeamB(int score) {
        TextView foulsView = (TextView) findViewById(R.id.team_b_foulscore_value);
        foulsView.setText(String.valueOf(score));
    }

    /**
     * Displays the given yellow cards for Team A.
     */
    public void displayycardTeamA(int score) {
        TextView ycardView = (TextView) findViewById(R.id.team_a_ycardscore_value);
        ycardView.setText(String.valueOf(score));
    }

    /**
     * Displays the given yellow cards for Team B.
     */
    public void displayycardTeamB(int score) {
        TextView ycardView = (TextView) findViewById(team_b_ycardscore_value);
        ycardView.setText(String.valueOf(score));
    }

    /**
     * Displays the given red cards for Team A.
     */
    public void displayrcardTeamA(int score) {
        TextView rcardView = (TextView) findViewById(R.id.team_a_rcardscore_value);
        rcardView.setText(String.valueOf(score));
    }

    /**
     * Displays the given red cards for Team B.
     */
    public void displayrcardTeamB(int score) {
        TextView rcardView = (TextView) findViewById(R.id.team_b_rcardscore_value);
        rcardView.setText(String.valueOf(score));
    }

    public void bt_goalA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void bt_goalB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void bt_FoulA(View view) {
        scorefoulA += 1;
        displayfoulsTeamA(scorefoulA);
    }

    public void bt_FoulB(View view) {
        scorefoulB += 1;
        displayfoulsTeamB(scorefoulB);
    }

    public void bt_ycardA(View view) {
        scoreycardA += 1;
        displayycardTeamA(scoreycardA);
    }

    public void bt_ycardB(View view) {
        scoreycardB += 1;
        displayycardTeamB(scoreycardB);
    }

    public void bt_rcardA(View view) {
        scorercardA += 1;
        displayrcardTeamA(scorercardA);
    }

    public void bt_rcardB(View view) {
        scorercardB += 1;
        displayrcardTeamB(scorercardB);
    }

    public void back_main(View View) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reset_result(View View) {
        //clear results
        reset_results();
    }

    public void reset_results(){
        //clear results
        TeamA_name="Team A";
        TeamB_name="Team B";
        scoreTeamA=0;
        scoreTeamB=0;
        scorefoulA=0;
        scorefoulB=0;
        scoreycardA=0;
        scoreycardB=0;
        scorercardA=0;
        scorercardB=0;
        displayTeamA_name(TeamA_name);
        displayTeamB_name(TeamB_name);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayfoulsTeamA(scorefoulA);
        displayfoulsTeamB(scorefoulB);
        displayycardTeamA(scoreycardA);
        displayycardTeamB(scoreycardB);
        displayrcardTeamA(scorercardA);
        displayrcardTeamB(scorercardB);
    }

    public void send_result(View View) {
        //send results via email
//        Intent intent = new Intent(this, FootballActivity.class);
//        startActivity(intent);

        String Result = "";
        String Result_extended = "";
        String email_text="";

        if(scoreTeamA>scoreTeamB)
            Result = String.format("\"%s\" wins", TeamA_name);
        else if(scoreTeamA<scoreTeamB)
            Result = String.format("\"%s\" wins", TeamB_name);
        else
            Result = String.format("Teams drew");

        Result_extended = String.format("Final Result: %s %d - %d %s\nFouls: %s - %s\nYellow Cards: %s - %s\nRed Cards: %s - %s", TeamA_name, scoreTeamA, scoreTeamB, TeamB_name,scorefoulA, scorefoulB, scoreycardA, scoreycardB, scorercardA, scorercardB);
        email_text = Result + "\n" + Result_extended;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Football_Results");
        intent.putExtra(Intent.EXTRA_TEXT, email_text);
/*        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmailcom"});*/
        Intent mailer = Intent.createChooser(intent, null);
        startActivity(mailer);

        reset_results();
    }

    public void bt_setteamB_name(View View){
        EditText teamB_nameEdit = (EditText) findViewById(R.id.ed_teamB_name);
        TeamB_name =  teamB_nameEdit.getText().toString();
        displayTeamB_name(TeamB_name);
    }

    public void bt_setteamA_name(View View){
        EditText teamA_nameEdit = (EditText) findViewById(R.id.ed_teamA_name);
        TeamA_name =  teamA_nameEdit.getText().toString();
        displayTeamA_name(TeamA_name);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

}
