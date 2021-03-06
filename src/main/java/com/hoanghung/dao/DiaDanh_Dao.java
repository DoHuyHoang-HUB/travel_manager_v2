package com.hoanghung.dao;

import com.hoanghung.model.DiaDanh;
import com.hoanghung.util.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface DiaDanh_Dao{
    
    public boolean addDiaDanh(DiaDanh diaDanh);

    public boolean updateDiaDanh(DiaDanh diaDanh);

    public boolean deleteDiaDanh(String id);

    public DiaDanh getDiaDanh(String id);

    public List<DiaDanh> getDiaDanhs();

    public List<DiaDanh> getDiaDanh(int numPage);

    public int getSoLuongDiaDanh();

    public List<String> getTinhThanhDiaDanhs();

    public List<DiaDanh> searchDiaDanhs(String textSearch, String tinhThanh, int numPage);

    public int getSoLuongSearch(String textSearch, String tinhThanh);
//
//    private SessionFactory sessionFactory;
//
//    public DiaDanhDao() {
//        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
//    }
//
//    @Override
//    public boolean addDiaDanh(DiaDanh diaDanh) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tr = session.getTransaction();
//        try {
//            tr.begin();
//            session.save(diaDanh);
//            tr.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            tr.rollback();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateDiaDanh(DiaDanh diaDanh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean deleteDiaDanh(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public DiaDanh getDiaDanh(String id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//
//        try {
//            transaction.begin();
//            DiaDanh diaDanh = session.find(DiaDanh.class, id);
//            transaction.commit();
//
//            return diaDanh;
//        } catch (Exception e) {
//            System.err.println(e);
//            transaction.rollback();
//        }
//        return null;
//    }
//
//    @Override
//    public List<DiaDanh> getDiaDanhs() {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tr = session.getTransaction();
//        try {
//            tr.begin();
//            List<DiaDanh> rs = session
//                    .createNamedQuery("getDiaDanhs", DiaDanh.class)
//                    .getResultList();
//            tr.commit();
//            return rs;
//        } catch (Exception e) {
//            e.printStackTrace();
//            tr.rollback();
//        }
//        return null;
//    }
//
//    @Override
//    public List<DiaDanh> getDiaDanh(int numPage) {
//        Session session = sessionFactory.openSession();
//        Transaction tr = session.getTransaction();
//        String sql = "select cdl.* from diadanh cdl order by diadanh_id offset :x row fetch next 20 rows only";
//        try {
//            tr.begin();
//            List<DiaDanh> list = session
//                    .createNativeQuery(sql, DiaDanh.class)
//                    .setParameter("x", numPage * 20)
//                    .getResultList();
//
//            tr.commit();
//            return list;
//
//        } catch (Exception e) {
//            tr.rollback();
//        }
//        session.close();
//        return null;
//    }
//
//    @Override
//    public int getSoLuongDiaDanh() {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tr = session.getTransaction();
//
//        String sql = "select count(*) from diadanh";
//        try {
//            tr.begin();
//            int rs = (int) session.createNativeQuery(sql).getSingleResult();
//            tr.commit();
//            return rs;
//        } catch (Exception e) {
//            tr.rollback();
//        }
//        return 0;
//    }
//
//    @Override
//    public List<String> getTinhThanhDiaDanhs() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//
//        String query = "select distinct(tinh) from diadanh";
//        try {
//            transaction.begin();
//            List<String> list = session.createNativeQuery(query).getResultList();
//            transaction.commit();
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        }
//
//        return null;
//    }
//
//    @Override
//    public List<DiaDanh> searchDiaDanhs(String textSearch, String tinhThanh, int numPage) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//
//        int soLuong = numPage * 20;
//        if (soLuong < 0) {
//            soLuong = Math.abs(soLuong);
//        }
//        
//        System.out.println("offset: "+soLuong);
//        String query = "select d.* from diadanh d where  "
//                + " ( diadanh_id like '%" + textSearch + "%'"
//                + " or tendiadanh like N'%" + textSearch + "%' ) "
//                + " and tinh like N'%" + tinhThanh + "%'"
//                + " order by diadanh_id offset " + soLuong + " rows fetch next 20 rows only";
//        try {
//            transaction.begin();
//            List<DiaDanh> list = session.createNativeQuery(query, DiaDanh.class)
//                    .getResultList();
//            transaction.commit();
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        }
//
//        return null;
//    }
//
//    @Override
//    public int getSoLuongSearch(String textSearch, String tinhThanh) {
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//
//        String query = "select count(*) from diadanh d where  "
//                + " ( diadanh_id like '%" + textSearch + "%'"
//                + " or tendiadanh like N'%" + textSearch + "%' ) "
//                + " and tinh like N'%" + tinhThanh + "%'";
//        try {
//            transaction.begin();
//            int x = (int) session.createNativeQuery(query).getSingleResult();
//            transaction.commit();
//            return x;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        }
//
//        return 0;
//    }

}
