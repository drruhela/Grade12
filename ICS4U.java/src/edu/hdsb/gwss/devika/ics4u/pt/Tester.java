/**
 * Open Hash Table Tester
 *
 * @version v2018.S2
 */
package edu.hdsb.gwss.devika.ics4u.pt;

public class Tester {

    /**
     */
    public static void main( String[] args ) {

        CSStudent student01 = new CSStudent( "Jonathan", "B", 7111, 12 );
        CSStudent student02 = new CSStudent( "Eric", "E", 2221, 12 );
        CSStudent student03 = new CSStudent( "Erika", "G", 2332, 12 );
        CSStudent student04 = new CSStudent( "Paul", "J", 1443, 12 );
        CSStudent student05 = new CSStudent( "Mackenzie", "K", 2554, 12 );
        CSStudent student06 = new CSStudent( "Mehak", "K", 6665, 12 );
        CSStudent student07 = new CSStudent( "Alan", "M", 7976, 12 );
        CSStudent student08 = new CSStudent( "Lucas", "P", 8387, 12 );
        CSStudent student09 = new CSStudent( "Callum", "P", 9098, 12 );
        CSStudent student10 = new CSStudent( "Raiyaan", "R", 1120, 12 );
        CSStudent student11 = new CSStudent( "Devika", "R", 2231, 12 );
        CSStudent student12 = new CSStudent( "Prarthana", "S", 8695, 12 );
        
        OpenHashTable ht = new OpenHashTable();
        System.out.println( ht.toString() );
        
        //Testing Empty Hash ht
        System.out.println("Test: Empty Table");
        System.out.println(ht.toString());
        assert( ht.capacity() == Integer.MAX_VALUE);
        assert( ht.isEmpty() == true);
        assert( ht.size() == 0);
        assert( ht.containsKey(student01.getKey()) == false);
        assert( ht.get( student01.getKey()) == null);
        System.out.println("Passed \n");
        
        
        //Testing with one student in ht
        System.out.println("Testing: One Student in Table");
        ht.put(student01);
        System.out.println(ht.toString());
        assert( ht.capacity() == Integer.MAX_VALUE);
        assert( ht.isEmpty() == false);
        assert( ht.size() == 1);
        assert( ht.containsKey(student01.getKey()) == true);
        assert( ht.containsKey(student02.getKey()) == false);
        assert( ht.get( student01.getKey()).equals(student01));
        assert( ht.get( student02.getKey()) == null);
        System.out.println("Passed \n");
        
        //Testing with multiple students in ht
        System.out.println("Testing: Multiple Students");
        ht.makeEmpty();
        ht.put(student01);
        ht.put(student02);
        ht.put(student03);
        ht.put(student04);
        ht.put(student05);
        ht.put(student06);
        ht.put(student07);
        ht.put(student08);
        ht.put(student09);
        ht.put(student10);
        ht.put(student11);
        ht.put(student12);
        System.out.println(ht.toString());
        assert( ht.capacity() == Integer.MAX_VALUE);
        assert( ht.isEmpty() == false);
        assert( ht.size() == 12);
        assert( ht.containsKey(student12.getKey()) == true);
        assert( ht.get( student05.getKey() ).equals(student05));
        System.out.println("Passed \n");
        
        //Testing empty again
        System.out.println("Testing: Empty again");
        ht.makeEmpty();
        System.out.println(ht.toString());
        assert( ht.capacity() == Integer.MAX_VALUE);
        assert( ht.isEmpty() == true);
        assert( ht.size() == 0);
        assert( ht.containsKey(student01.getKey()) == false);
        assert( ht.get( student03.getKey()) == null);
        System.out.println("Passed \n");
    }

}
