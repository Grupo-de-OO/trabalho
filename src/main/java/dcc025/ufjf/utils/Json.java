
package dcc025.ufjf.utils;
        
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dcc025.ufjf.trabalho.*;
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
/*
    public static<T> T toContato(String conteudo,T ) {
        Gson gson = new Gson();
        T generic = gson.fromJson(conteudo,generic.clas);

        return generic;
    }
*/
    
    
    public static<T> List<T> toGenerics(String conteudo) {
        Gson gson = new Gson();
        Type genericType= new TypeToken<ArrayList<T>>() {
        }.getType();
        List<T> generic = gson.fromJson(conteudo, genericType);

        return generic;
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
    
}