package com.example.android.scorekeeper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class BasketballActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;
    String TeamA_name="Team A";
    String TeamB_name="Team B";

    @Override
    public void onSaveInstanceState(Bundle save){

        /**Store values*/
        save.putInt("scoreTeamA",scoreTeamA);
        save.putInt("scoreTeamB",scoreTeamB);
        save.putString("TeamA_name",TeamA_name);
        save.putString("TeamB_name",TeamB_name);


        super.onSaveInstanceState(save);
    }

    /**
     * Restore UI state from the savedInstanceState.
     * This bundle has also been passed to onCreate.
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        TeamA_name = savedInstanceState.getString("TeamA_name");
        TeamB_name = savedInstanceState.getString("TeamB_name");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayTeamA_name(TeamA_name);
        displayTeamB_name(TeamB_name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        setTheme(android.R.style.BasktTheme);

*/
        setTheme(R.style.BasktTheme);
        setContentView(R.layout.activity_basketball);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_basketball);
        layout.addView(textView);*/


    }

    /**
     *  This method is called when button 3 poins is cliked from TeamA
     */
    public void bt_3pointsA(View view){
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }

    /**
     *  This method is called when button 2 poins is cliked from TeamA
     */
    public void bt_2pointsA(View view){
        scoreTeamA=scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }

    /**
     *  This method is called when button 1 poins is cliked from TeamA
     */
    public void bt_1pointA(View view){
        scoreTeamA=scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }

    /**
     *  This method is called when button 3 poins is cliked from TeamB
     */
    public void bt_3pointsB(View view){
        scoreTeamB=scoreTeamB+3;
        displayForTeamB(scoreTeamB);
    }

    /**
     *  This method is called when button 2 poins is cliked from TeamB
     */
    public void bt_2pointsB(View view){
        scoreTeamB=scoreTeamB+2;
        displayForTeamB(scoreTeamB);
    }

    /**
     *  This method is called when button 1 poins is cliked from TeamB
     */
    public void bt_1pointB(View view){
        scoreTeamB=scoreTeamB+1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given name of the Team A.
     */
    public void displayTeamA_name(String name) {
        TextView teamA_nameView = (TextView) findViewById(R.id.txt_TeamA_name);
        teamA_nameView.setText(String.valueOf(name));
    }

    /**
     * Displays the given name of the Team B.
     */
    public void displayTeamB_name(String name) {
        TextView teamB_nameView = (TextView) findViewById(R.id.txt_TeamB_name);
        teamB_nameView.setText(String.valueOf(name));
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
        scoreTeamA=0;
        scoreTeamB=0;
        TeamA_name="Team A";
        TeamB_name="Team B";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayTeamA_name(TeamA_name);
        displayTeamB_name(TeamB_name);
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

        Result_extended = String.format("Final Result:\n%s %d : %d %s", TeamA_name, scoreTeamA, scoreTeamB, TeamB_name);
        email_text = Result + "\n" + Result_extended;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Basketball_Results");
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
