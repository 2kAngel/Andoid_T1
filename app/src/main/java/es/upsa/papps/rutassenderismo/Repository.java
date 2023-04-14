package es.upsa.papps.rutassenderismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository
{
    private Map<String,Ruta> rutas = new HashMap<>();

    public Repository() {
        rutas.put("a", new Ruta("a","Ruta A", "Director A" ,1 ,1.0));
        rutas.put("b", new Ruta("b","Ruta B", "Director B" ,2 ,2.0));
        rutas.put("c", new Ruta("c","Ruta C", "Director C" ,3 ,3.0));
        rutas.put("d", new Ruta("d","Ruta D", "Director D" ,4 ,4.0));
        rutas.put("e", new Ruta("e","Ruta E", "Director E" ,5 ,5.0));
        rutas.put("f", new Ruta("f","Ruta F", "Director F" ,6 ,6.0));
        rutas.put("g", new Ruta("g","Ruta G", "Director G" ,7 ,7.0));
        rutas.put("h", new Ruta("h","Ruta H", "Director H" ,8 ,8.0));
    }

    public List<Ruta> getRutas()
    {
        ArrayList<Ruta> datos = new ArrayList<>();
        datos.addAll(rutas.values());
        return datos;
    }

    /*
    * public Pelicula insertPelicula(String titulo, String director, double valoracion)
    {
        Random random = new Random();
        int id = random.nextInt(1_000_000_000);
        while (peliculas.containsKey(String.valueOf(id)))
        {
            id = random.nextInt(1_000_000_000);
        }

        Pelicula pelicula = new Pelicula(String.valueOf(id),titulo
        ,director,valoracion);

        peliculas.put(pelicula.getId(), pelicula);
        return pelicula;

    }


    public Pelicula findPeliculaById(String id) {
        return peliculas.get(id);
    }
    * */
}
