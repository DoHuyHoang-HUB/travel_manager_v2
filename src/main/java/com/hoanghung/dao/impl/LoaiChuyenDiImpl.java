package com.hoanghung.dao.impl;

import com.hoanghung.dao.LoaiChuyenDi_DAO;
import com.hoanghung.model.LoaiChuyenDi;
import com.hoanghung.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoaiChuyenDiImpl implements LoaiChuyenDi_DAO {
    private SessionFactory sessionFactory;
    
    public LoaiChuyenDiImpl() {
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Override
    public boolean addLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        
        try {
            tr.begin();
            session.save(loaiChuyenDi);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    @Override
    public List<LoaiChuyenDi> getDsLoaiChuyenDi() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.getTransaction();
        
        List<LoaiChuyenDi> dsLoaiChuyenDi = new ArrayList<>();
        
        try {
            tr.begin();
            dsLoaiChuyenDi = session
                    .createNamedQuery("getDsLoaiChuyenDi", LoaiChuyenDi.class)
                    .getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
        return dsLoaiChuyenDi;
    }
    //nh
     @Override
    public boolean updateLoaiChuyenDi(LoaiChuyenDi loaiChuyenDi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLoaiChuyenDi(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoaiChuyenDi getLoaiChuyenDi(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiChuyenDi> getLoaiChuyenDis() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.getTransaction();
        try {
            tr.begin();
            List<LoaiChuyenDi> rs = session
                    .createNativeQuery(" select * from loaichuyendi ", LoaiChuyenDi.class)
                    .getResultList();
            tr.commit();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

    @Override
    public List<LoaiChuyenDi> getLoaiChuyenDi(int numPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSoLuongLCD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
