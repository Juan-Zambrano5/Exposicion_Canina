package umariana.exposicion_canina;

import Perro.Perro;
import java.util.*;

/**
 *
 * @author Santiago Luna y Juan Zambrano
 */
public class Exposicion_canina {
    
        //Creamos y definimos el ArrayList y el Scanner
        private ArrayList<Perro> misPerros = new ArrayList<>();
        private Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        
        Exposicion_canina expo = new Exposicion_canina();
        expo.mostrarMenu();
    }
    
    //Metodo para mostrar el menu
        public void mostrarMenu() {
            boolean activo = true;

            
        do {
            System.out.println("========= Menu de opciones ==========");
            System.out.println("1. Registrar un perro");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Mostrar informacion de un perro");
            System.out.println("4. Modificar informacion de un perro");
            System.out.println("5. Buscar el perro ganador");
            System.out.println("6. Buscar el perro con menor puntaje");
            System.out.println("7. Buscar al perro mas viejo");
            System.out.println("8. Eliminar un perro");
            System.out.println("9. Terminar programa");
            System.out.println("Seleccione una opcion");
            System.out.println("=====================================");
        
            int opcion = lector.nextInt();
            
             switch (opcion) {
                case 1:
                    try {
                    agregarPerro();
                    }
                    catch (NombreDuplicadoException e) {
                        System.out.println(e.getMessage()); 
                    }
                    break;
                case 2:
                    if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    mostrarLista();
                    }
                    break;
                case 3:
                    if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    mostrarInfo();
                    }
                    break;
                case 4:
                if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    modificarPerro();
                    }
                    break;
                case 5:
                if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    buscarGanador();
                    }
                    break;
                case 6:
                if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    buscarPerdedor();
                    }
                    break;
                case 7:
                if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    buscarPerroViejo();
                    }
                    break;
                case 8:
                if (misPerros.isEmpty()){
                        System.out.println("Aun no ha ingresado un perro");
                    }
                    else {
                    eliminarPerro();
                    }
                    break;
                case 9:
                    activo = false;
                    System.out.println("Programa terminado");
                    break;   
                    
                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }
        } while (activo);
    }
        //Metodo para agergar un perro a la exposicion
        //Solicita al usuario el nombre, raza, edad, puntos y la foto del perro
        public void agregarPerro() throws NombreDuplicadoException {
            //Ingresar el nombre del perro
             System.out.println("Ingrese el nombre del perro");
               lector.nextLine();
               String nombre = lector.nextLine();
                  //Llama a la excepcion si hay un nombre repetido
                  if (!misPerros.isEmpty()) {
                  for(Perro p: misPerros)
                  {
                  if (p.getNombre().equalsIgnoreCase(nombre)) 
                  {
                  throw new NombreDuplicadoException();
                  }
                 }
               }
                //Ingresar la raza del perro
                System.out.println("Ingrese la raza del perro");
                String raza = lector.nextLine();
                //Ingresar la edad del perro
              System.out.println("Ingrese la edad del perro");
              int edad = lector.nextInt();
              //Ingresar los puntos del perro
              System.out.println("Ingrese los puntos del perro");
              int puntos = lector.nextInt();
              
              //Variable oto
              String foto;
              //ciclo do-while para validar si la foto esta en el formato correcto
              do {
                //Ingresar la foto del perro
              System.out.println("Ingrese la foto del perro");
              System.out.println("Ej: firulais.jpg");
              lector.nextLine();
              foto = lector.nextLine();
              
              //Validar si la foto termina en .jpg
              if (foto.endsWith(".jpg")) {
                  System.out.println("La foto se ha asignada conrrectamente");
                  
        }
              else {
                System.out.println("La foto no corresponde al formato adecuado (.jpg)");
                System.out.println("Intente de nuevo");
              }
              
              }while (!foto.endsWith(".jpg"));
              

              //Creacion del objeto y llenar la informacion
              Perro nuevoPerro = new Perro (nombre, raza, edad, puntos, foto);
              //Agrega el nuevoPerro al ArrayList de misPerros
              misPerros.add(nuevoPerro);
              System.out.println("Informacion del perro agregada satisfactoriamente"); 
        }
        
        //Metodo para mostrar la lista de los perros ordenada por raza, puntos o edad
        //Solicita al usuario la opcion de ordenamiento
        public void mostrarLista() {
            boolean activo = true;
            do {
                System.out.println("======= Menu de opciones =======");
                System.out.println("1. Ordenar por raza");
                System.out.println("2. Ordenar por puntos");
                System.out.println("3. Ordenar por edad");
                System.out.println("4. Volver al menu");
                
                int opcion = lector.nextInt();
                
                switch (opcion) {
                    case 1:
                        //Ordena los perros por la raza
                        Collections.sort(misPerros, new Comparator<Perro>() {
                    @Override
                    public int compare(Perro p1, Perro p2) {
                        return p1.getRaza().compareToIgnoreCase(p2.getRaza());
                    }
                });
                //Muestra la lista de perros ordenada por su raza
                for (Perro p: misPerros){
                System.out.println("Nombre: " +p.getNombre());
                System.out.println("Raza: " +p.getRaza());
                System.out.println("Edad: " +p.getEdad());
                System.out.println("Puntos: " +p.getPuntos());
                System.out.println("Foto: " +p.getFoto());
                }
                break;
                    case 2:
                        //Ordena los perros por los puntos
                        int m = misPerros.size();
                    for (int i = 0; i < m - 1; i++) {
                        for (int j = 0; j < m - i - 1; j++) {
                            if (misPerros.get(j).getPuntos() < misPerros.get(j + 1).getPuntos()) {
                            Perro temp = misPerros.get(j);
                            misPerros.set(j, misPerros.get(j + 1));
                            misPerros.set(j + 1, temp);
                }
            }
        }       //Muestra la lista de perros ordenada por los puntos
                for (Perro p: misPerros){
                System.out.println("Nombre: " +p.getNombre());
                System.out.println("Raza: " +p.getRaza());
                System.out.println("Edad: " +p.getEdad());
                System.out.println("Puntos: " +p.getPuntos());
                System.out.println("Foto: " +p.getFoto());
                }
                break;
                    case 3:
                        //Ordena los perros por edad
                        int l = misPerros.size();
                    for (int i = 0; i < l - 1; i++) {
                        for (int j = 0; j < l - i - 1; j++) {
                            if (misPerros.get(j).getEdad() < misPerros.get(j + 1).getEdad()) {
                            Perro temp = misPerros.get(j);
                            misPerros.set(j, misPerros.get(j + 1));
                            misPerros.set(j + 1, temp);
                }
            }
        }       //Muestra la lista de perros ordenada por la edad
                for (Perro p: misPerros){
                System.out.println("Nombre: " +p.getNombre());
                System.out.println("Raza: " +p.getRaza());
                System.out.println("Edad: " +p.getEdad());
                System.out.println("Puntos: " +p.getPuntos());
                System.out.println("Foto: " +p.getFoto());
                }
                break;
                    case 4:
                        activo = false;
                        System.out.println("Opcion finalizada");
                        break;
                    default:
                        System.out.println("Opcion no valida, intentelo nuevamente");
                }
                
            } while (activo);
        }
        
        
        //Metodo para mostrar la informacion de un perro especifico
        //Solicita al usuario el nombre del perro
        public void mostrarInfo(){
            lector.nextLine();
        System.out.println("Ingrese el nombre del perro a buscar:");
        String n = lector.nextLine();
        boolean e = false;
    
        for (Perro p : misPerros) {
             //Comprobar que el nombre ingresado corresponde a un perro
             if (p.getNombre().equalsIgnoreCase(n)) {
                e = true;
                //Muestra la informacion del perro
                System.out.println("La informacion del perro "+n+ " es la siguiente");
                System.out.println("Nombre: " +p.getNombre());
                System.out.println("Raza: " +p.getRaza());
                System.out.println("Edad: " +p.getEdad());
                System.out.println("Puntos: " +p.getPuntos());
                System.out.println("Foto: " +p.getFoto());
             break;
        }
      }
      // Si no se logra comprobar el nombre ingresado, se mostrara que fue asi
      if (!e) {
        System.out.println("No se encontró ningún perro con ese nombre.");
      }
        }
        
        //Metodo para modificar la informacion de un perro
        //Solicita al usuario el nombre del perro a cambiar y que quiere cambiar
        public void modificarPerro() {
            lector.nextLine();
            System.out.println("Ingrese el nombre del perro del cual desea modificar la informacion");
                String n = lector.nextLine();
                 
                 
            boolean activo = true;
                
                 for (Perro p : misPerros) {
                    if (p.getNombre().equalsIgnoreCase(n)) {
                do {
                System.out.println("======= Menu de opciones =======");
                System.out.println("1. Cambiar raza");
                System.out.println("2. Cambiar edad");
                System.out.println("3. Cambiar puntos");
                System.out.println("4. Cambiar foto");
                System.out.println("5. Volver al menu");
                
                int opcion = lector.nextInt();
                
                switch (opcion) {
                    case 1:
                        modificarRaza(p);
                    break;
                    case 2:
                        modificarEdad(p);
                    break;
                    case 3:
                        modificarPuntos(p);
                    break;
                    case 4:
                        modificarFoto(p);
                    break;
                    case 5:
                        activo = false;
                        System.out.println("Opcion finalizada");
                        break;
                    default:
                        System.out.println("Opcion no valida, intentelo nuevamente");
                }
                
            } while (!activo);
                        }
                 }
                    }
        
        //Metodo para modificar la edad del perro
        //Solicita al usuario la nueva edad del perro
        public void modificarEdad (Perro p) {
            System.out.println("Ingrese la nueva edad");
                lector.nextLine();
                int nuevaEdad = lector.nextInt();
                p.setEdad(nuevaEdad);
        }
        
        //Metodo para modificar la raza del perro
        //Solicita al usuario la nueva raza del perro
        public void modificarRaza (Perro p) {
            System.out.println("Ingrese la nueva raza");
            lector.nextLine();
            String nuevaRaza = lector.nextLine();
            p.setRaza(nuevaRaza);
        }
        
        //Metodo para modificar los puntos del perro
        //Solicita al usuario la nueva cantidad de puntos del perro
        public void modificarPuntos(Perro p) {
            System.out.println("Ingrese la nueva cantidad de puntos");
            lector.nextLine();
            int nuevosPuntos = lector.nextInt();
            p.setPuntos(nuevosPuntos);
        }
        
        //Metodo para modificar la foto del perro
        //Solicita al usuario la nueva foto del perro
        public void modificarFoto (Perro p) {
            System.out.println("Ingrese la nueva foto");
            lector.nextLine();
            String nuevaFoto = lector.nextLine();
            p.setFoto(nuevaFoto);
        }

        //Metodo para buscar al perro ganador del evento por la cantidad de puntos
        public void buscarGanador() {
            int n = misPerros.size();
            
                    //Ordena los perros por los puntos
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (misPerros.get(j).getPuntos() > misPerros.get(j + 1).getPuntos()) {
                            Perro temp = misPerros.get(j);
                            misPerros.set(j, misPerros.get(j + 1));
                            misPerros.set(j + 1, temp);
                }
            }
        }
            //Obtener el perro ganador
            Perro perroGanador = misPerros.get(misPerros.size() - 1);
                //Muestra la informacion del perro ganador
                System.out.println("Nombre: " +perroGanador.getNombre());
                System.out.println("Raza: " +perroGanador.getRaza());
                System.out.println("Edad: " +perroGanador.getEdad());
                System.out.println("Puntos: " +perroGanador.getPuntos());
                System.out.println("Foto: " +perroGanador.getFoto());
        }
        
        //Metodo para buscar al perro perdedor del evento por la cantidad de puntos
        public void buscarPerdedor() {
            int n = misPerros.size();
                    //Ordena los perros por los puntos
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (misPerros.get(j).getPuntos() > misPerros.get(j + 1).getPuntos()) {
                            Perro temp = misPerros.get(j);
                            misPerros.set(j, misPerros.get(j + 1));
                            misPerros.set(j + 1, temp);
                }
            }
        }
            //Obtener el perro perdedor
            Perro perroPerdedor = misPerros.get(0);
                //Muestra la informacion del perro perdedor
                System.out.println("Nombre: " +perroPerdedor.getNombre());
                System.out.println("Raza: " +perroPerdedor.getRaza());
                System.out.println("Edad: " +perroPerdedor.getEdad());
                System.out.println("Puntos: " +perroPerdedor.getPuntos());
                System.out.println("Foto: " +perroPerdedor.getFoto());
        }
        
        //Metodo para buscar al perro mas viejo del evento
        public void buscarPerroViejo() {
            int n = misPerros.size();
                    //Ordena los perros por la edad
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (misPerros.get(j).getEdad() > misPerros.get(j + 1).getEdad()) {
                            Perro temp = misPerros.get(j);
                            misPerros.set(j, misPerros.get(j + 1));
                            misPerros.set(j + 1, temp);
                }
            }
        }
            //Obtener el perro mas viejo
            Perro perroViejo = misPerros.get(misPerros.size() -1);
                //Muestra la informacion del perro mas viejo
                System.out.println("Nombre: " +perroViejo.getNombre());
                System.out.println("Raza: " +perroViejo.getRaza());
                System.out.println("Edad: " +perroViejo.getEdad());
                System.out.println("Puntos: " +perroViejo.getPuntos());
                System.out.println("Foto: " +perroViejo.getFoto());
        }   
        
        //Metodo para eliminar un perro
        //Solicita al usuario el nombre del perro a eliminar
        public void eliminarPerro() {
            System.out.println("Ingrese el nombre del perro a eliminar");
            lector.nextLine();
            String n = lector.nextLine();
            
            //Iterar sobre la lista para buscar al perro por su nombre
            for(Perro p: misPerros) {
                if (p.getNombre().equalsIgnoreCase(n)) {
                    
                    //Verifica que se quiera eliminar al perro
                    System.out.println("Estas seguro que quieres eliminar un perro del evento?");
                    System.out.println("Escribe si para eliminarlo o escribe no para salir de la opcion");
                    String op = lector.nextLine();
                    
                    //Elimina al perro del evento
                    if (op.equals("si")) {
                    misPerros.remove(p);
                    System.out.println("El perro con nombre "+n+" ha sido eliminado correctamente");
                    }
                    else if (op.equals("no")) {
                        System.out.println("El perro con nombre "+n+" no ha sido eliminado");
                    }
                    else if (!op.equals("si" + "no")) {
                        System.out.println("Ingrese una opcion valida");
                    }
                    break;
                }
                else {
                    System.out.println("No se ha encontrado un perro con el nombre "+n);
                }
            }
            }
}
