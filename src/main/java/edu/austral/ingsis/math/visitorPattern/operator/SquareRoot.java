package edu.austral.ingsis.math.visitorPattern.operator;

import edu.austral.ingsis.math.composite.Term;
import edu.austral.ingsis.math.visitorPattern.Termino;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

import java.util.List;
import java.util.Map;

public class SquareRoot implements OperatorVisitor {
    private Termino term;

    public SquareRoot(Termino term) {
        this.term = term;
    }
    @Override
    public <T> T accept(TermVisitor<T> visitor) {
        return visitor.visitSquareRoot(this);
    }

    public Termino getTerm() {
        return term;
    }


}
