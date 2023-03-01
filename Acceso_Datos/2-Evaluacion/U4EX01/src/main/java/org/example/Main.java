package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import modulos.*;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
//            Dar de alta a un empleado
            Empleado empleado = new Empleado();
            empleado.setNombre("Marcos");
            empleado.setApellido1("Ortiz");
            empleado.setApellido2("Mena");
            empleado.setNif("43209201K");

//            Asociar al empleado a un departamento
            Departamento departamento = new Departamento();
            departamento.setCodigo(2);
            empleado.setDepartamentoByCodigoDepartamento(departamento);
            session.persist(empleado);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}