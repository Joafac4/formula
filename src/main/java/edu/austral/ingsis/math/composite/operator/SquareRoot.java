package edu.austral.ingsis.math.composite.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class SquareRoot implements Operator{
    private Term term;

    public SquareRoot(Term term) {
        this.term = term;
    }
    @Override
    public double solve(Map<String, Double> variables) {
        return Math.sqrt(term.solve(variables));
    }

    @Override
    public String printTerm() {
        return "sqrt "+term.printTerm();
    }

    @Override
    public List<String> listVariables() {
        return  term.listVariables();
    }

    public Term getTerm() {
        return term;
    }


}
