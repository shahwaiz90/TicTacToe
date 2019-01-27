package com.droidrank.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


//Ahmad Shahwaiz

public class MainActivity extends AppCompatActivity{



    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;
    int checkPlayer=0;
    int totalAttempts = 0;
    ArrayList<Integer> playerOneAttempts;
    ArrayList<Integer> playerTwoAttempts;

    private void restartGame(){
        checkPlayer = 0;
        totalAttempts = 0;
        result.setText("");
        enableAllButtons();
        playerTwoAttempts.clear();
        playerOneAttempts.clear();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneAttempts = new ArrayList<>();
        playerTwoAttempts = new ArrayList<>();

        block1 = (Button) findViewById(R.id.bt_block1);
        block2 = (Button) findViewById(R.id.bt_block2);
        block3 = (Button) findViewById(R.id.bt_block3);
        block4 = (Button) findViewById(R.id.bt_block4);
        block5 = (Button) findViewById(R.id.bt_block5);
        block6 = (Button) findViewById(R.id.bt_block6);
        block7 = (Button) findViewById(R.id.bt_block7);
        block8 = (Button) findViewById(R.id.bt_block8);
        block9 = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);

        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });

    }

    public void ButtonOneListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block1.setText("O");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 2) {
                    firstRule = firstRule+"2";
                } else if (playerOneAttempts.get(i) == 3) {
                    firstRule = firstRule + "3";
                } else if (playerOneAttempts.get(i) == 4) {
                    secondRule = secondRule + "4";
                } else if (playerOneAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                } else if (playerOneAttempts.get(i) == 5) {
                    thirdRule = thirdRule + "5";
                } else if (playerOneAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("23") || firstRule.contains("32")
                    ||secondRule.contains("74") || secondRule.contains("47")
                    ||  thirdRule.contains("95")|| thirdRule.contains("59") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
            playerOneAttempts.add(1);
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
        }else{
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            block1.setText("X");
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 2) {
                    firstRule = firstRule+"2";
                } else if (playerTwoAttempts.get(i) == 3) {
                    firstRule = firstRule + "3";
                } else if (playerTwoAttempts.get(i) == 4) {
                    secondRule = secondRule + "4";
                } else if (playerTwoAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                } else if (playerTwoAttempts.get(i) == 5) {
                    thirdRule = thirdRule + "5";
                } else if (playerTwoAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("23") || firstRule.contains("32")
                    ||secondRule.contains("74") || secondRule.contains("47")
                    ||  thirdRule.contains("95")|| thirdRule.contains("59") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(1);
        }
        checkPlayer++;
        block1.setEnabled(false);
    }

    public void ButtonTwoListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block2.setText("O");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerOneAttempts.get(i) == 3) {
                    firstRule = firstRule + "3";
                }
                else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerOneAttempts.get(i) == 8) {
                    secondRule = secondRule + "8";
                }
            }
            if(firstRule.contains("13") || firstRule.contains("31")
                    ||secondRule.contains("58") || secondRule.contains("85") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(2);
        }else{
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerTwoAttempts.get(i) == 3) {
                    firstRule = firstRule + "3";
                }
                else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerTwoAttempts.get(i) == 8) {
                    secondRule = secondRule + "8";
                }
            }
            if(firstRule.contains("13") || firstRule.contains("31")
                    ||secondRule.contains("58") || secondRule.contains("85") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(2);
            block2.setText("X");
        }
        block2.setEnabled(false);
        checkPlayer++;
    }

    public void ButtonThreeListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block3.setText("O");
            String lastAttempts = "";
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerOneAttempts.get(i) == 2) {
                    firstRule = firstRule + "2";
                }
                else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerOneAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                }
                else if (playerOneAttempts.get(i) == 6) {
                    thirdRule = thirdRule + "6";
                }
                else if (playerOneAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("12") || firstRule.contains("21")
                    ||secondRule.contains("57") || secondRule.contains("75")
                    ||thirdRule.contains("69") || thirdRule.contains("96")){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(3);
        }else{
            block3.setText("X");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerTwoAttempts.get(i) == 2) {
                    firstRule = firstRule + "2";
                }
                else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerTwoAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                }
                else if (playerTwoAttempts.get(i) == 6) {
                    thirdRule = thirdRule + "6";
                }
                else if (playerTwoAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("12") || firstRule.contains("21")
                    ||secondRule.contains("57") || secondRule.contains("75")
                    ||thirdRule.contains("69") || thirdRule.contains("96")){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(3);
        }

        block3.setEnabled(false);
        checkPlayer++;
    }

    public void ButtonFourListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block4.setText("O");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerOneAttempts.get(i) == 7) {
                    firstRule = firstRule + "7";
                }
                else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerOneAttempts.get(i) == 6) {
                    secondRule = secondRule + "6";
                }
            }
            if(firstRule.contains("17") || firstRule.contains("71")
                    ||secondRule.contains("56") || secondRule.contains("65") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(4);
        }else{
            block4.setText("X");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerTwoAttempts.get(i) == 7) {
                    firstRule = firstRule + "7";
                }
                else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                } else if (playerTwoAttempts.get(i) == 6) {
                    secondRule = secondRule + "6";
                }
            }
            if(firstRule.contains("17") || firstRule.contains("71")
                    ||secondRule.contains("56") || secondRule.contains("65") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(4);
        }

        block4.setEnabled(false);
        checkPlayer++;
    }

    public void ButtonFiveListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block5.setText("O");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 2) {
                    firstRule = firstRule+"2";
                } else if (playerOneAttempts.get(i) == 8) {
                    firstRule = firstRule + "8";
                }
                else if (playerOneAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerOneAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                }else if (playerOneAttempts.get(i) == 4) {
                    thirdRule = thirdRule + "4";
                }else if (playerOneAttempts.get(i) == 6) {
                    thirdRule = thirdRule + "6";
                }
            }
            if(firstRule.contains("46") || firstRule.contains("64")
                    ||secondRule.contains("37") || secondRule.contains("73")
                    ||thirdRule.contains("28") || thirdRule.contains("82") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(5);
        }else{
            block5.setText("X");
            String lastAttempts = "";

            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 2) {
                    firstRule = firstRule+"2";
                } else if (playerTwoAttempts.get(i) == 8) {
                    firstRule = firstRule + "8";
                }
                else if (playerTwoAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerTwoAttempts.get(i) == 7) {
                    secondRule = secondRule + "7";
                }else if (playerTwoAttempts.get(i) == 4) {
                    thirdRule = thirdRule + "4";
                }else if (playerTwoAttempts.get(i) == 6) {
                    thirdRule = thirdRule + "6";
                }
            }
            if(firstRule.contains("46") || firstRule.contains("64")
                    ||secondRule.contains("37") || secondRule.contains("73")
                    ||thirdRule.contains("28") || thirdRule.contains("82") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(5);
        }

        block5.setEnabled(false);
        checkPlayer++;
    }

    public void ButtonSixListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block6.setText("O");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 3) {
                    firstRule = firstRule+"3";
                } else if (playerOneAttempts.get(i) == 9) {
                    firstRule = firstRule + "9";
                }
                else if (playerOneAttempts.get(i) == 4) {
                    secondRule = secondRule + "4";
                } else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }
            }
            if(firstRule.contains("39") || firstRule.contains("93")
                    ||secondRule.contains("45") || secondRule.contains("54") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(6);
        }else{
            block6.setText("X");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 3) {
                    firstRule = firstRule+"3";
                } else if (playerTwoAttempts.get(i) == 9) {
                    firstRule = firstRule + "9";
                }
                else if (playerTwoAttempts.get(i) == 4) {
                    secondRule = secondRule + "4";
                } else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }
            }
            if(firstRule.contains("39") || firstRule.contains("93")
                    ||secondRule.contains("45") || secondRule.contains("54") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(6);
        }

        block6.setEnabled(false);
        checkPlayer++;
    }


    public void ButtonSevenListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block7.setText("O");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerOneAttempts.get(i) == 4) {
                    firstRule = firstRule + "4";
                }
                else if (playerOneAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }else if (playerOneAttempts.get(i) ==8) {
                    thirdRule = thirdRule + "8";
                } else if (playerOneAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("14") || firstRule.contains("41")
                    ||secondRule.contains("35") || secondRule.contains("53")
                    ||thirdRule.contains("89") || thirdRule.contains("98") ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(7);
        }else{
            block7.setText("X");
            String lastAttempts = "";
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerTwoAttempts.get(i) == 4) {
                    firstRule = firstRule + "4";
                }
                else if (playerTwoAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }else if (playerTwoAttempts.get(i) ==8) {
                    thirdRule = thirdRule + "8";
                } else if (playerTwoAttempts.get(i) == 9) {
                    thirdRule = thirdRule + "9";
                }
            }
            if(firstRule.contains("14") || firstRule.contains("41")
                    ||secondRule.contains("35") || secondRule.contains("53")
                    ||thirdRule.contains("89") || thirdRule.contains("98") ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(7);
        }

        block7.setEnabled(false);
        checkPlayer++;
    }
    public void ButtonEightListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block8.setText("O");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 7) {
                    firstRule =firstRule+"7";
                } else if (playerOneAttempts.get(i) == 9) {
                    firstRule = firstRule + "9";
                }
                else if (playerOneAttempts.get(i) == 2) {
                    secondRule = secondRule + "2";
                } else if (playerOneAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }
            }
            if(firstRule.contains("79") || firstRule.contains("97")
                    ||secondRule.contains("25") || secondRule.contains("52")  ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(8);
        }else{
            block8.setText("X");
            String firstRule = "";
            String secondRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 7) {
                    firstRule = firstRule+"7";
                } else if (playerTwoAttempts.get(i) == 9) {
                    firstRule = firstRule + "9";
                }
                else if (playerTwoAttempts.get(i) == 2) {
                    secondRule = secondRule + "2";
                } else if (playerTwoAttempts.get(i) == 5) {
                    secondRule = secondRule + "5";
                }
            }
            if(firstRule.contains("79") || firstRule.contains("97")
                    ||secondRule.contains("25") || secondRule.contains("52")  ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(8);
        }

        block8.setEnabled(false);
        checkPlayer++;
    }

    public void ButtonNineListener(View view) {
        totalAttempts++;
        if(checkPlayer%2 == 0){
            block9.setText("O");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";

            for(int i=0; i < playerOneAttempts.size(); i++) {
                if (playerOneAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerOneAttempts.get(i) == 5) {
                    firstRule = firstRule + "5";
                }
                else if (playerOneAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerOneAttempts.get(i) == 6) {
                    secondRule = secondRule + "6";
                }
                else if (playerOneAttempts.get(i) == 7) {
                    thirdRule = thirdRule + "7";
                } else if (playerOneAttempts.get(i) == 8) {
                    thirdRule = thirdRule + "8";
                }
            }
            if(firstRule.contains("15") || firstRule.contains("51")
                    ||secondRule.contains("36") || secondRule.contains("63")
                    ||thirdRule.contains("78") || thirdRule.contains("87")   ){
                result.setText(getString(R.string.player_1_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 1 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerOneAttempts.add(9);
        }else{
            block9.setText("X");
            String firstRule = "";
            String secondRule = "";
            String thirdRule = "";
            for(int i=0; i < playerTwoAttempts.size(); i++) {
                if (playerTwoAttempts.get(i) == 1) {
                    firstRule = firstRule+"1";
                } else if (playerTwoAttempts.get(i) == 5) {
                    firstRule = firstRule + "5";
                }
                else if (playerTwoAttempts.get(i) == 3) {
                    secondRule = secondRule + "3";
                } else if (playerTwoAttempts.get(i) == 6) {
                    secondRule = secondRule + "6";
                }
                else if (playerTwoAttempts.get(i) == 7) {
                    thirdRule = thirdRule + "7";
                } else if (playerTwoAttempts.get(i) == 8) {
                    thirdRule = thirdRule + "8";
                }
            }
            if(firstRule.contains("15") || firstRule.contains("51")
                    ||secondRule.contains("36") || secondRule.contains("63")
                    ||thirdRule.contains("78") || thirdRule.contains("87")   ){
                result.setText(getString(R.string.player_2_wins));
            }else if(totalAttempts == 9){
                result.setText(getString(R.string.draw));
            }
//            Toast.makeText(getApplicationContext(), "Player 2 Last Attempts: "+lastAttempts, Toast.LENGTH_SHORT).show();
            playerTwoAttempts.add(9);
        }

        block9.setEnabled(false);
        checkPlayer++;
    }

    private void enableAllButtons(){
        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");

        block1.setEnabled(true);
        block2.setEnabled(true);
        block3.setEnabled(true);
        block4.setEnabled(true);
        block5.setEnabled(true);
        block6.setEnabled(true);
        block7.setEnabled(true);
        block8.setEnabled(true);
        block9.setEnabled(true);
    }


}
