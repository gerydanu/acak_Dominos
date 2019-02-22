
package Dominos;


public class Dominos {
 
       
    /**
     * Mengacak index array dari array dominos kemudian diberi sama banyak ke jumlah pemain kemudian ditampilkan.
     * <p>Ketika slot masing-masing pemain sudah penuh dan masih ada sisa dominos,
     * maka sisa dominos akan ditampilkan.
     * @param pemain  Jumlah pemain
     * @return Tampilkan seluruh pemain beserta domino masing-masing pemain.
     * <p>Jika ada sisa domino, maka tampilkan pula sisanya.
     */
    public static String[][] acakDominos(int pemain)
    {
        if (pemain < 0) {
            String[][] errDominos=new String[1][1];
            errDominos[0][0]="Pemain tidak boleh kurang dari nol";
            return errDominos;
        }
        else if (pemain > 28) {
            String[][] errDominos=new String[1][1];
            errDominos[0][0]="Pemain tidak boleh lebih dari 28";
            return errDominos;
        }
        
        
        String[] dominos = { "0-0","0-1","0-2","0-3","0-4","0-5","0-6","1-1","1-2","1-3","1-4","1-5","1-6","2-2","2-3","2-4","2-5","2-6","3-3","3-4","3-5","3-6","4-4","4-5","4-6","5-5","5-6","6-6" };

        int jmlDominos=dominos.length; // jumlah item dominos = 28
        
        for(int i=0; i<jmlDominos; i++) // perulangan sebanyak banyak item dominos
        {
            double index = Math.random() * jmlDominos; 
            String temp = dominos[i]; 
            dominos[i] = dominos [(int)index];  // karena sebelumnya tipedata index adl double
            dominos[(int)index] = temp;         // nukar item i dengan index (random), simpan sementara di temp
        }
        
        jmlDominos--; // 28-1 = 27
        
        int paket = dominos.length / pemain;
        
        String[][] ambilDomino=new String[pemain+1][paket]; //tambahan 1 pemain sebagai sisa
        for (int i = 0; i < pemain; i++) {
            for (int j = 0; j < paket; j++) {
                ambilDomino[i][j]=dominos[jmlDominos];
                jmlDominos--;
            }
        }
        for (int i=jmlDominos; i>=0; i--) {  // perulangan utk sisa jmlDominos yang akan ditampilkan
            ambilDomino[pemain][i]= dominos[i];
            jmlDominos--;
        }
        return ambilDomino;
    }
  
    public static void main(String[] args) {
 
        //tentukan banyak pemain
        int pemain = 29;
        
        System.out.println("Banyak pemain : " + pemain + "\n");
        String[][] game = acakDominos(pemain);
        for (int i = 0; i < pemain; i++) {
            System.out.print("Pemain ke " + (i+1) + " : ");
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("\nJumlah kartu tiap pemain: "+game[0].length);
        System.out.print("\n" + "Sisa domino: ");
        for (int i = 0; i < 28%pemain; i++) {
            System.out.print(game[pemain][i] + " ");
        }
        
        
    }
    
}
