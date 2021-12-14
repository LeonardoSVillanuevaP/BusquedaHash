
package busquedaHash;
import javax.swing.JOptionPane;

public class TestHash {
    public static void main(String[] args) {
        try {
            int i, n, resp;
            String nombre = "";
            int promedio = 0;
            
            int m = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null,"Ingrese el tamaño de la tabla","Tamaño de la tabla",JOptionPane.QUESTION_MESSAGE));
            Hash[] h = new Hash[m];
            for (i = 0; i < h.length; i++) {
                h[i] = new Hash();
                h[i].estado = 0;
            }
            do {
                resp = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Menú Principal \n"
                        + "Insertar (1)\nBuscar (2)\nEliminar (3)\nMostrar 4)\nSalir (5)"));
                switch (resp) {
                    case 1:
                        n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el número de control:","Insertar No. control",JOptionPane.QUESTION_MESSAGE));
                        nombre=JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante","Insertar nombre",JOptionPane.QUESTION_MESSAGE);
                        promedio=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el promedio del estudiante","Insertar promedio",JOptionPane.QUESTION_MESSAGE));
                        Hash.insertaHashDatos(h, m, n, nombre, promedio);
                        break;
                    case 2:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null,"Ingrese el número de control:","Buscar",JOptionPane.QUESTION_MESSAGE));
                        i = Hash.buscaHashDatos(h, m, n);
                        if (i == -1) {
                            JOptionPane.showMessageDialog(null, "Número de control no encontrado","No encontrado",JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Número de control encontrado","Exito al buscar",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null,"Ingrese el número de control a ser eliminado:","Eliminar",JOptionPane.QUESTION_MESSAGE));
                        i = Hash.eliminaHashDatos(h, m, n);
                        if (i == -1) {
                            JOptionPane.showMessageDialog(null, "Número no encontrado", "No encontrado",JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Número eliminado con éxito", "Exito al eliminar",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4: Hash.mostrarHashDatos(h);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                }
            } while (resp != 5);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Está Saliendo del Programa","Salir",JOptionPane.INFORMATION_MESSAGE);
        } catch (OutOfMemoryError ome) {
            JOptionPane.showMessageDialog(null, "No Hay Espacio","Espacio insuficiente", JOptionPane.ERROR_MESSAGE);
        }
    }
}