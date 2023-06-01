package com.iudigital.actividad.thread;

import com.iudigital.actividad.cliente.producto.ClienteProducto;
import com.iudigital.actividad.cliente.producto.Producto;



public class CajeraThreadProducto extends Thread {

    private String nombre;
    private ClienteProducto cliente;
    private long initialTime;

    public CajeraThreadProducto(String nombre, ClienteProducto cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println("La cajera: " + this.nombre
                + " Comienza a procesar la compra del cliente: "
                + this.cliente.getNombre() + " En el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");

        int contCliente = 1;
        for (Producto producto : cliente.getProductos()) {
            this.esperarXsegundos();
            System.out.println("****************************************");
            System.out.println("Procesando el producto: " + contCliente);
            System.out.println("Nombre del producto: " + producto.getNombre());
            System.out.println("Precio del producto: " + producto.getPrecio());
            System.out.println("Cantidad de productos: " + producto.getCantidad());
            System.out.println("Costo total: " + producto.getCantidad() * producto.getPrecio());
            System.out.println("Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            

            contCliente++;
        }

        System.out.println("La cajera: " + this.nombre + " ha terminado de procesar: " + this.cliente.getNombre()
                + " en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
    }
}
