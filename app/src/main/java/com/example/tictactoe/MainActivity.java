package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, restart;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextView player1, player2, pointx, pointo;
    View row1, row2, row3, col1, col2, col3, cross1, cross2;
    int flag = 0;
    int count = 0;
    int win_count_x, win_count_o = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        restart = findViewById(R.id.restart_btn);
        pointx = findViewById(R.id.player1_point);
        pointo = findViewById(R.id.player2_point);
        row1 = findViewById(R.id.row1_win);
        row2 = findViewById(R.id.row2_win);
        row3 = findViewById(R.id.row3_win);
        col1 = findViewById(R.id.column1_win);
        col2 = findViewById(R.id.column2_win);
        col3 = findViewById(R.id.column3_win);
        cross1 = findViewById(R.id.cross1_win);
        cross2 = findViewById(R.id.cross2_win);
//        btn1.setBackgroundResource(R.drawable.start_drawable_bg);
//        btn2 = findViewById(R.id.button2);
//        btn3 = findViewById(R.id.button3);
//        btn4 = findViewById(R.id.button4);
//        btn5 = findViewById(R.id.button5);
//        btn6 = findViewById(R.id.button6);
//        btn7 = findViewById(R.id.button7);
//        btn8 = findViewById(R.id.button8);
//        btn9 = findViewById(R.id.button9);
    }

    public void winningLogic(){
        btn1.setClickable(false);
        btn2.setClickable(false);
        btn3.setClickable(false);
        btn4.setClickable(false);
        btn5.setClickable(false);
        btn6.setClickable(false);
        btn7.setClickable(false);
        btn8.setClickable(false);
        btn9.setClickable(false);

//        if (win_count == 0){
//            if (flag == 0) {
//                pointo.setText("Points : 1");
//                winner.setText("O Won");
//            } else if (flag == 1) {
//                pointx.setText("Points : 1");
//                winner.setText("X Won");
//            }
//        }else {
            if (flag == 0) {
                win_count_o++;
                pointo.setText("Points : "+ win_count_o);
                dialogBox(MainActivity.this, "O Won");
          //      winner.setText("O Won");
            } else if (flag == 1) {
                win_count_x++;
                pointx.setText("Points : "+ win_count_x);
                dialogBox(MainActivity.this, "X Won");
         //       winner.setText("X Won");
            }
//        }
    }

    public void dialogBox(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Victory!!");
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    public void playStart(View view) {
        Button btnCurrent = (Button) view;
        if (btnCurrent.getText().toString().equals(""))
        {
            count++;
            if (flag == 0) {
                btnCurrent.setText("X");
                btnCurrent.setBackgroundColor(Color.CYAN);
             //   btnCurrent.setBackgroundColor(getResources().getColor(R.color.teal_200));
                flag = 1;
            } else {
                btnCurrent.setText("O");
                btnCurrent.setBackgroundColor(Color.YELLOW);
             //   btnCurrent.setBackgroundResource(R.drawable.o_drawable_bg);
             //   btnCurrent.setBackgroundColor(getResources().getColor(R.color.purple_300));
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (!b1.isEmpty() && b1.equals(b2) && b2.equals(b3)) {
                    //  winner.setVisibility(View.VISIBLE);
                    col1.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b4.isEmpty() && b4.equals(b5) && b5.equals(b6)) {
                    //  winner.setVisibility(View.VISIBLE);
                    col2.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b7.isEmpty() && b7.equals(b8) && b8.equals(b9)) {
                    //  winner.setVisibility(View.VISIBLE);
                    col3.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b1.isEmpty() && b1.equals(b4) && b4.equals(b7)) {
                    // winner.setVisibility(View.VISIBLE);
                    row1.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b2.isEmpty() && b2.equals(b5) && b5.equals(b8)) {
                    // winner.setVisibility(View.VISIBLE);
                    row2.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b3.isEmpty() && b3.equals(b6) && b6.equals(b9)) {
                    //winner.setVisibility(View.VISIBLE);
                    row3.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b1.isEmpty() && b1.equals(b5) && b5.equals(b9)) {
                    //winner.setVisibility(View.VISIBLE);
                    cross1.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (!b3.isEmpty() && b3.equals(b5) && b5.equals(b7)) {
                    //winner.setVisibility(View.VISIBLE);
                    cross2.setVisibility(View.VISIBLE);
                    winningLogic();
                } else if (count == 9) {
                    dialogBox(MainActivity.this, "Match Is Drawn");
                }
            }
        }
    }

    public void restartGame(View view) {
        count = 0;
        flag = 0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);
        row1.setVisibility(View.INVISIBLE);
        row2.setVisibility(View.INVISIBLE);
        row3.setVisibility(View.INVISIBLE);
        col1.setVisibility(View.INVISIBLE);
        col2.setVisibility(View.INVISIBLE);
        col3.setVisibility(View.INVISIBLE);
        cross1.setVisibility(View.INVISIBLE);
        cross2.setVisibility(View.INVISIBLE);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);
    }
}