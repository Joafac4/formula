package edu.austral.ingsis.math.compositeTest;

import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operator.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {
    private HashMap<String,Double> variables = new HashMap<>();

    @Before
    public void setUp() {
        variables.put("1", 1d);
        variables.put("6", 6d);
        variables.put("x", 3d);
        variables.put("div", 4d);
        variables.put("y", 4d);
        variables.put("a", 9d);
        variables.put("b", 3d);
        variables.put("z", 36d);
        variables.put("value", 8d);
        variables.put("i", 2d);
    }

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Double result = 4d;

        assertThat(result, equalTo(new Sum(new Value(1), new Variable("x")).solve(variables)));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Double result = 3d;

        assertThat(result, equalTo(new Division(new Value(12), new Variable("div")).solve(variables)));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Double result = 12d;

        assertThat(result, equalTo(new Division(new Value(9), new Variable("x")).solve(variables) * new Variable("y").solve(variables)));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Double result = 27d;

        assertThat(result, equalTo(Math.pow(new Division(new Value(27), new Variable("a")).solve(variables), new Variable("b").solve(variables))));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Double result = 6d;

        assertThat(result, equalTo(new Pow(new Variable("z"), new Value(1/2d)).solve(variables)));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Double result = 0d;

        assertThat(result, equalTo(new Substraction(new Variable("value"), new Value(8)).solve(variables)));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Double result = 0d;

        assertThat(result, equalTo(new Substraction(new Variable("value"), new Value(8)).solve(variables)));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Double result = 24d;

        assertThat(result, equalTo(new Product(new Substraction(new Value(5), new Variable("i")), new Value(8)).solve(variables)));
    }
}
