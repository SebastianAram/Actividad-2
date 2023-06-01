package com.iudigital.actividad.productos;

import com.iudigital.actividad.cliente.producto.ClienteProducto;
import com.iudigital.actividad.cliente.producto.Producto;

public class CajeraProducto {

    private String nombre;

    public CajeraProducto(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        System.out.println("La cajera: " + this.nombre + " comienza a procesar la compra del cliente: " + cliente.getNombre()
                + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000
                + " seg");

        int contCliente = 1;
        for (Producto producto : cliente.getProductos()) {
            this.esperarXsegundos();
            System.out.println("****************************************");
            System.out.println("Procesando el producto: " + contCliente);
            System.out.println("----------------------------------------");
            System.out.println("Nombre del producto: " + producto.getNombre());
            System.out.println("Precio del producto: " + producto.getPrecio());
            System.out.println("Cantidad de productos: " + producto.getCantidad());
            System.out.println("Costo total: " + producto.getCantidad() * producto.getPrecio());
            System.out.println("----------------------------------------");
            System.out.println("Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
            System.out.println("****************************************");

            contCliente++;
        }

        System.out.println("La cajera: " + this.nombre + " ha terminado de procesar: " + cliente.getNombre()
                + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
