// mineSweeper.java (class GameBoard (part of the MVC model))
// Copyright Dave Binkley 2018


public class GameBoard
{

  protected void cheat()
  {
    for(int r=0; r<BOARD_SIZE; r++)        
    {
      String S = "";
      for(int c=0; c<BOARD_SIZE; c++)
        S += grid[r][c].cheat();
      System.out.println(S);
    }
  }


  public GameBoard(View v) 
  { 
    view = v; 
    int cnt = NUMBER_OF_MINES;
  
    ...
  
    for(int r=0; r<BOARD_SIZE; r++)        // fill in mine counters
      for(int c=0; c<BOARD_SIZE; c++)
        grid[r][c].tellNeighborsAboutMine(this, r, c);

    // cheat();  // for testing ... and amazing your friends!
  }


}


