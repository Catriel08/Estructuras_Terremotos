import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TerremotosBrayanGrimaldo {

    //Este es un comentario
    ArrayList terremotos;
    int contador =0;

    Scanner leer = new Scanner(System.in);

    File cargar = new File("C:\\Users\\Brayan\\IdeaProjects\\ServgeologicoBrayanGrimaldo\\Txt_Terremotos\\Terremotos.txt");

    File reporte = new File("C:\\Users\\Brayan\\IdeaProjects\\ServgeologicoBrayanGrimaldo\\Txt_Terremotos\\ReporteTerremoto.txt");



    public TerremotosBrayanGrimaldo() {
        terremotos = new ArrayList<>();
        cargarTerremotosTxtBrayanGrimaldo();
        contador=retornarUltimoIdTerremotoBrayanGrimaldo();

        while (true){

            System.out.println("---------------------------------------------------");
            System.out.println("---------------------------------------------------");
            System.out.println("                  MENÚ PRICIPAL");
            System.out.println("---------------------------------------------------");
            System.out.println("---------------------------------------------------");
            System.out.println("");

            System.out.println("1. Mostrar los terremotos\n" +
                                "2. Ordenar terremotos de forma ascendente por nombre  \n" +
                                "3. Ordenar terremotos de forma ascendente por número de muertos  \n" +
                                "4. Ordenar terremotos de forma descendente por magnitud  \n" +
                                "5. mostrar terremotos especifico \n" +
                                "6. registrar un terremotos \n" +
                                "7. Buscar terremotos por nombre  \n" +
                                "8. Buscar terremotos por número de muertos  \n" +
                                "9. buscar terremotos que causo menos muertos  \n" +
                                "10. buscar terremotos que tiene mayor magnitud  \n" +
                                "11. Eliminar terremotos \n" +
                                "12. Generar reporte de terremotos y salir\n" +
                                "---------------------------------------------------\n" +
                                "---------------------------------------------------\n" +
                                "---------------------------------------------------\n" +
                                "---------------------------------------------------");
                                System.out.println("");

            System.out.println("Ingrese una opcion: ");
            switch (leer.nextInt())
            {
                case 1:
                    mostrarTerremotosBrayanGrimaldo();
                    break;
                case 2:
                    ordenarNombreTerremotoBrayanGrimaldo();
                    break;
                case 3:
                    ordenarMuertosTerremotoBrayanGrimaldo();
                    break;
                case 4:
                    ordenarMagnitudTerremotoBrayanGrimaldo();
                    break;
                case 5:
                    mostrarTerremotoEspecificoBrayanGrimaldo();
                    break;
                case 6:
                    registrarTerremotoBrayanGrimaldo();
                    guardarTerremotosTxtBrayanGrimaldo();
                    break;
                case 7:
                    buscarTerremotoNombreBrayanGrimaldo();
                    break;
                case 8:
                    busquedaMuertosTerremotoBrayanGrimaldo();
                    break;
                case 9:
                    buscarTerremotoMenosMuertosBrayanGrimaldo();
                    break;
                case 10:
                    buscarTerremotoMayorMagnitudBrayanGrimaldo();
                    break;
                case 11:
                    eliminarTerremotoTxtBrayanGrimaldo();
                    break;
                case 12:
                    guardarTerremotosTxtBrayanGrimaldo();
                    reporteTerremotosTxtBrayanGrimaldo();
                    System.out.println("Ha salido correctamente del menú");
                    leer.close();
                    System.exit(0);
            }
        }
    }

    public int retornarUltimoIdTerremotoBrayanGrimaldo() {
        int tempNumMayor = 0;
        Terremoto terremoto;

        for(int i=0; i<terremotos.size();i++) {
            terremoto = (Terremoto) terremotos.get(i);
            if (terremoto.getIdentificacion() > tempNumMayor) {
                tempNumMayor = terremoto.getIdentificacion();
            }
        }

        return tempNumMayor;
    }

    public void eliminarTerremotoTxtBrayanGrimaldo() {

        System.out.println("");
        System.out.println("------------------ELIMINAR TERREMOTO-------------------");
        System.out.println("");

        int idTerremoto;
        String nombreTerremoto;
        int numMuertosTerremoto;
        float magnitudTerremoto;
        String fechaTerremoto;
        String departamentoTerremoto;
        Terremoto terremoto;
        String opcion;

        // Le pedimos al usuario el id para buscar el terremotos
        System.out.println("Ingrese el id del terremoto que desea eliminar:");
        idTerremoto = leer.nextInt();

        // Iteramos todos los terremotos y encontramos el terremotos que el usuario esta buscando con el "idTerremoto"
        for(int i=0; i<terremotos.size();i++) {
            terremoto = (Terremoto) terremotos.get(i);

            if (terremoto.getIdentificacion() == idTerremoto) {
                System.out.println("¿Está seguro que desea eliminar el terremoto con el id " + idTerremoto + "? (Y/N)");
                opcion = leer.next();

                // Si la respuesta es "Y", entonces eliminara el terremotos
                if (opcion.compareToIgnoreCase("Y") == 0) {
                    terremotos.remove(i);
                    guardarTerremotosTxtBrayanGrimaldo();
                    System.out.println("El terremotos con el id " + idTerremoto + " ha sido eliminado correctamente");
                    // Si la respuesta es "N", entonces NO eliminara el terremotos
                } else if (opcion.compareToIgnoreCase("N") == 0) {
                    System.out.println("Operación cancelada, volviendo al menu principal...");

                    System.out.println("");
                    System.out.println("------------------FIN ELIMINAR TERREMOTO-------------------");
                    System.out.println("");
                }
            }
        }
    }

    public void cargarTerremotosTxtBrayanGrimaldo()
    {
        int cont;
        int iden=1;

        String nombre_terremoto;
        String fecha_ocurrencia;
        float magnitud_terremoto;
        String departamento_ocurrencia;
        int numero_muertos;

        Terremoto colombia;
        String linea = " ";

        try
        {
            FileReader reader= new FileReader(cargar) ;
            BufferedReader bufer= new BufferedReader(reader);
            linea=bufer.readLine();
            cont=Integer.parseInt(linea);
            for(int i=0;i<cont;i++)
            {

                iden=Integer.parseInt(bufer.readLine());

                nombre_terremoto=bufer.readLine();

                fecha_ocurrencia=bufer.readLine();

                magnitud_terremoto=Float.parseFloat(bufer.readLine());

                departamento_ocurrencia=bufer.readLine();

                numero_muertos=Integer.parseInt(bufer.readLine());

                contador ++;
                colombia = new Terremoto(iden, nombre_terremoto,fecha_ocurrencia,magnitud_terremoto, departamento_ocurrencia, numero_muertos);
                terremotos.add(colombia);
            }

            bufer.close();
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("error al leer informacion del archivo");
        }
    }

    public void guardarTerremotosTxtBrayanGrimaldo()
    {
        int totalterremotos;

        int iden=1;
        String nombre_terremoto;
        String fecha_ocurrencia;
        float magnitud_terremoto;
        String departamento_ocurrencia;
        int numero_muertos;

        Terremoto colombia;
        try
        {
            PrintWriter writer = new PrintWriter(cargar);
            totalterremotos = terremotos.size();
            writer.println(totalterremotos);
            for(int i = 0; i< terremotos.size(); i++)
            {
                colombia=(Terremoto) terremotos.get(i);
                iden=colombia.getIdentificacion();
                nombre_terremoto=colombia.getNombre_terremoto();
                fecha_ocurrencia=colombia.getFecha_ocurrencia();
                magnitud_terremoto=colombia.getMagnitud_terremoto();
                departamento_ocurrencia=colombia.getDepartamento_ocurrencia();
                numero_muertos=colombia.getNumero_muertos();

                writer.println(iden);
                writer.println(nombre_terremoto);
                writer.println(fecha_ocurrencia);
                writer.println(magnitud_terremoto);
                writer.println(departamento_ocurrencia);
                writer.println(numero_muertos);

            }

            writer.close();
        }
        catch(Exception e)
        {
            System.out.println("error al escribir en el archivo");
        }
    }

    public void reporteTerremotosTxtBrayanGrimaldo()
    {

        String nombre_terremoto;
        String fecha_ocurrencia;
        float magnitud_terremoto;
        String departamento_ocurrencia;
        int numero_muertos;

        Terremoto colombia;
        try
        {
            PrintWriter writer = new PrintWriter(reporte);

            writer.println("  *******************************************************");
            writer.println("  S E R V I C I O  G E O L O G I C O  C O L O M B I A N O");
            writer.println("  *******************************************************");
            writer.println("");
            writer.println("  Lista de terremotos ocurridos en Colombia: ");
            writer.println(" ");

            for(int i = 0; i< terremotos.size(); i++)
            {
                colombia =(Terremoto) terremotos.get(i);

                nombre_terremoto = colombia.getNombre_terremoto();
                fecha_ocurrencia=colombia.getFecha_ocurrencia();
                magnitud_terremoto=colombia.getMagnitud_terremoto();
                departamento_ocurrencia=colombia.getDepartamento_ocurrencia();
                numero_muertos=colombia.getNumero_muertos();

                writer.println("  < " + nombre_terremoto + " & " + fecha_ocurrencia + " & " + magnitud_terremoto + " & "
                        + departamento_ocurrencia + " & " + numero_muertos + " >");
                writer.println(" ");

            }

            //Terremoto con mayor magnitud
            Terremoto tempMayor = (Terremoto) terremotos.get(0);
            Terremoto terremotoMagnitud;

            for (int i = 0; i < terremotos.size(); i++) {
                terremotoMagnitud = (Terremoto) terremotos.get(i);
                if (tempMayor.getMagnitud_terremoto() < terremotoMagnitud.getMagnitud_terremoto()) {
                    tempMayor = terremotoMagnitud;
                }
            }
            writer.println("  Terremoto de mayor magnitud: " + tempMayor.getNombre_terremoto());
            writer.println("");


            //terremotos con mayor número de muertos
            Terremoto tempMenor = (Terremoto) terremotos.get(0);
            Terremoto terremotoMuertos;

            for (int i = 0; i < terremotos.size(); i++) {
                terremotoMuertos = (Terremoto) terremotos.get(i);
                if (tempMenor.getNumero_muertos() < terremotoMuertos.getNumero_muertos()) {
                    tempMenor = terremotoMuertos;
                }
            }
            writer.println("  Terremoto con mayor número de perdidas humanas: " + "<" + tempMenor.getNombre_terremoto() + " & " +
                        tempMenor.getNumero_muertos()+ ">");
            writer.println("");

            writer.println("  *******************************************************");
            writer.println("            F I N  D E L  R E P O R T E");
            writer.println("  *******************************************************");

            writer.close();

            System.out.println("Se hizo el reporte correctamente");
        }
        catch(Exception e)
        {
            System.out.println("error al escribir en el archivo");
        }
    }

    public static void main(String[] args) {
        TerremotosBrayanGrimaldo obj = new TerremotosBrayanGrimaldo();
    }

    public void mostrarTerremotosBrayanGrimaldo() {

        Terremoto call;

        for (int i = 0; i < terremotos.size(); i++) {
            call = (Terremoto) terremotos.get(i);
            System.out.println("Identificación: " + call.identificacion);
            System.out.println("Nombre: " + call.getNombre_terremoto());
            System.out.println("Fecha: " + call.getFecha_ocurrencia());
            System.out.println("Magnitud: " + call.getMagnitud_terremoto());
            System.out.println("Departamento: " + call.getDepartamento_ocurrencia());
            System.out.println("Muertos: " + call.getNumero_muertos());
            System.out.println(" ");


        }
    }


    public void ordenarNombreTerremotoBrayanGrimaldo() //Ordenamiento insercción
    {
        System.out.println("");
        System.out.println("------------------ORDENAR TERREMOTO POR NOMBRE ASCENDENTE-------------------");
        System.out.println("");
        for (int i = 1; i < terremotos.size(); i++) {
            Terremoto porInsertar = (Terremoto) terremotos.get(i);
            boolean termino = false;
            for (int j = i; j > 0 && !termino; j--) {
                Terremoto actual = (Terremoto) terremotos.get(j - 1);
                if (actual.getNombre_terremoto().compareToIgnoreCase(porInsertar.getNombre_terremoto()) > 0) {
                    terremotos.set(j, actual);
                    terremotos.set(j - 1, porInsertar);
                } else {
                    termino = true;
                }
            }
        }
        mostrarTerremotosBrayanGrimaldo();

        System.out.println("------------------FIN ORDENAMIENTO-------------------");
        System.out.println("");
    }

    public void ordenarMuertosTerremotoBrayanGrimaldo() //Ordenamiento burbuja
    {
        System.out.println("");
        System.out.println("------------------ORDENAR TERREMOTO POR NÚEMRO DE MUERTOS ASCENDENTE-------------------");
        System.out.println("");
        for (int i = terremotos.size(); i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                Terremoto p1 = (Terremoto) terremotos.get(j);
                Terremoto p2 = (Terremoto) terremotos.get(j + 1);

                if (p1.getNumero_muertos() > p2.getNumero_muertos()) {
                    terremotos.set(j, p2);
                    terremotos.set(j + 1, p1);
                }
            }
        }
        mostrarTerremotosBrayanGrimaldo();

        System.out.println("------------------FIN ORDENAMIENTO-------------------");
        System.out.println("");
    }

    public void ordenarMagnitudTerremotoBrayanGrimaldo() //Ordenamiento seleccion
    {
        System.out.println("");
        System.out.println("------------------ORDENAR TERREMOTO POR MAGNITUD ASCENDENTE-------------------");
        System.out.println("");

        for (int i = 0; i < terremotos.size(); i++) {
            int posicionMenor = i;
            Terremoto datoMenor = (Terremoto) terremotos.get(i);
            for (int j = i + 1; j < terremotos.size(); j++) {
                Terremoto datoPosicion = (Terremoto) terremotos.get(j);
                if (datoPosicion.getMagnitud_terremoto() > datoMenor.getMagnitud_terremoto()) {
                    datoMenor = datoPosicion;
                    posicionMenor = j;
                }

            }
            if (posicionMenor != i) {
                Terremoto temp = (Terremoto) terremotos.get(i);
                terremotos.set(i, datoMenor);
                terremotos.set(posicionMenor, temp);
            }
        }
        mostrarTerremotosBrayanGrimaldo();

        System.out.println("------------------FIN ORDENAMIENTO-------------------");
        System.out.println("");
    }

    public void mostrarTerremotoEspecificoBrayanGrimaldo() {

        System.out.println("");
        System.out.println("---------------------MOSTRANDO TERREMOTOS---------------");
        System.out.println("");

        mostrarTerremotosBrayanGrimaldo();

        int identificacion = 0;
        boolean existe = false;
        int posicion = 0;
        Terremoto temp;
        System.out.println("Ingrese la identificación del terremotos que desee ver: ");
        identificacion = leer.nextInt();

        for (int i = 0; i < terremotos.size() && !existe; i++) {
            temp = (Terremoto) terremotos.get(i);
            if (identificacion == temp.getIdentificacion()) {
                existe = true;
                posicion = i;
            }
        }
        if (existe == true) {
            temp = (Terremoto) terremotos.get(posicion);
            System.out.println("Identificación del terremotos: " + temp.getIdentificacion());
            System.out.println("Nombre del terremotos: " + temp.getNombre_terremoto());
            System.out.println("Fecha de ocurrencia en formato: " + temp.getFecha_ocurrencia());
            System.out.println("magnitud del terremotos: " + temp.getMagnitud_terremoto());
            System.out.println("Departamento de ocurrencia: " + temp.getDepartamento_ocurrencia());
            System.out.println("Número de muertos: " + temp.getNumero_muertos());

        } else
            System.out.println("El terremotos con la identiicación: " + identificacion + " no existe");

        System.out.println("");
        System.out.println("------------------FIN BÚSQUEDA TERREMOTO ESPECÍFICO-------------------");
        System.out.println("");
    }


    public void registrarTerremotoBrayanGrimaldo()
    {
        String nombre;
        String fecha;
        float magnitud;
        String departamento;
        int muertos;
        contador++;

        System.out.println("");
        System.out.println("------------------REGISTRANDO TERREMOTO-------------------");
        System.out.println("");

        System.out.println("Ingrese el nombre del terremotos: ");
        nombre=leer.next().toUpperCase();

        System.out.println("Ingrese la fecha del terremotos en formato (DD/MM/YYYY): ");
        fecha=leer.next();

        System.out.println("Ingrese la magnitud del terremotos decimal (x,x): ");
        magnitud=leer.nextFloat();

        System.out.println("Ingrese el departamento de ocurrencia del terremotos: ");
        departamento=leer.next();

        System.out.println("Ingrese la cantidad de muertos del terremotos: ");
        muertos=leer.nextInt();

        if ((magnitud <0 || muertos <0))
        {
        System.out.println("ERROR. Ingrese correctamente los valores de magnitud o número de muertos, estos deben ser mayores a 0");

        }else if ((magnitud < 5 && muertos > 0) || (magnitud > 5)){
        Terremoto temp = new Terremoto(contador,nombre,fecha,magnitud,departamento,muertos);
        terremotos.add(temp);

        }else {
        System.out.println("No se registra el terremotos debido a que no tiene relevancia por número de muertos y/o magnitud," +
                " esta debe ser mayor a 5 o inferior a 5 pero con un registro mayor a 0 de número de muertos");
        }

        System.out.println("------------------FIN REGISTRO TERREMOTO-------------------");
        System.out.println("");

    }

    public void buscarTerremotoNombreBrayanGrimaldo() {

        System.out.println("");
        System.out.println("------------------BUSCAR TERREMOTO POR NOMBRE-------------------");
        System.out.println("");

        String identificacion = "";
        boolean existe = false;
        int posicion = 0;
        Terremoto temp;
        System.out.println("Digite el nombre del terremotos: ");
        identificacion = leer.next();

        for (int i = 0; i < terremotos.size() && !existe; i++) {
            temp = (Terremoto) terremotos.get(i);
            if (identificacion.compareToIgnoreCase(temp.getNombre_terremoto()) == 0) {
                existe = true;
                posicion = i;
            }
        }

        if (existe == true) {
            temp = (Terremoto) terremotos.get(posicion);
            System.out.println("Identificación del terremotos: " + temp.getIdentificacion());
            System.out.println("Nombre del terremotos: " + temp.getNombre_terremoto());
            System.out.println("Fecha de ocurrencia: " + temp.getFecha_ocurrencia());
            System.out.println("magnitud del terremotos: " + temp.getMagnitud_terremoto());
            System.out.println("Departamento de ocurrencia: " + temp.getDepartamento_ocurrencia());
            System.out.println("Número de muertos: " + temp.getNumero_muertos());

        } else
            System.out.println("El terremotos con dicho nombre no se encunetra registrado");

        System.out.println("");
        System.out.println("------------------FIN BÚSQUEDA-------------------");
        System.out.println("");
    }

    public void busquedaMuertosTerremotoBrayanGrimaldo() {

        System.out.println("");
        System.out.println("------------------BUSCANDO TERREMOTO POR NÚMERO DE MUERTOS-------------------");
        System.out.println("");

        int muertos = 0;
        boolean existe = false;
        int posicion = 0;
        Terremoto temp;
        System.out.println("Ingrese el número de muertos del terremotos que desea encontrar: ");
        muertos = leer.nextInt();

        for (int i = 0; i < terremotos.size() && !existe; i++) {
            temp = (Terremoto) terremotos.get(i);
            if (muertos == temp.getNumero_muertos()) {
                existe = true;
                posicion = i;
            }
        }
        if (existe == true) {
            temp = (Terremoto) terremotos.get(posicion);
            System.out.println("Identificación del terremotos: " + temp.getIdentificacion());
            System.out.println("Nombre del terremotos: " + temp.getNombre_terremoto());
            System.out.println("Fecha de ocurrencia: " + temp.getFecha_ocurrencia());
            System.out.println("magnitud del terremotos: " + temp.getMagnitud_terremoto());
            System.out.println("Departamento de ocurrencia: " + temp.getDepartamento_ocurrencia());
            System.out.println("Número de muertos: " + temp.getNumero_muertos());

        } else
            System.out.println("El terremotos con " + muertos + " muertos no se encuentra registrado");

        System.out.println("");
        System.out.println("------------------FIN BÚSQUEDA-------------------");
        System.out.println("");
    }

    public void buscarTerremotoMenosMuertosBrayanGrimaldo()
    {
        System.out.println("");
        System.out.println("------------------BUSCAR TERREMOTO CON MENOR NÚMERO DE MUERTOS-------------------");

        Terremoto tempMenor = (Terremoto) terremotos.get(0);
        Terremoto terremotoMuertos;

        for (int i = 0; i < terremotos.size(); i++) {
            terremotoMuertos = (Terremoto) terremotos.get(i);
            if (tempMenor.getNumero_muertos() > terremotoMuertos.getNumero_muertos()) {
                tempMenor = terremotoMuertos;
            }
        }
        System.out.println("Identificación del terremotos: " + tempMenor.getIdentificacion());
        System.out.println("Nombre del terremotos: " + tempMenor.getNombre_terremoto());
        System.out.println("Fecha de ocurrencia: " + tempMenor.getFecha_ocurrencia());
        System.out.println("magnitud del terremotos: " + tempMenor.getMagnitud_terremoto());
        System.out.println("Departamento de ocurrencia: " + tempMenor.getDepartamento_ocurrencia());
        System.out.println("Número de muertos: " + tempMenor.getNumero_muertos());

        System.out.println("");
        System.out.println("------------------FIN BÚSQUEDA-------------------");
        System.out.println("");
    }

    public void buscarTerremotoMayorMagnitudBrayanGrimaldo()
    {
        System.out.println("------------------BUSCAR TERREMOTO DE MAYOR MAGNITUD-------------------");

        Terremoto tempMayor = (Terremoto) terremotos.get(0);
        Terremoto terremotoMagnitud;

        for (int i = 0; i < terremotos.size(); i++) {
            terremotoMagnitud = (Terremoto) terremotos.get(i);
            if (tempMayor.getMagnitud_terremoto() < terremotoMagnitud.getMagnitud_terremoto()) {
                tempMayor = terremotoMagnitud;
            }
        }
        System.out.println("Identificación del terremotos: " + tempMayor.getIdentificacion());
        System.out.println("Nombre del terremotos: " + tempMayor.getNombre_terremoto());
        System.out.println("Fecha de ocurrencia: " + tempMayor.getFecha_ocurrencia());
        System.out.println("magnitud del terremotos: " + tempMayor.getMagnitud_terremoto());
        System.out.println("Departamento de ocurrencia: " + tempMayor.getDepartamento_ocurrencia());
        System.out.println("Número de muertos: " + tempMayor.getNumero_muertos());

        System.out.println("");
        System.out.println("------------------FIN BÚSQUEDA-------------------");
        System.out.println("");
    }
}