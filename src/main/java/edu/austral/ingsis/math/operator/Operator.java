package edu.austral.ingsis.math.operator;

import edu.austral.ingsis.math.Term;

import java.util.List;
import java.util.Map;

public interface Operator extends Term {

    public double solve(Map<String,Double> variables);

    public String printTerm();

    public List<String> listVariables();
}
