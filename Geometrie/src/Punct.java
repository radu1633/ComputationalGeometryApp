public class Punct {
    private int x, y;
    private String nume;
    private String taietura;
    private Punct stanga, dreapta;

    Punct(int xPunct, int yPunct){
        this.x = xPunct;
        this.y = yPunct;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x; 
    }

    public void setY(int y){
        this.y = y;
    }

    public void setNume(String x){
        nume = x;
    }

    public String getNume(){
        return nume;
    }

    public void setTaietura(String x){
        taietura = x;
    }

    public String getTaietura(){
        return taietura;
    }

    public void setStanga(Punct p){
        stanga = p;
    }
    public void setDreapta(Punct p){
        dreapta = p;
    }

    public Punct getStanga(){
        return stanga;
    }
    public Punct getDreapta(){
        return dreapta;
    }
}
