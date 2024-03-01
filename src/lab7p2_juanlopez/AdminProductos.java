
package lab7p2_juanlopez;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminProductos {
    private ArrayList <Productos> productos=new ArrayList<>();
    private File archivo = null;

    public AdminProductos() {
    }
    
    public AdminProductos(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }
    
    public void cargarArchivo() {
        Scanner leer = null;
        productos = new ArrayList();
        if (archivo.exists()) {
            try {
                leer = new Scanner(archivo);
                leer.useDelimiter(",");
                while (leer.hasNext()) {
                    productos.add(new Productos(leer.nextInt(), leer.nextLine(), leer.nextLine(), leer.nextDouble(), leer.nextInt(), leer.nextInt()));
                }
            } catch (Exception ex) {
            }
            leer.close();
        }
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Productos p : productos) {
                bw.write(p.getId()+",");
                bw.write(p.getNombre()+",");
                bw.write(p.getCategoria()+",");
                double x=p.getPrecio();
                String price=String.valueOf(x);
                bw.write(price+",");
                bw.write(p.getAisle()+",");
                bw.write(p.getBin()+",");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
}
