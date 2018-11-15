// mineSweeper.java (class Block (part of the MVC model))
// Copyright Dave Binkley 2018


abstract class Block
{
    public abstract String cheat();
}


class MineBlock extends Block   // [ no instance variables ]
{
    public String cheat() { return "M"; }
}


class NumberBlock extends Block
{
    public String cheat() { return ""+"0123456789".charAt(adjacentMineCount); }
}


