package org.example;

import clases.Departamentos;
import clases.Personas;
import clases.Profesores;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
//Conclusion
//Trabajar con hibernate me parece mucho mas complicado, que por ejemplo
//trabajar con un preparetStatement, ya que no hay que configurar tanto
//y la forma de trabajar con los datos es mas intuitivo

public class Main {
    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static Session session = sessionFactory.openSession();

    public static void main(String[] args) {
//        altaDepartamentos();
//        System.out.println("Departamento añadido");
//        altaPersona();
//        System.out.println("Persona añaida");
//        altaProfesores();
//        System.out.println("Profesor añadido");
//        modificarDepartamentos();
//        System.out.println("Departamento modificar");
//        modificarPersona();
//        System.out.println("Persona modificada");
//        modificarProfesor();
//        System.out.println("Profesor modificado");
//        eliminarProfesor();
//        System.out.println("Profesor eliminado");
//        eliminarPersona();
//        System.out.println("Persona eliminado");
//        eliminarDepartamento();
//        System.out.println("Departamento eliminado");
        consultaPersona();
        consultaDepartamento();
    }

    private static void consultaDepartamento() {
        Query query = session.createQuery("from Departamentos where idDepartamento = :id");
        query.setParameter("id", 3);
        Departamentos persona = (Departamentos) ((org.hibernate.query.Query<?>) query).uniqueResult();
        System.out.println("Departamento: " + persona.getNombreDepartamento() );
    }

    private static void consultaPersona() {
        Query query = session.createQuery("from Personas where idPersona = :id");
        query.setParameter("id", 3);
        Personas persona = (Personas) ((org.hibernate.query.Query<?>) query).uniqueResult();
        System.out.println("Persona: " + persona.getNombre() + " " + persona.getPrimerApellido() + " " + persona.getSegundoApellido());
    }


    private static void eliminarProfesor() {
        try {
            session.beginTransaction();
            Profesores per = session.get(Profesores.class, 1);
            session.remove(per);
            session.getTransaction().commit();
            System.out.println("Profesor eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar profesor");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    private static void eliminarPersona() {
        try {
            session.beginTransaction();
            Personas per = session.get(Personas.class, 2);
            per.setProfesoresByIdPersona(null);
            session.remove(per);
            session.getTransaction().commit();
            System.out.println("Error al eliminar persona");

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    private static void eliminarDepartamento() {
        try {
            session.beginTransaction();
            Departamentos dep = session.get(Departamentos.class, 1);
            session.remove(dep);
            session.getTransaction().commit();
            System.out.println("Error al eliminar departamento");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    private static void modificarProfesor() {
        try {
            session.beginTransaction();
            Profesores pro = session.get(Profesores.class, 1);
            pro.setIdPersona(2);
            session.persist(pro);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    private static void modificarPersona() {
        session.beginTransaction();
        Personas p = session.get(Personas.class,2);
        p.setNombre("Marcos");

        session.persist(p);
        session.getTransaction().commit();
    }

    private static void modificarDepartamentos() {
        session.beginTransaction();
        Departamentos dp = session.get(Departamentos.class, 1);
        dp.setNombreDepartamento("Departamento Matematicas");

        session.persist(dp);
        session.getTransaction().commit();

    }

    private static void altaProfesores() {
        session.beginTransaction();
        Profesores pro = new Profesores();
        pro.setIdDepartamento(2);
        pro.setIdPersona(3);
        session.persist(pro);
        session.getTransaction().commit();

    }

    private static void altaPersona() {
        session.beginTransaction();
        Personas p = new Personas();
        p.setNif("43209201K");
        p.setNombre("Ivan");
        p.setPrimerApellido("Ortiz");
        p.setSegundoApellido("Maura");
        p.setFechaNacimiento(new Date(2002, 11, 25));
        p.setDireccion("Calle aragon");
        p.setSexo("H");
        p.setNumeroTelefono("689279765");

        session.persist(p);
        session.getTransaction().commit();
    }


    public static void altaDepartamentos(){
        session.beginTransaction();
            Departamentos dp = new Departamentos();
            dp.setNombreDepartamento("departamento fisioterapia");

            session.persist(dp);
            session.getTransaction().commit();

    }
}