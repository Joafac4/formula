package edu.austral.ingsis.math.visitorPattern.visitor;

import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;

public interface TermVisitor <T> {

    public T visitSum(Sum sumTerm);

    public T visitSubstraction(Substraction substractionTerm);

    public T visitProduct(Product productTerm);

    public T visitModule(Module moduleTerm);

    public T visitSquareRoot(SquareRoot squareRootTerm);

    public T visitDivision(Division divisionTerm);

    public T visitPow(Pow powTerm);

    public T visitVariable(VariableVisitor variable);

    public T visitValue(ValueVisitor value);


}
