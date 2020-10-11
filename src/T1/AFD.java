package T1;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class AFD {

    private Transicao umaTransicao;
    private int EstadoInicial;
    private ArrayList<Integer> aceitandoEstados;


    public AFD(Transicao umaTransicao, int umEstadoInicial, ArrayList<Integer> aceitandoEstados){
        this.umaTransicao = Objects.requireNonNull(umaTransicao, "Transição nula");
        EstadoInicial = umEstadoInicial;
        this.aceitandoEstados = Objects.requireNonNull(aceitandoEstados, "Estado é nulo");
    }

    public boolean validacao (String palavra){
        Integer estadoAtual = EstadoInicial;

        for(char Lista : palavra.toCharArray()){
            estadoAtual = umaTransicao.processamento(estadoAtual, Lista);
            if(estadoAtual == null){
                return false;
            }
        }
        //System.out.println(aceitandoEstados);
        return aceitandoEstados.contains(estadoAtual);
    }


}
