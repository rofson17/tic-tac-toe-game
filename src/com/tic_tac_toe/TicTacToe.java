package com.tic_tac_toe;

//import classes
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//game class
class TicTacToe implements  ActionListener{
    //    private static Random random;
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel Title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textField=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1;

    TicTacToe(){
        //set the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Tic Tac Toe");
        ImageIcon image=new ImageIcon("src/com/tic_tac_toe/logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25, 225, 0));
        //set the font
        textField.setFont(new Font("Lucida Console", Font.PLAIN,57));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac toe");
        textField.setOpaque(true);

        Title_panel.setLayout(new BorderLayout());
        Title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0; i<9; ++i){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Courier New", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        Title_panel.add(textField);
        frame.add(Title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<9; ++i){
            if(e.getSource()==buttons[i]){
                if (player1){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(225, 0, 0));
                        buttons[i].setText("X");
                        player1=false;
                        textField.setText("O turn");
                        cheak();
                    }
                }else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 225));
                        buttons[i].setText("O");
                        player1 = true;
                        textField.setText("X turn");
                        cheak();
                    }
                }
            }
        }
    }

    public  void   firstTurn(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1 = true;
            textField.setText("X turn");
        } else {
            player1 = false;
            textField.setText("O turn");
        }

    }
    //cheak who wins (x or 0)
    public  void cheak(){
        //if x wins
        if((buttons[0].getText()=="X" )&& (buttons[1].getText()=="X") &&  (buttons[2].getText()=="X") ){
            xWin(0, 1, 2);
        }
        if((buttons[3].getText()=="X" )&& (buttons[4].getText()=="X") &&  (buttons[5].getText()=="X") ){
            xWin(3, 4, 5);
        }
        if((buttons[6].getText()=="X" )&& (buttons[7].getText()=="X") &&  (buttons[8].getText()=="X") ){
            xWin(6, 7, 8);
        }
        if((buttons[0].getText()=="X" )&& (buttons[3].getText()=="X") &&  (buttons[6].getText()=="X") ){
            xWin(0, 3, 6);
        }
        if((buttons[1].getText()=="X" )&& (buttons[4].getText()=="X") &&  (buttons[7].getText()=="X") ){
            xWin(1, 4, 7);
        }
        if((buttons[2].getText()=="X" )&& (buttons[5].getText()=="X") &&  (buttons[8].getText()=="X") ){
            xWin(2, 5, 8);
        } if((buttons[0].getText()=="X" )&& (buttons[4].getText()=="X") &&  (buttons[8].getText()=="X") ){
            xWin(0, 0, 8);
        } if((buttons[2].getText()=="X" )&& (buttons[4].getText()=="X") &&  (buttons[6].getText()=="X") ){
            xWin(2, 4, 6);
        }

        //if O wins
        if((buttons[0].getText()=="O" )&& (buttons[1].getText()=="O") &&  (buttons[2].getText()=="O") ){
            oWin(0, 1, 2);
        }
        if((buttons[3].getText()=="O" )&& (buttons[4].getText()=="O") &&  (buttons[5].getText()=="O") ){
            oWin(3, 4, 5);
        }
        if((buttons[6].getText()=="O" )&& (buttons[7].getText()=="O") &&  (buttons[8].getText()=="O") ){
            oWin(6, 7, 8);
        }
        if((buttons[0].getText()=="O" )&& (buttons[3].getText()=="O") &&  (buttons[6].getText()=="O") ){
            oWin(0, 3, 6);
        }
        if((buttons[1].getText()=="O" )&& (buttons[4].getText()=="O") &&  (buttons[7].getText()=="O") ){
            oWin(1, 4, 7);
        }
        if((buttons[2].getText()=="O" )&& (buttons[5].getText()=="O") &&  (buttons[8].getText()=="O") ){
            oWin(2, 5, 8);
        } if((buttons[0].getText()=="O" )&& (buttons[4].getText()=="O") &&  (buttons[8].getText()=="O") ){
            oWin(0, 4, 8);
        }
        if((buttons[2].getText()=="O" )&& (buttons[4].getText()=="O") &&  (buttons[6].getText()=="O") ){
            oWin(2, 4, 6);
        }

    }


    public void xWin(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0; i<9; ++i){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }
    public void oWin(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0; i<9; ++i){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}

