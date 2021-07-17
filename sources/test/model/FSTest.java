package model;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import java.util.Iterator;

public class FSTest {

    @Test
    public void testPlayer() {
        
        System.out.println("Testare folosind jUnit");
        System.out.println("Caz de test: instantierea jucatorului se face o singura data");
         
        // Creare referinta nula catre clasa Player
        Player object1 = null;
        assertNull(object1);

        // Instantiere obiect a clasei player
        object1 = Player.getInstance();
        assertNotNull(object1);

        // Creare alta referinta catre clasa Player
        Player object2 = null;
        assertNull(object2);

        // Instantiere alt obiect al clasei Player
        // Ar trebui sa pointeze catre prima instanta
        object2 = Player.getInstance();
        assertNotNull(object2);

        // Verificare obiecte
        assertEquals(object1, object2);
        
        // Testare metoda getPlayerIcon
        // Metoda intoarce o imagine sub forma unui obiect BufferedImage
        // Se va folosi object1 creat mai sus pentru a apela metoda
        assertNotNull(object1.getPlayerIcon());
        
        // Testare metoda set si get player position
        // Metodele seteaza si returneaza pozitia player-ului
        // initial pozitia jucatorului este nula
        assertNull("Eroare la apelarea metodei getPosition()", object1.getPosition());
        
        object1.setPosition(new Point(10, 10));
        assertNotNull(object1.getPosition());
        
        System.out.println("Testare folosind mockito");
        System.out.println("Caz de test: instantierea jucatorului se face o singura data");

        // Creare iterator
        // Returneaza o instanta a player-ului cand next() este apelata
        // Returneaza inca o instanta a player-ului daca next() este apelata a doua oara
        // Instantele returnate trebuie sa fie 
        Iterator instances = mock(Iterator.class);
        when(instances.next()).thenReturn(Player.getInstance()).thenReturn(Player.getInstance());
        
        //assert
        assertEquals(instances.next(), instances.next());
    }
}
