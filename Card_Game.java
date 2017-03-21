Design a deck of cards that can be used for different card game applications.

Please code out what you would need for the deck class and a card class.

Implement a deal method.
//below Stack<Cards> is wrong; should use List<cards> (use LinkedList to implement)
CardShape.java

package com.ankitgupta;

/**
 * Created by ankitgupta on 9/9/16.
 */
public enum CardShape {
	SPADE,
	DIAMOND,
	CLUB,
	HEART;
}

CardNumber.java

package com.ankitgupta;

/**
 * Created by ankitgupta on 9/9/16.
 */
public enum CardNumber {
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING;
}

Card.java
package com.ankitgupta;

/**
 * Created by ankitgupta on 9/9/16.
 */
public class Card {

	CardShape shape;
	CardNumber number;

	Card(CardShape shape,CardNumber number){
		this.shape = shape;
		this.number = number;
	}

	public CardNumber getNumber() {
		return number;
	}

	public CardShape getShape() {
		return shape;
	}

	public String getName(){
		return number + " of " + shape;
	}
}

Deck.java

package com.ankitgupta;

import java.util.Random;
import java.util.Stack;

/**
 * Created by ankitgupta on 9/9/16.
 */
public class Deck {

	public static Stack<Card> getNewSortedDeck(){
		Stack<Card> cardDeck = new Stack<Card>();
		for (CardShape shape: CardShape.values()){
			for (CardNumber number: CardNumber.values()){
				Card card = new Card(shape,number);
				cardDeck.push(card);
			}
		}
		return cardDeck;
	}

	public static Stack<Card> getShuffeledDeck(){
		return getShuffeledDeck(getNewSortedDeck());
	}

	public static Stack<Card> getShuffeledDeck(Stack<Card> deck){
		Stack<Card> cardDeck = new Stack<Card>();
		int count = 0;
		for (int i=deck.size();i>;0;i--){
			Random random = new Random();
			Card randomCard = deck.remove(random.nextInt(i));
			cardDeck.push(randomCard);
		}
		return cardDeck;
	}

	public static void printDeck(Stack<Card> deck){
		for (int i=0 ; i<deck.size();i++) {
			System.out.println("Adding Random Card No. " + (i+1) + " to the Deck : " + deck.get(i).getName());
		}
	}
}

Player.java

package com.ankitgupta;

import java.util.Stack;

/**
 * Created by ankitgupta on 9/9/16.
 */
public class Player {

	private String name;
	private Stack<Card> cards;

	Player (String name){
		this.name = name;
		this.cards = new Stack<Card>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card){
		this.cards.push(card);
	}
	
	public void removeCard(Card card){
		this.cards.remove(card);
	}

}


CardGame.java
package com.ankitgupta;

import java.security.PublicKey;
import java.util.Stack;

/**
 * Created by ankitgupta on 9/9/16.
 */
public class CardGame {
	private Player[] players;
	private int cardsPerPlayer;
	Stack<Card> stackOfCards = Deck.getShuffeledDeck();
	CardGame(Player[] players){
		this.players = players;
		this.cardsPerPlayer=0;
	}

	CardGame(Player[] players, int cardsPerPlayer){
		this.players = players;
		this.cardsPerPlayer = cardsPerPlayer;
	}

	public void dealCards(){
		int playerCount = players.length;
		if (playerCount>;0){
			int cardsToDeal = cardsPerPlayer==0? stackOfCards.size() :cardsPerPlayer*playerCount;
			for (int i=0;i<cardsToDeal;i++){
				players[i%playerCount].addCard(stackOfCards.pop());
			}
		}
	}
	public Stack<Card> getStackOfCards(){
		return stackOfCards;
	}
}


Deal.java

package com.ankitgupta;

import java.util.Stack;

/**
 * Created by ankitgupta on 9/9/16.
 */
public class Deal {

	public static void main(String[] args) {

		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		Player player3 = new Player("Player3");
		Player player4 = new Player("Player4");

		Player[] players = {player1,player2,player3,player4};
		CardGame game = new CardGame(players);
		game.dealCards();

		System.out.println("Player 1 Cards : ");
		Deck.printDeck(player1.getCards());

		System.out.println("Player 2 Cards : ");
		Deck.printDeck(player2.getCards());

		System.out.println("Player 3 Cards : ");
		Deck.printDeck(player3.getCards());

		System.out.println("Player 4 Cards : ");
		Deck.printDeck(player4.getCards());

		System.out.println("Remaining Cards : ");
		Deck.printDeck(game.getStackOfCards());

	}
}
