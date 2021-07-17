package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import java.util.List;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FSTest2 {

    @Test
    public void testPlayer() {
        
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(25);
        list.add(33);
        list.add(56);
        list.add(31);
        list.add(11);
        list.add(14);
        list.add(17);
        list.add(31);
        list.add(81);
        
        // verific dimensiunea listei sa fie 10
        assertEquals(10, list.size());
        
        // stiind ca sunt elemente diferite
        // voi sterge unul si voi verifica daca lista contine elementul respectiv
        list.remove(new Integer(17));
        
        // verific dimensiunea listei sa fie 9
        // verific ca elementul 17 sa nu fie in lista
        assertEquals(9, list.size());
        assertFalse(list.contains(17));
        
        // stiind ca acum ar trebui sa fie 9 elemente in lista
        // adaug un element diferit si verific daca lungimea listei a crescut
        // si daca elementul exista in lista
        list.add(99);
        
        // verific daca dimensiunea listei a crescut
        // verific daca elementul 99 este in lista
        assertEquals(10, list.size());
        assertTrue(list.contains(99));
        

        List mockList = mock(List.class);
        
        when(mockList.get(anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("Metoda get() a clasei List a fost apelata!");
                return null;
            }
        });
        mockList.get(0);
        mockList.get(1);
        mockList.get(2);
        mockList.get(3);
        mockList.get(4);
    }
}