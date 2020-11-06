package com.manuelvalenzuelajr.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static String LOG = MainActivity.class.getName();
      private SudokuGames sg;
      private int [][] grid;
      private int [][] result;
      private int [][] currentGame;
      private Button resolveButton;
      private Button newGameButton;
      private EditText[][]casillas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        actions();
        GameCreator();

    }
    private void initViews(){
        resolveButton=findViewById(R.id.resolve);
        newGameButton=findViewById(R.id.newGame);
        grid= new int[9][9];
        result= new int[9][9];
        casillas=new EditText[9][9];
        casillas[0][0]=findViewById(R.id.casilla1_1);
        casillas[0][1]=findViewById(R.id.casilla1_2);
        casillas[0][2]=findViewById(R.id.casilla1_3);
        casillas[0][3]=findViewById(R.id.casilla1_4);
        casillas[0][4]=findViewById(R.id.casilla1_5);
        casillas[0][5]=findViewById(R.id.casilla1_6);
        casillas[0][6]=findViewById(R.id.casilla1_7);
        casillas[0][7]=findViewById(R.id.casilla1_8);
        casillas[0][8]=findViewById(R.id.casilla1_9);
        casillas[1][0]=findViewById(R.id.casilla2_1);
        casillas[1][1]=findViewById(R.id.casilla2_2);
        casillas[1][2]=findViewById(R.id.casilla2_3);
        casillas[1][3]=findViewById(R.id.casilla2_4);
        casillas[1][4]=findViewById(R.id.casilla2_5);
        casillas[1][5]=findViewById(R.id.casilla2_6);
        casillas[1][6]=findViewById(R.id.casilla2_7);
        casillas[1][7]=findViewById(R.id.casilla2_8);
        casillas[1][8]=findViewById(R.id.casilla2_9);
        casillas[2][0]=findViewById(R.id.casilla3_1);
        casillas[2][1]=findViewById(R.id.casilla3_2);
        casillas[2][2]=findViewById(R.id.casilla3_3);
        casillas[2][3]=findViewById(R.id.casilla3_4);
        casillas[2][4]=findViewById(R.id.casilla3_5);
        casillas[2][5]=findViewById(R.id.casilla3_6);
        casillas[2][6]=findViewById(R.id.casilla3_7);
        casillas[2][7]=findViewById(R.id.casilla3_8);
        casillas[2][8]=findViewById(R.id.casilla3_9);
        casillas[3][0]=findViewById(R.id.casilla4_1);
        casillas[3][1]=findViewById(R.id.casilla4_2);
        casillas[3][2]=findViewById(R.id.casilla4_3);
        casillas[3][3]=findViewById(R.id.casilla4_4);
        casillas[3][4]=findViewById(R.id.casilla4_5);
        casillas[3][5]=findViewById(R.id.casilla4_6);
        casillas[3][6]=findViewById(R.id.casilla4_7);
        casillas[3][7]=findViewById(R.id.casilla4_8);
        casillas[3][8]=findViewById(R.id.casilla4_9);
        casillas[4][0]=findViewById(R.id.casilla5_1);
        casillas[4][1]=findViewById(R.id.casilla5_2);
        casillas[4][2]=findViewById(R.id.casilla5_3);
        casillas[4][3]=findViewById(R.id.casilla5_4);
        casillas[4][4]=findViewById(R.id.casilla5_5);
        casillas[4][5]=findViewById(R.id.casilla5_6);
        casillas[4][6]=findViewById(R.id.casilla5_7);
        casillas[4][7]=findViewById(R.id.casilla5_8);
        casillas[4][8]=findViewById(R.id.casilla5_9);
        casillas[5][0]=findViewById(R.id.casilla6_1);
        casillas[5][1]=findViewById(R.id.casilla6_2);
        casillas[5][2]=findViewById(R.id.casilla6_3);
        casillas[5][3]=findViewById(R.id.casilla6_4);
        casillas[5][4]=findViewById(R.id.casilla6_5);
        casillas[5][5]=findViewById(R.id.casilla6_6);
        casillas[5][6]=findViewById(R.id.casilla6_7);
        casillas[5][7]=findViewById(R.id.casilla6_8);
        casillas[5][8]=findViewById(R.id.casilla6_9);
        casillas[6][0]=findViewById(R.id.casilla7_1);
        casillas[6][1]=findViewById(R.id.casilla7_2);
        casillas[6][2]=findViewById(R.id.casilla7_3);
        casillas[6][3]=findViewById(R.id.casilla7_4);
        casillas[6][4]=findViewById(R.id.casilla7_5);
        casillas[6][5]=findViewById(R.id.casilla7_6);
        casillas[6][6]=findViewById(R.id.casilla7_7);
        casillas[6][7]=findViewById(R.id.casilla7_8);
        casillas[6][8]=findViewById(R.id.casilla7_9);
        casillas[7][0]=findViewById(R.id.casilla8_1);
        casillas[7][1]=findViewById(R.id.casilla8_2);
        casillas[7][2]=findViewById(R.id.casilla8_3);
        casillas[7][3]=findViewById(R.id.casilla8_4);
        casillas[7][4]=findViewById(R.id.casilla8_5);
        casillas[7][5]=findViewById(R.id.casilla8_6);
        casillas[7][6]=findViewById(R.id.casilla8_7);
        casillas[7][7]=findViewById(R.id.casilla8_8);
        casillas[7][8]=findViewById(R.id.casilla8_9);
        casillas[8][0]=findViewById(R.id.casilla9_1);
        casillas[8][1]=findViewById(R.id.casilla9_2);
        casillas[8][2]=findViewById(R.id.casilla9_3);
        casillas[8][3]=findViewById(R.id.casilla9_4);
        casillas[8][4]=findViewById(R.id.casilla9_5);
        casillas[8][5]=findViewById(R.id.casilla9_6);
        casillas[8][6]=findViewById(R.id.casilla9_7);
        casillas[8][7]=findViewById(R.id.casilla9_8);
        casillas[8][8]=findViewById(R.id.casilla9_9);
    }
  private void actions(){
     resolveButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             result=currentGame;
             if (solveSudoku(result,9)){
                 print(result,9);
             }
             for (int i=0; i<9; i++){
                 for (int j=0; j<9;j++){
                     String s= casillas[i][j].getText().toString().trim();
                     int number;
                     if (s.equals("")){
                        number = 0;
                        casillas[i][j].setText("0");
                     }else{
                         number= Integer.parseInt(s);
                     }
                     grid[i][j]=number;
                 }
             }
             compareResults(result,grid);
         }
     });
     newGameButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
              restart(MainActivity.this);
         }
     });
    }
  private void compareResults(int result[][], int grid[][]){
        int cont=0;
        for (int i=0;i<9;i++){
            for(int j=0 ; j<9;j++ ){
                casillas[i][j].setBackgroundColor(getResources().getColor(R.color.white));
                if (grid[i][j] != result[i][j]){
                    cont++;
                    casillas[i][j].setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        }
        if (cont == 0){
            Toast.makeText(MainActivity.this,"El juego ha sido completado correctamente",
                    Toast.LENGTH_SHORT).show();
            resolveButton.setVisibility(View.GONE);
        }

    }
    private void restart(Activity actividad){
        Intent intent=new Intent();
        intent.setClass(actividad, actividad.getClass());
        actividad.startActivity(intent);
        actividad.finish();
    }
  private void GameCreator(){
        sg= new SudokuGames();
         currentGame=sg.getGame1();
      for (int i=0; i<9; i++){
          for (int j=0; j<9;j++){
              String number= String.valueOf(currentGame[i][j]);
              casillas[i][j].setText(number);
              if (currentGame[i][j] != 0) {casillas[i][j].setFocusable(false);}

          }
      }

  }
    private boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    private void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }
}