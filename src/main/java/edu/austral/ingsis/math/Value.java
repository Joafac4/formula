package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Value implements Term {
    private double value;

    public Value(double value){
        this.value = value;
    }
    @Override
    public double solve(Map<String,Double> variables) {
        return this.value;
    }

    @Override
    public String printTerm() {
        return ""+value;
    }

    @Override
    public List<String> listVariables() {
        return new ArrayList<>();
    }
}
