import java.util.*;

import javax.xml.transform.Source;

class SLL {
    Node head;
    int counter = 0;

    class Node {
        int data;
        Node next;

        Node(int number) {
            this.data = number;
        }
    }

    void insert_At_Head(int number) {
        Node n = new Node(number);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
        counter++;
    }

    void insert_At_Last(int number) {
        Node n = head;
        Node newnumber = new Node(number);

        if (head == null) {
            head = n;
        } else {
            while (n.next != null) {
                n = n.next;
            }
            n.next = newnumber;
        }
        counter++;
    }

    void display() {
        Node n = head;
        if (head == null) {
            System.out.println("LinkedList is Empty");
        } else {
            while (n.next != null) {
                System.out.print(n.data + "---->");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    void count() {
        if (counter < 0) {
            System.out.println("Invalid Response");
        } else {
            System.out.println("Count of Nodes:" + counter);
        }
    }

    void insert_Before_Index(int number, int index) {
        Node n = head;
        Node newnumber = new Node(number);
        int innercount = 0;
        if (head == null && n == head && index == innercount + 1) {
            newnumber.next = head;
            head = newnumber;

        } else {
            while (innercount + 1 != index) {
                n = n.next;
                innercount++;
            }
            newnumber.next = n.next;
            n.next = newnumber;
            counter++;
        }
    }

    void insert_After_Index(int number, int index) {
        Node n = head;
        Node newnumber = new Node(number);
        int innercount = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (innercount != index) {
                n = n.next;
                innercount++;
            }
            newnumber.next = n.next;
            n.next = newnumber;
            counter++;
        }
    }

    void insert_Before_Value(int number, int value_Match) {
        Node dummy = head;
        Node n = new Node(number);

        if (head == null || (dummy == head && dummy.data == value_Match)) {
            if (head == null) {
                System.out.println("Linkedlist is empty");
            } else {
                n.next = head;
                head = n;
                counter++;
            }
        } else {
            while (dummy.next.data != value_Match) {
                dummy = dummy.next;
            }
            if (dummy.next == null) {
                System.out.println("No such value exist in the Linkedlist you want to insert before");
            } else {
                n.next = dummy.next;
                dummy.next = n;
                counter++;
            }
        }
    }

    void insert_After_Value(int number, int value_Match) {
        Node n = head;
        Node newnumber = new Node(number);
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (n.data != value_Match) {
                n = n.next;
            }
            newnumber.next = n.next;
            n.next = newnumber;
            counter++;
        }
    }

    void display_Rec(Node dummyHead) {
        if (dummyHead.next == null) {
            System.out.print(dummyHead.data + "--->");
            System.out.println("Empty");
        } else {
            System.out.print(dummyHead.data + "--->");
            display_Rec(dummyHead.next);
        }
    }

    void delete_At_Last() {
        Node dummy = head;
        while (dummy.next.next != null) {
            dummy = dummy.next;
        }
        dummy.next = null;
        counter--;
    }

    void delete_At_Head() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            head = head.next;
            counter--;
        }
    }

    void delete_Particular_Pos(int index) {
        Node n = head;
        int innerloop = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (index == 0) {
                head = n.next; // this is working with head but why is it not working if use n instead of head
            } else {
                while (innerloop + 1 != index) {
                    n = n.next;
                    innerloop++;
                }
                n.next = n.next.next;
            }
            counter--;
        }
    }

    void delete_Particular_Val(int value_Match) {
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (head.data == value_Match) {
                head = n.next;
            } else {
                while (n.next.data != value_Match) {
                    n = n.next;
                }
                n.next = n.next.next;
            }
            counter--;
        }
    }

    void even_Delete() {
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (n.next != null && n.next.next != null) { // Working for Odd no nodes but not for even
                n.next = n.next.next;
                n = n.next;
            }
            if (counter % 2 == 0) {
                n.next = null;
            }
        }
    }

    void odd_Delete() {
        // head-->33-->22-->11-->55-->empty
        // head-->empty
        // head-->33-->22-->empty
        // head-->33-->22-->11-->empty
        head = head.next;
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (n.next != null && n.next.next != null) { // Working for Odd no nodes but not for even
                n.next = n.next.next;
                n = n.next;
            }
            if (counter % 2 != 0) {
                n.next = null;
            }
        }
    }

    void insert_Sorted(int number) {
        Node n = new Node(number);
        Node dummNode = head;

        if (head == null) {
            head = n;
        } else {
            if (head.data > number) {
                n.next = head;
                head = n;
            } else {
                while ((number >= dummNode.data)) {
                    if (dummNode.next != null && number <= dummNode.next.data) {
                        n.next = dummNode.next;
                        dummNode.next = n;
                        break;
                    } else if (dummNode.next == null) {
                        dummNode.next = n;
                        break;
                    } else {
                        dummNode = dummNode.next;
                    }
                }
            }
        }
    }

    void count_Odd() {
        int oddNo;
        if (counter % 2 != 0) {
            oddNo = (counter + 1) / 2;
        } else {
            oddNo = counter;
        }
        System.out.println("Count of Odd Nodes:" + oddNo);
    }

    void count_Even() {
        int evenNo;
        evenNo = counter / 2;
        System.out.println("Count of Even Nodes:" + evenNo);
    }

    void display_Sum() {
        Node temp = head;
        int sum = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (temp.next != null) {
                sum += temp.data;
                temp = temp.next;
            }
            sum += temp.data;
            System.out.println("Sum of elements in the Linkedlist :" + sum);
        }
    }

    void display_Middle() {
        Node temp = head;
        int loop = 0;
        int innerloop = 0;
        if (counter % 2 == 0) {
            loop = counter / 2;
            while (loop != innerloop + 1) {
                temp = temp.next;
                innerloop++;
            }
            System.out.println("Middle Node element :" + temp.data + "," + temp.next.data);
        } else {
            loop = (counter + 1) / 2;
            while (loop != innerloop + 1) {
                temp = temp.next;
                innerloop++;
            }
            System.out.println("Middle Node element :" + temp.data);
        }
    }

    void empty_LL() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (head != null) {
                head = head.next;
            }
        }
    }

    void delete_Before_Index(int position) {
        Node temp = head;
        int innerloop = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (innerloop + 1 == position) {
                head = head.next;
            } else {
                while (innerloop + 2 != position) {
                    temp = temp.next;
                    innerloop++;
                }
                temp.next = temp.next.next;
            }
        }
    }

    void delete_After_Index(int position) {
        Node temp = head;
        int innerloop = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (innerloop == position) {
                head.next = head.next.next;
            } else {
                while (innerloop != position) {
                    temp = temp.next;
                    innerloop++;
                }
                temp.next = temp.next.next;
            }
        }
    }

    void delete_Before_Value(int value_Match) {
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (head.next.data == value_Match) {
                head = n.next;
            } else {
                while (n.next.next.data != value_Match) {
                    n = n.next;
                }
                n.next = n.next.next;
            }
            counter--;
        }
    }

    void delete_After_Value(int value_Match) {
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (head.data == value_Match) {
                head.next = n.next.next;
            } else {
                while (n.data != value_Match) {
                    n = n.next;
                }
                n.next = n.next.next;
            }
            counter--;
        }
    }

    void replace_Value(int value_Match, int value_instead) {
        Node n = head;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (head.data == value_Match) {
                head.data = value_instead;
            } else {
                while (n.next.data != value_Match) {
                    n = n.next;
                }
                n.next.data = value_instead;
            }
        }
    }

    void replace_IndexVal(int index, int value_instead) {
        Node n = head;
        int innerloop = 0;
        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            if (index == 0) {
                head.data = value_instead;
            } else {
                while (innerloop + 1 != index) {
                    n = n.next;
                    innerloop++;
                }
                n.next.data = value_instead;
            }
        }
    }

    void swap_Alt_Elements() {
        Node n = head;
        int temp_change;

        if (head == null) {
            System.out.println("Linkedlist is empty");
        } else {
            while (n != null && n.next != null) {
                if (head==n) {
                    temp_change = head.data;
                    head.data = head.next.data;
                    head.next.data = temp_change;
                    n = head.next.next;
                } else {
                    temp_change=n.data;
                    n.data=n.next.data;
                    n.next.data=temp_change;
                    n = n.next.next;
                }
            }
        }
    }

    void reverse_LL() {
        Node temp=head;
        Node extra;
        extra=head;

        if(head==null) {
            System.out.println("Linkedlist is empty");
        } else {
            while(temp.next!=null) {
                
                head=temp.next;
                temp.next=head.next;
                head.next=temp;

            }
        }
    }
}

class Process {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL s = new SLL();

        boolean b = true;
        while (b) {
            System.out.println("Choose from the following");
            System.out.println("Press 1: Inserting at head");
            System.out.println("Press 2: Inserting at last");
            System.out.println("Press 3: Inserting Before particular Index");
            System.out.println("Press 4: Inserting After particular Index");
            System.out.println("Press 5: Deleting odd Position Nodes");
            System.out.println("Press 6: Deleting even Position Nodes");
            System.out.println("Press 7: Inserting before particular value");
            System.out.println("Press 8: Inserting after particular value");
            System.out.println("Press 9: Insert in Sorted way(values)");
            System.out.println("Press 10: Delete at last");
            System.out.println("Press 11: Delete at head");
            System.out.println("Press 12: Delete Node having particular value");
            System.out.println("Press 13: Delete Node having particular position");
            System.out.println("Press 14: Display without using recursion");
            System.out.println("Press 15: Display using recursion");
            System.out.println("Press 16: Count of total nodes");
            System.out.println("Press 17: Count of total odd nodes");
            System.out.println("Press 18: Count of total even nodes");
            System.out.println("Press 19: Displaying the middle element");
            System.out.println("Press 20: Displaying the sum of all the elements in the Linkedlist");
            System.out.println("Press 21: Emptying the Linkedlist");
            System.out.println("Press 22: Delete Before particular index");
            System.out.println("Press 23: Delete after particular index");
            System.out.println("Press 24: Delete before particular value");
            System.out.println("Press 25: Delete after particular value");
            System.out.println("Press 26: Replacing the value at particular index");
            System.out.println("Press 27: Replacing the value at particular value");
            System.out.println("Press 28: Reversing the Linkedlist");
            System.out.println("Press 29: Swapping the atlernate elements in the Linkedlist");
            System.out.println("Press 30: Exit");
            int choice = sc.nextInt();

            int input, index;
            switch (choice) {
                case 1:
                    System.out.println("Please enter the number :");
                    input = sc.nextInt();
                    s.insert_At_Head(input);
                    break;

                case 2:
                    System.out.println("Please enter the number :");
                    input = sc.nextInt();
                    s.insert_At_Last(input);
                    break;

                case 3:
                    System.out.println("Please enter our values");
                    System.out.println("Enter the value you want to insert :");
                    input = sc.nextInt();
                    System.out.println("Enter the index you want to insert before :");
                    index = sc.nextInt();
                    s.insert_Before_Index(input, index);
                    break;

                case 4:
                    System.out.println("Please enter our values");
                    System.out.println("Enter the value you want to insert :");
                    input = sc.nextInt();
                    System.out.println("Enter the index you want to insert after :");
                    index = sc.nextInt();
                    s.insert_After_Index(input, index);
                    break;

                case 5:
                    System.out.println("Deleting the odd Position Nodes");
                    s.odd_Delete();
                    break;

                case 6:
                    System.out.println("Deleting the even Position Nodes");
                    s.even_Delete();
                    break;

                case 7:
                    System.out.println("Please enter our values");
                    System.out.println("Enter the value you want to insert :");
                    input = sc.nextInt();
                    System.out.println("Enter the value you want to insert after :");
                    index = sc.nextInt();
                    s.insert_Before_Value(input, index);
                    break;

                case 8:
                    System.out.println("Please enter our values");
                    System.out.println("Enter the value you want to insert :");
                    input = sc.nextInt();
                    System.out.println("Enter the value you want to insert after :");
                    index = sc.nextInt();
                    s.insert_After_Value(input, index);
                    break;

                case 9:
                    System.out.println("Enter the value you want to insert :");
                    input = sc.nextInt();
                    s.insert_Sorted(input);
                    break;

                case 10:
                    System.out.println("Deleting at last");
                    s.delete_At_Last();
                    break;

                case 11:
                    System.out.println("Deleting at head ");
                    s.delete_At_Head();
                    break;

                case 12:
                    System.out.println("Enter the value you want to remove");
                    input = sc.nextInt();
                    s.delete_Particular_Val(input);
                    break;

                case 13:
                    System.out.println("Enter the index you want to remove");
                    index = sc.nextInt();
                    s.delete_Particular_Pos(index);
                    break;

                case 14:
                    System.out.println("*LINKEDLIST*");
                    s.display();
                    break;

                case 15:
                    System.out.println("*LINKEDLIST WITH RECURSION*");
                    s.display_Rec(s.head);
                    break;

                case 16:
                    System.out.println("Displaying total of Nodes :");
                    s.count();
                    break;
                case 17:
                    System.out.println("Displaying total of Odd Nodes :");
                    s.count_Odd();
                    break;

                case 18:
                    System.out.println("Displaying total of Even Nodes :");
                    s.count_Even();
                    break;

                case 19:
                    System.out.println("Displaying Middle Nodes :");
                    s.display_Middle();
                    break;

                case 20:
                    System.out.println("Displaying sum of elements of Nodes :");
                    s.display_Sum();
                    break;

                case 21:
                    System.out.println("Emptying the Linkedlist :");
                    s.empty_LL();
                    break;

                case 22:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the index you want to delete before:");
                    index = sc.nextInt();
                    s.delete_Before_Index(index);
                    break;

                case 23:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the index you want to delete after:");
                    index = sc.nextInt();
                    s.delete_After_Index(index);
                    break;

                case 24:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the value you want to delete Before:");
                    input = sc.nextInt();
                    s.delete_Before_Value(input);
                    break;

                case 25:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the value you want to delete After:");
                    input = sc.nextInt();
                    s.delete_After_Value(input);
                    break;

                case 26:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the Index you want to replace:");
                    index = sc.nextInt();
                    System.out.println("Enter the value you want to replace with:");
                    int changevalue = sc.nextInt();
                    s.replace_IndexVal(index, changevalue);
                    break;

                case 27:
                    System.out.println("Enter the values for following:");
                    System.out.println("Enter the value you want to replace:");
                    input = sc.nextInt();
                    System.out.println("Enter the value you want to replace with:");
                    changevalue = sc.nextInt();
                    s.replace_Value(input, changevalue);
                    break;
                case 28:
                    System.out.println("Reversing the Linkedlist :");
                    s.reverse_LL();
                    break;

                case 29:
                    System.out.println("Swapping the elements:");
                    s.swap_Alt_Elements();
                    break;

                case 30:
                    System.out.println("Exited");
                    b = false;
                    break;

                default:
                    System.out.println("Invalid. Choose again");
            }
        }
    }
}

/*
 * if (head == null) {
 * head=n;
 * } else {
 * if (head.data<number && number< head.next.data) {
 * n.next= head.next;
 * head.next=n;
 * } else {
 * if (dummNode.next!=null) {
 * while (!(number > dummNode.data) && !(dummNode.next.data < number)) {
 * dummNode = dummNode.next;
 * }
 * n.next = dummNode.next;
 * dummNode = n;
 * } else {
 * dummNode.next=n;
 * }
 * }
 * }
 */