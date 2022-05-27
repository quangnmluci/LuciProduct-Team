package org.example.controller;

import org.example.service.Service;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ControllerTest {

    @Mock
    private Service service;

    @InjectMocks
    private Controller controller;

    @Test
    void shouldReturnEmptyWhenInputEmpty(){

    }

}
