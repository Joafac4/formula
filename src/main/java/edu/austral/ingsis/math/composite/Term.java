package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public interface Term {

    public double solve(Map<String,Double> variables);

    public String printTerm();

    public List<String> listVariables();



}
