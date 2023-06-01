
package com.iudigital.actividad.thread;

import com.iudigital.actividad.cliente.producto.ClienteProducto;
import com.iudigital.actividad.cliente.producto.Producto;
import java.util.ArrayList;
import java.util.List;

public class MainThreadProducto {
    
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        
        ClienteProducto cliente1 = new ClienteProducto("Sebas ", productos);
        ClienteProducto cliente2 = new ClienteProducto("Andres ", productos);
        
        long initialTime = System.currentTimeMillis();
        CajeraThreadProducto cajera1 = new CajeraThreadProducto("Sandra", cliente1, initialTime);
        CajeraThreadProducto cajera2 = new CajeraThreadProducto("Daniela", cliente2, initialTime);
        
        cajera1.start();
        cajera2.start();
    }
    
    private static void setProductos(List<Producto> productos){
        Producto p1 = new Producto("Manzana", 50, 5);
        Producto p2 = new Producto("Durazno", 30, 5);
        Producto p3 = new Producto("Fresa", 60, 5);
        
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
    }
}
