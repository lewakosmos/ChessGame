package View;

import Controller.ActionHierarchy;
import Model.DeckCreator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel {
    private static ArrayList<JButton> tilesList;
    //list of all tiles on JPanel (JButton)
    private static ArrayList<JButton> possiblePiecesListToGo;
    //list of possible tile to place for figure (JButton)

    public JPanel panelCreator(){
        DeckCreator dc = new DeckCreator();
        dc.deckListCreator();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(BorderLayout.SOUTH, columnLettersCreatorCombined(dc.getColumnDeckArray()));
        mainPanel.add(BorderLayout.WEST, stringNumbersCreator(dc.getStringDeckArray()));
        mainPanel.add(BorderLayout.CENTER, deckTilesCreator(dc.getDeckTilesList()));
        return mainPanel;
    }
    //mainPanel (JButton)
    private JPanel deckTilesCreator(ArrayList<String> deckList){
        tilesList = new ArrayList<>();
        possiblePiecesListToGo = new ArrayList<>();
        JPanel deckTilesPanel = new JPanel(new GridLayout(8, 8));
        for(String tile : deckList){
            JButton tileButton = new JButton(tile);
            tileButton.setPreferredSize(new Dimension(50, 50));
            tileButton.setBackground(Color.WHITE);
            tileButton.setFont(new Font("Arial", Font.BOLD, 0));
            tilesList.add(tileButton);
            deckTilesPanel.add(tileButton);
        }
        whiteTilesIconsCreator(tilesList);
        blackTilesIconsCreator(tilesList);
        actionHierarchy(); //todo Also for actionHierarchy
        return deckTilesPanel;
    }

    //subPanel of figures only (JButton)

    private JPanel columnLettersCreatorCombined(String [] array){
        JPanel columnLettersCreatorCombined = new JPanel(new BorderLayout());
        columnLettersCreatorCombined.add(BorderLayout.WEST, columnEmptyPanelCreator());
        columnLettersCreatorCombined.add(BorderLayout.CENTER, columnLetterCreator(array));
        return columnLettersCreatorCombined;
    }
    //1.1
    private JPanel columnLetterCreator(String [] array)
    {
        JPanel columnLettersPanel = new JPanel(new GridLayout(1, array.length));
        for (String unit : array) {
            JLabel columnLetterLabel = new JLabel();
            columnLetterLabel.setPreferredSize(new Dimension(60, 20));
            columnLetterLabel.setVerticalAlignment(SwingConstants.CENTER);
            columnLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
            columnLetterLabel.setText(unit);
            columnLettersPanel.add(columnLetterLabel);
        }
        return columnLettersPanel;
    }
    //1.2
    private JPanel columnEmptyPanelCreator(){
        JPanel emptyLabelPanel = new JPanel();
        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(20, 20));
        emptyLabelPanel.add(emptyLabel);
        return emptyLabelPanel;
    }
    //1.3 methods for columns on mainPanel, subPanel (JLabel)
    private JPanel stringNumbersCreator(String[] array){
        JPanel stringNumbersPanel = new JPanel(new GridLayout(array.length, 1));
        for(int i = array.length-1; i >= 0; i--){
            JLabel stringNumberLabel = new JLabel();
            stringNumberLabel.setPreferredSize(new Dimension(30, 60));
            stringNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
            stringNumberLabel.setText(array[i]);
            stringNumbersPanel.add(stringNumberLabel);
        }
        return stringNumbersPanel;
    }
    //subPanel for strings on mainPanel (JLabel)

    private void whiteTilesIconsCreator(ArrayList<JButton> tilesList){
        WhitePiecesIconsCreator wpic = new WhitePiecesIconsCreator();
        wpic.tilesIconsCreator(tilesList);
    }
    //subMethod for deckTilesCreator. Icons for white figures.
    private void blackTilesIconsCreator(ArrayList<JButton> tilesList){
        BlackPiecesIconsCreator bpic = new BlackPiecesIconsCreator();
        bpic.tilesIconsCreator(tilesList);
    }
    //subMethod for deckTilesCreator. Icons for black figures.
    private void actionHierarchy(){
        ActionHierarchy ah = new ActionHierarchy();
        ah.gameAction();
    }
    //todo hierarchy for gamePlay on mainPanel
    public ArrayList<JButton> getTilesList(){
        return tilesList;
    }
    //encapsulation
    public ArrayList<JButton> getPossiblePiecesListToGo(){
        return possiblePiecesListToGo;
    }
    //encapsulation
}
