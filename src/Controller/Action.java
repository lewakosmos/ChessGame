package Controller;

import javax.swing.*;

public interface Action {
    void firstPartTurn();
    void secondPartTurn(JButton button);
    void figureRecognition(JButton button);
    void piecePlaceSecondPart(JButton button);
}
