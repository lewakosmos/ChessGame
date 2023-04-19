package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackPiecesIconsCreator implements IconCreator{
    private final String pawnIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackPawn.png";
    private final String rookIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackRook.png";
    private final String knightIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKnight.png";
    private final String bishopIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackBishop.png";
    private final String queenIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackQueen.png";
    private final String kingIconPath = "C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKing.png";
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
            if(Arrays.asList("A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7").contains(button.getText())){
                button.setText(button.getText() + "blackPawn");
                button.setIcon(iconCreator(pawnIconPath));
            }
        }
    }
    @Override
    public void rookIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A8", "H8").contains(button.getText())){
                button.setText(button.getText() + "blackRook");
                button.setIcon(iconCreator(rookIconPath));
            }
        }
    }
    @Override
    public void knightIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("B8", "G8").contains(button.getText())){
                button.setText(button.getText() + "blackKnight");
                button.setIcon(iconCreator(knightIconPath));
            }
        }
    }
    @Override
    public void bishopIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("C8", "F8").contains(button.getText())){
                button.setText(button.getText() + "blackBishop");
                button.setIcon(iconCreator(bishopIconPath));
            }
        }
    }
    @Override
    public void queenIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("D8".contains(button.getText())){
                button.setText(button.getText() + "blackQueen");
                button.setIcon(iconCreator(queenIconPath));
            }
        }
    }
    @Override
    public void kingIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("E8".contains(button.getText())){
                button.setText(button.getText() + "blackKing");
                button.setIcon(iconCreator(kingIconPath));
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
