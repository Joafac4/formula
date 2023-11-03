package edu.austral.ingsis.math.visitorPattern.visitor;

import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;
import edu.austral.ingsis.math.visitorPattern.visitor.TermVisitor;

public class PrintVisitor implements TermVisitor<String> {
    @Override
    public String visitSum(Sum sumTerm) {
        return (sumTerm.getLeft().accept(this)+ " + " +sumTerm.getRight().accept(this));
    }

    @Override
    public String visitSubstraction(Substraction substractionTerm) {
        if(!substractionTerm.isParenthesis()){return (substractionTerm.getLeft().accept(this)+ " - " +substractionTerm.getRight().accept(this));}
        else{return ("("+substractionTerm.getLeft().accept(this)+ " - " +substractionTerm.getRight().accept(this)+")");}
    }

    @Override
    public String visitProduct(Product productTerm) {
        return (productTerm.getLeft().accept(this)+ " * " +productTerm.getRight().accept(this));
    }

    @Override
    public String visitModule(Module moduleTerm) {
        return ("|"+moduleTerm.getTerm().accept(this)+"|");
    }

    @Override
    public String visitSquareRoot(SquareRoot squareRootTerm) {
        return ("sqrt("+squareRootTerm.getTerm().accept(this)+")");
    }

    @Override
    public String visitDivision(Division divisionTerm) {
        return (divisionTerm.getLeft().accept(this)+ " / " +divisionTerm.getRight().accept(this));
    }

    @Override
    public String visitPow(Pow powTerm) {
        return (powTerm.getLeft().accept(this)+ " ^ " +powTerm.getRight().accept(this));
    }

    @Override
    public String visitVariable(VariableVisitor variable) {
        return variable.getName();
    }

    @Override
    public String visitValue(ValueVisitor value) {
        return (""+value.getValue());
    }


}
