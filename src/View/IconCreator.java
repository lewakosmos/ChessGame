package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface IconCreator {
    void tilesIconsCreator(ArrayList<JButton> tilesList);
    void pawnIconCreator(ArrayList<JButton> tilesList);
    void rookIconCreator(ArrayList<JButton> tilesList);
    void knightIconCreator(ArrayList<JButton> tilesList);
    void bishopIconCreator(ArrayList<JButton> tilesList);
    void queenIconCreator(ArrayList<JButton> tilesList);
    void kingIconCreator(ArrayList<JButton> tilesList);
    ImageIcon iconCreator(String str);
}
