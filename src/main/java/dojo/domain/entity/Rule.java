package dojo.domain.entity;

enum Rule {
    ROCK{
        @Override
        public boolean Iwin(Rule figureRule) {
            return figureRule.equals(Rule.SCISSOR);
        }

        @Override
        public boolean ILoose(Rule figureRule) {
            return figureRule.equals(Rule.PAPER);
        }

        @Override
        public boolean itsATie(Rule figureRule) {
            return figureRule.equals(Rule.ROCK);
        }
    }, SCISSOR{
        @Override
        public boolean Iwin(Rule figureRule) {
            return figureRule.equals(Rule.PAPER);
        }

        @Override
        public boolean ILoose(Rule figureRule) {
            return figureRule.equals(Rule.ROCK);
        }

        @Override
        public boolean itsATie(Rule figureRule) {
            return figureRule.equals(Rule.SCISSOR);
        }
    }, PAPER{
        @Override
        public boolean Iwin(Rule figureRule) {
            return figureRule.equals(Rule.ROCK);
        }

        @Override
        public boolean ILoose(Rule figureRule) {
            return figureRule.equals(Rule.SCISSOR);
        }

        @Override
        public boolean itsATie(Rule figureRule) {
            return figureRule.equals(Rule.PAPER);
        }
    };

    public abstract boolean Iwin(Rule figureRule);
    public abstract boolean ILoose(Rule figureRule);
    public abstract boolean itsATie(Rule figureRule);


}
