package edu.austral.ingsis.math.visitorPattern;

import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

public class ValueVisitor implements Termino{
    private double value;

    public ValueVisitor(double value){
        this.value = value;
    }
    @Override
    public <T> T accept(TermVisitor<T> visitor) {
        return visitor.visitValue(this);
    }

    public double getValue(){
        return value;
    }

}
