package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operator.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    private HashMap<String,Double> variables = new HashMap<>();
    @Before
    public void setUp() {
        variables.put("1", 1d);
        variables.put("6", 6d);
        variables.put("2", 2d);
        variables.put("3", 3d);
        variables.put("9", 9d);
        variables.put("27", 27d);
        variables.put("12", 12d);
        variables.put("5", 5d);
        variables.put("8", 8d);
        variables.put("36", 36d);
        variables.put("1/2", 1/2d);
        variables.put("136", 136d);
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = 7d;

        assertThat(result, equalTo(new Sum(new Value(1), new Value(6)).solve(variables)));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = 6d;

        assertThat(result, equalTo(new Division(new Value(12), new Value(2)).solve(variables)));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = 13.5;

        assertThat(result, equalTo(new Product(new Division(new Value(9), new Value(2)), new Value(3)).solve(variables)));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = 20.25;

        assertThat(result, equalTo(new Pow(new Division(new Value(27), new Value(6)), new Value(2)).solve(variables)));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = 6d;

        assertThat(result, equalTo(new Pow(new Value(36), new Value(1/2d)).solve(variables)));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = 136d;

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = 136d;

        assertThat(result, equalTo(new Module(new Value(-136)).solve(variables)));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = 0d;

        assertThat(result, equalTo(new Product(new Substraction(new Value(5), new Value(5)), new Value(8)).solve(variables)));
    }
}
