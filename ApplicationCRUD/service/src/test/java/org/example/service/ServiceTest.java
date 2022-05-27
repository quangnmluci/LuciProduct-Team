package org.example.service;

import org.example.Dao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
//    Khoi tao 1 mock Dao
    @Mock
    private Dao dao;

//    Khoi tao 1 injectMockservice
    @InjectMocks
    private Service service;

    @Test
    void shouldReturnFalseIfInputNull(){
        assertFalse(service.save(null));
    }

    @Test
    void shouldReturnTrueIfDaoSaveSuccessAndInputNotNull(){
        when(dao.save(any())).thenReturn(true);
        assertTrue(service.save(new Service.ServiceDTO()));
    }

}
