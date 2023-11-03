package edu.austral.ingsis.math.visitorPattern.visitor;

import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;

import java.util.ArrayList;
import java.util.List;

public class ListVariablesVisitor implements TermVisitor<List<String>>{

    @Override
    public List<String> visitSum(Sum sumTerm) {
        List<String> variables = sumTerm.getLeft().accept(this);
        variables.addAll(sumTerm.getRight().accept(this));
        return variables;
    }

    @Override
    public List<String> visitSubstraction(Substraction substractionTerm) {
        List<String> variables = substractionTerm.getLeft().accept(this);
        variables.addAll(substractionTerm.getRight().accept(this));
        return variables;
    }

    @Override
    public List<String> visitProduct(Product productTerm) {
        List<String> variables = productTerm.getLeft().accept(this);
        variables.addAll(productTerm.getRight().accept(this));
        return variables;
    }

    @Override
    public List<String> visitModule(Module moduleTerm) {
        return moduleTerm.getTerm().accept(this);
    }

    @Override
    public List<String> visitSquareRoot(SquareRoot squareRootTerm) {
        return squareRootTerm.getTerm().accept(this);
    }

    @Override
    public List<String> visitDivision(Division divisionTerm) {
        List<String> variables = divisionTerm.getLeft().accept(this);
        variables.addAll(divisionTerm.getRight().accept(this));
        return variables;
    }

    @Override
    public List<String> visitPow(Pow powTerm) {
        List<String> variables = powTerm.getLeft().accept(this);
        variables.addAll(powTerm.getRight().accept(this));
        return variables;
    }

    @Override
    public List<String> visitVariable(VariableVisitor variable) {
        List<String> variables = new ArrayList<>();
        variables.add(variable.getName());
        return variables;
    }

    @Override
    public List<String> visitValue(ValueVisitor value) {
        return new ArrayList<>();
    }
}
