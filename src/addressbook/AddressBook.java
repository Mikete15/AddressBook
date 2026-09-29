package addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    private HashMap<String, String> contacts;

    public AddressBook() {
        contacts = new HashMap<>();
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 2) {
                    contacts.put(data[0], data[1]);
                }
            }

        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de contactos.");
        }
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contacts.csv"))) {

            for (Map.Entry<String, String> contact : contacts.entrySet()) {
                writer.println(contact.getKey() + "," + contact.getValue());
            }

        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de contactos.");
        }
    }

    public void list() {
        System.out.println("\nContactos:");

        if (contacts.isEmpty()) {
            System.out.println("No hay contactos guardados.");
            return;
        }

        for (Map.Entry<String, String> contact : contacts.entrySet()) {
            System.out.println(contact.getKey() + " : " + contact.getValue());
        }
    }

    public void create(Scanner scanner) {
        System.out.print("Escribe el número telefónico: ");
        String number = scanner.nextLine();

        System.out.print("Escribe el nombre del contacto: ");
        String name = scanner.nextLine();

        contacts.put(number, name);

        save();

        System.out.println("Contacto guardado correctamente.");
    }

    public void delete(Scanner scanner) {
        System.out.print("Escribe el número telefónico que deseas eliminar: ");
        String number = scanner.nextLine();

        if (contacts.containsKey(number)) {
            contacts.remove(number);

            save();

            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró un contacto con ese número.");
        }
    }
}