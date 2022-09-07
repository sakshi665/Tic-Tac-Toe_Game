package game;

import java.util.Random;
import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//to make a game board
		char[][] board = {{' ',' ',' '},
				          {' ',' ',' '},
				          {' ',' ',' '}};
	
		//to print a board
		printboard(board);
		//take x from user input
		
		while(true) {
		playerTurn(board,sc);
		if(isGameFinished(board))
		{
			break;
		}
		
		printboard(board);
		
		computerTurn(board);
		if(isGameFinished(board))
		{
			break;
		}
		printboard(board);
		}
   
	}

	private static boolean isGameFinished(char[][] board) {
		
		// TODO Auto-generated method stub
		
		//8 different possibility;
		if(hasConstestantwon(board,'X'))
		{
			printboard(board);
			System.out.println("PLAYER WON !!!");
			return true;
		}
		if(hasConstestantwon(board,'O'))
		{
			printboard(board);
			System.out.println("COMPUTER WON !!!");
			return true;
		}
		
		//for tie
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;i++)
			{
				if(board[i][j]==' ')
				{
					return false;
				}
			}
		}
		printboard(board);
		System.out.print("The game ended ----its tie!!");
		return true;
	}

	private static boolean hasConstestantwon(char[][] board,char symbol) {
		if((board[0][0] == symbol && board[0][1]==symbol && board[0][2]==symbol) ||
		  ( board[1][0] == symbol && board[1][1]==symbol && board[1][2]==symbol) ||
           (board[2][0] == symbol && board[2][1]==symbol && board[2][2]==symbol) ||

            (board[0][0] == symbol && board[1][0]==symbol && board[2][0]==symbol) ||
           (board[0][1] == symbol && board[1][1]==symbol && board[2][1]==symbol) ||	
             (board[0][2] == symbol && board[1][2]==symbol && board[2][2]==symbol)||
             
             (board[0][0] == symbol && board[1][1]==symbol && board[2][2]==symbol) ||
		     (board[0][2] == symbol && board[1][1]==symbol && board[2][0]==symbol))
		{
			
			return true;
		}
		return false;
	}

	private static void computerTurn(char[][] board) {
		Random rand=new Random();
		//It will take random any input from 1 to 8 add 1 to it
		int  computerMove;
		while(true) {
		 computerMove=rand.nextInt(9)+1;
		if(isValidMove(board,Integer.toString(computerMove))) {
			break;
		}
		}
		System.out.println("computer choose" +computerMove);
		//we convert computer move which is integer and to string
		placeMove(board,Integer.toString(computerMove),'O');
	}
	
	private static boolean isValidMove(char[][] board, String position)
	{
		switch(position)
		{
		//if board is equal to space then then return true
		case "1":
			return(board[0][0] ==' ');
		case "2":
			return(board[0][1] ==' ');
		case "3":
			return(board[0][2] ==' ');
		case "4":
			return(board[1][0] ==' ');
		case "5":
			return(board[1][1] ==' ');
		case "6":
			return(board[1][2] ==' ');
		case "7":
			return(board[2][0] ==' '); 
		case "8":
			return(board[2][1] ==' ');
		case "9":
			return(board[2][2] ==' ');
		default:
			return false;
		}
	}
//alt shift r to rename at a time
	private static void playerTurn(char[][] board, Scanner sc) {
//not choosing same move by both
		String userInput;
		while(true)
		{
		System.out.println("Where would you like to play? (1-9)");
		 userInput=sc.nextLine();
		if(isValidMove(board,userInput))
		{
			break;
		}
		else
		{
			System.out.println(userInput +" is not a valid move");
		}
		}
		placeMove(board, userInput,'X');
		//sc.close();
	}

	private static void placeMove(char[][] board, String position,char symbol) {
		switch(position)
		{
		case "1":
			board[0][0] = symbol;
			break;
		
		case "2":
			board[0][1] = symbol ;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		
		case "4":
			board[1][0] = symbol;
			break;
		
		case "5":
			board[1][1] = symbol;
			break;
			
		case "6":
			board[1][2] = symbol;
			break;
		
		case "7":
			board[2][0] = symbol;
			break;
		 
		case "8":
			board[2][1] = symbol;
			break;
		
		case "9":
			board[2][2] = symbol;
			break;
			
		default:
			System.out.println(":(");
		}
	}

	private static void printboard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" +board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" +board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" +board[2][2]);
	}

}
