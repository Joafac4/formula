package edu.austral.ingsis.math.visitorPattern;

import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

public interface Termino {

    public <T> T accept(TermVisitor<T> visitor);



}
