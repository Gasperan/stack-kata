package com.gaspar;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack(100);
    }


    @Test
    public void whenICreateANewStackShouldBeEmpty() throws Exception {
        assertThat(stack.size(), is(0));
    }


    @Test
    public void whenIPushOneElementStackSizeShouldBeOne() throws Exception {
        stack.push(3);

        assertThat(stack.size(), is(1));
    }


    @Test
    public void whenIPushTwoElementsStackSizeShouldBeTwo() throws Exception {
        stack.push(3);
        stack.push(8);

        assertThat(stack.size(), is(2));
    }


    @Test
    public void whenIPush1ShouldPop1() throws Exception {
        stack.push(1);

        assertThat(stack.pop(), is(1));
    }


    @Test
    public void whenIPush1And4ShouldPop4And1() throws Exception {
        stack.push(1);
        stack.push(4);

        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(1));
    }


    @Test(expected = Stack.Underflow.class)
    public void whenIPopAnEmptyStackShouldThrowException() throws Exception {
        stack.pop();
    }


    @Test(expected = Stack.Overflow.class)
    public void whenIPushOverFullStackShouldThrowException() throws Exception {
        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(4);
        stack.push(7);
    }


    @Test(expected = Stack.Overflow.class)
    public void whenIPushOverZeroCapacityStackShouldThrowException() throws Exception {
        Stack stack = new Stack(0);

        stack.push(1);
    }


    @Test(expected = Stack.Underflow.class)
    public void whenIPopOverZeroCapacityStackShouldThrowException() throws Exception {
        Stack stack = new Stack(0);

        stack.pop();
    }
}
