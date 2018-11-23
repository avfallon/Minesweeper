// mineSweeper.java (class Block (part of the MVC model))
// Copyright Dave Binkley 2018


abstract class Block
{
    protected boolean markedAsMine;
    
    protected Block()
    {
        markedAsMine = false;
    }
    
    protected void markAsMine()
    {
        markedAsMine = true;
    }
    
    protected abstract void guessSafe();
}


class MineBlock extends Block   // [ no instance variables ]
{
    public void guessSafe()
    {
        System.out.println("BOOM");
        System.exit(0);
    }
    
    public void tellNeighborsAboutMine(GameBoard gb, int r, int c)
    {
        gb.incrementCountForSurroundingBlocks(r, c);
    }
    
    public boolean correctlyGuessed()
    {
        return markedAsMine;
    }
    
    public String displayAs()
    {
        if(markedAsMine)
            return "M";
        else
            return ". ";
    }
}


class NumberBlock extends Block
{
    private int adjacentMineCount;
    private boolean exposed;
    
    public NumberBlock()
    {
        adjacentMineCount = 0;
        exposed = false;
    }
    
    public void guessSafe()
    {
        exposed = true;
        markedAsMine = false;
    }
    
    public void IncrementMineCount()
    {
        adjacentMineCount++;
    }
    
    public boolean CorrectlyGuessed()
    {
        return !markedAsMine;
    }
    
    public String displayAs()
    {
        if(markedAsMine)
            return "M ";
        if(exposed)
            return adjacentMineCount + " ";
        else
            return ". ";
    }
}


