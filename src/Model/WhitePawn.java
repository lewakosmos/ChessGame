package Model;

import View.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class WhitePawn implements Piece {
    @Override
    public void moveAndAttack(JButton button) {
        if(button.getText().charAt(1) == '2'){
            firstTurnPossibleTilesToGo(button);
        }
        else{
            possibleTilesToRun(button);
        }
        possibleTilesToAttack(button);
    }
    public void firstTurnPossibleTilesToGo(JButton button){
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(buttonNextPlace(button)) ||
                    tileButton.getText().equals(buttonNextNextPlace(button))){
                tileButton.setBackground(Color.PINK);
            }
            else{
                tileButton.setEnabled(false);
            }
        }
    }
    private String buttonNextPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex + 1];
    }
    private String buttonNextNextPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex + 2];
    }
    @Override
    public void possibleTilesToRun(JButton button) {
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(buttonNextPlace(button))){
                tileButton.setBackground(Color.PINK);
            }
            else{
                tileButton.setEnabled(false);
            }
        }
    }
    @Override
    public void possibleTilesToAttack(JButton button) {
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if(leftPieceToAttackException(tileButton, button) ||
                    rightPieceToAttackException(tileButton, button)){
                tileButton.setBackground(Color.CYAN);
            }
        }
    }
    private boolean leftPieceToAttackException(JButton tileButton, JButton button){
        return tileButton.getText().substring(0, 2).equals(leftPieceToAttack(button)) &&
                tileButton.getText().charAt(0) != 'A' &&
                tileButton.getText().startsWith("black", 2);
    }
    private boolean rightPieceToAttackException(JButton tileButton, JButton button){
        return tileButton.getText().substring(0, 2).equals(rightPieceToAttack(button)) &&
                tileButton.getText().charAt(0) != 'H' &&
                tileButton.getText().startsWith("black", 2);
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
}
