/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.HibernateUtil;
import modelo.Setor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;


/**
 *
 * @author bredow
 */
public class SetorDao {
    private Session sessao;
    private Transaction trans;
    private List<Setor> listaSetores;
    
    public void addSetor(Setor s){
    try{    sessao= HibernateUtil.getSessionFactory().openSession();
        trans= sessao.beginTransaction();
        
        
        Setor setor= new Setor();
        setor.setNome(s.getNome());
        setor.setResponsavel(s.getResponsavel());
        setor.setDescricao(s.getDescricao());
        setor.setEmail(s.getEmail());
        
        
        sessao.save(s);
        trans.commit();
      
    } catch (Exception e){
        e.printStackTrace();
    }finally{
    sessao.close();
        }
    }
    public void removeSetor(Setor s){
        
        try{
        
        sessao.delete(s);
        trans.commit();
      
    } catch (Exception e){
      
        e.printStackTrace();
        
        
    }finally{
            
    sessao.close();
        }
    }
    public void updateSetor (Setor s){
        try{    sessao= HibernateUtil.getSessionFactory().openSession();
        trans= sessao.beginTransaction();
        sessao.update(s);
        trans.commit();
        } catch (Exception e){
      
        e.printStackTrace();
        
        
    }finally{
            
    sessao.close();
        }
    }
            
       public List<Setor> getListaSetores() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Setor.class);
        this.listaSetores = cri.list();
        return listaSetores;
    }

    public List consultaPorNome(String nomePesq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List consultaSetorResponsal(String setorResponsavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        
        
    