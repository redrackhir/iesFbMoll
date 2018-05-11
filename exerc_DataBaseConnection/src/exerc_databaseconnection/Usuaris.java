/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_databaseconnection;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author soib1a20
 */
@Entity
@Table(name = "usuaris", catalog = "mydatabase", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuaris.findAll", query = "SELECT u FROM Usuaris u")
    , @NamedQuery(name = "Usuaris.findByNif", query = "SELECT u FROM Usuaris u WHERE u.nif = :nif")
    , @NamedQuery(name = "Usuaris.findByNom", query = "SELECT u FROM Usuaris u WHERE u.nom = :nom")
    , @NamedQuery(name = "Usuaris.findByLlinatge1", query = "SELECT u FROM Usuaris u WHERE u.llinatge1 = :llinatge1")
    , @NamedQuery(name = "Usuaris.findByLlinatge2", query = "SELECT u FROM Usuaris u WHERE u.llinatge2 = :llinatge2")})
public class Usuaris implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIF")
    private String nif;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "LLINATGE1")
    private String llinatge1;
    @Basic(optional = false)
    @Column(name = "LLINATGE2")
    private String llinatge2;

    public Usuaris() {
    }

    public Usuaris(String nif) {
        this.nif = nif;
    }

    public Usuaris(String nif, String nom, String llinatge1, String llinatge2) {
        this.nif = nif;
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        changeSupport.firePropertyChange("nif", oldNif, nif);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public String getLlinatge1() {
        return llinatge1;
    }

    public void setLlinatge1(String llinatge1) {
        String oldLlinatge1 = this.llinatge1;
        this.llinatge1 = llinatge1;
        changeSupport.firePropertyChange("llinatge1", oldLlinatge1, llinatge1);
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public void setLlinatge2(String llinatge2) {
        String oldLlinatge2 = this.llinatge2;
        this.llinatge2 = llinatge2;
        changeSupport.firePropertyChange("llinatge2", oldLlinatge2, llinatge2);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuaris)) {
            return false;
        }
        Usuaris other = (Usuaris) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exerc_databaseconnection.Usuaris[ nif=" + nif + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
