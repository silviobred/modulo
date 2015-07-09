/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


/**
 *
 * @author bredow
 */
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Table(name="setor")


public class Setor implements Serializable{
    
    
      @Transient
    final String regexAlfabetico = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÊÉÈÍÏÓÔÕÖÚÇÑ ]+$";
    @Transient
    final String regexEmail = "[a-zA-Z0-9\\-\\_\\.]+@restinga.ifrs.edu.br";
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull (message="Nome não foi preenchido, campo obrigatório.")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÊÉÈÍÏÓÔÕÖÚÇÑ ]+$", message="Nome com formato incorreto, digite somente letras.")
    private String nome;
    @NotNull (message="Responsável não foi preenchido, campo obrigatório.")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÊÉÈÍÏÓÔÕÖÚÇÑ ]+$", message="Responsável com formato incorreto, digite somente letras.")
    private String responsavel;
    @Pattern(regexp = "^[0-9A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÊÉÈÍÏÓÔÕÖÚÇÑ\\-\\_\\.\\,\\: ]*$", message="Descrição com formato incorreto, digite somente letras.")
    private String descricao;
   
    private String email;
    private Set setor = new HashSet(0);
    private Set<Setor> setores;
    
    

   @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *
     * @return
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "setor")
    public Set<Setor> getSetores() {
        return this.setores;
    }

    public void setSetores(Set setor) {
        this.setores = setores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Setor other = (Setor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
