
package com.programacion.javaCrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Producto")
    private Long idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estado_stock")
    private String estadoStock;

    // --- Getters y Setters ---
    public Long getIdProducto() { 
        return idProducto; 
    }
    
    public void setIdProducto(Long idProducto) { 
        this.idProducto = idProducto; 
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public Integer getCantidad() { 
        return cantidad; 
    }
    
    public void setCantidad(Integer cantidad) { 
        this.cantidad = cantidad; 
    }

    public Double getPrecio() { 
        return precio; 
    }
    
    public void setPrecio(Double precio) { 
        this.precio = precio; 
    }

    public String getEstadoStock() { 
        return estadoStock; 
    }
    
    public void setEstadoStock(String estadoStock) { 
        this.estadoStock = estadoStock; 
    }
}