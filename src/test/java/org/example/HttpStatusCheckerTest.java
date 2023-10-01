package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {

    @Test
    void testGetStatusImageCorrectCode() {
        //Given
        HttpStatusChecker checker = new HttpStatusChecker();
        int code = 418;
        //When
        String result = checker.getStatusImage(code);
        //Then
        String except = "https://http.cat/418.jpg";
        assertEquals(except,result);
    }

    @Test
    void textGetStatusImageIncorrectCode(){
        //Given
        HttpStatusChecker checker = new HttpStatusChecker();
        int code = 466;
        //When & Then
        assertThrows(Exception.class, () ->{
            checker.getStatusImage(code);
        });
    }
}