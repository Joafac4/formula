package edu.austral.ingsis.math.visitorPattern;

import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.Map;

public class VariableVisitor implements Termino{

    private Map<String,Double> variables;
    private String name;

    public VariableVisitor(String name){
        this.name = name;
    }

    public VariableVisitor(String name, Map<String,Double> variables){
        this.name = name;
        this.variables = variables;
    }
    @Override
    public <T> T accept(TermVisitor<T> visitor) {
        return visitor.visitVariable(this);
    }

    public String getName(){
        return name;
    }


    public double resolve(){
        return this.variables.get(name);
    }
}
