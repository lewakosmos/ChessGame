package Model.WhitePiece;

import Controller.PlayerAction;
import Model.DeckCreator;
import Model.Piece;
import View.GamePanel;
import View.WhitePiecesIconsCreator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class WhitePawn implements Piece {
    @Override
    public void moveAndAttack(JButton button) {
        if(button.getText().charAt(1) == '2' && button.getText().substring(2).equals("whitePawn")){
            possibleTilesToRunOnFirstTurn(button);
        }
        else{
            possibleTilesToRun(button);
        }
        possibleTilesToAttack(button);
    }
    private void possibleTilesToRunOnFirstTurn(JButton button){
        GamePanel gp = new GamePanel();
        button.setText(button.getText().substring(0, 2));
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(pawnNextPossibleStringPlace(button)) ||
                    tileButton.getText().equals(pawnNextNextPossibleStringPlace(button))){
                tileButton.setBackground(Color.PINK);
                gp.getPossibleWhitePiecesListToGo().add(tileButton);
            }
            else{
                tileButton.setEnabled(false);
            }
        }
    }
    @Override
    public void possibleTilesToRun(JButton button) {
        GamePanel gp = new GamePanel();
        button.setText(button.getText().substring(0, 2));
        for(JButton tileButton : gp.getTilesList()){
            if (tileButton.getText().equals(pawnNextPossibleStringPlace(button))) {
                tileButton.setBackground(Color.PINK);
                gp.getPossibleWhitePiecesListToGo().add(tileButton);
            }
            else{
                tileButton.setEnabled(false);
                tileButton.setContentAreaFilled(false);
                }
            }
        }
    private String pawnNextPossibleStringPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex + 1];
    }
    private String pawnNextNextPossibleStringPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex + 2];
    }
    @Override
    public void possibleTilesToAttack(JButton button) {
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if(leftSideToAttackException(tileButton, button) ||
                    rightPieceToAttackException(tileButton, button)){
                tileButton.setBackground(Color.CYAN);
            }
        }
    }
    private boolean leftSideToAttackException(JButton tileButton, JButton button){
        boolean firstOption = false;
        try {
            firstOption = tileButton.getText().substring(0, 2).equals(leftPieceToAttack(button));
        }catch (ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().charAt(0) != 'A';
        boolean thirdOption = tileButton.getText().startsWith("black", 2);
        return firstOption && secondOption && thirdOption;
    }
    private boolean rightPieceToAttackException(JButton tileButton, JButton button){
        boolean firstOption = false;
        try{
            firstOption = tileButton.getText().substring(0, 2).equals(rightPieceToAttack(button));
        }catch(ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().charAt(0) != 'H';
        boolean thirdOption = tileButton.getText().startsWith("black", 2);
        return firstOption && secondOption && thirdOption;
    }
    private String leftPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex - 1] + dc.getStringDeckArray()[stringIndex + 1];
    }
    private String rightPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex + 1] + dc.getStringDeckArray()[stringIndex + 1];
    }
    public void secondPartOfTheTurn(JButton button){
        PlayerAction pa = new PlayerAction();
        GamePanel gp = new GamePanel();
        WhitePiecesIconsCreator wpic = new WhitePiecesIconsCreator();
        if(gp.getPossibleWhitePiecesListToGo().contains(button)){
            button.setIcon(wpic.iconCreator(wpic.getPawnIconPath()));
            button.setDisabledIcon(wpic.iconCreator(wpic.getPawnIconPath()));
            button.setText(button.getText() + "whitePawn");
        }
        gp.getTilesList().forEach(JButton -> JButton.setBackground(Color.WHITE));
        gp.getTilesList().forEach(JButton -> JButton.setEnabled(true));
        gp.getPossibleWhitePiecesListToGo().clear();//todo maybe im wrong and we need only 1 list
        pa.whitePiecesListCreator(); //todo not working
    }
}
