package Auxiliar;

public interface ObserverJogo {
    // Comunicacao entre VideoGame com a Fase e as Telas
    void terminaFase();
    void terminaInicio();
    void terminaFim();
    void iniciarFim(boolean i);
}
