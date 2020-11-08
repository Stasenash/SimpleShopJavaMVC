package com.webshop.simplewebapplication.database;

import com.webshop.simplewebapplication.model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ItemDAOHib implements ItemDAO {

    @Override
    public void addItem(Item item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Item> items = (List<Item>) session.createQuery("from Item").list();
            return items;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public Item findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query query = (Query) session.createQuery("FROM Item where id = :id");
            query.setParameter("id", id);
            return (Item) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteItem(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Item item = findById(id);
            session.delete(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAllInCart() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            List<Item> items = (List<Item>) session.createQuery("From Item").list();
            return items;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    public int countOfItems() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Item> items = (List<Item>) session.createQuery("From Item").list();
            return items.size();
        }catch (Exception e){
            return 0;
        }finally {
            session.close();
        }
    }
}
