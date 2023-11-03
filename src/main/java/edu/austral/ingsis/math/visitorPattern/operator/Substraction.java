package edu.austral.ingsis.math.visitorPattern.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.Termino;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class Substraction implements OperatorVisitor {
    private boolean parenthesis = false;
    private Termino left;
    private Termino right;

    public Substraction(Termino left, Termino right) {
        this.left = left;
        this.right = right;
    }

    public Substraction(Termino left, Termino right, boolean parenthesis) {
        this.left = left;
        this.right = right;
        this.parenthesis = parenthesis;
    }

    @Override
    public <T> T accept(TermVisitor<T> visitor) {
        return visitor.visitSubstraction(this);
    }


    public Termino getLeft() {
        return left;
    }

    public Termino getRight() {
        return right;
    }

    public boolean isParenthesis() {
        return parenthesis;
    }


}
