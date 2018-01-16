/**
 * Author: Dan Agustinus
 * Build Date: January 16, 2018
 */

package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /**
     * Initialized the variables for score and timeouts for both teams
     */
    int score_team_a = 0;
    int score_team_b = 0;
    int timeout_a = 3;
    int timeout_b = 3;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Reset Button for all
     */

    public void reset_score(View v){
        score_team_a = 0;
        score_team_b = 0;
        timeout_a = 3;
        timeout_b = 3;
        extra_invisible_a();
        extra_invisible_b();
        displayScoreA(score_team_a);
        displayScoreB(score_team_b);
        displayTimeOutA(timeout_a);
        displayTimeOutB(timeout_b);
    }

    /**
     * Start of Team A Java Methods
     */

    /**
     * Add touchdown to team A (6 pts) and make the initial buttons invisible to show the extra points options
     */
    public void touchdown_a(View v){
        score_team_a += 6;
        displayScoreA(score_team_a);
        extra_visible_a();
    }

    /**
     * Add the extra point (1 pt) to team A and trigger turn the extra points button off. If
     * all of the timeouts has been used, the timeout button will be invisible
     */
    public void extra_1_a(View v){
        score_team_a += 1;
        displayScoreA(score_team_a);
        extra_invisible_a();
        if (timeout_a < 1){
            timeout_invisible_a();
        }
    }

    /**
     * Add the 2 point conversion (2 pt) to team A and trigger the extra points button off. If
     * all of the timeouts has been used, the timeout button will be invisible
     */
    public void extra_2_a(View v){
        score_team_a += 2;
        displayScoreA(score_team_a);
        extra_invisible_a();
        if (timeout_a < 1){
            timeout_invisible_a();
        }
    }

    /**
     * Add 3 points to team A score
     */
    public void field_goal_a(View v){
        score_team_a += 3;
        displayScoreA(score_team_a);
    }

    /**
     * Cancel out the extra point and hide the extra point buttons and reveal the normal menu
     */
    public void extra_point_fail_a(View v){
        extra_invisible_a();
        if (timeout_a < 1){
            timeout_invisible_a();
        }
    }

    /**
     * Add 2 points for safety to team A
     */
    public void safety_a(View v){
        score_team_a += 2;
        displayScoreA(score_team_a);
        if (timeout_a < 1){
            timeout_invisible_a();
        }
    }

    /**
     * Subtract the timeout by 1 for team A. If there's no more timeouts, the button will disapear
     */
    public void timeout_a(View v){
        timeout_a -= 1;
        if (timeout_a <= 0) {
            timeout_invisible_a();
            timeout_a = 0;
        }
        displayTimeOutA(timeout_a);
    }

    /**
     * Method to turn on and off the buttons. This one is to turn on extra point options after TD
     */
    private void extra_visible_a(){
        TextView extraPoint = findViewById(R.id.extraPoint_a);
        TextView conversion = findViewById(R.id.conversion_a);
        TextView extra_failed = findViewById(R.id.extra_failed_a);
        TextView touchdown = findViewById(R.id.touchDown_a);
        TextView field_goal = findViewById(R.id.fieldGOal_a);
        TextView safety = findViewById(R.id.safety_a);
        TextView timeout = findViewById(R.id.timeout_button_a);
        extraPoint.setVisibility(View.VISIBLE);
        conversion.setVisibility(View.VISIBLE);
        extra_failed.setVisibility(View.VISIBLE);
        touchdown.setVisibility(View.INVISIBLE);
        field_goal.setVisibility(View.INVISIBLE);
        safety.setVisibility(View.INVISIBLE);
        timeout.setVisibility(View.INVISIBLE);
    }

    /**
     * Method to turn on and off the buttons. This one is to turn on extra point options OFF and
     * turn on the initial buttons again
     */
    private void extra_invisible_a(){
        TextView extraPoint = findViewById(R.id.extraPoint_a);
        TextView conversion = findViewById(R.id.conversion_a);
        TextView extra_failed = findViewById(R.id.extra_failed_a);
        TextView touchdown = findViewById(R.id.touchDown_a);
        TextView field_goal = findViewById(R.id.fieldGOal_a);
        TextView safety = findViewById(R.id.safety_a);
        TextView timeout = findViewById(R.id.timeout_button_a);
        extraPoint.setVisibility(View.INVISIBLE);
        conversion.setVisibility(View.INVISIBLE);
        extra_failed.setVisibility(View.INVISIBLE);
        touchdown.setVisibility(View.VISIBLE);
        field_goal.setVisibility(View.VISIBLE);
        safety.setVisibility(View.VISIBLE);
        timeout.setVisibility(View.VISIBLE);
    }

    /**
     * Turn off timeout for team A
     */
    private void timeout_invisible_a(){
        TextView timeout = findViewById(R.id.timeout_button_a);
        timeout.setVisibility(View.INVISIBLE);
    }

    /**
     * display score for team A
     */
    private void displayScoreA(int score){
        TextView ScoreTeamA = findViewById(R.id.scoreTeamA);
        ScoreTeamA.setText(String.valueOf(score));
    }

    /**
     * display timeouts for team A
     */
    private void displayTimeOutA(int timeout){
        TextView TimeoutA = findViewById(R.id.timeout_count_a);
        TimeoutA.setText(String.valueOf(timeout));
    }

    /**
     * Start of Team B Java Methods
     */

    /**
     * Add touchdown to team B (6 pts) and make the initial buttons invisible to show the extra points options
     */
    public void touchdown_b(View v){
        score_team_b += 6;
        displayScoreB(score_team_b);
        extra_visible_b();
    }

    /**
     * Add the extra point (1 pt) to team B and trigger the extra points button off. If
     * all of the timeouts has been used, the timeout button will be invisible
     */
    public void extra_1_b(View v){
        score_team_b += 1;
        displayScoreB(score_team_b);
        extra_invisible_b();
        if (timeout_b < 1){
            timeout_invisible_b();
        }
    }

    /**
     * Add the 2 point conversion (2 pt) to team B and trigger the extra points button off. If
     * all of the timeouts has been used, the timeout button will be invisible
     */
    public void extra_2_b(View v){
        score_team_b += 2;
        displayScoreB(score_team_b);
        extra_invisible_b();
        if (timeout_b < 1){
            timeout_invisible_b();
        }
    }

    /**
     * Add 3 points to team B score
     */
    public void field_goal_b(View v){
        score_team_b += 3;
        displayScoreB(score_team_b);
    }

    /**
     * Cancel out the extra point and hide the extra point buttons and reveal the normal menu
     */
    public void extra_point_fail_b(View v){
        extra_invisible_b();
        if (timeout_b < 1){
            timeout_invisible_b();
        }
    }

    /**
     * Add 2 points for safety to team B
     */
    public void safety_b(View v){
        score_team_b += 2;
        displayScoreB(score_team_b);
    }

    /**
     * Subtract the timeout by 1 for team B. If there's no more timeouts, the button will disapear
     */
    public void timeout_b(View v){
        timeout_b -= 1;
        if (timeout_b <= 0) {
            timeout_invisible_b();
            timeout_b = 0;
        }
        displayTimeOutB(timeout_b);
    }

    /**
     * Method to turn on and off the buttons. This one is to turn on extra point options after TD
     */
    private void extra_visible_b(){
        TextView extraPoint = findViewById(R.id.extraPoint_b);
        TextView conversion = findViewById(R.id.conversion_b);
        TextView extra_failed = findViewById(R.id.extra_failed_b);
        TextView touchdown = findViewById(R.id.touchDown_b);
        TextView field_goal = findViewById(R.id.fieldGOal_b);
        TextView safety = findViewById(R.id.safety_b);
        TextView timeout = findViewById(R.id.timeout_button_b);
        extraPoint.setVisibility(View.VISIBLE);
        conversion.setVisibility(View.VISIBLE);
        extra_failed.setVisibility(View.VISIBLE);
        touchdown.setVisibility(View.INVISIBLE);
        field_goal.setVisibility(View.INVISIBLE);
        safety.setVisibility(View.INVISIBLE);
        timeout.setVisibility(View.INVISIBLE);
    }

    /**
     * Method to turn on and off the buttons. This one is to turn on extra point options OFF and
     * turn on the initial buttons again
     */
    private void extra_invisible_b(){
        TextView extraPoint = findViewById(R.id.extraPoint_b);
        TextView conversion = findViewById(R.id.conversion_b);
        TextView extra_failed = findViewById(R.id.extra_failed_b);
        TextView touchdown = findViewById(R.id.touchDown_b);
        TextView field_goal = findViewById(R.id.fieldGOal_b);
        TextView safety = findViewById(R.id.safety_b);
        TextView timeout = findViewById(R.id.timeout_button_b);
        extraPoint.setVisibility(View.INVISIBLE);
        conversion.setVisibility(View.INVISIBLE);
        extra_failed.setVisibility(View.INVISIBLE);
        touchdown.setVisibility(View.VISIBLE);
        field_goal.setVisibility(View.VISIBLE);
        safety.setVisibility(View.VISIBLE);
        timeout.setVisibility(View.VISIBLE);
    }

    /**
     * Turn off timeout for team A
     */
    private void timeout_invisible_b(){
        TextView timeout = findViewById(R.id.timeout_button_b);
        timeout.setVisibility(View.INVISIBLE);
    }

    /**
     * display score for team A
     */
    private void displayScoreB(int score){
        TextView ScoreTeamA = findViewById(R.id.scoreTeamB);
        ScoreTeamA.setText(String.valueOf(score));
    }

    /**
     * display timeouts for team A
     */
    private void displayTimeOutB(int timeout){
        TextView TimeoutA = findViewById(R.id.timeout_count_b);
        TimeoutA.setText(String.valueOf(timeout));
    }
}
