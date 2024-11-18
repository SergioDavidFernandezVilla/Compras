package com.Ventas.Compras.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ventas.Compras.models.ProductoModel;
import com.Ventas.Compras.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductoModel> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public Optional<ProductoModel> getProductoById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    // Crear producto
    @PostMapping
    public ProductoModel createProducto(@RequestBody ProductoModel producto) {
        return productoService.saveProducto(producto);
    }

    // Actualizar producto por ID
    @PutMapping("/{id}")
    public String updateProducto(@PathVariable int id, @RequestBody ProductoModel producto) {
        Optional<ProductoModel> existingProducto = productoService.getProductoById(id);

        if (existingProducto.isPresent()) {
            ProductoModel productoToUpdate = existingProducto.get();
            productoToUpdate.setNombre(producto.getNombre());
            productoToUpdate.setExistencia(producto.getExistencia());
            productoToUpdate.setDescripcion(producto.getDescripcion());
            productoToUpdate.setNombreProv(producto.getNombreProv());

            productoService.saveProducto(productoToUpdate);
            return "Producto actualizado con éxito.";
        } else {
            return "El producto con ID " + id + " no existe.";
        }
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable int id) {
        boolean isDeleted = productoService.deleteProducto(id);
        if (isDeleted) {
            return "Producto eliminado con éxito.";
        } else {
            return "El producto con ID " + id + " no existe.";
        }
    }
}