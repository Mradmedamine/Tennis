package org.refactoring.refactored;

public class TennisGame {

	private static final int WINNING_POINT = 4;

	private static final String DASH = "-";
	private static final String DEUCE = "Deuce";
	private static final String EQUAL_SCORE_TEXT = "-All";
	private static final String WIN_SCORE_TEXT = "Win for ";
	private static final String ADVANTAGE_SCORE_TEXT = "Advantage ";
	private static final String[] LOW_SCORE_LABELS = { "Love", "Fifteen", "Thirty", "Forty" };

	private PlayerGameDetails player1;
	private PlayerGameDetails player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = new PlayerGameDetails(player1);
		this.player2 = new PlayerGameDetails(player2);
	}

	public TennisGame(String player_1Name, String player_2Name) {
		this(new Player(player_1Name), new Player(player_2Name));
	}

	public void wonPoint(Player player) {
		if (player.equals(player1.getPlayer())) {
			player1.wonPoint();
		} else {
			player2.wonPoint();
		}
	}

	public void wonPoint(String playerName) {
		this.wonPoint(new Player(playerName));
	}

	public String getScore() {
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();
		if (player1Score < WINNING_POINT && player2Score < WINNING_POINT) {
			return printLowScore(player1Score, player2Score);
		} else {
			return printHighScore(player1Score, player2Score);
		}
	}

	private String printLowScore(int player1Score, int player2Score) {
		if (player1Score == player2Score) {
			return LOW_SCORE_LABELS[player1Score] + EQUAL_SCORE_TEXT;
		}
		return LOW_SCORE_LABELS[player1Score] + DASH + LOW_SCORE_LABELS[player2Score];
	}

	private String printHighScore(int player1Score, int player2Score) {
		if (player1Score == player2Score) {
			return DEUCE;
		} else {
			String winningPlayerName = winningPlayerName(player1Score, player2Score);
			String scoreText = onePointDifference(player1Score, player2Score) ? ADVANTAGE_SCORE_TEXT : WIN_SCORE_TEXT;
			return scoreText + winningPlayerName;
		}
	}

	private String winningPlayerName(int player1Score, int player2Score) {
		return player1Score > player2Score ? player1.getPlayer().getName() : player2.getPlayer().getName();
	}

	private boolean onePointDifference(int player1Score, int player2Score) {
		return (player2Score - player1Score) * (player2Score - player1Score) == 1;
	}

}
