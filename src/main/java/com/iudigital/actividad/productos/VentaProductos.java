package com.iudigital.actividad.productos;

import com.iudigital.actividad.cliente.producto.ClienteProducto;
import com.iudigital.actividad.cliente.producto.Producto;
import java.util.ArrayList;
import java.util.List;

public class VentaProductos {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);

        ClienteProducto cliente1 = new ClienteProducto("Cliente 1", productos);
        ClienteProducto cliente2 = new ClienteProducto("Cliente 2", productos);

        long initialTime = System.currentTimeMillis();
        CajeraProducto cajera1 = new CajeraProducto("Cajera 1");
        CajeraProducto cajera2 = new CajeraProducto("Cajera 2");

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);

    }

    private static void setProductos(List<Producto> productos) {
        Producto producto1 = new Producto("Arroz", 20, 3);
        Producto producto2 = new Producto("Azucar", 10, 1);
        Producto producto3 = new Producto("Cafe", 5, 5);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}
