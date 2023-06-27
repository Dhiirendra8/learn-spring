package com.hbn.learn;


import com.hbn.learn.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args)  {
        System.out.println("Hibernate app started ...");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

//        Student st = new Student(1,"Dhirendra",30,"pqr@xyz.com");
        Student st = new Student();
        st.setName("Dhirendra Singh");
        st.setAge(30);
        st.setEmail("abc@gmail.com");

        Transaction tx = session.beginTransaction();
        session.save(st);

        tx.commit();

        session.close();

        factory.close();
    }
}
