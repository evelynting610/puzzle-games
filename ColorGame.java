import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColorGame extends Game{
    
    private Spot[] [] spotMatrix = {{new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
				    {new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
				    {new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
				    {new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
				    {new Spot(), new Spot(), new Spot(), new Spot(), new Spot()},
    };
    
    
    int [] [] colorMatrix = new int [10] [5];
    //5x5 with values
    //underneath, 5x5 that specifies box
    
    int [] possibleValues = {1, 2, 3, 4, 5};  
    
    Spot [] empties = new Spot [20];
    
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
	    for (int row = 0; row<10; row++){   
		for (int column = 0; column <5; column++){
		    colorMatrix[row][column] = (sc.nextInt());
		}
	    }
	}
    }
    
    public void fillSpots(){
	int ecount = 0;
	for (int row = 0; row<5; row++){   
	    for (int column = 0; column <5; column++){
		spotMatrix[row][column].setRow(row);
		spotMatrix[row][column].setColumn(column);
		spotMatrix[row][column].setValue(colorMatrix[row][column]);
		spotMatrix[row][column].setBox(colorMatrix[row+5][column]);
		if (colorMatrix[row][column]==0){
		    empties[ecount]=spotMatrix[row][column];
		    ecount=ecount+1;}
	    }
	}
	
    }
    
    public boolean constraintsWork(Spot s){ 
	int emptyVal=s.getValue();
	int spotRow = s.getRow();
	int spotCol = s.getColumn();
	
	int spotBox = s.getBox();
	int count = 0;
	int[] sameBox = new int [5];
	
	
	for (int row = 0; row<5; row++){   
	    for (int column = 0; column <5; column++){
		if(spotRow != row && spotCol != column){
		    if (spotBox==spotMatrix[row][column].getBox()){
			sameBox[count]=spotMatrix[row][column].getValue();
			count=count+1;}
		}
	    }
	}
	
	
	for(int i = 0; i<5; i++){
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
	String letter = "E";
	for (int row = 0; row<5; row++){   
	    for (int column = 0; column <5; column++){
		if (spotMatrix[row][column].getValue() == 1)
		    letter = "B";
		if (spotMatrix[row][column].getValue() == 2)
		    letter = "G";
		if (spotMatrix[row][column].getValue() == 3)
		    letter = "R";
		if (spotMatrix[row][column].getValue() == 4)
		    letter = "V";
		if (spotMatrix[row][column].getValue() == 5)
		    letter = "Y";
		System.out.print(letter+" ");
	    }
	    System.out.println();
	}
    }
}