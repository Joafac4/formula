package edu.austral.ingsis.math.visitorTests;

import edu.austral.ingsis.math.visitorPattern.Termino;
import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;
import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.visitor.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VisitorPrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1.0 + 6.0";
        final String result = new Sum(new ValueVisitor(1), new ValueVisitor(6)).accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12.0 / 2.0";
        final String result = new Division(new ValueVisitor(12), new ValueVisitor(2)).accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "9.0 / 2.0 * 3.0";
        Termino term = new Division(new ValueVisitor(9),new ValueVisitor(2));
        Termino term1 = new Product(term,new ValueVisitor(3));
        final String result = term1.accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "27.0 / 6.0 ^ 2.0";
        Termino term = new Division(new ValueVisitor(27),new ValueVisitor(6));
        Termino term1 = new Pow(term,new ValueVisitor(2));
        final String result = term1.accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8.0";
        final String result = new Substraction(new Module(new VariableVisitor("value")),new ValueVisitor(8)).accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8.0";
        final String result = new Substraction(new Module(new VariableVisitor("value")),new ValueVisitor(8)).accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5.0 - i) * 8.0";
        final String result = new Product(new Substraction(new ValueVisitor(5),new VariableVisitor("i"),true),new ValueVisitor(8)).accept(new PrintVisitor());

        assertThat(result, equalTo(expected));
    }
}
