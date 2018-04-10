package data_structures;
import data_structures.*;

public class Driver2 {
    private LinearListADT<String> list;
    
    public Driver2() {
        list = new LinearLinkedList<String>();
        try {
            for(int i=0; i < 101; i++)
                list.addFirst(""+ (i+1));
            for(String s : list)
                System.out.print(s + " ");
            System.out.println("\n");
            for(int i=0; i < 101; i++)
                list.removeFirst();            
            }
        catch(Exception e) {
            System.out.println("Block #1 " +e);
            e.printStackTrace();
            }
        try {
            for(int i=0; i < 10; i++)
                list.addLast(""+ (i+1));
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();
            }
        catch(Exception e) {
            System.out.println("Block #2 " +e);        
            e.printStackTrace();
            }   
        try {
            list.clear();
            System.out.print("Should not print anything before MARK");
            for(String s : list)
                System.out.print(s + " "); 
            System.out.println("\n ***** MARK *****");
            list.addLast("X");                           
            for(int i=0; i < 10; i++)
                list.insert(""+ (i+1),1);
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();
            if(list.locate("X") != 11)
                System.out.println("ERROR, -10 location should be 11, but locate returned " + list.locate("X"));
            String tmp = list.remove("X");
            if(tmp.compareTo("X") != 0)                
                System.out.println("ERROR, -10 remove should return 11, but remoe returned " + tmp);
            if(list.locate("X") != -1 )
                System.out.println("ERROR, -10 found removed item X");
            if(list.contains("X"))
                System.out.println("ERROR -10, found removed item X");                                   
            list.clear();
            for(int i=0; i < 100000; i++) 
                list.insert(i+"", (i+1)); 
            System.out.println("Size is " + list.size());  
            list.clear();
                
            for(int i=0; i < 100;  i++)
                list.addFirst(""+(i+1));
            for(int i=0; i < 90;  i++)
                list.remove(5);
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();                            
            for(int i=0; i < 10;  i++)
                list.remove(1); 
            System.out.print("Should not print anything before MARK, if so -10");
            for(String s : list)
                System.out.print(s + " "); 
            System.out.println("\n ***** MARK *****");                           
            }
        catch(Exception e) {
            System.out.println("Block #3 " +e);        
            e.printStackTrace();
            }                     
    }
    
    public static void main(String [] args)  {
        new Driver2();
        }
    }