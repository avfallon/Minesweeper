// mineSweeper.java (class TTYView (an MVC view))
// Copyright Dave Binkley 2018


interface View
{
  public void setModel(GameBoard m);
  public void initialDisplay();
  abstract public void update(int r, int c);
  abstract public void gameOver(String msg);
}


// this abstract class provides default versions of the methods
// setModel, initialDisplay, and gameOver
abstract class aView implements View
{
  protected GameBoard model = null;

  public void setModel(GameBoard m) {model = m;}
  public void initialDisplay() {update(0, 0);}
  public void gameOver(String msg) {System.out.println(msg); System.exit(0);}

  abstract public void update(int r, int c);
}


class TTYView extends aView
{
  public void update(int _r, int _c)   // tty version ignores _r and _c
  {
    for(int r = 0; r < GameBoard.BOARD_SIZE; r++)
    {
      String S = "";
      for(int c = 0; c < GameBoard.BOARD_SIZE; c++)
        S += model.displayAs(r, c);
      System.out.println(S);
    }
  }
}


