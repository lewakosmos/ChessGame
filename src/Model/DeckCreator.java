package Model;

import java.util.ArrayList;

public class DeckCreator {
    private final String[] columnDeckArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    //columns (String) on JPanel
    private final String[] stringDeckArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    //strings (String) on JPanel
    private static ArrayList<String> deckTilesList;
    public void deckListCreator() {
        deckTilesList = new ArrayList<>();
        for (int i = stringDeckArray.length - 1; i >= 0; i--) {
            for (String s : columnDeckArray) {
                deckTilesList.add(s + stringDeckArray[i]);
            }
        }
    }
    //list of all deck elements (String) on JPanel
    public String[] getColumnDeckArray(){
        return columnDeckArray;
    }
    //encapsulation
    public String[] getStringDeckArray(){
        return stringDeckArray;
    }
    //encapsulation
    public ArrayList<String> getDeckTilesList(){
        return deckTilesList;
    }
    //encapsulation
}
