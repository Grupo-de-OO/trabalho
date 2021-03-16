package dcc025.ufjf.utils;
        
import dcc025.ufjf.restaurante.Movimentacao;
import dcc025.ufjf.restaurante.ItemCardapio;
import dcc025.ufjf.restaurante.ItemEstoque;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Json {

    public static <T> String toJSON(T genericType) {
        Gson gson = new Gson();
        String json = gson.toJson(genericType);
        return json;
    }

    public static<T> String toJSON(List<T> genericType) {
        Gson gson = new Gson();
        String json = gson.toJson(genericType);
        return json;
    }

    public static List<ItemEstoque> toEstoque(String conteudo) {
        Gson gson = new Gson();
        Type item= new TypeToken<ArrayList<ItemEstoque>>() {
        }.getType();
        List<ItemEstoque> itemEstoque = gson.fromJson(conteudo, item);

        return itemEstoque;
    }

    public static List<ItemCardapio> toCardapio(String conteudo){
        Gson gson = new Gson();
         Type item= new TypeToken<ArrayList<ItemCardapio>>() {
        }.getType();
        List<ItemCardapio> itemCardapio = gson.fromJson(conteudo, item);
        return itemCardapio;
    }
    
    public static List<Movimentacao> toCaixa(String conteudo){
        Gson gson = new Gson();
         Type item= new TypeToken<ArrayList<Movimentacao>>() {
        }.getType();
        List<Movimentacao> movimentacoes = gson.fromJson(conteudo, item);
        return movimentacoes;
    }
    
}