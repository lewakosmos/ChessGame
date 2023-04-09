package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackPiecesIconsCreator implements IconCreator{

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
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackPawn.png"));
            }
        }
    }

    @Override
    public void rookIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("A8", "H8").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackRook.png"));
            }
        }
    }

    @Override
    public void knightIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("B8", "G8").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKnight.png"));
            }
        }
    }

    @Override
    public void bishopIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if(Arrays.asList("C8", "F8").contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackBishop.png"));
            }
        }
    }

    @Override
    public void queenIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("D8".contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackQueen.png"));
            }
        }
    }

    @Override
    public void kingIconCreator(ArrayList<JButton> tilesList) {
        for(JButton button : tilesList){
            if("E8".contains(button.getText())){
                button.setIcon(iconCreator("C:\\Users\\lewak\\IdeaProjects\\ChessGame\\pieces\\blackKing.png"));
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
