package edu.austral.ingsis.math.operator;

import edu.austral.ingsis.math.Term;
import edu.austral.ingsis.math.Value;

import java.util.List;
import java.util.Map;

public class Sum implements Operator{
    private Term left;
    private Term right;


    public Sum(Term left, Term right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double solve(Map<String,Double> variables) {
        return left.solve(variables) + right.solve(variables);
    }

    @Override
    public String printTerm() {
        return left.printTerm()+" + "+right.printTerm();
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = left.listVariables();
        variables.addAll(right.listVariables());
        return variables;
    }


}
