package edu.austral.ingsis.math.composite.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class Division implements Operator{
    private Term left;
    private Term right;

    public Division(Term left, Term right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double solve(Map<String,Double> variables) {
        return left.solve(variables) / right.solve(variables);
    }

    @Override
    public String printTerm() {
        return left.printTerm()+ " / "+ right.printTerm();
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = left.listVariables();
        variables.addAll(right.listVariables());
        return variables;
    }
    public Term getLeft() {
        return left;
    }

    public Term getRight() {
        return right;
    }


}
