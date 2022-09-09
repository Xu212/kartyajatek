package kartyajatek;

import java.util.Scanner;

public class Kartyajatek {

    public static void main(String[] args) {
        Kartyajatek kj = new Kartyajatek();
        String[] pakli = kj.kartyafelt();

        for (int i = 0; i < 3; i++) {
            kj.kiiratas(pakli);
            pakli = kj.oszlopCsereEsKever(pakli);
        }
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

    private int melyik() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Melyik oszlopban van a lap?");
        int hely = Integer.parseInt(scn.nextLine());
        return hely;
    }

    private String[] kever(String[] keverendoPakli) {//Mindig középrekerüljön a választott oszlop
        String[] megkevertTomb = new String[21];
        int kovetkezoSorSzamlalo = 0;
        for (int i = 0; i < keverendoPakli.length/3; i++) {
            megkevertTomb[i+kovetkezoSorSzamlalo] = keverendoPakli[i];
            megkevertTomb[i+1+kovetkezoSorSzamlalo] = keverendoPakli[i + 7];
            megkevertTomb[i+2+kovetkezoSorSzamlalo] = keverendoPakli[i + 14];
            kovetkezoSorSzamlalo+=2;
        }
        return megkevertTomb;
    }

    private void ezvolt(String[] pakli) {
        System.out.printf("Ez volt a kártya: %s", pakli[10]);
    }

    private String[] oszlopCsereEsKever(String[] pakli) {
        Kartyajatek kj = new Kartyajatek();
        int poz = kj.melyik();
        String[] IdeiglenesOszlop = new String[7];
        if (poz == 1) {
            for (int i = 0; i < pakli.length / 3; i++) {
                IdeiglenesOszlop[i] = pakli[i];
            }
            for (int i = 0; i < pakli.length / 3; i++) {
                pakli[i] = pakli[i + 7];
                pakli[i + 7] = IdeiglenesOszlop[i];
            }
        } else if (poz == 3) {
            for (int i = 0; i < pakli.length / 3; i++) {
                IdeiglenesOszlop[i] = pakli[i + 14];
            }
            for (int i = 0; i < pakli.length / 3; i++) {
                pakli[i + 14] = pakli[i + 7];
                pakli[i + 7] = IdeiglenesOszlop[i];
            }
        }
        String[] megkevert = kj.kever(pakli);
        return megkevert;
    }

    private void kiiratas(String[] lapok) {
        for (int i = 0; i < lapok.length / 3; i++) {
            System.out.print("|" + lapok[i] + "| ");
            System.out.print("|" + lapok[i + 7] + "| ");
            System.out.println("|" + lapok[i + 14] + "|");

        }
        System.out.println("IIIIIIII");
    }
}
