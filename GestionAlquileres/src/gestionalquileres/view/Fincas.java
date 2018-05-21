/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalquileres.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author soib1a20
 */
@Entity
@Table(name = "fincas", catalog = "gestion_alquileres", schema = "")
@NamedQueries({
    @NamedQuery(name = "Fincas.findAll", query = "SELECT f FROM Fincas f")
    , @NamedQuery(name = "Fincas.findById", query = "SELECT f FROM Fincas f WHERE f.id = :id")
    , @NamedQuery(name = "Fincas.findByNombre", query = "SELECT f FROM Fincas f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Fincas.findByTipo", query = "SELECT f FROM Fincas f WHERE f.tipo = :tipo")
    , @NamedQuery(name = "Fincas.findByUbicacion", query = "SELECT f FROM Fincas f WHERE f.ubicacion = :ubicacion")
    , @NamedQuery(name = "Fincas.findByRefcatastral", query = "SELECT f FROM Fincas f WHERE f.refcatastral = :refcatastral")
    , @NamedQuery(name = "Fincas.findByRefPropietario", query = "SELECT f FROM Fincas f WHERE f.refPropietario = :refPropietario")})
public class Fincas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "REFCATASTRAL")
    private String refcatastral;
    @Column(name = "REF_PROPIETARIO")
    private String refPropietario;
    @Lob
    @Column(name = "COMENTARIOS")
    private String comentarios;

    public Fincas() {
    }

    public Fincas(Integer id) {
        this.id = id;
    }

    public Fincas(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        String oldUbicacion = this.ubicacion;
        this.ubicacion = ubicacion;
        changeSupport.firePropertyChange("ubicacion", oldUbicacion, ubicacion);
    }

    public String getRefcatastral() {
        return refcatastral;
    }

    public void setRefcatastral(String refcatastral) {
        String oldRefcatastral = this.refcatastral;
        this.refcatastral = refcatastral;
        changeSupport.firePropertyChange("refcatastral", oldRefcatastral, refcatastral);
    }

    public String getRefPropietario() {
        return refPropietario;
    }

    public void setRefPropietario(String refPropietario) {
        String oldRefPropietario = this.refPropietario;
        this.refPropietario = refPropietario;
        changeSupport.firePropertyChange("refPropietario", oldRefPropietario, refPropietario);
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        String oldComentarios = this.comentarios;
        this.comentarios = comentarios;
        changeSupport.firePropertyChange("comentarios", oldComentarios, comentarios);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fincas)) {
            return false;
        }
        Fincas other = (Fincas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionalquileres.view.Fincas[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
