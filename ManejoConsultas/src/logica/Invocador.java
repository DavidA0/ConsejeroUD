package logica;

public class Invocador {
    Comando comando;

    public Invocador(Comando c) {
        comando = c;
    }

    public javax.swing.JTable actuar(){
        return comando.ejecutar();
    }
}
