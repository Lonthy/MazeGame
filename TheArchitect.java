import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
//Your life is the sum of a remainder of an unbalanced equation inherent to the programming
//of the matrix

public class TheArchitect extends JFrame
{
   public void setExit(int x, int y)//records the location of the exit so we can show it when its time
   {
       WallXCord=x;
       WallYCord=y;  
   } 
   public void showWall()//used when its time to show the exit.  
   {
       updatedMatrix[WallXCord][WallYCord]="E";  
   }

    public void playerMove(int xScale, int yScale, String[][] currentMatrix,int totalDimonds)
    {
       int x=0;
       int y=0;
       int found=0;
       globalTotalDimonds=totalDimonds; //use this later for the gui dimond count
       nextLevel(false); //dont go to the next level yet.
       String[][] junkMatrix=currentMatrix;//we will be updating currentMatrix  
        for (int i = 0; i < currentMatrix.length; i++) //for loop will find were the player is now
        {
        for (int j = 0; j < currentMatrix[i].length; j++) 
        {
           if(currentMatrix[i][j].equals("P"))//we found the player
           {
            x=i;//record the players position
            y=j;
            found = 1;
            break;
           }
        }}//end both for loops
        
        try {
            currentMatrix = moveBlocks(currentMatrix,x,y,xScale,yScale);
        }catch(ArrayIndexOutOfBoundsException exception) {
        	throw new StupidAssMove("Ass Hole hit wall!");
        }
                
            if(collected==totalDimonds)//if we have all the dimonds give the player the exit
            showWall();
               
            updatedMatrix=currentMatrix;  //we will return updatedMatrix for the gui                     
        }//end method
    
    public String[][] moveBlocks(String matrix[][], int x, int y, int xScale, int yScale){
    	if(matrix[x+xScale][y+yScale].equals("H")){
            matrix[x][y]="N";
            matrix[x+xScale][y+yScale]="P";
            matrix[x][y]="N";
            collected+=1;
            return matrix;
        }
    	if(matrix[x+xScale][y+yScale].equals("D")){
            matrix[x][y]="N";
            matrix[x+xScale][y+yScale]="P";
            collected+=1;
            return matrix;
    	}
    	if(matrix[x+xScale][y+yScale].equals("M") && matrix[x+(xScale*2)][y+(yScale*2)].equals("N")){
            matrix[x][y]="N";
            matrix[x+xScale][y+yScale]="P"; 
            matrix[x+(xScale*2)][y+(yScale*2)]="M";
            return matrix;
        }
    	if (matrix[x+xScale][y+yScale].equals("N")){
            matrix[x][y]="N";
            matrix[x+xScale][y+yScale]="P";
            return matrix;
        }
    	if (matrix[x+xScale][y+yScale].equals("E")){
            matrix[x][y]="N";
            matrix[x+xScale][y+yScale]="P"; 
            nextLevel(true);
            return matrix;
        }
    	
    	throw new StupidAssMove("Ass Hole hit wall!");
    }

    public void nextLevel(boolean tOrF)//true we go to next level, false we update current level's gui 
    {
        level=tOrF;
    }
    
    public boolean getLevel()//returs level true or false
    {
        return level;
    }
        
    public int getDimondsLeft()
    {
        return globalTotalDimonds-collected;//for GUI JLabel, show how many dimonds are left to be collected
    }
    
    public String[][] getUpdatedMatrix()//returns the updated matrix for the gui to display
    {
        return updatedMatrix;    
    }
    
    private class StupidAssMove extends RuntimeException
    {
         public StupidAssMove(String event)
         {
             JFrame frame = new JFrame("Warning");
             JOptionPane.showMessageDialog(frame, "You Stupid Ass, Ran into something did you?");
         }
    }//end inner class
    
int foundPlayer=0;
String[][] updatedMatrix;
int WallXCord;
int WallYCord;
int collected=0;
boolean level;
int globalTotalDimonds=0;
}//end class
