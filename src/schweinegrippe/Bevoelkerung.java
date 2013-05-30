/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schweinegrippe;

public class Bevoelkerung {

    private double imun;
    private double kranke;
    private double gesunde;

    public Bevoelkerung(double gesunde, double kranke, double imun) {
        this.imun = imun;
        this.kranke = kranke;
        this.gesunde = gesunde;
    }

    public double getImun() {
        return imun;
    }

    public void setImun(double imun) {
        this.imun = imun;
    }

    public double getKranke() {
        return kranke;
    }

    public void setKranke(double kranke) {
        this.kranke = kranke;
    }

    public double getGesunde() {
        return gesunde;
    }

    public void setGesunde(double gesunde) {
        this.gesunde = gesunde;
    }
    
}
