package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WhitePiecesIconsCreator implements IconCreator{
    private final String pawnIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whitePawn.png";
    //static path for whitePawn
    private final String rookIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteRook.png";
    //static path for whiteRook
    private final String knightIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKnight.png";
    //static path for whiteKnight
    private final String bishopIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteBishop.png";
    //static path for whiteBishop
    private final String queenIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteQueen.png";
    //static path for whiteQueen
    private final String kingIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKing.png";
    //static path for whiteKing
    @Override
    public void tilesIconsCreator(ArrayList<JButton> tilesList) {
        pawnIconCreator(tilesList);
        rookIconCreator(tilesList);
        knightIconCreator(tilesList);
        bishopIconCreator(tilesList);
        queenIconCreator(tilesList);
        kingIconCreator(tilesList);
    }
    //polymorphism
    @Override
    public void pawnIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2").contains(button.getText())){
                button.setText(button.getText() + "whitePawn");
                button.setIcon(iconCreator(pawnIconPath));
                button.setDisabledIcon(iconCreator(pawnIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void iconChecker(ArrayList<JButton> tilesList)
    {
        for(JButton button : tilesList)
        {
            if(button.getText().contains("whitePawn"))
            {
                button.setIcon(iconCreator(pawnIconPath));
            }
            else if(button.getText().contains("whiteRook"))
            {
                button.setIcon(iconCreator(rookIconPath));
            }
            else if(button.getText().contains("whiteKnight"))
            {
                button.setIcon(iconCreator(knightIconPath));
            }
            else if(button.getText().contains("whiteBishop"))
            {
                button.setIcon(iconCreator(bishopIconPath));
            }
            else if(button.getText().contains("whiteQueen"))
            {
                button.setIcon(iconCreator(queenIconPath));
            }
            else if(button.getText().contains("whiteKing"))
            {
                button.setIcon(iconCreator(kingIconPath));
            }
            else if(!button.getText().contains("black"))
            {
                button.setIcon(null);
            }
        }
    }
    //polymorphism
    @Override
    public void rookIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A1", "H1").contains(button.getText())){
                button.setText(button.getText() + "whiteRook");
                button.setIcon(iconCreator(rookIconPath));
                button.setDisabledIcon(iconCreator(rookIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void knightIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("B1", "G1").contains(button.getText())){
                button.setText(button.getText() + "whiteKnight");
                button.setIcon(iconCreator(knightIconPath));
                button.setDisabledIcon(iconCreator(knightIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void bishopIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("C1", "F1").contains(button.getText())){
                button.setText(button.getText() + "whiteBishop");
                button.setIcon(iconCreator(bishopIconPath));
                button.setDisabledIcon(iconCreator(bishopIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void queenIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("D1".contains(button.getText())){
                button.setText(button.getText() + "whiteQueen");
                button.setIcon(iconCreator(queenIconPath));
                button.setDisabledIcon(iconCreator(queenIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void kingIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("E1".contains(button.getText())){
                button.setText(button.getText() + "whiteKing");
                button.setIcon(iconCreator(kingIconPath));
                button.setDisabledIcon(iconCreator(kingIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public ImageIcon iconCreator(String str){
        ImageIcon tileImage = new ImageIcon(str);
        Image figure = tileImage.getImage();
        figure = figure.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        tileImage = new ImageIcon(figure);
        return tileImage;
    }
    //polymorphism
}
