package com.example.admin.testweek4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Node {
    private Node parent;
    private List<Node> children = new ArrayList<>();
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node getRoot()
    {
        Node current = this;
        while (current.getParent() != null)
        {
            current = current.getParent();
        }
        return current;
    }
    public Node getParent()
    {
        return parent;
    }
    public void setParent(Node value)
    {
        parent = value;
    }
    public List<Node> getChildren() {
        return children;
    }

    public static Node fromString(String[] args)
    {
        Dictionary<String, Node> nodes = addNodesToDict(args);
        Node anyNode = null;//just need any node doesnt matter which one

        for(String arg : args)
        {
            List<String> splitArg = Arrays.asList(arg.split(","));
            for (int i = 1; i < splitArg.size(); i++)
            {
                anyNode = nodes.get(splitArg.get(0));
                nodes.get(splitArg.get(0)).getChildren().add(nodes.get(splitArg.get(i)));
                (nodes.get(splitArg.get(i))).setParent(nodes.get(splitArg.get(0)));
            }
        }
        //for(String arg : args)
        //{
        //    List<String> splitArg = Arrays.asList(arg.split(","));
        //    for (int i = 1; i < splitArg.size(); i++)
        //    {
        //        nodes.get(splitArg.get(0)).getChildren().add(nodes.get(splitArg.get(i)));
        //        (nodes.get(splitArg.get(i))).setParent(nodes.get(splitArg.get(0)));
        //    }
        //}

        if (anyNode == null)//there are no nodes
            return null;
        return anyNode.getRoot();
    }

    private static Dictionary<String, Node> addNodesToDict(String[] args)
    {
        Dictionary<String, Node> nodes = new Hashtable<>();

        for (int i = 0; i < args.length; i++)
        {
            List<String> splitArg = Arrays.asList(args[i].split(","));
            for (int j = 0; j < splitArg.size(); j++)
            {
                Node exists = nodes.get(splitArg.get(j));
                if (exists == null)
                    nodes.put(splitArg.get(j), new Node(splitArg.get(j)));
            }
        }
        return nodes;
    }

    public void printNodes()
    {
        printNodes(this, 0);
    }

    private static void printNodes(Node node, int treeLevel)
    {
        System.out.print(addTabs(node.name, treeLevel) + '\n');
        for (Node child : node.children)
        {
            int nextLevel = treeLevel + 1;
            printNodes(child, nextLevel);
        }
    }

    //wish java had extension methods DX
    private static String addTabs(String string, int count)
    {
        String result = "";
        for (int i = 0; i < count; i++)
        {
            result += "\t";
        }
        return result + string;
    }
}
