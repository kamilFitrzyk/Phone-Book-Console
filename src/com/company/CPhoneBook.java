package com.company;

import java.io.*;
import java.util.Scanner;

public class CPhoneBook {

    protected CPerson[] phoneBook = new CPerson[CConfig.lengthTable]; // table of person

    protected static int n; // number people in CPerson[] (phoneBook)

    public CPhoneBook() {
        this.n = 0;
    }

    public void insertPerson() throws InterruptedException {

        CPerson p = new CPerson();
        CGetValueFromUser getValue = new CGetValueFromUser();

        System.out.flush();
        System.out.println(CConfig.newPerson);
        p.firstName = getValue.getStringFromConsole(CConfig.firstName);
        p.lastName = getValue.getStringFromConsole(CConfig.lastName);
        p.address = getValue.getStringFromConsole(CConfig.address);
        p.number = getValue.getStringFromConsole(CConfig.number);

        phoneBook[n] = p;
        n++;
    }


    public void showOneContact(int i) {
        System.out.println(i+1 + "\t " + phoneBook[i].firstName + "\t\t" + phoneBook[i].lastName +
                "\t\t" + phoneBook[i].address + "\t\t" + phoneBook[i].number);
    }

    public void modifyContactFirstName(String id, String newFirstName) {

        phoneBook[Integer.parseInt(id)-1].setFirstName(newFirstName);

    }

    public void modifyContactLastName(String id, String newLastName) {

        phoneBook[Integer.parseInt(id)-1].setLastName(newLastName);

    }

    public void modifyContactAddress(String id, String newAddress) {

        phoneBook[Integer.parseInt(id)-1].setAddress(newAddress);

    }

    public void modifyContactNumber(String id, String newnumber) {

        phoneBook[Integer.parseInt(id)-1].setFirstName(newnumber);

    }

    public void deletePerson(int id) {
        phoneBook[id] = new CPerson();
        n--;
        for( int i=id;i<n;i++) {
            phoneBook[i] = phoneBook[i+1];
        }
    }

    public int[] searchContacts(String search) {

        int start = 0;
        int counter = 0;

        while(start < n) {
            System.out.println(CConfig.titleHeader);
            if (phoneBook[start].firstName.contains(search) == true ||
                    phoneBook[start].lastName.contains(search) == true ||
                    phoneBook[start].address.contains(search) == true ||
                    phoneBook[start].number.contains(search) == true) {
                counter++;
                showOneContact(start);
            }
            start++;
        }
        if (counter == 0){
            System.out.println(CConfig.nothingFind);
        } else {
            System.out.println(CConfig.find(counter));
        }


        int ni[] = new int[6];

        return ni;

    }

    public void save(String filName) throws InterruptedException {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(filName+ ".txt"));
            for(int i=0;i<n;i++){
                bw.write(phoneBook[i].firstName + "&" + phoneBook[i].lastName + "&" + phoneBook[i].address + "&" + phoneBook[i].number +  "&\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load(String fileName) {

        phoneBook = new CPerson[CConfig.lengthTable];
        Scanner s = new Scanner(System.in);
        n=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader( fileName+ ".txt"));
            String line;
            int start = 0;
            int stop = 0;
            int counter=0;
            while((line = br.readLine()) != null) {
                System.out.println(s);
                phoneBook[n] = new CPerson();

                for (int i=1;i<line.length();i++) {

                    if(line.charAt(i) == '&') {
                        System.out.println(line.substring(start,stop));
                       switch (counter) {
                            case 0:
                                phoneBook[n].firstName = line.substring(start,stop);
                                counter++;
                                break;
                            case 1:
                                phoneBook[n].lastName = line.substring(start,stop);
                                counter++;
                                break;
                            case 2:
                                phoneBook[n].address = line.substring(start,stop);
                                counter++;
                                break;
                            case 3:
                                phoneBook[n].number = line.substring(start,stop);
                                counter++;
                                break;
                        }

                        start=i+1;
                    } else {
                        stop = i+1;
                    }

                }

                showOneContact(n);
                n++;
                start=0;
                stop=0;
                counter=0;
            }
            br.close();
        } catch(Exception e) {
            System.out.println(CConfig.fileNotExist);
            s.nextLine();
        }
    }
}
