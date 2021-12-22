package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        CPhoneBook pb = new CPhoneBook();
        Scanner s = new Scanner(System.in);
        CGetValueFromUser getValue = new CGetValueFromUser();


        do {
           System.out.flush();
           System.out.print(CConfig.menuContext + '\n');

           CConfig.selectedOptions = getValue.getIntFromConsole(CConfig.chooseNumber);

           switch(CConfig.selectedOptions) {
               case 1:
                   pb.showContacts();
                   s.nextLine();
                   break;
               case 2:
                    pb.insertPerson();
                   break;
               case 3:

                   do {
                       CConfig.modifySelectedId = getValue.getIntFromConsole(CConfig.giveMeId);
                   } while (CConfig.modifySelectedId < 0);

                   if(CConfig.modifySelectedId == 0 ) break;

                    do {
                        pb.showOneContact(CConfig.modifySelectedId-1);
                        System.out.println(CConfig.menuModify);

                        CConfig.modifySelectedOptions = getValue.getIntFromConsole(CConfig.chooseNumber);

                        switch(CConfig.modifySelectedOptions) {
                            case 1:
                                String newName = getValue.getStringFromConsole(CConfig.newFirstName);
                                pb.modifyContactFirstName(Integer.toString(CConfig.modifySelectedId),newName);

                                break;
                            case 2:
                                String newLastName = getValue.getStringFromConsole(CConfig.newLastName);
                                pb.modifyContactLastName(Integer.toString(CConfig.modifySelectedId),newLastName);

                                break;
                            case 3:
                                String newAddress = getValue.getStringFromConsole(CConfig.newAddress);
                                pb.modifyContactAddress(Integer.toString(CConfig.modifySelectedId),newAddress);
                                break;
                            case 4:
                                String newNumber = getValue.getStringFromConsole(CConfig.newNumber);
                                pb.modifyContactNumber(Integer.toString(CConfig.modifySelectedId),newNumber);
                                break;
                            case 0:
                                CConfig.modifySelectedOptions = 0;
                            default:
                                break;
                        }

                    }while (CConfig.modifySelectedOptions != 0);

                   break;
               case 4:
                   int idPerson = getValue.getIntFromConsole(CConfig.idToDelete);
                   if (idPerson != 0) pb.deletePerson(idPerson-1);
                   System.out.println(CConfig.deletePerson(idPerson));
                   s.nextLine();
                   break;
               case 5:
                    String search = getValue.getStringFromConsole(CConfig.whatDoYouSearch);
                    if (search != "0") {
                        pb.searchContacts(search);
                        s.nextLine();
                    }
                   break;
               case 6:
                   String filName = getValue.getStringFromConsole(CConfig.fileName);
                   pb.save(filName);
                   s.nextLine();
                   break;
               case 7:
                   String fileName = getValue.getStringFromConsole(CConfig.fileName);
                   pb.load(fileName);
                   s.nextLine();
                   break;
               case 8:
                   System.out.println("Kamil Fitrzyk 2021");
                   s.nextLine();
                   break;
               default:
                   break;
           }

       } while (CConfig.selectedOptions != 0);

       s.close();


    }
}
