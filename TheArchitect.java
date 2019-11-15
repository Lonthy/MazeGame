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

    public void playerMove(int xScale, int yScale, String[][] currentMatrix,int totalDimonds)throws StupidAssMove
    {
       int x=0;
       int y=0;
       int found=0;
       globalTotalDimonds=totalDimonds; //use this later for the gui dimond count

       Block[][] levelBlockMatrix = buildBlockMatrix(currentMatrix);
       updatedMatrix = currentMatrix;

       nextLevel(false); //dont go to the next level yet.
        for (int i = 0; i < levelBlockMatrix.length; i++) //for loop will find were the player is now
        {
        for (int j = 0; j < levelBlockMatrix[i].length; j++) 
        {
           if(levelBlockMatrix[i][j].toString().equals("P"))//we found the player
           {
            x=i;//record the players position
            y=j;
            found = 1;
            break;
           }
        }}//end both for loops

            levelBlockMatrix[x+xScale][y+yScale].collision(this, x, y, xScale, yScale);
                
            if(collected==totalDimonds)//if we have all the dimonds give the player the exit
                showWall();                    
        }//end method
    
    private Block[][] buildBlockMatrix(String[][] matrix) {
        Block[][] blockMatrix = new Block[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                blockMatrix[i][j] = BlockFactory.createBlock(matrix[i][j]);
        
        return blockMatrix;
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
