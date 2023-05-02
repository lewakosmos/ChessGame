package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WhitePiecesIconsCreator implements IconCreator{
    private final String pawnIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whitePawn.png";
    private final String rookIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteRook.png";
    private final String knightIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKnight.png";
    private final String bishopIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteBishop.png";
    private final String queenIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteQueen.png";
    private final String kingIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKing.png";
    @Override
    public void tilesIconsCreator(ArrayList<JButton> tilesList) {
        pawnIconCreator(tilesList);
        rookIconCreator(tilesList);
        knightIconCreator(tilesList);
        bishopIconCreator(tilesList);
        queenIconCreator(tilesList);
        kingIconCreator(tilesList);
    }
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
    @Override
    public ImageIcon iconCreator(String str){
        ImageIcon tileImage = new ImageIcon(str);
        Image figure = tileImage.getImage();
        figure = figure.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        tileImage = new ImageIcon(figure);
        return tileImage;
    }
    public String getPawnIconPath(){
        return pawnIconPath;
    }
    public String getRookIconPath(){
        return rookIconPath;
    }
    public String getKnightIconPath(){
        return knightIconPath;
    }
    public String getBishopIconPath(){
        return bishopIconPath;
    }
    public String getQueenIconPath(){
        return queenIconPath;
    }
    public String getKingIconPath(){
        return kingIconPath;
    }
}
