package addressbook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        addressBook.load();

        int option;

        do {
            System.out.println("\nAGENDA TELEFÓNICA");
            System.out.println("1. Mostrar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {

                case 1:
                    addressBook.list();
                    break;

                case 2:
                    addressBook.create(scanner);
                    break;

                case 3:
                    addressBook.delete(scanner);
                    break;

                case 4:
                    addressBook.save();
                    System.out.println("Agenda guardada. Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (option != 4);

        scanner.close();
    }
}

