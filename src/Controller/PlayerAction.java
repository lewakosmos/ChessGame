package Controller;

import Model.WhitePawn;
import View.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerAction {
    public void playerTurn(){
        GamePanel gp = new GamePanel();
        for(JButton button : gp.getTilesList()){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    figureRecognition(button);

                }
            });
        }
    }
    private void figureRecognition(JButton button){
        if(isItPawn(button)){
            WhitePawn wp = new WhitePawn();
            wp.firstTurnPossibleTilesToGo(button);
        }
    }
    private boolean isItPawn(JButton button){
        boolean itsPawn = false;
        if(button.getText().substring(2).equals("whitePawn")){
            itsPawn = true;
            button.setBackground(Color.RED);
        }
        return itsPawn;
    }
}
