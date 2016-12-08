package audiostudio;
public class Presets {

    public int bass;
    public int midrange;
    public int treble;
    public int balance;
    public int volume;

    public Presets(int b, int m, int t, int ba, int v) {
        this.bass = b;
        this.midrange = m;
        this.treble = t;
        this.balance = ba;
        this.volume = v;
    }

    public String toString(){
        return "Bass: "+bass+", midrange: "+midrange+", temble: "+treble+", balance: "+balance+", volume: "+volume;
    }
}