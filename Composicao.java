import java.util.ArrayList;
import java.util.List;
class Posto {
    private List<Bomba> bombas;
    public Posto(int numBombas) {
        bombas = new ArrayList<Bomba>();
        for (int i = 0; i < numBombas; i++) {
            bombas.add(new Bomba("Diesel"));
        }
    }
    public Bomba bombaDisponivel() throws Exception {
        for (Bomba bomba : bombas) {
            if (bomba.estaDisponivel()) {
                return bomba;
            }
        }
        throw new Exception("Nenhuma bomba disponível");
    }
}

public class App {
    public static void main(String[] args) {
        Posto posto = new Posto(3);
        Caminhao caminhao = new Caminhao("Mercedes", "1318", 16);

        try {
            Bomba bombaDisponivel = posto.bombaDisponivel();
            bombaDisponivel.abastecer(caminhao);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
