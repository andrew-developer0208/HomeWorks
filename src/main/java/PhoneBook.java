import java.util.*;

/**
 * This class encapsulates contacts and provides methods for create and find
 */
public class PhoneBook {
    private HashMap<Integer, LinkedList<String>> contacts = new HashMap<>();

    /**
     * Adds contact to contact
     * @param value String
     */
    public void addContact(String value) {
        LinkedList<String> list = new LinkedList<>(List.of(value.split(" ")));
        contacts.put(getUniqueID(), list);
    }

    /**
     * Gets unique keys for new record
     * @return int
     */
    private int getUniqueID() {
        if (contacts.isEmpty()) {
            return 1;
        } else {
            return Collections.max(contacts.keySet()) + 1;
        }
    }

    /**
     * Finds records with value equal last name at contacts
     * @param value String
     * @return HashMap<Integer, LinkedList<String>>
     */
    public HashMap<Integer, LinkedList<String>> findLastName(String value) {
        HashMap<Integer, LinkedList<String>> result = new HashMap<>();
        for (Map.Entry<Integer, LinkedList<String>> entry: contacts.entrySet()) {
            if (value.equals(entry.getValue().peek())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    /**
     * Gets all contacts
     * @return HashMap<Integer, LinkedList<String>>
     */
    public HashMap<Integer, LinkedList<String>> getContacts() {
        return contacts;
    }
}
