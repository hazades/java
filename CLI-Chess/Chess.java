import java.util.Scanner;

public class Chess {

	public enum characterChess {		//define collection of constant
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_ROOK,
		WHITE_BISHOP,
		WHITE_KNIGHT,
		WHITE_PAWN,
		BLACK_KING,
		BLACK_QUEEN,
		BLACK_ROOK,
		BLACK_BISHOP,
		BLACK_KNIGHT,
		BLACK_PAWN,
		EMPTY
	}
	
	
	public static void buildChessBoard(characterChess[][] chessboard) {
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {

				if (i == 0) {
					switch (j) {
					case 0:
					case 7:
						chessboard[i][j] = characterChess.BLACK_ROOK;		//row 0, column 0 & column 7
						break;
					case 1:
					case 6:
						chessboard[i][j] = characterChess.BLACK_KNIGHT;		//row 0, column 1 & column 6
						break;
					case 2:
					case 5:
						chessboard[i][j] = characterChess.BLACK_BISHOP;		//row 0, column 2 & column 5
						break;
					case 3:
						chessboard[i][j] = characterChess.BLACK_QUEEN;		//row 0, column 3
						break;
					case 4:
						chessboard[i][j] = characterChess.BLACK_KING;		//row 0, column 4
						break;
					}
					
					/*	Arrangement will be like below:- 
					 * 
					 * i = 0 --> |BR|BK|BB|BQ|BKING|BB|BK|BR|
					 * 
					 */
				} else if (i == 1) {
					chessboard[i][j] = characterChess.BLACK_PAWN;	//BP will be full in all columns at row 1
				}
				
				/*	Arrangement will be like below:- 
				 * 
				 * i = 0 --> |BR|BK|BB|BQ|BKING|BB|BK|BR|
				 * i = 1 --> |BP|BP|BP|BP|BP   |BP|BP|BP|
				 * 
				 */

				else if (i > 1 && i < 6) {
					chessboard[i][j] = characterChess.EMPTY;		//empty space for row i 2 to 5, EMPTY = ?
				}
				/*	Arrangement will be like below:- 
				 * 
				 * i = 0 --> |BR|BK|BB|BQ|BKING|BB|BK|BR|
				 * i = 1 --> |BP|BP|BP|BP|BP   |BP|BP|BP|
				 * i = 2 --> |? |? |? |? |?    |? |? |? |
				 * i = 3 --> |? |? |? |? |?    |? |? |? |
				 * i = 4 --> |? |? |? |? |?    |? |? |? |
				 * i = 5 --> |? |? |? |? |?    |? |? |? |
				 * 
				 */

				else if (i == 6) {
					chessboard[i][j] = characterChess.WHITE_PAWN;		//when i = 6, build board for white pawn
				}
				/*	Arrangement will be like below:- 
				 * 
				 * i = 0 --> |BR|BK|BB|BQ|BKING|BB|BK|BR|
				 * i = 1 --> |BP|BP|BP|BP|BP   |BP|BP|BP|
				 * i = 2 --> |? |? |? |? |?    |? |? |? |
				 * i = 3 --> |? |? |? |? |?    |? |? |? |
				 * i = 4 --> |? |? |? |? |?    |? |? |? |
				 * i = 5 --> |? |? |? |? |?    |? |? |? |
				 * i = 6 --> |WP|WP|WP|WP|WP   |WP|WP|WP|
				 * 
				 */
				else if (i == 7) {
					switch (j) {
						case 0:
						case 7:
							chessboard[i][j] = characterChess.WHITE_ROOK;	//row = 7, column 0 & column 7
							break;
						case 1:
						case 6:
							chessboard[i][j] = characterChess.WHITE_KNIGHT;	//row = 7, column 1 & column 6
							break;
						case 2:
						case 5:
							chessboard[i][j] = characterChess.WHITE_BISHOP;	//row = 7, column 2 & column 5
							break;
						case 3:
							chessboard[i][j] = characterChess.WHITE_QUEEN;	//row = 7, column 3
							break;
						case 4:
							chessboard[i][j] = characterChess.WHITE_KING;	//row = 7, column 4 
							break;
					}
				}
				
				/*	Arrangement will be like below:- 
				 * 
				 * i = 0 --> |BR|BK|BB|BQ|BKING|BB|BK|BR|
				 * i = 1 --> |BP|BP|BP|BP|BP   |BP|BP|BP|
				 * i = 2 --> |? |? |? |? |?    |? |? |? |
				 * i = 3 --> |? |? |? |? |?    |? |? |? |
				 * i = 4 --> |? |? |? |? |?    |? |? |? |
				 * i = 5 --> |? |? |? |? |?    |? |? |? |
				 * i = 6 --> |WP|WP|WP|WP|WP   |WP|WP|WP|
				 * i = 7 --> |WR|WK|WB|WQ|WKING|WB|WK|WR|
				 * 
				 */
			}

		}

	}
	
	/*
	 * Now the chessboard ready to be printed after finished arrangement part
	 */
	
	public static void printBoard(characterChess[][] chessboard) {
		char a = 'a';
		System.out.print(" ");
		for (int l = 0; l < 8; l++) {
			System.out.print(String.format("%5s", a));		//space with 3 spaces each string
			a++;											//increase ASCII value
		}
		System.out.println("\r");							//carriage return or set value to new line
		
		for (int i = 0; i < 8; i++) {
			System.out.print(8-i + ". ");		//print number 1 at bottom
			//System.out.print(i+1 + ". ");		//print number 1 at top
			
			for (int j = 0; j < 8; j++) {		
				
				switch (chessboard[i][j]) {
				
				case BLACK_PAWN:
					System.out.print("|BP |");
					//System.out.print("\u265F ");			//unicode value
					break;
				case BLACK_ROOK:
					System.out.print("|BR |");
					//System.out.print("\u265C ");
					break;
				case BLACK_KNIGHT:
					System.out.print("|BK |");
					//System.out.print("\u265E ");
					break;
				case BLACK_BISHOP:
					System.out.print("|BB |");
					//System.out.print("\u265D ");
					break;
				case BLACK_QUEEN:
					System.out.print("|BQ |");
					//System.out.print("\u265B ");
					break;
				case BLACK_KING:
					System.out.print("|BKG|");
					//System.out.print("\u265A ");
					break;
				case WHITE_PAWN:
					System.out.print("|WP |");
					//System.out.print("\u2659 ");
					break;
				case WHITE_ROOK:
					System.out.print("|WR |");
					//System.out.print("\u2656 ");
					break;
				case WHITE_KNIGHT:
					System.out.print("|WK |");
					//System.out.print("\u2658 ");
					break;
				case WHITE_BISHOP:
					System.out.print("|WB |");
					//System.out.print("\u2657 ");
					break;
				case WHITE_QUEEN:
					System.out.print("|WQ |");
					//System.out.print("\u2655 ");
					break;
				case WHITE_KING:
					System.out.print("|WKG|");
					//System.out.print("\u2654 ");
					break;
				case EMPTY:
					System.out.print("|   |");
					break;
				}
			}
			System.out.println("\r");
		}
	}
	
	public static void move(characterChess[][] chessboard, String move) {
		// parse move string into components
		String[] components = move.split(" ");
		try {
			// validates user input
			if (components.length > 3){
				System.err.println("\r1.Please provide valid move!");
			}
			else if ( components[0].length() != 2 || components[2].length() != 2){
				System.err.println("\r2.Please provide valid move!");
			}
			else if ( components[0].charAt(0) < 'a' || components[0].charAt(0) > 'h' || components[0].charAt(1) < '1' || components[0].charAt(1) > '8' ){
				System.err.println("\r3.Please provide valid move!");
			}
			else if ( components[2].charAt(0) < 'a' || components[2].charAt(0) > 'h' || components[2].charAt(1) < '1' || components[2].charAt(1) > '8' ){
				System.err.println("\r4.Please provide valid move!");
			}
			else{
			// make the move: replace original position with characterChess.
			int col = components[0].charAt(0) - 97;					//for first position (a-h), a in ascii is 97
			int row = Math.abs(components[0].charAt(1) - 49-7);		//for second position (1-8), 1 in ascii is 49, 1 at bottom
			//int row = Math.abs(components[0].charAt(1) - 49);		//for second position (1-8), 1 in ascii is 49, 1 at top
			
			//and place the piece into the new position
			int nCol = components[2].charAt(0) - 97;
			int nRow = Math.abs(components[2].charAt(1) - 49-7);
			//int nRow = Math.abs(components[2].charAt(1) - 49);
			
			//knight moves
			int Xknight = nCol-col;
			int Yknight = nRow-row;
			
			//if(Xknight>2 || Yknight<8) {
				if(Xknight==2 || Yknight==1 || Yknight==-1) {
					//if (isValid(chessboard, row, col, nRow, nCol)){
						chessboard[Xknight][+Yknight] = chessboard[row][+col];
						chessboard[row][+col] = characterChess.EMPTY;
					//}
				}if(Xknight==-2 || Yknight==1 || Yknight==-1) {
					chessboard[Xknight][+Yknight] = chessboard[row][+col];
					chessboard[row][+col] = characterChess.EMPTY;
				}if(Xknight==1 || Yknight==2 || Yknight==-2) {
					chessboard[Xknight][+Yknight] = chessboard[row][+col];
					chessboard[row][+col] = characterChess.EMPTY;
				}if(Xknight==-1 || Yknight==2 || Yknight==-2) {
					chessboard[Xknight][+Yknight] = chessboard[row][+col];
					chessboard[row][+col] = characterChess.EMPTY;
				}
			//}else
			//	System.out.println("not valid move for knight");
			//knight move
			
			System.out.println("ASCII : "+col+ " " + row + " " + nCol + " " + nRow);
			if (isValid(chessboard, row, col, nRow, nCol)){
				chessboard[nRow][+nCol] = chessboard[row][+col];
				chessboard[row][+col] = characterChess.EMPTY;
			}
			else{
				System.err.println("Move not allowed");
			}
			
			}
		} catch (Exception e) {
			System.out.println("Error : "+e);
		}
		
	}
	
	/**
	Returns a boolean true if the move is valid, false otherwise.
	@param chessboard @param oldI @param oldJ @param newI @param newJ @return
	**/
	public static Boolean isValid(characterChess[][] chessboard, int row, int col, int nRow, int nCol) {

		switch (chessboard[row][col]) {
			
		case BLACK_PAWN:
			if (chessboard[nRow][nCol] != characterChess.EMPTY && (nCol == col + 1 || nCol == col - 1) ){
				return true;
			}
			else if ( chessboard[nRow][nCol] != characterChess.EMPTY ){
				return false;
			}
			else if ( row + 1 == nRow || (row == 1 && row + 2 == nRow)){
				return true;
			}
			break;
		case WHITE_PAWN:
			if (chessboard[nRow][nCol] != characterChess.EMPTY && (nCol == col + 1 || nCol == col - 1) ){
				return true;
			}
			else if ( chessboard[nRow][nCol] != characterChess.EMPTY ){
				return false;
			}
			else if ( row - 1 == nRow || (row == 6 && row - 2 == nRow)){
				return true;
			}
			break;
		case BLACK_ROOK:
				if ((chessboard[nRow][nCol] == characterChess.WHITE_ROOK ||
				 chessboard[nRow][nCol] == characterChess.WHITE_KNIGHT ||
				 chessboard[nRow][nCol] == characterChess.WHITE_BISHOP ||
				 chessboard[nRow][nCol] == characterChess.WHITE_QUEEN ||
				 chessboard[nRow][nCol] == characterChess.WHITE_KING || chessboard[nRow][nCol] == characterChess.EMPTY )
				 && (nCol == col || nRow == row) ){
				return true;
				}
			break;
		case WHITE_ROOK:
			if ((chessboard[nRow][nCol] == characterChess.BLACK_ROOK ||
				 chessboard[nRow][nCol] == characterChess.BLACK_KNIGHT ||
				 chessboard[nRow][nCol] == characterChess.BLACK_BISHOP ||
				 chessboard[nRow][nCol] == characterChess.BLACK_QUEEN ||
				 chessboard[nRow][nCol] == characterChess.BLACK_KING || chessboard[nRow][nCol] == characterChess.EMPTY )
				 && (nCol == col || nRow == row) ){
				return true;
				}
			break;
		case BLACK_KNIGHT:
			
			break;
		case WHITE_KNIGHT:
			break;
		case BLACK_BISHOP:
		case WHITE_BISHOP:
			break;
		case BLACK_QUEEN:
			if ((chessboard[nRow][nCol] == characterChess.WHITE_ROOK ||
			 chessboard[nRow][nCol] == characterChess.WHITE_KNIGHT ||
			 chessboard[nRow][nCol] == characterChess.WHITE_BISHOP ||
			 chessboard[nRow][nCol] == characterChess.WHITE_QUEEN ||
			 chessboard[nRow][nCol] == characterChess.WHITE_KING || chessboard[nRow][nCol] == characterChess.EMPTY)
			 && (nCol == col || nRow == row || nCol == col-1 || nRow == row+1 || nRow == row || nRow == row-1)){
				return true;
		}
		break;
		case WHITE_QUEEN:
			if ((chessboard[nRow][nCol] == characterChess.BLACK_ROOK ||
			 chessboard[nRow][nCol] == characterChess.BLACK_KNIGHT ||
			 chessboard[nRow][nCol] == characterChess.BLACK_BISHOP ||
			 chessboard[nRow][nCol] == characterChess.BLACK_QUEEN ||
			 chessboard[nRow][nCol] == characterChess.BLACK_KING || chessboard[nRow][nCol] == characterChess.EMPTY)
			 && (nCol == col || nRow == row || nCol == col-1 || nRow == row+1 || nRow == row || nRow == row-1)){
				return true;
		}
			break;
		case BLACK_KING:
			if ((chessboard[nRow][nCol] == characterChess.WHITE_ROOK ||
			 chessboard[nRow][nCol] == characterChess.WHITE_KNIGHT ||
			 chessboard[nRow][nCol] == characterChess.WHITE_BISHOP ||
			 chessboard[nRow][nCol] == characterChess.WHITE_QUEEN ||
			 chessboard[nRow][nCol] == characterChess.WHITE_KING || chessboard[nRow][nCol] == characterChess.EMPTY)
			 && (( nCol == col+1 || nCol == col || nCol == col-1 ) && ( nRow == row+1 || nRow == row || nRow == row-1 ))){
				return true;
		}
		break;
		case WHITE_KING:
			if ((chessboard[nRow][nCol] == characterChess.BLACK_ROOK ||
				 chessboard[nRow][nCol] == characterChess.BLACK_KNIGHT ||
				 chessboard[nRow][nCol] == characterChess.BLACK_BISHOP ||
				 chessboard[nRow][nCol] == characterChess.BLACK_QUEEN ||
				 chessboard[nRow][nCol] == characterChess.BLACK_KING || chessboard[nRow][nCol] == characterChess.EMPTY)
				 && (( nCol == col+1 || nCol == col || nCol == col-1 ) && ( nRow == row+1 || nRow == row || nRow == row-1 ))){
					return true;
			}
			break;	
		case EMPTY:
			return false;		
		}
		return false;
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		characterChess[][] chessboard = new characterChess[8][8]; // creates chessboard of size 8 x 8
		String move = "";
		
		buildChessBoard(chessboard);
		System.out.println("Input the moves in standard chess notation, such as: “e1 to e5”:\n#only lower case is accepted for alphabert\nonly accepted number form 1-8\n");
		
		while(true){
			printBoard(chessboard);
			move = sc.nextLine();
			
			if (move.equals("exit")){
				System.exit(1);
			}
			
			move(chessboard, move);
						
		}
		
	}

}
