import java.util.Random;

// mineSweeper.java (class GameBoard (part of the MVC model))
// Copyright Dave Binkley 2018


public class GameBoard
{
    private Block[][] grid;
    private View view;
    public static final int BOARD_SIZE = 5;
    public static final int NUMBER_OF_MINES = 3;
    
    public GameBoard(View v)
    {
        grid = new Block[BOARD_SIZE][BOARD_SIZE];
        view = v;
        int minesLeftToAdd = NUMBER_OF_MINES;
        for(int r=0;r<BOARD_SIZE;r++)
        {
            for(int c=0;c<BOARD_SIZE;c++)
            {
                if(minesLeftToAdd > 0)
                {
                    Block mineBlock = new MineBlock();
                    grid[r][c] = mineBlock;
                    minesLeftToAdd--;
                }
                else
                {
                    Block numBlock = new NumberBlock();
                    grid[r][c] = numBlock;
            
                }
            }
        }
        
        Random rand = new Random();
        int mineCount = NUMBER_OF_MINES;
        
        for(int r=0; r<BOARD_SIZE; r++)        
        {
            for(int c=0; c<BOARD_SIZE; c++)
            {
                if(mineCount>0)
                {
                    Block temp = grid[r][c];
                    int _r = rand.nextInt(BOARD_SIZE);
                    int _c = rand.nextInt(BOARD_SIZE);
                    grid[r][c] = grid[_r][_c];
                    grid[_r][_c] = temp;
                }
            }
        }    
        
        for(int r=0; r<BOARD_SIZE; r++)        
            for(int c=0; c<BOARD_SIZE; c++)
              grid[r][c].tellNeighborsAboutMine(this, r, c);
    }
    
    public void guessBlockIsSafe(int r, int c)
    {
        grid[r][c].guessSafe();
    }
    
    public void incrementCountForSurroundingBlocks(int r, int c)
    {
        for(int i=r-1; i<=r+1; i++)        
        {
            for(int j=c-1; j<=c+1; j++)
            {
                if(i>=0 && i< BOARD_SIZE && j>=0 && j< BOARD_SIZE)
                {
                    grid[i][j].incrementMineCount();
                }
            }
        }
    }
    
    public void markBlockAsMine(int r, int c)
    {
        grid[r][c].markAsMine();
    }
    
    public boolean minesAllFound()
    {
        for(int r=0; r<BOARD_SIZE; r++)        
            for(int c=0; c<BOARD_SIZE; c++)
                if(!grid[r][c].correctlyGuessed())
                    return false;
        return true;
    }
    
    public String displayAs(int r, int c)
    {
        return grid[r][c].displayAs();
    }
}
