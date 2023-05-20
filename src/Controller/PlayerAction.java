package Controller;

import Model.WhitePiece.*;
import View.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerAction implements Action {
    private ArrayList<JButton> whitePiecesList;
    public void whitePiecesListCreator() {
        GamePanel gp = new GamePanel();
        whitePiecesList = new ArrayList<>();
        for (JButton button : gp.getTilesList()) {
            if (button.getText().startsWith("white", 2)) {
                whitePiecesList.add(button);
            }
        }
    }
    @Override
    public void firstPartTurn(){
        whitePiecesListCreator();
            for (JButton button : whitePiecesList) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        figureRecognition(button);
                        System.out.println("figureRecognition");
                    }
                });
            }
    }

    public void figureRecognition(JButton button){
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
    @Override
    public void secondPartTurn(){
        GamePanel gp = new GamePanel();
        for(JButton secondPlaceButton : gp.getPossiblePiecesListToGo()){
            secondPlaceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    piecePlaceSecondPart(secondPlaceButton);
                }
            });
        }
    }
    public void piecePlaceSecondPart(JButton button){
        WhitePawn wp = new WhitePawn();
        wp.secondPartOfTheTurn(button);
    }
}
