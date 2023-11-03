package edu.austral.ingsis.math.visitorPattern.visitor;

import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

public class SolveVisitor implements TermVisitor<Double> {
    @Override
    public Double visitSum(Sum sumTerm) {
        return sumTerm.getLeft().accept(this) + sumTerm.getRight().accept(this);
    }

    @Override
    public Double visitSubstraction(Substraction substractionTerm) {
        return substractionTerm.getLeft().accept(this) - substractionTerm.getRight().accept(this);
    }

    @Override
    public Double visitProduct(Product productTerm) {
        return productTerm.getLeft().accept(this) * productTerm.getRight().accept(this);
    }

    @Override
    public Double visitModule(Module moduleTerm) {
        return Math.abs(moduleTerm.getTerm().accept(this));
    }

    @Override
    public Double visitSquareRoot(SquareRoot squareRootTerm) {
        return null;
    }

    @Override
    public Double visitDivision(Division divisionTerm) {
        return divisionTerm.getLeft().accept(this) / divisionTerm.getRight().accept(this);
    }

    @Override
    public Double visitPow(Pow powTerm) {
        return Math.pow(powTerm.getLeft().accept(this), powTerm.getRight().accept(this));
    }

    @Override
    public Double visitVariable(VariableVisitor variable) {
        return variable.resolve();
    }

    @Override
    public Double visitValue(ValueVisitor value) {
        return value.getValue();
    }
}
