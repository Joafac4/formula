package edu.austral.ingsis.math.operator;

import edu.austral.ingsis.math.Term;

import java.util.List;
import java.util.Map;

public class Pow implements Operator{
    private Term left;
    private Term right;

    public Pow(Term left, Term right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public double solve(Map<String, Double> variables) {
        return Math.pow(left.solve(variables)  , right.solve(variables));
    }

    @Override
    public String printTerm() {
        return left.printTerm()+ " ^ "+right.printTerm();
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = left.listVariables();
        variables.addAll(right.listVariables());
        return variables;
    }
}
