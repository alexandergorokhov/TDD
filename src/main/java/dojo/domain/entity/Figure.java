package dojo.domain.entity;

import utils.UtilsFigures;

public class Figure {
    private Rule rule;


    public Figure(UtilsFigures.FigureEnum figure) {
        switch(figure){
            case ROCK: this.setRule(Rule.ROCK); break;
            case SCISSORS:this.setRule(Rule.SCISSOR); break;
            case PAPER:this.setRule(Rule.PAPER); break;
        }
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
