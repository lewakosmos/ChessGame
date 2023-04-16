package Controller;

import Model.WhitePawn;
import View.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerAction {
    public void playerFirstPartTurn(){
        GamePanel gp = new GamePanel();
        for(JButton button : gp.getTilesList()){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    figureRecognition(button);
                    for(JButton secondPlaceButton : gp.getPossibleTilesToGoList()){
                        secondPlaceButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                figureRecognitionSecondPart(secondPlaceButton);
                                button.setIcon(null);
                            }
                        });
                    }
                }
            });
        }
    }
    private void figureRecognition(JButton button){
        if(isItPawn(button)){
            WhitePawn wp = new WhitePawn();
            wp.moveAndAttack(button);
        }
    }
    private void figureRecognitionSecondPart(JButton button){
        WhitePawn wp = new WhitePawn();
        wp.secondPartOfTheTurn(button);
    }
    private boolean isItPawn(JButton button){
        boolean itsPawn = false;
        if(button.getText().substring(2).equals("whitePawn")){
            itsPawn = true;
        }
        return itsPawn;
    }
}
