import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KenGame extends Game{
	
	private Spot[] [] spotMatrix = {{new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot()},
	{new Spot(), new Spot(), new Spot(), new Spot()},
};

int [] [] kenMatrix = new int [4][12];
    //4x4 that specifies cage number
    //followed by 4x4 that gives intended result
    //followed by 4x4 that specifies operation (+, -, x, /)

int [] possibleValues = {1, 2, 3, 4};

Spot [] empties = new Spot [16];

public Spot [] getEmpties(){
	return empties;
	}

public int [] getPossibles(){
	return possibleValues;
}

public Spot [] [] getMatrix(){
	return spotMatrix;
}

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
	    	for (int row = 0; row<4; row++){   
				for (int column = 0; column <12; column++){
					kenMatrix[row][column] = (sc.nextInt());
			}
	}
}
}


public void fillSpots(){
	int ecount = 0;
	for (int row = 0; row<4; row++){   
		for (int column = 0; column <4; column++){
			spotMatrix[row][column].setRow(row);
			spotMatrix[row][column].setColumn(column);
			spotMatrix[row][column].setBox(kenMatrix[row][column]);
			spotMatrix[row][column].setResult(kenMatrix[row][column+4]);
			spotMatrix[row][column].setOperation(kenMatrix[row][column+8]);
			empties[ecount]=spotMatrix[row][column];
			ecount=ecount+1;		}
	}
}

public boolean constraintsWork(Spot s){
	int emptyVal=s.getValue();
	int spotRow = s.getRow();
	int spotCol = s.getColumn();
	int spotResult = s.getResult();
	int spotOperation = s.getOperation();
	
	int spotBox = s.getBox();

	for(int i = 0; i<4; i++){
		if (i!= spotCol && emptyVal==spotMatrix[spotRow][i].getValue()){
		    System.out.println("false");
			return false;}
		if (i!= spotRow && emptyVal==spotMatrix[i][spotCol].getValue()){
		    System.out.println("false");
			return false;}

		if(i!= spotRow && spotBox==spotMatrix[i][spotCol].getBox() && spotMatrix[i][spotCol].getValue() != 0){
			if (spotOperation==6 && emptyVal+spotMatrix[i][spotCol].getValue()!=spotResult)
				return false;
			if(spotOperation==7 && Math.abs(emptyVal-spotMatrix[i][spotCol].getValue()) != spotResult)
				return false;
			if(spotOperation==8 && emptyVal*spotMatrix[i][spotCol].getValue() != spotResult)
				return false;
			if(spotOperation==9 && emptyVal/spotMatrix[i][spotCol].getValue() !=spotResult && spotMatrix[i][spotCol].getValue()/emptyVal!=spotResult)
				return false;
		}
		if (i!= spotCol && spotBox==spotMatrix[spotRow][i].getBox() && spotMatrix[spotRow][i].getValue() != 0){
			if (spotOperation==6 && emptyVal+spotMatrix[spotRow][i].getValue()!=spotResult)
				return false;
			if(spotOperation==7 && Math.abs(emptyVal-spotMatrix[spotRow][i].getValue()) != spotResult)
				return false;
			if(spotOperation==8 && emptyVal*spotMatrix[spotRow][i].getValue() != spotResult)
				return false;
			if(spotOperation==9 && emptyVal/spotMatrix[spotRow][i].getValue() !=spotResult && spotMatrix[spotRow][i].getValue()/emptyVal!=spotResult)
				return false;	
		}		

	}
	System.out.println("true");
	return true;
}

	public void printMatrix(){
		for (int row = 0; row<4; row++){   
			for (int column = 0; column <4; column++){
				System.out.print(spotMatrix[row][column].getValue()+" ");
			}
		System.out.println();
		}
	}
}