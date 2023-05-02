package View;


import Controller.ActionHierarchy;
import Model.DeckCreator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel {
    private static ArrayList<JButton> tilesList;
    private ArrayList<JButton> possibleWhitePiecesListToGo;
    private ArrayList<JButton> possibleBlackPiecesListToGo;

    public JPanel panelCreator(){
        DeckCreator dc = new DeckCreator();
        dc.deckListCreator();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(BorderLayout.SOUTH, columnLettersCreator(dc.getColumnDeckArray()));
        mainPanel.add(BorderLayout.WEST, stringNumbersCreator(dc.getStringDeckArray()));
        mainPanel.add(BorderLayout.CENTER, deckTilesCreator(dc.getDeckTilesList()));
        return mainPanel;
    }
    private JPanel deckTilesCreator(ArrayList<String> deckList){
        tilesList = new ArrayList<>();
        possibleWhitePiecesListToGo = new ArrayList<>();
        possibleBlackPiecesListToGo = new ArrayList<>();
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
        actionHierarchy();
        return deckTilesPanel;
    }

    private JPanel columnLettersCreator(String[] array){
        JPanel columnLettersPanel = new JPanel(new GridLayout(1, array.length + 1));
        columnLettersPanel.add(columnEmptyLabelCreator());
        for (String s : array) {
            JLabel columnLetterLabel = new JLabel();
            columnLetterLabel.setPreferredSize(new Dimension(60, 30));
            columnLetterLabel.setVerticalAlignment(SwingConstants.CENTER);
            columnLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
            columnLetterLabel.setText(s);
            columnLettersPanel.add(columnLetterLabel);
        }
        return columnLettersPanel;
    }
    private JLabel columnEmptyLabelCreator(){
        JLabel emptyLabel = new JLabel();
        emptyLabel.setSize(new Dimension(30, 30));
        return emptyLabel;
    }
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

    private void whiteTilesIconsCreator(ArrayList<JButton> tilesList){
        WhitePiecesIconsCreator wpic = new WhitePiecesIconsCreator();
        wpic.tilesIconsCreator(tilesList);
    }
    private void blackTilesIconsCreator(ArrayList<JButton> tilesList){
        BlackPiecesIconsCreator bpic = new BlackPiecesIconsCreator();
        bpic.tilesIconsCreator(tilesList);
    }
    private void actionHierarchy(){
        ActionHierarchy ah = new ActionHierarchy();
        ah.gameAction();
    }
    public ArrayList<JButton> getTilesList(){
        return tilesList;
    }
    public ArrayList<JButton> getPossibleWhitePiecesListToGo(){
        return possibleWhitePiecesListToGo;
    }
    public ArrayList<JButton> getPossibleBlackPiecesListToGo(){
        return possibleBlackPiecesListToGo;
    }

}
