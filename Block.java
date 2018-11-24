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
    
    protected abstract boolean correctlyGuessed();
    protected abstract void guessSafe();
    protected abstract void tellNeighborsAboutMine(GameBoard gb, int r, int c);
    protected abstract void incrementMineCount();
    protected abstract String displayAs();
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
    
    public void incrementMineCount() {}
    
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
    
    public void incrementMineCount()
    {
        adjacentMineCount++;
    }
    
    public void tellNeighborsAboutMine(GameBoard gb, int r, int c){}
    
    public boolean correctlyGuessed()
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


