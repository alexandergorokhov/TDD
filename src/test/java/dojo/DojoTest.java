package dojo;

import dojo.domain.entity.Player;
import org.junit.Assert;
import org.junit.Test;
import utils.UtilsFigures;

public class DojoTest {

    @Test
    public void rockVsScissors(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void scissorsVsRock(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player winner = player1.play(player2);

        Assert.assertEquals(player2,winner);
    }

    @Test
    public void rockVsPaper(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player winner = player1.play(player2);

        Assert.assertEquals(player2,winner);
    }

    @Test
    public void paperVsRock(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void paperVsScissors(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player winner = player1.play(player2);

        Assert.assertEquals(player2,winner);
    }


    @Test
    public void ScissorsVsPaper(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void rockVsRock(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void ScissorsVsScissors(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void paperVsPaper(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player winner = player1.play(player2);

        Assert.assertEquals(player1,winner);
    }

    @Test
    public void rockVsPaperVsScissors(){
        Player player1 = new Player();
        player1.setPlayerFigure(UtilsFigures.FigureEnum.ROCK);
        Player player2 = new Player();
        player2.setPlayerFigure(UtilsFigures.FigureEnum.PAPER);
        Player player3 = new Player();
        player3.setPlayerFigure(UtilsFigures.FigureEnum.SCISSORS);
        Player winner = player1.play(player2).play(player3);

        Assert.assertEquals(player3,winner);
    }

}
