package com.java.learn.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User implements Externalizable {
    private String username, password; //Dont want to write password
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(username); // Only write username
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
    }
}
