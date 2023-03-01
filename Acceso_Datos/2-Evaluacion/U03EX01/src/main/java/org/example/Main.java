package org.example;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

public class Main {
    public static void main(String[] args) {
       ObjectContainer oc = Db4oEmbedded.openFile("videclub.db4o");
        String titulo ="titulo";
        String director ="director";
       Pelicula p = new Pelicula("titul","director", "productora", 2,200,2001);
//       darAltaPelicula(oc,p);
//       modifPelicula(oc,p);
//        darBajaPelicula(oc,p);
//        consultaPeliculaTitulo(oc,titulo);
//        consultaPeliculaDirector(oc,director);


        Persona persona = new Persona("persona","Apellidos", "Direccon", "telefono", 20);
      String nombre = "persona";
      String apllidos = "Apellidos";
//       darAltaSocio(oc,persona);
//       darBajaPersona(oc,persona);
//        modifPersona(oc,persona);
//        consultaPersonaNombre(oc,nombre);
//        consultaPersonaApellidos(oc,apllidos);


        crearPresatamos(oc,p,persona);
          oc.close();
    }

    private static void crearPresatamos(ObjectContainer oc, Pelicula p, Persona persona) {

    }

    private static void consultaPersonaApellidos(ObjectContainer oc, String apllidos) {
        Query query = oc.query();
        query.constrain(Persona.class);
        query.descend("apellidos").constrain(apllidos);
        ObjectSet os = query.execute();
        System.out.println(os);
    }

    private static void consultaPersonaNombre(ObjectContainer oc, String nombre) {
        Query query = oc.query();
        query.constrain(Persona.class);
        query.descend("nombre").constrain(nombre);
        ObjectSet os = query.execute();
        System.out.println(os);
    }

    private static void consultaPeliculaDirector(ObjectContainer oc, String director) {
        Query query = oc.query();
        query.constrain(Pelicula.class);
        query.descend("director").constrain(director);
        ObjectSet os = query.execute();
        System.out.println(os);
    }

    private static void consultaPeliculaTitulo(ObjectContainer oc, String titulo) {
        Query query = oc.query();
        query.constrain(Pelicula.class);
        query.descend("titulo").constrain(titulo);
        ObjectSet os = query.execute();
        System.out.println(os);

    }

    private static void darBajaPersona(ObjectContainer oc, Persona persona) {
        ObjectSet<Persona> os = oc.queryByExample(persona);
        if (os.hasNext()){
            oc.delete(persona);
        }else {
            System.out.println("La persona no existe");
        }
    }

    private static void darBajaPelicula(ObjectContainer oc, Pelicula p) {
        ObjectSet<Pelicula> os = oc.queryByExample(p);
        if (os.hasNext()){
            oc.delete(p);
        }else {
            System.out.println("La persona no existe");
        }
    }

    private static void modifPelicula(ObjectContainer oc, Pelicula p) {
        ObjectSet<Pelicula> os = oc.queryByExample(p);
        if (os.hasNext()){
            Pelicula pauxiliar = os.next();
            pauxiliar.setTitulo("titilo2");
            pauxiliar.setDirector("director2");
            pauxiliar.setAño(1920);
            pauxiliar.setDuracion(200);
            pauxiliar.setProductora("productora2");
            pauxiliar.setNumEjemplares(5);
            oc.store(pauxiliar);
        }else {
            System.out.println("La pelicula no existe");
        }
    }
    private static void modifPersona(ObjectContainer oc, Persona p) {
        ObjectSet<Persona> os = oc.queryByExample(p);
        if (os.hasNext()){
            Persona persAuxiliar = os.next();
            persAuxiliar.setNombre("nombre2");
            persAuxiliar.setApellidos("apellido2");
            persAuxiliar.setEdad(1920);
            persAuxiliar.setTelefono("123456789");
            persAuxiliar.setDireccion("C/Calle2");
            oc.store(persAuxiliar);
        }else {
            System.out.println("El socio no existe");
        }
    }

    private static void darAltaSocio(ObjectContainer oc, Persona p) {
        ObjectSet<Persona> os = oc.queryByExample(p);
        if (!(os.hasNext())){
            oc.store(p);
        }else {
            System.out.println("La persona ya existe");
        }
    }

    public static void darAltaPelicula(ObjectContainer oc, Pelicula p){
        ObjectSet<Pelicula> os = oc.queryByExample(p);
        if (!(os.hasNext())){
            oc.store(p);
        }else {
            System.out.println("La pelicula ya existe");
        }

    }
}
