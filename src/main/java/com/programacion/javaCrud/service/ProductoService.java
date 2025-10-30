

package com.programacion.javaCrud.service;

import com.programacion.javaCrud.entity.Producto;
import com.programacion.javaCrud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // Crear nuevo producto
    public Producto createProduct(Producto producto) {
        // Actualizar automáticamente el estado del stock basado en la cantidad
        actualizarEstadoStock(producto);
        return repository.save(producto);
    }

    // Leer todos los productos
    public List<Producto> getAllProducts() {
        return repository.findAll();
    }

    // Leer producto por id
    public Optional<Producto> getProductById(Long id) {
        return repository.findById(id);
    }

    // Actualizar producto por nombre
    public Producto updateProductByName(String nombre, Producto updatedProduct) {
        Producto existing = repository.findByNombre(nombre);
        if (existing != null) {
            existing.setNombre(updatedProduct.getNombre());
            existing.setCantidad(updatedProduct.getCantidad());
            existing.setPrecio(updatedProduct.getPrecio());
            
            // Actualizar automáticamente el estado del stock
            actualizarEstadoStock(existing);
            
            return repository.save(existing);
        }
        return null;
    }

    // Borrar producto por id
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    // Método auxiliar para actualizar el estado del stock automáticamente
    private void actualizarEstadoStock(Producto producto) {
        Integer cantidad = producto.getCantidad();
        if (cantidad == 0) {
            producto.setEstadoStock("AGOTADO");
        } else if (cantidad <= 10) {
            producto.setEstadoStock("BAJO");
        } else if (cantidad <= 50) {
            producto.setEstadoStock("MEDIO");
        } else {
            producto.setEstadoStock("ALTO");
        }
    }
}