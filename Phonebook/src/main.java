import java.util.Scanner;
class DNode {
    public String number;
    public String gmail;
    public String name;
    public DNode prev;
    public DNode next;

    public DNode(String n, String r, String g) {
        name = n;
        number = r;
        gmail = g;
        next = null;
        prev = null;
    }
}

class DList {
    private DNode head;
    private DNode temp;
    private DNode ptr;
    private DNode ptr1;
    private DNode ptr2;
    private DNode dup;

    public DList() {
        head = null;
        temp = null;
        ptr = null;
        ptr1 = null;
        ptr2 = null;
        dup = null;
    }

    public void accept() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String number;
        String gmail;
        String name;
        char ans;
        do {
            System.out.print("ENTER NAME      :");
            name = scanner.nextLine();
            System.out.print("ENTER NUMBER    :");
            number = scanner.nextLine();
            while (number.length() != 10) {
                System.out.print("ENTER VALID NUMBER  :");
                number = scanner.nextLine();
            }
            System.out.print("ENTER G-MAIL    :");
            gmail = scanner.nextLine();
            temp = new DNode(name, number, gmail);
            if (head == null) {
                head = temp;
            } else {
                ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
                temp.prev = ptr;
            }
            System.out.print("DO YOU WANT TO CONTINUE [YES/NO] ?????????");
            ans = scanner.next().charAt(0);
            scanner.nextLine();
        } while (ans == 'y');
    }

    public void display() {
        ptr = head;
        while (ptr != null) {
            System.out.println("\n\nNAME  ::\t" + ptr.name);
            System.out.println("NUMBER::\t+91-" + ptr.number);
            System.out.println("G-MAIL::\t" + ptr.gmail);
            ptr = ptr.next;
        }
    }

    public void insert() {
        accept();
    }

    public void sort() {
        DNode i, j;
        String temp;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.name.compareTo(j.name) > 0) {
                    temp = i.name;
                    i.name = j.name;
                    j.name = temp;
                }
            }
        }
    }

    public void deleteContact(String s) {
        int c = 0;
        ptr = head;
        while (ptr != null) {
            if (s.equals(ptr.name)) {
                c = 1;
                break;
            } else {
                c = 2;
            }
            ptr = ptr.next;
        }
        if (c == 1 && ptr != head && ptr.next != null) {
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
            System.out.println("YOUR CONTACT IS SUCCESSFULLY DELETED\n\n");
        }
        if (ptr == head) {
            head = head.next;
            head.prev = null;
            System.out.println("YOUR CONTACT IS SUCCESSFULLY DELETED\n\n");
        }
        if (ptr.next == null) {
            ptr.prev.next = null;
            ptr.prev = null;
            System.out.println("YOUR CONTACT IS SUCCESSFULLY DELETED\n\n");
        }
        if (c == 2) {
            System.out.println("YOUR ENTERED NAME IS NOT IN THE LIST...");
        }
    }

    public void deleteSameName() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.name.equals(ptr2.next.name)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    dup = null;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteSameGmail() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.gmail.equals(ptr2.next.gmail)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    dup = null;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteSameNumber() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.number.equals(ptr2.next.number)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    dup = null;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void searchByName(String na) {
        ptr = head;
        while (ptr != null) {
            if (na.equals(ptr.name)) {
                System.out.println("NAME FOUND");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
            }
            ptr = ptr.next;
        }
    }

    public void searchByNumber(String num) {
        ptr = head;
        while (ptr != null) {
            if (num.equals(ptr.number)) {
                System.out.println("NUMBER FOUND\n");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
            }
            ptr = ptr.next;
        }
    }

    public void searchByGmail(String gm) {
        ptr = head;
        while (ptr != null) {
            if (gm.equals(ptr.gmail)) {
                System.out.println("G-MAIL FOUND\n");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
            }
            ptr = ptr.next;
        }
    }

    public void update(String n) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        char ans;
        int c;
        ptr = head;
        while (ptr != null) {
            if (n.equals(ptr.name)) {
                do {
                    System.out.println("\nWHAT DO YOU WANT TO UPDATE?\n1.NAME\n2.PHONE NUMBER\n3.G-MAIL\n");
                    c = scanner.nextInt();
                    scanner.nextLine();
                    switch (c) {
                        case 1:
                            System.out.print("ENTER NEW-NAME=");
                            ptr.name = scanner.nextLine();
                            break;
                        case 2:
                            System.out.print("ENTER NEW PHONE-NUMBER?");
                            ptr.number = scanner.nextLine();
                            while (ptr.number.length() != 10) {
                                System.out.print("ENTER VALID NUMBER  :");
                                ptr.number = scanner.nextLine();
                            }
                            break;
                        case 3:
                            System.out.print("ENTER NEW G-MAIL");
                            ptr.gmail = scanner.nextLine();
                            break;
                    }
                    System.out.print("DO YOU WANT TO CONTINUE UPDATING?");
                    ans = scanner.next().charAt(0);
                    scanner.nextLine();
                } while (ans == 'y');
            }
            ptr = ptr.next;
        }
    }
}

public class main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String n;
        String nam;
        String name;
        String number;
        String gmail;
        DList d1 = new DList();
        char ans;
        int ch, a;
        System.out.println("**************                                PHONE BOOK                          ********************");
        System.out.println("\n\nWHAT IS YOUR NAME?\n");
        name = scanner.nextLine();
        System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!   WELCOME " + name + "   !!!!!!!!!!!!!!!!!!!!!");
        System.out.println("\n\n\nLET'S CREATE OUR PHONEBOOK " + name + "  \n\n");
        d1.accept();
        d1.sort();
        do {
            System.out.println("\n\n\n\n1) DISPLAY YOUR PHONE BOOK\n2) INSERT NEW CONTACT\n3) UPDATE DETAILS ON EXISTING CONTACT\n4) DELETE CONTACT\n5) DELETE SAME NAME IN PHONEBOOK\n6) DELETE SAME NUMBERS IN PHONEBOOK\n7) SEARCH\n");
            ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 2:
                    d1.insert();
                    d1.sort();
                    break;

                case 1:
                    d1.display();
                    break;
                case 3:
                    System.out.println("\n\nENTER THE NAME OF PERSON WHOSE DETAILS YOU WANT TO UPDATE...\n");
                    n = scanner.nextLine();
                    d1.update(n);
                    d1.sort();
                    break;
                case 4:
                    System.out.println("\nENTER THE NAME YOU WANT TO DELETE FROM PHONEBOOK\n");
                    name = scanner.nextLine();
                    d1.deleteContact(name);
                    break;
                case 5:
                    d1.deleteSameName();
                    d1.display();
                    break;
                case 6:
                    d1.deleteSameNumber();
                    d1.display();
                    break;
                case 7:
                    do {
                        System.out.println("1.SEARCH BY NAME\n2.SEARCH BY NUMBER\n3.SEARCH BY GMAIL");
                        a = scanner.nextInt();
                        scanner.nextLine();
                        switch (a) {
                            case 1:
                                System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                name = scanner.nextLine();
                                d1.searchByName(name);
                                break;
                            case 2:
                                System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                number = scanner.nextLine();
                                d1.searchByNumber(number);
                                break;
                            case 3:
                                System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                gmail = scanner.nextLine();
                                d1.searchByGmail(gmail);
                                break;
                            default:
                                System.out.println("\nNO PROPER INPUT GIVEN.....\n");
                        }
                        System.out.println("DO YOU WANT TO CONTINUE SEARCHING?????????");
                        ans = scanner.next().charAt(0);
                        scanner.nextLine();
                    } while (ans == 'y');

                    break;
                case 8:
                    d1.deleteSameGmail();
                    d1.display();
                    break;
                default:
                    System.out.println("\nNO PROPER INPUT GIVEN..\n");
            }
            System.out.println("\n\nDO YOU WANT TO CONTINUE OPERATIONS?????????");
            ans = scanner.next().charAt(0);
            scanner.nextLine();
        } while (ans == 'y');
    }
}


