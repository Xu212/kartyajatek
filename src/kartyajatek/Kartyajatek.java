package kartyajatek;

import java.util.Scanner;

public class Kartyajatek {

    public static void main(String[] args) {
        Kartyajatek kj = new Kartyajatek();
        String[] pakli = kj.kartyafelt();
        kj.kiiratas(pakli);
        kj.kever(pakli);
    }

    public String[] kartyafelt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        String[] pakli = new String[21];
        int y = 0;
        int ertekhatar = ertekek.length;
        for (int i = 0; i < szinek.length; i++) {
            if (szinek[i].equals(szinek[3])) {
                ertekhatar = 3;
            }
            for (int j = 0; j < ertekhatar; j++) {
                pakli[y] = szinek[i] + ertekek[j];
                y++;
            }
        }

        return pakli;
    }

    public int melyik() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Melyik oszlopban van a lap?");
        int hely = Integer.parseInt(scn.nextLine());
        return hely;
    }

    public String[] kever(String[] pakli) {//Mindig középrekerüljön a választott oszlop
        Kartyajatek kj = new Kartyajatek();
        int poz = kj.melyik();
        String[] IdeiglenesOszlop = new String[7];
        if (poz == 1) {
            for (int i = 0; i < pakli.length/3; i++) {
                IdeiglenesOszlop[i] = pakli[i];
            }
        }
        else if(poz == 3){
            
        }
        return pakli;
    }

    public void ezvolt(String[] pakli) {
        System.out.printf("Ez volt a kártya: %s", pakli[10]);
    }

    public void kiiratas(String[] lapok) {
        for (int i = 0; i < lapok.length/3; i++) {
            System.out.print("|"+lapok[i]+"| ");
            System.out.print("|"+lapok[i+7]+"| ");
            System.out.println("|"+lapok[i+14]+"|");
            
        }
    }
}
