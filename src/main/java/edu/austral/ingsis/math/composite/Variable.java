package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Variable implements Term {
    private String name;

    public Variable(String name){
        this.name = name;
    }


    @Override
    public double solve(Map<String,Double> variables) {
        return variables.get(name);
    }

    @Override
    public String printTerm() {
        return name;
    }

    @Override
    public List<String> listVariables() {
         List<String> newList = new ArrayList<>();
         newList.add(name);
         return newList;

    }



}
