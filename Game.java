public class Game{

    Spot [] empties = new Spot [1];
    int [] possibles = new int [1];
    Spot [] [] matrix = new Spot [1] [1];
    
    public Spot [] getEmpties(){
	return empties;
    }
    
    public int [] getPossibles(){
	return possibles;
    }
    
    public Spot [] [] getMatrix(){
	return matrix;
    }
    
    public void fillSpots(){
	
    }
    
    public void addFile(String fileName) {
    }
    
    public boolean constraintsWork(Spot s){
	return true;
    }
    
    public void printMatrix(){
	System.out.println("didn't override");
    }
}