package dojo.domain.entity;

import utils.UtilsFigures;

public class Player {
    private Figure figure;

     private void setFigure(Figure figure){
         this.figure = figure;
     }
    public void setPlayerFigure(UtilsFigures.FigureEnum figure) {
        this.setFigure(new Figure(figure));
    }

    public Figure getFigure() {
        return figure;
    }

    public Player play(Player player2) {

        Player winner =  this.getFigure().getRule().Iwin( player2.getFigure().getRule())
                ? this:player2;
       return this.getFigure().getRule().itsATie( winner.getFigure().getRule())
                ? this:player2;

    }
}
