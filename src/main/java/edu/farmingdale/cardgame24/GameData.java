package edu.farmingdale.cardgame24;
import java.util.ArrayList;
import java.util.Random;

public class GameData {
    ArrayList<String> cards;
    String solution;
    static String[] cardImagePaths = new String[]{
            "2_of_clubs.png", "3_of_clubs.png", "4_of_clubs.png", "5_of_clubs.png",
            "6_of_clubs.png", "7_of_clubs.png", "8_of_clubs.png", "9_of_clubs.png", "10_of_clubs.png", "jack_of_clubs.png",
            "queen_of_clubs.png", "king_of_clubs.png", "ace_of_clubs.png", "2_of_diamonds.png",
            "3_of_diamonds.png", "4_of_diamonds.png", "5_of_diamonds.png", "6_of_diamonds.png",
            "7_of_diamonds.png", "8_of_diamonds.png", "9_of_diamonds.png", "10_of_diamonds.png",
            "jack_of_diamonds.png", "queen_of_diamonds.png", "king_of_diamonds.png", "ace_of_diamonds.png",
            "2_of_hearts.png", "3_of_hearts.png", "4_of_hearts.png", "5_of_hearts.png", "6_of_hearts.png",
            "7_of_hearts.png", "8_of_hearts.png", "9_of_hearts.png", "10_of_hearts.png", "jack_of_hearts.png",
            "queen_of_hearts.png", "king_of_hearts.png", "ace_of_hearts.png", "2_of_spades.png",
            "3_of_spades.png", "4_of_spades.png", "5_of_spades.png", "6_of_spades.png", "7_of_spades.png",
            "8_of_spades.png", "9_of_spades.png", "10_of_spades.png", "jack_of_spades.png", "queen_of_spades.png",
            "king_of_spades.png", "ace_of_spades.png"
    };

    public GameData() {
        this.cards = new ArrayList<String>();
        this.solution = "";
    }

    //Randomly chooses from the cardImagePaths array and adds the card to the cards arraylist (ensures no duplicates)
    public void generateCards() {
        this.cards.clear();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = rand.nextInt(52);
            while (this.cards.contains(cardImagePaths[randomIndex])) {
                randomIndex = rand.nextInt(52);
            }
            this.cards.add(cardImagePaths[randomIndex]);
        }
    }
}