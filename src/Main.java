import Controller.ItemController;
import Repository.Repository;
import basic.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {/*
        Registration r = new Registration();
        r.displaySoldiers();

        r.generalSoldierList.add(new Soldier("Alex",1,Rang.Private));
        r.generalSoldierList.add(new Soldier("Bob",2,Rang.Officer));
        r.generalSoldierList.add(new Soldier("Martin",3,Rang.Private));
        r.generalSoldierList.add(new Soldier("Greg",4,Rang.General));

        Scanner in = new Scanner(System.in);
        System.out.println("Delete id:");
        int id = in.nextInt();
        r.deleteSoldier(id);
        r.displaySoldiers();*/
        ItemController itemController = new ItemController();
        Weapon weapon = new Weapon("AK-74", (float) 7.62,1);
        Armor armor = new Armor("Heavy","Heavy",2);
        Vehicle vehicle = new Vehicle("Humvee",3,new ArrayList<Soldier>());

        itemController.add(weapon);
        itemController.add(armor);
        itemController.add(vehicle);
        System.out.println("1.Update Weapon\n2.Update Armor\n3.Update Vehicle");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice == 1){
            System.out.println("Enter id: ");
            int id = in.nextInt();
            System.out.println("New name: ");
            String name = in.next();
            System.out.println("New calibre: ");
            double calibre = in.nextDouble();
            itemController.updateWeapon(name,calibre,id);
            itemController.display();
        }
        load_basic_data("data.txt");
    }

    public static void load_basic_data(String filepath) throws FileNotFoundException {
        File memory = new File(filepath);
        if(memory.canRead()) {
            System.out.println(memory);
            Scanner memoscan=new Scanner(memory);
            System.out.println(memoscan.nextLine());
        }

    }
    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.print("1.Register Soldier\n");
        System.out.print("Name:\nId:");
        String name = input.next();
        int id = input.nextInt();
        Soldier newSoldier= new Soldier(name,id,Rang.Private);
        Registration r = new Registration();
        System.out.println("Update existing Soldier");
        System.out.println("Id of Soldier: ");
        id = input.nextInt();
        System.out.println("Name for Soldier: ");
        name = input.next();
        System.out.println("Rang for Soldier: ");
        System.out.println("Available rangs are: \n1."+Rang.Officer+"\n2."+Rang.General+"\n3."+Rang.Private);
        Rang rang;
        if(input.nextInt()==1){
            rang = Rang.Officer;
        } else if (input.nextInt()==2) {
            rang = Rang.General;

        }
        else {rang = Rang.Private;}
        input.close();
//        r.updateSoldier(id,name,rang);
//        r.addSoldier(newSoldier);
        r.displaySoldiers();

    }
}