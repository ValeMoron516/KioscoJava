
package com.programacion.javaCrud.controller;

import com.programacion.javaCrud.entity.Producto;
import com.programacion.javaCrud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // Crear producto
    @PostMapping("/create")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto creado = service.createProduct(producto);
        return ResponseEntity.status(201).body(creado);
    }

    // Leer todos
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    // Leer por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return service.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar por nombre
    @PutMapping("/update/{nombre}")
    public ResponseEntity<Producto> actualizarProductoPorNombre(@PathVariable String nombre,
                                                       @RequestBody Producto producto) {
        Producto actualizado = service.updateProductByName(nombre, producto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Borrar por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}