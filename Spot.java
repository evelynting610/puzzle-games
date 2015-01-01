
public class Spot{
    private int row = 0;
    private int column = 0 ;
    private int box = 0;
    private int value=0;
    private int result = 0;
    private int operation = 0;
    
    public void setRow(int r){
	this.row = r;
    }
    
    public int getRow(){
	return this.row;
    }
    
    public void setColumn(int c){
	this.column = c;
    }
    
    public int getColumn(){
	return this.column;
    }
    
    public void setBox(int b){
	this.box = b;
    }
    
    public int getBox(){
	return this.box;
    }
    
    public void setResult(int r){
	this.result = r;
    }
    
    public int getResult(){
	return this.result;
    }
    
    public void setOperation(int o){
	this.operation = o;
    }
    
    public int getOperation(){
	return this.operation;
    }
    
    public void setValue (int v){
	this.value=v;
    }
    
    public int getValue(){
	return this.value;
    }
    
    
}