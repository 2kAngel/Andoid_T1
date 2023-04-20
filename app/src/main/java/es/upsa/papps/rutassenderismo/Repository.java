package es.upsa.papps.rutassenderismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Repository
{
    private Map<String,Ruta> rutas = new HashMap<>();

    public Repository() {
        rutas.put("a", new Ruta("a","Ruta A", "Explorador A" ,1 ,1.0));
        rutas.put("b", new Ruta("b","Ruta B", "Explorador B" ,2 ,2.0));
        rutas.put("c", new Ruta("c","Ruta C", "Explorador C" ,3 ,3.0));
        rutas.put("d", new Ruta("d","Ruta D", "Explorador D" ,4 ,4.0));
        rutas.put("e", new Ruta("e","Ruta E", "Explorador E" ,5 ,5.0));
        rutas.put("f", new Ruta("f","Ruta F", "Explorador F" ,6 ,6.0));
        rutas.put("g", new Ruta("g","Ruta G", "Explorador G" ,7 ,7.0));
        rutas.put("h", new Ruta("h","Ruta H", "Explorador H" ,8 ,8.0));
    }

    public List<Ruta> getRutas()
    {
        ArrayList<Ruta> datos = new ArrayList<>();
        datos.addAll(rutas.values());
        return datos;
    }


     public Ruta insertRuta(String nombre_ruta, String explorador, double valoracion, double dificultad)
    {
        Random random = new Random();
        int id = random.nextInt(1_000_000_000);
        while (rutas.containsKey(String.valueOf(id)))
        {
            id = random.nextInt(1_000_000_000);
        }

        Ruta ruta = new Ruta(String.valueOf(id),nombre_ruta,explorador,valoracion,dificultad);

        rutas.put(ruta.getId(), ruta);
        return ruta;

    }


    public Ruta findRutaById(String id) {
        return rutas.get(id);
    }

}
