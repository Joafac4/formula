package edu.austral.ingsis.math.visitorTests;

import edu.austral.ingsis.math.visitorPattern.ValueVisitor;
import edu.austral.ingsis.math.visitorPattern.VariableVisitor;
import edu.austral.ingsis.math.visitorPattern.operator.*;
import edu.austral.ingsis.math.visitorPattern.visitor.ListVariablesVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

public class VisitorListVariablesTest {


    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = new Sum(new ValueVisitor(1), new ValueVisitor(6)).accept(new ListVariablesVisitor());

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = new Division(new ValueVisitor(12), new VariableVisitor("div")).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = new Product(new Division(new ValueVisitor(9), new VariableVisitor("x")), new VariableVisitor("y")).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = new Pow(new Division(new ValueVisitor(27), new VariableVisitor("a")), new VariableVisitor("b")).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = new Pow(new VariableVisitor("z"), new ValueVisitor(1/2)).accept(new ListVariablesVisitor());
        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = new Substraction(new Module(new VariableVisitor("value")), new ValueVisitor(8)).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = new Substraction(new Module(new VariableVisitor("value")), new ValueVisitor(8)).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = new Product(new Substraction(new ValueVisitor(5), new VariableVisitor("i")), new ValueVisitor(8)).accept(new ListVariablesVisitor());

        assertThat(result, containsInAnyOrder("i"));
    }
}