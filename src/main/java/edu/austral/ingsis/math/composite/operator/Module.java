package edu.austral.ingsis.math.composite.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class Module implements Operator{
    private Term term;
    public Module(Term term) {
        this.term = term;
    }


    @Override
    public double solve(Map<String, Double> variables) {
        return Math.abs(term.solve(variables));
    }

    @Override
    public String printTerm() {
        return "| "+term.printTerm()+" |";
    }

    @Override
    public List<String> listVariables() {
        return  term.listVariables();
    }

    public Term getTerm() {
        return term;
    }


}
