import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuGame extends Game{
	
	private Spot[] [] spotMatrix = {{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},

};
	int [] possibleValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	public int [] [] sudokuMatrix = new int [9] [9];

	public void addFile(String fileName) {
	    File f = new File(fileName);
	    Scanner sc = null;
	    try{
		sc = new Scanner(f);
	    } catch (FileNotFoundException e){
		e.printStackTrace();
		System.out.println("File "+fileName+" doesn't exist");
		System.exit(1);	
		
	    }
	    while (sc.hasNextInt() == true){
	    	for (int row = 0; row<9; row++){   
				for (int column = 0; column <9; column++){
					sudokuMatrix[row][column] = (sc.nextInt());
			}
	}
}
}

    private Spot [] empties = new Spot [81-26];


	public Spot [] getEmpties(){
		return empties;
	}

	public int [] getPossibles(){
		return possibleValues;
	}

	public Spot [] [] getMatrix(){
		return spotMatrix;
	}

	public void fillSpots(){
		int ecount =0;
		int scount =0;
		int boxcount = 1;
		for (int row = 0; row<9; row++){   
			for (int column = 0; column <9; column++){
				spotMatrix[row][column].setValue(sudokuMatrix[row][column]);
				spotMatrix[row][column].setRow(row);
				spotMatrix[row][column].setColumn(column);
				if (column<=2){
					spotMatrix[row][column].setBox(boxcount);
				}
				else if (column>2 && column <6){
					spotMatrix[row][column].setBox(boxcount+1);
				}
				else if (column>=6){
					spotMatrix[row][column].setBox(boxcount+2);
				}

				if (sudokuMatrix[row][column]==0){
					empties[ecount]=spotMatrix[row][column];
					ecount=ecount+1;}
			}
			if (row==2){
				boxcount=boxcount+3;
			}
			else if (row==5){
				boxcount = boxcount+3;
			}
	}
}


public void printEmpties(){
	for (int e = 0; e<empties.length; e++){
		System.out.println("box of empties"+ empties[e].getBox());
	}
}


	public boolean constraintsWork(Spot s){ 
	int emptyVal=s.getValue();
	int spotRow = s.getRow();
	int spotCol = s.getColumn();
	
	int spotBox = s.getBox();
	int count = 0;
	int[] sameBox = new int [9];


	for (int row = 0; row<9; row++){   
			for (int column = 0; column <9; column++){
				if(spotRow != row && spotCol != column){
					if (spotBox==spotMatrix[row][column].getBox()){
						sameBox[count]=spotMatrix[row][column].getValue();
						count=count+1;}
			}
		}
		}




	for(int i = 0; i<9; i++){
		//System.out.println("values in same box are "+sameBox[i]);
		if (i!= spotCol && emptyVal==spotMatrix[spotRow][i].getValue())
			return false;
		if (i!= spotRow && emptyVal == spotMatrix[i][spotCol].getValue())
			return false;
		if (emptyVal == sameBox[i]){
			System.out.println("False");
			return false;}	
	}

	System.out.println("true");
	return true;
}

	public void printMatrix(){
		for (int row = 0; row<9; row++){   
			for (int column = 0; column <9; column++){
				System.out.print(spotMatrix[row][column].getValue()+" ");
			}
		System.out.println();
		}
	}
}