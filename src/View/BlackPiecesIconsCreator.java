package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackPiecesIconsCreator implements IconCreator{
    private final String pawnIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackPawn.png";
    //static path for blackPawn
    private final String rookIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackRook.png";
    //static path for blackRook
    private final String knightIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKnight.png";
    //static path for blackKnight
    private final String bishopIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackBishop.png";
    //static path for blackBishop
    private final String queenIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackQueen.png";
    //static path for blackQueen
    private final String kingIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKing.png";
    //static path for blackKing
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
            if(Arrays.asList("A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7").contains(button.getText())){
                button.setText(button.getText() + "blackPawn");
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
            if(button.getText().contains("blackPawn"))
            {
                button.setIcon(iconCreator(pawnIconPath));
            }
            else if(button.getText().contains("blackRook"))
            {
                button.setIcon(iconCreator(rookIconPath));
            }
            else if(button.getText().contains("blackKnight"))
            {
                button.setIcon(iconCreator(knightIconPath));
            }
            else if(button.getText().contains("blackBishop"))
            {
                button.setIcon(iconCreator(bishopIconPath));
            }
            else if(button.getText().contains("blackQueen"))
            {
                button.setIcon(iconCreator(queenIconPath));
            }
            else if(button.getText().contains("blackKing"))
            {
                button.setIcon(iconCreator(kingIconPath));
            }
            else if(!button.getText().contains("white"))
            {
                button.setIcon(null);
            }
        }
    }
    //polymorphism
    @Override
    public void rookIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A8", "H8").contains(button.getText())){
                button.setText(button.getText() + "blackRook");
                button.setIcon(iconCreator(rookIconPath));
                button.setDisabledIcon(iconCreator(rookIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void knightIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("B8", "G8").contains(button.getText())){
                button.setText(button.getText() + "blackKnight");
                button.setIcon(iconCreator(knightIconPath));
                button.setDisabledIcon(iconCreator(knightIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void bishopIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("C8", "F8").contains(button.getText())){
                button.setText(button.getText() + "blackBishop");
                button.setIcon(iconCreator(bishopIconPath));
                button.setDisabledIcon(iconCreator(bishopIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void queenIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("D8".contains(button.getText())){
                button.setText(button.getText() + "blackQueen");
                button.setIcon(iconCreator(queenIconPath));
                button.setDisabledIcon(iconCreator(queenIconPath));
            }
        }
    }
    //polymorphism
    @Override
    public void kingIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("E8".contains(button.getText())){
                button.setText(button.getText() + "blackKing");
                button.setIcon(iconCreator(kingIconPath));
                button.setDisabledIcon(iconCreator(kingIconPath));
            }
        }
    }
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
