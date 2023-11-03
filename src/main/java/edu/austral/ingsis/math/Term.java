package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Term {

    public double solve(Map<String,Double> variables);

    public String printTerm();

    public List<String> listVariables();

}
