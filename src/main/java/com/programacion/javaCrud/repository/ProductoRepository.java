
package com.programacion.javaCrud.repository;

import com.programacion.javaCrud.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findByNombre(String nombre);
}
