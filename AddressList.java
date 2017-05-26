/**
 * This class contains all of the method to manipulate ListNodes to create a linked list.
 */
public class AddressList
{
    /**
     * The AddressList instance variables.
     */
    private ListNode head, currentNode;
    /**
     * The AddressList constructor.
     */
    public AddressList()
    {
        head = null;
        currentNode = head;
    }
    /**
     * This inner class contains all of the methods to get and set data.
     */
    private class ListNode
    {
        /**
         * The ListNode instance variables.
         */
        private String name, telephoneNumber, email, address, dateOfBirth;
        private ListNode next;
        /**
         * The ListNode constructor.
         * @param newName
         * @param newTelephoneNumber
         * @param newEmail
         * @param newAddress
         * @param newDateOfBirth
         */
        private ListNode(String newName, String newTelephoneNumber, String newEmail, String newAddress,
                         String newDateOfBirth)
        {
            name = newName;
            telephoneNumber = newTelephoneNumber;
            email = newEmail;
            address = newAddress;
            dateOfBirth = newDateOfBirth;
        }
        /**
         * The ListNode getter methods.
         */
        public String getName()
        {
            return name;
        }
        public String getTelephoneNumber()
        {
            return telephoneNumber;
        }
        public String getEmail()
        {
            return email;
        }
        public String getAddress()
        {
            return address;
        }
        public String getDateOfBirth()
        {
            return dateOfBirth;
        }
        /**
         * The ListNode setter methods.
         */
        public void setName(String newName)
        {
            name = newName;
        }
        public void setTelephoneNumber(String newTelephoneNumber)
        {
            telephoneNumber = newTelephoneNumber;
        }
        public void setEmail(String newEmail)
        {
            email = newEmail;
        }
        public void setAddress(String newAddress)
        {
            address = newAddress;
        }
        public void setDateOfBirth(String newDateOfBirth)
        {
            dateOfBirth = newDateOfBirth;
        }
        /**
         * The getNext method returns the next node in the linked list.
         * @return next
         */
        public ListNode getNext()
        {
            return next;
        }
        /**
         * The setNext method sets the next node of the linked list.
         * @param newLink
         */
        public void setNext(ListNode newLink)
        {
            next = newLink;
        }

        /**
         * The toString method takes all of the data of a node and neatly organizes the information into one single
         * string.
         * @return string
         */
        public String toString()
        {
            return "Name: " + getName() + "\nTelephone: " + getTelephoneNumber() + "\nEmail: "
                    + getEmail() + "\nAddress: " + getAddress() + "\nDate of Birth: " + getDateOfBirth() + "\n\n";
        }
    }
    /**
     * The isEmpty method returns if the linked list is empty or not.
     * @return
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    /**
     * The addToFront method takes in data and creates a new node out of that data. Adds the node to the front of
     * the linked list.
     * @param newName
     * @param newTelephoneNumber
     * @param newEmail
     * @param newAddress
     * @param newDateOfBirth
     */
    public void addToFront(String newName, String newTelephoneNumber, String newEmail, String newAddress,
                           String newDateOfBirth)
    {
        ListNode node = new ListNode(newName, newTelephoneNumber, newEmail, newAddress, newDateOfBirth);
        ListNode temp;

        if (head != null)
        {
            temp = head;
            head = node;
            node.setNext(temp);
        }
        else
        {
            head = node;
            node.setNext(null);
        }
    }
    /**
     * The addToBack method takes in data and creates a new node out of that data. Adds the node to the back of
     * the linked list.
     * @param newName
     * @param newTelephoneNumber
     * @param newEmail
     * @param newAddress
     * @param newDateOfBirth
     */
    public void addToBack(String newName, String newTelephoneNumber, String newEmail, String newAddress,
                          String newDateOfBirth)
    {
        ListNode node = new ListNode(newName, newTelephoneNumber, newEmail, newAddress, newDateOfBirth);

        if (head != null)
        {
            traverseList(head, head.getNext(), node);
        }
        else
        {
            head = node;
            node.setNext(null);
        }
    }
    /**
     * The toString method takes all existing nodes and creates a single string result.
     * @return string
     */
    public String toString()
    {
        String result = "";

        if (head != null)
        {
            result += toStringTraverse(head.getNext(), head.toString());
        }
        else
        {
            result = "No data available to print.";
        }
        return result;
    }
    /**
     * The reverseToString method takes all existing nodes and creates a single string result in reverse.
     * @return
     */
    public String reverseToString()
    {
        String result = "";

        if (head != null)
        {
            result += toStringReverseTraverse(head.getNext());
            result += head.toString();
        }
        else
        {
            result = "No data available to print.";
        }
        return result;
    }
    /**
     * The reverse method creates a new AddressList but in reverse.
     * @return newList
     */
    public AddressList reverse()
    {
        AddressList newList = new AddressList();

        if (head != null)
        {
            newList.addToFront(head.getName(), head.getTelephoneNumber(), head.getEmail(), head.getAddress(),
                    head.getDateOfBirth());
            newList = listReverse(head.getNext(), newList);
        }
        else
        {
            newList.head = null;
        }
        return newList;
    }
    /**
     * The sizeOf method returns the size of the linked list.
     * @return result
     */
    public int sizeOf()
    {
        int result = 0;

        if (head != null)
        {
            result = 1 + countList(head.getNext(), result);
        }

        return result;
    }
    /**
     * The phoneNumberByName method looks up a phone number if the name matches a name within a node.
     * @param otherName
     * @return result
     */
    public String phoneNumberByName(String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getTelephoneNumber();
            }
            else
            {
                result = phoneNumberTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    /**
     * The emailByName method looks up an email if the name matches a name within a node.
     * @param otherName
     * @return result
     */
    public String emailByName(String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getEmail();
            }
            else
            {
                result = emailTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    /**
     * The nameByPhoneNumber method looks up a name if the phone number matches a phone number within a node.
     * @param otherTelephoneNumber
     * @return
     */
    public String nameByPhoneNumber(String otherTelephoneNumber)
    {
        String result;

        if (head != null)
        {
            if (head.getTelephoneNumber().equals(otherTelephoneNumber))
            {
                result = head.getName();
            }
            else
            {
                result = nameTraverse(head.getNext(), otherTelephoneNumber);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    /**
     * The dobByName method looks but a date of birth by name if the name matches a name within a node.
     * @param otherName
     * @return
     */
    public String dobByName(String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getDateOfBirth();
            }
            else
            {
                result = dobTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    /**
     * Recursive helper methods.
     */
    private void traverseList(ListNode previous, ListNode head, ListNode node)
    {
        if (head != null)
        {
            traverseList(head, head.getNext(), node);
        }
        else
        {
            previous.setNext(node);
            node.setNext(null);
        }
    }
    private String toStringTraverse(ListNode node, String result)
    {
        if (node != null)
        {
            result += toStringTraverse(node.getNext(), node.toString());
        }
        return result;
    }
    private String toStringReverseTraverse(ListNode node)
    {
        String result = "";

        if (node != null)
        {
            result += toStringReverseTraverse(node.getNext());
            result += node.toString();
        }
        return result;
    }
    private AddressList listReverse(ListNode head, AddressList newList)
    {
        if (head != null)
        {
            newList.addToFront(head.getName(), head.getTelephoneNumber(), head.getEmail(), head.getAddress(),
                    head.getDateOfBirth());
            newList = listReverse(head.getNext(), newList);
        }
        return newList;
    }
    private int countList(ListNode head, int result)
    {
        if (head != null)
        {
            result = 1 + countList(head.getNext(), result);
        }
        return result;
    }
    private String phoneNumberTraverse(ListNode head, String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getTelephoneNumber();
            }
            else
            {
                result = phoneNumberTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    private String emailTraverse(ListNode head, String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getEmail();
            }
            else
            {
                result = emailTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    private String nameTraverse(ListNode head, String otherTelephoneNumber)
    {
        String result;

        if (head != null)
        {
            if (head.getTelephoneNumber().equals(otherTelephoneNumber))
            {
                result = head.getName();
            }
            else
            {
                result = nameTraverse(head.getNext(), otherTelephoneNumber);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
    private String dobTraverse(ListNode head, String otherName)
    {
        String result;

        if (head != null)
        {
            if (head.getName().equals(otherName))
            {
                result = head.getDateOfBirth();
            }
            else
            {
                result = dobTraverse(head.getNext(), otherName);
            }
        }
        else
        {
            result = "No matching data.";
        }
        return result;
    }
}