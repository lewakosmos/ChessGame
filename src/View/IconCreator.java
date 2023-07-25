package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface IconCreator {
    void tilesIconsCreator(ArrayList<JButton> tilesList);
    //mainMethod for all subMethods
    void pawnIconCreator(ArrayList<JButton> tilesList);
    //subMethod for Pawn
    void iconChecker(ArrayList<JButton> tilesList);
    //refill icons on tileDeck
    void rookIconCreator(ArrayList<JButton> tilesList);
    //subMethod for Rook
    void knightIconCreator(ArrayList<JButton> tilesList);
    //subMethod for Knight
    void bishopIconCreator(ArrayList<JButton> tilesList);
    //subMethod for Bishop
    void queenIconCreator(ArrayList<JButton> tilesList);
    //subMethod for Queen
    void kingIconCreator(ArrayList<JButton> tilesList);
    //subMethod for King
    ImageIcon iconCreator(String str);
    //getting image and send it to upper methods
}
