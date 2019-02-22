package Tes_Domino;

import Dominos.Dominos;
import org.junit.Test;
import static org.junit.Assert.*;


public class DominosTest {
    
    Dominos dm = new Dominos();
    
    public DominosTest() {
    }

    // test banyak item tiap pemain
    @Test
    public void tesBanyakDominos() {
        int exp = 4;
        String[][] temp=dm.acakDominos(6);
        int act = temp[0].length;
    }
    
    // test pemain -n
    @Test
    public void tesPemainNegatif() {
        int exp = 1;
        String[][] temp=dm.acakDominos(-6);
        int act = temp[0].length;
    }
    
    // test pemain 0
    @Test
    public void tesPemainBerlebih() {
        int exp = 1;
        String[][] temp=dm.acakDominos(29);
        int act = temp[0].length;
    }

}
