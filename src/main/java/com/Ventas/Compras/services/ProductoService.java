package com.Ventas.Compras.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ventas.Compras.models.ProductoModel;
import com.Ventas.Compras.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<ProductoModel> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por ID
    public Optional<ProductoModel> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    // Crear o actualizar producto
    public ProductoModel saveProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto por ID
    public boolean deleteProducto(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
