package Controller;

import Model.WhitePiece.*;
import View.GamePanel;

import javax.swing.*;
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
                                gp.getPossibleTilesToGoList().clear();
                                playerFirstPartTurn();
                            }
                        });
                    }
                }
            });
        }
    }
    private void figureRecognition(JButton button){
        String piece = "";
        switch (button.getText().substring(2)){
            case "whitePawn":
                WhitePawn wPawn = new WhitePawn();
                wPawn.moveAndAttack(button);
                break;
            case "whiteRook":
                WhiteRook wRook = new WhiteRook();
                wRook.moveAndAttack(button);
                break;
            case "whiteKnight":
                WhiteKnight wKnight = new WhiteKnight();
                wKnight.moveAndAttack(button);
                break;
            case "whiteBishop":
                WhiteBishop wBishop = new WhiteBishop();
                wBishop.moveAndAttack(button);
                break;
            case "whiteQueen":
                WhiteQueen wQueen = new WhiteQueen();
                wQueen.moveAndAttack(button);
                break;
            default:
                WhiteKing wKing = new WhiteKing();
                wKing.moveAndAttack(button);
                break;
        }
    }
    private void figureRecognitionSecondPart(JButton button){
        WhitePawn wp = new WhitePawn();
        wp.secondPartOfTheTurn(button);
    }
}
