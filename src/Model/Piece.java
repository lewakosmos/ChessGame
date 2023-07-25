package Model;

import javax.swing.*;

public interface Piece {
    void moveAndAttack(JButton button);
    //main method for figure to run and attack
    void possibleTilesToRun(JButton button);
    //sub method for figure to run
    void possibleTilesToAttack(JButton button);
    //sub method for figure to attack
}
