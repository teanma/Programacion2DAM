package org.iesfm.institutomongo.exceptions;

public class GroupNotFoundException extends Exception {

    private int id;

    public GroupNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
