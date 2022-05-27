package com.example.springsqlapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringSqlAppApplicationTests {

    Calculator calculatorUnderTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        //given
        int no1=20;
        int no2=30;
        //when
        int result = calculatorUnderTest.add(no1,no2);
        //then
        int expected = 50;
        assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
