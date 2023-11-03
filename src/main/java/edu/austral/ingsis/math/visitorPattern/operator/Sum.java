package edu.austral.ingsis.math.visitorPattern.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.Termino;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class Sum implements OperatorVisitor {
    private Termino left;
    private Termino right;


    public Sum(Termino left, Termino right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(TermVisitor<T> visitor) {
        return visitor.visitSum(this);
    }


    public Termino getLeft() {
        return left;
    }

    public Termino getRight() {
        return right;
    }



}
