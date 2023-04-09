package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WhitePiecesIconsCreator implements IconCreator{

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
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whitePawn.png"));
            }
        }
    }

    @Override
    public void rookIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A1", "H1").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteRook.png"));
            }
        }
    }

    @Override
    public void knightIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("B1", "G1").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKnight.png"));
            }
        }
    }

    @Override
    public void bishopIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("C1", "F1").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteBishop.png"));
            }
        }
    }

    @Override
    public void queenIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("D1".contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteQueen.png"));
            }
        }
    }

    @Override
    public void kingIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("E1".contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\whiteKing.png"));
            }
        }
    }
    public ImageIcon iconCreator(String str){
        ImageIcon tileImage = new ImageIcon(str);
        Image figure = tileImage.getImage();
        figure = figure.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        tileImage = new ImageIcon(figure);
        return tileImage;
    }
}
