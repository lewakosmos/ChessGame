package Controller;

import Model.BlackPiece.*;
import View.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OpponentAction implements Action {
    private ArrayList<JButton> blackPiecesListCreator(){
        GamePanel gp = new GamePanel();
        ArrayList<JButton> blackPiecesList = new ArrayList<>();
        for(JButton button : gp.getTilesList()){
            if(button.getText().startsWith("black", 2)){
                blackPiecesList.add(button);
            }
        }
        return blackPiecesList;
     }
    @Override
    public void firstPartTurn() {
        for(JButton button : blackPiecesListCreator()){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    figureRecognition(button);
                }
            });
        }
    }

    @Override
    public void secondPartTurn() {
        PlayerAction pa = new PlayerAction();
        GamePanel gp = new GamePanel();
        for(JButton secondPlaceButton : gp.getPossiblePiecesListToGo()){
            secondPlaceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    piecePlaceSecondPart(secondPlaceButton);
                    pa.firstPartTurn();
                }
            });
        }
    }

    @Override
    public void figureRecognition(JButton button) {
        switch (button.getText().substring(2)){
            case "blackPawn":
                BlackPawn bPawn = new BlackPawn();
                bPawn.moveAndAttack(button);
                break;
            case "blackRook":
                BlackRook bRook = new BlackRook();
                bRook.moveAndAttack(button);
                break;
            case "blackKnight":
                BlackKnight wKnight = new BlackKnight();
                wKnight.moveAndAttack(button);
                break;
            case "blackBishop":
                BlackBishop bBishop = new BlackBishop();
                bBishop.moveAndAttack(button);
                break;
            case "blackQueen":
                BlackQueen bQueen = new BlackQueen();
                bQueen.moveAndAttack(button);
                break;
            default:
                BlackKing bKing = new BlackKing();
                bKing.moveAndAttack(button);
                break;
        }
    }

    @Override
    public void piecePlaceSecondPart(JButton button) {
        BlackPawn bp = new BlackPawn();
        bp.secondPartOfTheTurn(button);
    }
}