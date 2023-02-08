package com.mycompany.supermarket;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class supermarket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        String Usuario = sc.nextLine();
        System.out.println("Ingrese la contraseña");
        String Contraseña = sc.nextLine();

        if (Usuario.equals("s") && Contraseña.equals("p")) { //Condicional por si los 2 datos son correctos ejecutar el menú.
            System.out.println("--BIENVENIDO AL SISTEMA--");
            menuSuper();
            //Llamando al método del menú.
        } //Llave del if
        while (!"s".equals(Usuario) || !"p".equals(Contraseña)) { //While por si el primer if no cumple con la condición, osea que la contraseña o el usuario son incorrectos.
            System.out.println("NOMBRE DE USUARIO O CONTRASEÑA INCORRECTOS, INTENTELO NUEVAMENTE.");
            System.out.println("Ingrese su nombre de usuario");
            Usuario = sc.nextLine();
            System.out.println("Ingrese la contraseña");
            Contraseña = sc.nextLine();
            if (Usuario.equals("s") && Contraseña.equals("p")) { //Otro if para que si se equivoca pueda seguir entrando.
                System.out.println("--BIENVENIDO AL SISTEMA--");
                menuSuper(); //Lamando al método del menú.
            }
        }

    } //Llave del main

    public static void menuSuper() { //Método para llamar al menú.
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner menuSuper = new Scanner(System.in);
        Scanner prod = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        String[] nombre = new String[20];
        String nombrecajero = "Luis Corleto";
        int[] nombre2 = new int[20];
        double[] totales = new double[20];
        String nombrecliente = null;
        double[] precio = new double[20];
        String[] cupdescuento = new String[50];
        double[] descuento = new double[50];
        int[] cantidad = new int[10000];
        double[] precios = new double[10000];
        double suma = 0;
        double pordescuento;
        double desc = 0;
        String cupondescuento;
        boolean salir = false;
        boolean aux3 = true;
        boolean aux2 = true;
        boolean aux4 = true;
        int aux = 0;
        int noproductos = 0;
        int contadordescuentos = 0;
        int contadorcompras = 0;
        int opcionmenu = 0;
        int salir2 = 0;
        int salir1 = 0;
        int salir3 = 0;
        int nit = 0;
        int cant = 0;
        double total = 0;
        int contador2 = 0;
        int contador3 = 0;
        int contador4 = 0;
        int contador5 = 0;
        int contador6 = 0;
        int cup = 0;
        int aplidesc = 0;
        int asa = 0;
        int cont1 = 0;
        String nuevonit;

        while (!salir) {
            System.out.println("[1]. Agregar productos."); //Menú de opciones
            System.out.println("[2]. Agregar cupón de descuento.");
            System.out.println("[3]. Realizar ventas.");
            System.out.println("[4]. Emitir factura.");
            System.out.println("[5]. Salir.");

            System.out.println("Ingrese el numero de la opción que quiera realizar:");
            opcionmenu = menuSuper.nextInt();
            //menuDos(opcionmenu);
            switch (opcionmenu) {
                case 1: //Primer opción.

                    System.out.println("---USTED SE ENCUENTRA EN EL MENU -AGREGAR PRODUCTOS-.---");

                    do /*(aux2)*/ { //Ciclo para agregar productos.
                        System.out.println("Ingrese el nombre del producto");
                        String nombreproducto = prod.next();
                        System.out.println("Ingrese el precio del producto");
                        double precioproducto = prod.nextDouble();

                        if (precioproducto > 0) { //Validar si el precio es mayor a 0
                            for (int i = aux; i < 20; i++) { //Primer ciclo para llenar los arrays
                                nombre[i] = nombreproducto; //Igualar las variables
                                precio[i] = precioproducto;
                                break;
                            }
                        } else {
                            System.out.println("El producto debe ser mayor a 0");
                            continue;
                        }
                        for (int i = 0; i < 20; i++) {
                            if (nombre[i] != null) {
                                System.out.println("[" + i + "]." + "Producto: " + nombre[i] + " - " + "Precio: Q." + precio[i]);
                            }
                        }
                        aux += 1;
                        System.out.println("Desea agregar otro producto?");
                        System.out.println("[1]. Si");
                        System.out.println("[2]. No");
                        salir1 = sn.nextInt();
//                        if (salir1 != 1) {
//                            aux2 = false;
//                        }
                    } while (salir1 == 1);
                    continue;
                case 2:

                    System.out.println("---USTED SE ENCUENTRA EN EL MENU -AGREGAR CUPON DE DESCUENTO-.---");
                    do /*(aux3)*/ {
                        System.out.println("Ingrese el cupon de descuento");
                        cupondescuento = menuSuper.next();
                        System.out.println("Ingrese el porcentaje de descuento");
                        pordescuento = menuSuper.nextInt();
                        if (pordescuento > 0 && pordescuento < 100) {
                            for (int i = contadordescuentos; i < 50; i++) {
                                cupdescuento[i] = cupondescuento;
                                descuento[i] = pordescuento;
                                break;
                            }
                        } else {
                            System.out.println("El porcentaje de descuento debe ser mayor a 0 y menor a 100");
                            continue;
                        }
                        if (cupondescuento.length() > 4) {
                            System.out.println("El codigo solo puede tener 4 caracteres");
                            continue;
                        }
                        for (int i = 0; i < 50; i++) {
                            if (cupdescuento[i] != null) {
                                System.out.println("[" + i + ".]" + cupdescuento[i] + "-" + descuento[i] + "%");
                            }
                        }
                        contadordescuentos += 1;
                        System.out.println("Desea agregar otro cupon de descuento?");
                        System.out.println("[1]. Si");
                        System.out.println("[2]. No");
                        salir2 = menuSuper.nextInt();
//                        if (salir2 != 1) {
//                            aux3 = false;
//                        }
                    } while (salir2 == 1);
                    continue;
                case 3:

                    System.out.println("---USTED SE ENCUENTRA EN EL MENU -REALIZAR VENTAS-.---");
                    System.out.println("Ingrese su nombre:");
                    nombrecliente = menuSuper.next();
                    System.out.println("Ingrese su nit o coloque un 0 si no tiene");
                    nit = menuSuper.nextInt();
//                    if (nit == 0) {
//                        String CF = String.valueOf(nit);
//                    }
                    do/*(aux4)*/ {
                        System.out.println("Esta es la lista de productos que puede comprar");
                        for (int i = 0; i < 20; i++) {
                            if (nombre[i] != null) {
                                System.out.println("[" + i + "]" + "Producto: " + nombre[i] + " - " + "Precio: Q." + precio[i]);
                            }
                        }
                        System.out.println("Seleccione el numero del producto que quiere comprar");
                        noproductos = menuSuper.nextInt();
//                        for (int i = noproductos; i < 20; i++) {
//                            noproductos = noproductos;
//                            nombre2[i] = menuSuper.nextInt();
//                            break;
//                        }
                        System.out.println("Seleccione la cantidad que quiera comprar");
                        cant = menuSuper.nextInt();
                        for (int i = noproductos; i < 10000; i++) {
                            totales[i] = total;
                            cantidad[i] = cant;
                            nombre2[i] = noproductos;
                            //if (noproductos == i) {
                            if (nombre2[i] == 0) {
                                System.out.println("Producto seleccionado: " + nombre[0]);
                                totales[0] = precio[0] * cantidad[i];
                            }
                            if (nombre2[i] == 1) {
                                System.out.println("Producto seleccionado: " + nombre[1]);
                                totales[1] = precio[1] * cantidad[i];
                            }
                            if (nombre2[i] == 2) {
                                System.out.println("Producto seleccionado: " + nombre[2]);
                                totales[2] = precio[2] * cantidad[i];
                            }
                            if (noproductos == 3) {
                                System.out.println("Producto seleccionado: " + nombre[3]);
                                totales[3] = precio[3] * cantidad[i];
                            }
                            if (noproductos == 4) {
                                System.out.println("Producto seleccionado: " + nombre[4]);
                                totales[4] = precio[4] * cantidad[i];
                            }
                            if (noproductos == 5) {
                                System.out.println("Producto seleccionado: " + nombre[5]);
                                totales[5] = precio[5] * cantidad[i];
                            }
                            if (noproductos == 6) {
                                System.out.println("Producto seleccionado: " + nombre[6]);
                                totales[6] = precio[6] * cantidad[i];
                            }
                            if (noproductos == 7) {
                                System.out.println("Producto seleccionado: " + nombre[7]);
                                totales[7] = precio[7] * cantidad[7];
                            }
                            if (noproductos == 8) {
                                System.out.println("Producto seleccionado: " + nombre[8]);
                                totales[8] = precio[8] * cantidad[i];
                            }
                            if (noproductos == 9) {
                                System.out.println("Producto seleccionado: " + nombre[9]);
                                totales[9] = precio[9] * cantidad[i];
                            }
                            if (noproductos == 10) {
                                System.out.println("Producto seleccionado: " + nombre[10]);
                                totales[10] = precio[10] * cantidad[i];
                            }
                            if (noproductos == 11) {
                                System.out.println("Producto seleccionado: " + nombre[11]);
                                totales[11] = precio[11] * cantidad[i];
                            }
                            if (noproductos == 12) {
                                System.out.println("Producto seleccionado: " + nombre[12]);
                                totales[12] = precio[12] * cantidad[i];
                            }
                            if (noproductos == 13) {
                                System.out.println("Producto seleccionado: " + nombre[13]);
                                totales[13] = precio[13] * cantidad[i];
                            }
                            if (noproductos == 14) {
                                System.out.println("Producto seleccionado: " + nombre[14]);
                                totales[14] = precio[14] * cantidad[i];
                            }
                            if (noproductos == 15) {
                                System.out.println("Producto seleccionado: " + nombre[15]);
                                totales[15] = precio[15] * cantidad[i];
                            }
                            if (noproductos == 16) {
                                System.out.println("Producto seleccionado: " + nombre[16]);
                                totales[16] = precio[16] * cantidad[i];
                            }
                            if (noproductos == 17) {
                                System.out.println("Producto seleccionado: " + nombre[17]);
                                totales[17] = precio[17] * cantidad[i];
                            }
                            if (noproductos == 18) {
                                System.out.println("Producto seleccionado: " + nombre[18]);
                                totales[18] = precio[18] * cantidad[i];
                            }
                            if (noproductos == 19) {
                                System.out.println("Producto seleccionado: " + nombre[19]);
                                totales[19] = precio[19] * cantidad[i];
                            }
                            if (noproductos == 20) {
                                System.out.println("Producto seleccionado: " + nombre[20]);
                                totales[20] = precio[20] * cantidad[i];
                            }

                            //System.out.println("Producto seleccionado: " + nombre[i]);
                            //totales[i] = precio[i] * cantidad[i];
                            suma += totales[i];
                            //System.out.println("El total de la compra individual es: " + totales[i]);
                            //}
                            break;
                        }
                        noproductos += 1;
                        System.out.println("EL TOTAL DE LA COMPRA ES: " + suma);
                        System.out.println("____________________________");
                        System.out.println("Desea comprar otro producto?");
                        System.out.println("[1]. Si");
                        System.out.println("[2]. No");
                        salir3 = menuSuper.nextInt();
//                        if (salir3 != 1) {
//                            aux4 = false;
//                        }
                    } while (salir3 == 1);
                    System.out.println("Desea aplicar un código de descuento a sus compras?");
                    System.out.println("[1]. Si");
                    System.out.println("[2]. No");
                    aplidesc = menuSuper.nextInt();
                    if (aplidesc == 1) {
                        System.out.println("Usted ingresó estos códigos de descuento anteriormente, puede aplicar 1 de ellos para la compra de sus productos");
                        for (int i = 0; i < 50; i++) {
                            if (cupdescuento[i] != null) {
                                System.out.println("[" + i + "]." + cupdescuento[i] + "-" + descuento[i] + "%");
                            }
                        }
                        System.out.println("Seleccione el número del cupón");
                        cup = menuSuper.nextInt();
                        for (int i = contador3; i < 50; i++) {
                            if (cup == i) {
                                System.out.println("Cupon seleccioando: " + cupdescuento[i]);
                                System.out.println("Descuento a realizar: " + descuento[i] + "%");
                                desc = suma - (suma * (descuento[i] / 100));
                            }
                        }
                    }
                    continue;

                case 4:
                    System.out.println("---USTED SE ENCUENTRA EN EL MENU -EMITIR FACTURA-.---");
                    System.out.println("------------------------------------------------------");
                    System.out.println("-----------------------SUPER-25-----------------------");
                    System.out.println("Atendido por: " + nombrecajero);
                    System.out.println("Nombre: " + nombrecliente);
                    if (nit == 0) {
                        System.out.println("Numero de NIT: C/F");
                    } else {
                        System.out.println("Numero de NIT: " + nit);
                    }
                    System.out.println("Fecha: " + fechaActual.format(formatter));
                    do {
                        for (int i = cont1; i < 20; i++) {
                            if (nombre2[i] == i) {
                                System.out.println("Producto: " + nombre[i]);
                                System.out.println("Precio: " + precio[i]);
                                System.out.println("Cantidad: " + cantidad[i]);
                            }
                        }
                    } while (cont1 > 20);
                    cont1 += 1;
                    if (cup == 1) {
                        System.out.println("Descuento del: " + descuento + "%");
                        System.out.println("TOTAL: " + desc);
                    } else {
                        System.out.println("Sin descuento");
                        System.out.println("TOTAL: " + suma);
                    }
                    continue;
                case 5:
                    System.out.println("--SALIENDO...---");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente");
                    continue;
            }//LLave del switch.
            break;
        }//Llave del while.

    }//Clase principal supermarket.

    public static void listaProductos() {

    }

//    static void menuDos(int opcionmenu) {
//        String[] nombre = new String[20];
//        double[] precio = new double[20];
//        int aux = 0;
//        switch (opcionmenu) {
//            case 1: //Primer opción.
//                Scanner prod = new Scanner(System.in);
//                Scanner sn = new Scanner(System.in);
//                int salir1 = 0;
//                System.out.println("---USTED SE ENCUENTRA EN EL MENU -AGREGAR PRODUCTOS-.---");
//
//                do { //Ciclo para agregar productos.
//                    System.out.println("Ingrese el nombre del producto");
//                    String nombreproducto = prod.next();
//                    System.out.println("Ingrese el precio del producto");
//                    double precioproducto = prod.nextDouble();
//
//                    if (precioproducto > 0) {
//                        for (int i = aux; i < 20; i++) {
//                            nombre[i] = nombreproducto;
//                            precio[i] = precioproducto;
//                            break;
//                        } //Llave del for
//
//                    }
//                    for (int i = 0; i < 20; i++) {
//                        if (nombre[i] != null) {
//                            System.out.println("Producto: " + nombre[i] + "Precio: Q." + precio[i]);
//                        }
//                    }
//                    aux += 1;
//                    System.out.println("Desea agregar otro producto?");
//                    System.out.println("[1]. Si");
//                    System.out.println("[2]. No");
//                    salir1 = sn.nextInt();
//                } while (salir1 == 1);
//                break;
//            case 2:
//                System.out.println("---USTED SE ENCUENTRA EN EL MENU -AGREGAR CUPON DE DESCUENTO-.---");
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            default:
//                System.out.println("Opcion no valida, intente nuevamente");
//                break;
//        }
//
//    }
}

//                            if (noproductos == 1) {
//                                System.out.println("Producto seleccionado: " + nombre[1]);
//                                System.out.println("El precio del producto es: " + precio[0]);
//                                totales[i] = precio[1] * cantidad[i];
//                            }
//                        for (int i = 0; i < 20; i++) {
//                            if (nombre[i] != null) {
//                                contador2 += 1;
//                                suma += totales[i];
//                                System.out.println("--ESTOS SON LOS PRODUCTOS DE SU COMPRA:--");
//                                System.out.println("[" + i + "]" + nombre[i] + "-" + "Cantidad: " + cantidad[i] + "-Total: " + suma);
//                            }
//                        }
// System.out.println("El precio del producto es: " + precio[i]);
//for (int i = contador4; i < 20; i++) {
//                        System.out.println("Producto: " + nombre[i]);
//
//                        continue;
//                    }
//                    contador4 += 1;
//                    for (int i = contador5; i < 20; i++) {
//                        System.out.println("Precio unitario: " + precio[i]);
//
//                        break;
//                    }
//                    contador5 += 1;
//                    for (int i = contador6; i < 20; i++) {
//                        System.out.println("Cantidad comprada: " + cantidad[i]);
//
//                        break;
//                    }
//                    contador6 += 1;
//                    System.out.println("Total de la compra: " + suma);
//                    System.out.println("Subtotal: " + suma);
//                    for (int i = 0; i < 20; i++) {
//                        System.out.println("Porcentaje de descuento: " + descuento[i]);
//                        break;
//                    }
//for (int i = noproductos; i < 20; i++) {
//                        if (noproductos==i){
//                            System.out.println("Producto: " + nombre[i]);
//                        }
//                        break;
//                    }
//for (int i = 0; i < 20; i++) {
//                        if (noproductos == i) {
//                            System.out.println("Producto: " + nombre[i]);
//                        }
//                    }
//for (int i = 0; i < 20; i++) {
//                        if (noproductos == i) {
//                            System.out.println("Producto: " + nombre[i]);
//                            System.out.println("Precio: " + precio[i]);
//                        }
//                        break;
//                    }
