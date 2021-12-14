
package busquedaHash;

public class Hash {
    int dato;
    String nombre;
    int promedio;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado

    static int funcion(int n, int m) {
        return ((n) % m);
    }

    
    static void insertaHashDatos(Hash[] h, int m, int n, String name, int prom) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].nombre=name;
                h[j].promedio=prom;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Elementos insertados con éxito!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Tabla llena!");
        }
    }

    
    static int buscaHashDatos(Hash[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    System.out.print("No. control: "+h[j].dato+"\nNombre: "+h[j].nombre+"\tPromedio: "+h[j].promedio+"\n");
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;
    }
            
        static void mostrarHashDatos(Hash[] h){
            for(int i=0;i<h.length;i++){
                System.out.println("No. control: "+h[i].dato+"\nNombre: "+h[i].nombre+"\tPromedio: "+h[i].promedio+"\n");
            }
            System.out.print("=================================================================================\n");
        }
           
    static int eliminaHashDatos(Hash[] h, int m, int n) {
        int i = buscaHashDatos(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            h[i].dato=0;
            h[i].nombre="";
            h[i].promedio=0;
            return 1;
        }
    }
}