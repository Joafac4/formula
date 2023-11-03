package edu.austral.ingsis.math.operator;

import edu.austral.ingsis.math.Term;

import java.util.List;
import java.util.Map;

public class Substraction implements Operator{
    private boolean parenthesis = false;
    private Term left;
    private Term right;

    public Substraction(Term left, Term right) {
        this.left = left;
        this.right = right;
    }

    public Substraction(Term left, Term right, boolean parenthesis) {
        this.left = left;
        this.right = right;
        this.parenthesis = parenthesis;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return left.solve(variables) - right.solve(variables);
    }

    @Override
    public String printTerm() {
        if(!parenthesis) return left.printTerm()+" - "+right.printTerm();
        else{
            return "("+left.printTerm()+" - "+right.printTerm()+")";
        }
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = left.listVariables();
        variables.addAll(right.listVariables());
        return variables;
    }
}
