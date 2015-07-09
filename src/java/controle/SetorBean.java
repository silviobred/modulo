/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import modelo.Setor;
import modelo.SetorDao;

/**
 *
 * @author bredow
 */
@ManagedBean
@SessionScoped
public class SetorBean {

    /**
     * Creates a new instance of SetoresBean
     */
    private Setor setor =new Setor();
    private SetorDao setorDao = new SetorDao();
    private List<Setor> listaSertores;
    private Object responsavelpesq;
    private String nomePesq;
    private List listaSetores;
    
    public List<Setor> getListaSetores() {
        return listaSetores;
    }
    private String nomePesq;
    private String setorResponsavel;

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    public String consultarPorNome() {
        listaSetores = setorDao.consultaPorNome(nomePesq);
        return "listagemPorNome";
    }

    public String consultarPorNaturalidade() {
        listaSetores = setorDao.consultaSetorResponsal(setorResponsavel);
        return "listagemSetorResponsavel";
    }

    public String getNomePesq() {
        return nomePesq;
    }

    public void setNomePesq(String nomePesq) {
        this.nomePesq = nomePesq;
    }

    
    public SetorBean() {
    }

    public String adicionarSetor(){
        setorDao.addSetor(setor);
        return "sucesso";
                
       
    }
    
    public String removeSetor(){
        setorDao.removeSetor(setor);
        return "sucessoremove";
    }
        
public String carregarSetor(Setor s) {
        setor = s;
        return "sucessocarregar";
    }
public String atualizarSetor() {
        setorDao.updateSetor(setor);
        setor = new Setor();
        return "sucessoatualizar";
    }
    
public List listarSetores() {
        List<Setor> listaSetores = setorDao.getListaSetores();
        return this.listaSetores;
    }


    
        
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.setor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SetorBean other = (SetorBean) obj;
        if (!Objects.equals(this.setor, other.setor)) {
            return false;
        }
        return true;
    }
    
    
}
