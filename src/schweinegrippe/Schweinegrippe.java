/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schweinegrippe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jan-Ove
 */
public class Schweinegrippe {

    public static void main(String[] args) {
        int zeit = 0;


        List<Bevoelkerung> listeBevoelkerung = new ArrayList<Bevoelkerung>();
        listeBevoelkerung.add(new Bevoelkerung(1590, 10, 0));


        double infektionsRate = 0.0003;
        double immunisierungsRate = 0.06;

        while (zeit < 30) {
            Bevoelkerung bevoelkerungAktuell = listeBevoelkerung.get(zeit);
            double immunisierte 
            = immunisierungsRate * bevoelkerungAktuell.getKranke();
            double infizierte 
            = infektionsRate * bevoelkerungAktuell.getGesunde() 
              * bevoelkerungAktuell.getKranke();
            
            double gesundeAktuell = bevoelkerungAktuell.getGesunde() - infizierte;
            double krankeAktuell = bevoelkerungAktuell.getKranke() + infizierte - immunisierte;
            double immuneAktuell = bevoelkerungAktuell.getImun() + immunisierte;
            
            listeBevoelkerung.add(new Bevoelkerung(gesundeAktuell,krankeAktuell,immuneAktuell));
            
            zeit++;
        }
        ExcelExport x = new ExcelExport();
        x.initWorkbook("Schweinegrippe");
        x.writeheader("Gesund", "Krank", "Imun");
        for (int i = 0; i < listeBevoelkerung.size(); i++) {

            x.writeRow(listeBevoelkerung.get(i).getGesunde(), listeBevoelkerung.get(i).getKranke(), listeBevoelkerung.get(i).getImun());
        }
        x.close();
    }
}
