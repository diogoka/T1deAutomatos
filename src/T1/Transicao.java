package T1;

import java.util.Map;
import java.util.HashMap;

public class Transicao {

    private Map<Integer, Map<Character, Integer>> funcao = new HashMap<>();

    public void setTransicao(Integer estadoInicial, Integer estadoFinal, char simbolo){
        funcao.putIfAbsent(estadoInicial, new HashMap<>());
        funcao.get(estadoInicial).put(simbolo, estadoFinal);
    }

    public Integer processamento (Integer umEstadoInicial, char umSimbolo){
        if(!funcao.containsKey(umEstadoInicial)){
            return null;
        }
        return funcao.get(umEstadoInicial).get(umSimbolo);
    }

}
