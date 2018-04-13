package com.example.admin.testweek4;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        //c# style factory
        Node root = Node.fromString(new String[]{"B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"});

        root.printNodes();
    }


}
