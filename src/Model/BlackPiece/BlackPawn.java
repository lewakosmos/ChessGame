package Model.BlackPiece;

import Model.DeckCreator;
import Model.Piece;
import View.BlackPiecesIconsCreator;
import View.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BlackPawn implements Piece {
    @Override
    public void moveAndAttack(JButton button) {
        if(button.getText().charAt(1) == '7' && button.getText().substring(2).equals("blackPawn")){
            firstTurnPossibleTilesToRun(button);
        }
        else {
            possibleTilesToRun(button);
        }
        possibleTilesToAttack(button);
    }
    public void firstTurnPossibleTilesToRun(JButton button){
        GamePanel gp = new GamePanel();
        button.setText(button.getText().substring(0, 2));
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(buttonNextPlace(button)) ||
                    tileButton.getText().equals(buttonNextNextPlace(button))){
                tileButton.setBackground(Color.PINK);
                gp.getPossibleBlackPiecesListToGo().add(tileButton);
            }
            else{
                tileButton.setEnabled(false);
            }
        }
    }

    @Override
    public void possibleTilesToRun(JButton button) {
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(buttonNextPlace(button))){
                tileButton.setBackground(Color.PINK);
                gp.getPossibleBlackPiecesListToGo().add(tileButton);
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
        return columnLetter + dc.getStringDeckArray()[stringIndex - 1];
    }
    private String buttonNextNextPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex - 2];
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
        boolean firstOption = false;
        try{
            firstOption = tileButton.getText().substring(0, 2).equals(leftPieceToAttack(button));
        }catch(ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().charAt(0) != 'A';
        boolean thirdOption = tileButton.getText().startsWith("white", 2);
        return firstOption && secondOption && thirdOption;
    }
    private boolean rightPieceToAttackException(JButton tileButton, JButton button){
        boolean firstOption = false;
        try{
            firstOption = tileButton.getText().substring(0, 2).equals(rightPieceToAttack(button));
        }catch(ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().charAt(0) != 'H';
        boolean thirdOption = tileButton.getText().startsWith("white", 2);
        return firstOption && secondOption && thirdOption;
    }
    private String leftPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex - 1] + dc.getStringDeckArray()[stringIndex - 1];
    }
    private String rightPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex + 1] + dc.getStringDeckArray()[stringIndex - 1];
    }
    public void secondPartOfTheTurn(JButton button){
        GamePanel gp = new GamePanel();
        BlackPiecesIconsCreator bpic = new BlackPiecesIconsCreator();
        if(gp.getPossibleBlackPiecesListToGo().contains(button)){
            button.setIcon(bpic.iconCreator(bpic.getPawnIconPath()));
            button.setDisabledIcon(bpic.iconCreator(bpic.getPawnIconPath()));
            button.setText(button.getText() + "blackPawn");
        }
        gp.getTilesList().forEach(JButton -> JButton.setBackground(Color.WHITE));
        gp.getTilesList().forEach(JButton -> JButton.setEnabled(true));
        gp.getPossibleBlackPiecesListToGo().clear();
        //repaint blackPiecesList
    }
}
