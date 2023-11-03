package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operator.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    private Variable leftParentesis;
    private Variable rightParentesis;
    @Before
    public void setUp(){
        Variable parentesis = new Variable("(");
        Variable parentesis1 = new Variable(")");
        leftParentesis = parentesis;
        rightParentesis = parentesis1;
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1.0 + 6.0";
        final String result = new Sum(new Value(1),new Value(6)).printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12.0 / 2.0";
        final String result = new Division(new Value(12), new Value(2)).printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "9.0 / 2.0 * 3.0";
        Term term = new Division(new Value(9),new Value(2));
        Term term1 = new Product(term,new Value(3));
        final String result = term1.printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "27.0 / 6.0 ^ 2.0";
        Term term = new Division(new Value(27),new Value(6));
        Term term1 = new Pow(term,new Value(2));
        final String result = term1.printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "| value | - 8.0";
        final String result = new Substraction(new Module(new Variable("value")),new Value(8)).printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "| value | - 8.0";
        final String result = new Substraction(new Module(new Variable("value")),new Value(8)).printTerm();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5.0 - i) * 8.0";
        final String result = new Product(new Substraction(new Value(5),new Variable("i"),true),new Value(8)).printTerm();

        assertThat(result, equalTo(expected));
    }
}
