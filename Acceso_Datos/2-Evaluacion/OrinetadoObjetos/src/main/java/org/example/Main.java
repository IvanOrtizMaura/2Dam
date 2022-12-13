package org.example;

import com.db4o.*;

public class Main {
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), "personas.db4o");
        Persona p1 = new Persona("Fernando", 30, 1.73, 73);
        Persona p2 = new Persona("Pepe", 30, 1.75, 80);
        Persona p3 = new Persona("Alfredo", 20, 1.9, 90);
        Persona p4 = new Persona("Roberto", 35, 1.70, 70);
        Persona p5 = new Persona("Domingo", 30, 1.73, 80);

        try {
            db.store(p1);
            db.store(p2);
            db.store(p3);
            db.store(p4);
            db.store(p5);

            Persona p = new Persona();
            ObjectSet<Persona> result = db.queryByExample(p);

            while (result.hasNext()) {
                System.out.println(result.next().getNombre());
            }
        } finally {
            db.close();
        }
    }
}