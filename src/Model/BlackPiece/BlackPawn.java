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
        if(button.getText().contains("7") && button.getText().contains("blackPawn")){
            possibleTilesToRunOnFirstTurn(button);
        }
        else if(!button.getText().contains("7") && button.getText().contains("blackPawn")){
            possibleTilesToRun(button);
        }
        possibleTilesToAttack(button);
    }
    //if pawn haven't moved - 1 sub, else - 2 sub. And possible tiles to attack method
    private void possibleTilesToRunOnFirstTurn(JButton button){
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList())
        {
            if(tileButton.getText().equals(button.getText()))
            {
                tileButton.setText(tileButton.getText().substring(0, 2));
            }
        }
        button.setText(button.getText().substring(0, 2));
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(pawnNextPossibleStringPlace(button)) ||
                    (tileButton.getText().equals(pawnNextNextPossibleStringPlace(button))) &&
                            pawnNextPossibleStringPlace(button).length() == 2){
                tileButton.setBackground(Color.PINK);
                gp.getPossiblePiecesListToGo().add(tileButton);
            }
            else{
                tileButton.setEnabled(false);
                tileButton.setContentAreaFilled(false);
            }
        }
    }
    //if two forward tiles is not filled with figure, adds it to possibleTilesToGoList and paint in pink
    @Override
    public void possibleTilesToRun(JButton button) {
        GamePanel gp = new GamePanel();
        button.setText(button.getText().substring(0, 2));
        for(JButton tileButton : gp.getTilesList()){
            if(tileButton.getText().equals(pawnNextPossibleStringPlace(button))) {
                tileButton.setBackground(Color.PINK);
                gp.getPossiblePiecesListToGo().add(tileButton);
            }
            else
            {
                tileButton.setEnabled(false);
                tileButton.setContentAreaFilled(false);
            }
        }
    }
    //if tile is not filled with figure, adds it to possibleTilesToGoList and paint in pink
    private String pawnNextPossibleStringPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex - 1];
    }
    //return (string) name of next possible tile to go;
    private String pawnNextNextPossibleStringPlace(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return columnLetter + dc.getStringDeckArray()[stringIndex - 2];
    }
    //return (string) name of next next possible tile to go
    @Override
    public void possibleTilesToAttack(JButton button) {
        GamePanel gp = new GamePanel();
        for(JButton tileButton : gp.getTilesList()){
            if((leftSideToAttackException(tileButton, button) && !button.getText().contains("H"))||
                    (rightPieceToAttackException(tileButton, button)) && !button.getText().contains("A")){
                tileButton.setBackground(Color.CYAN);
                gp.getPossiblePiecesListToGo().add(tileButton);
            }
        }
    }
    //main method for attack with exceptions about placement and figures on deck
    private boolean leftSideToAttackException(JButton tileButton, JButton button){
        boolean firstOption = false;
        try {
            firstOption = tileButton.getText().substring(0, 2).equals(leftPieceToAttack(button));
        }catch (ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().startsWith("white", 2);
        return firstOption && secondOption;
    }
    // exception to attack on left if it placed on left column "A"
    private boolean rightPieceToAttackException(JButton tileButton, JButton button){
        boolean firstOption = false;
        try{
            firstOption = tileButton.getText().substring(0, 2).equals(rightPieceToAttack(button));
        }catch(ArrayIndexOutOfBoundsException ignored){}
        boolean secondOption = tileButton.getText().startsWith("white", 2);
        return firstOption && secondOption;
    }
    // exception to attack on right if it placed on left column "H"
    private String leftPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex - 1] + dc.getStringDeckArray()[stringIndex - 1];
    }
    // possible tile to attack (string) from left
    private String rightPieceToAttack(JButton button){
        DeckCreator dc = new DeckCreator();
        String columnLetter = button.getText().substring(0, 1);
        String numberString = button.getText().substring(1, 2);
        int columnIndex = Arrays.asList(dc.getColumnDeckArray()).indexOf(columnLetter);
        int stringIndex = Arrays.asList(dc.getStringDeckArray()).indexOf(numberString);
        return dc.getColumnDeckArray()[columnIndex + 1] + dc.getStringDeckArray()[stringIndex - 1];
    }
    // possible tile to attack (string) from right
    public void secondPartOfTheTurn(JButton button){

        //PlayerAction pa = new PlayerAction(); todo what?
        GamePanel gp = new GamePanel();
        BlackPiecesIconsCreator bpic = new BlackPiecesIconsCreator();
        if(gp.getPossiblePiecesListToGo().contains(button)){
            for(JButton tileButton : gp.getTilesList())
            {
                if(tileButton.getText().equals(button.getText()))
                {
                    tileButton.setText(tileButton.getText() + "blackPawn");
                }
            }
            button.setText(button.getText() + "blackPawn");
            bpic.iconChecker(gp.getTilesList());
        }
        gp.getTilesList().forEach(JButton -> JButton.setBackground(Color.WHITE));
        gp.getTilesList().forEach(JButton -> JButton.setEnabled(true));
        gp.getPossiblePiecesListToGo().clear();
        // pa.whitePiecesListCreator(); //todo not working
        // from first look - okay, but where we delete our existing tile icon?
        // in another class? Maybe!? Lets check
    }
}
