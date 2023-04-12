package Model;

import javax.swing.*;

public interface Piece {
    void moveAndAttack(JButton button);
    void possibleTilesToRun(JButton button);
    void possibleTilesToAttack(JButton button);
}
