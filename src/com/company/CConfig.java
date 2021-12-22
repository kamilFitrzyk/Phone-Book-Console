package com.company;

public class CConfig {

    public static final String OK = " OK";
    public static int lengthTable = 100;

    public static int selectedOptions=13;
    public static int modifySelectedOptions=13;
    public static int modifySelectedId;
    public static int searchedId = 0;

    public static final String menuContext =
           " PHONE BOOK \n"+
           " (1) Show contacts \n"+
           " (2) Add contact \n"+
           " (3) Modify contact \n"+
           " (4) Delete contact \n"+
           " (5) Search contact \n"+
           " (6) Save \n"+
           " (7) Load \n"+
           " (8) Info \n"+
           " (0) Exit";

    public static final String newPerson = "Add new person:";

    public static final String firstName = " First name: ";
    public static final String lastName = " Last name: ";
    public static final String address = " Address: ";
    public static final String number = " Number: ";

    public static final String menuModify =
           " MODIFY MENU \n"+
           " (1) Modify first name \n"+
           " (2) Modify last name \n"+
           " (3) Modify address\n"+
           " (4) Modify number\n"+
           " (0) Cancel";

    public static final String newFirstName = " New first name: ";
    public static final String newLastName = " New last name: ";
    public static final String newAddress = " New address: ";
    public static final String newNumber = " New number: ";

    public static final String whatDoYouSearch = " What do you search, (0) - cancel: ";

    public static final String badValue = "Bad value";
    public static final String chooseNumber = "Choose option:";


    public static final String giveMeId = "Set id to modify, 0 - back";

    public static final String idToDelete = "Id to delete, 0 - cancel";

    public static String nothingFind = "Nothing search";
    public static String fileName = "File name:";

    public static String fileNotExist = "File not exist";
    public static String header = "ID\tFirst name  Last name   Address                  Number";

    public static String find(int counter) {
        return "Find " + counter + " row";
    }

    public static String deletePerson(int id) {
        return "Delete person with " + id;
    }
}
