/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

/**
 *
 * @author drruh
 */
public class StateDBClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StateDB db = new StateDB();
        
        State s1 = new State( "Ontario", "Canada", 52, 250000, 14.45, true);
        State s2 = new State ("Quebec", "Canada", 227, 561, 8.43, true);
        State s3 = new State();
        
        s3.setName("PEI");
        s3.setCountry("Canada");
        s3.setCities(231); //made up number
        s3.setLakes(23); //made up num
        s3.setPopulation(3.2); //made up
        s3.setCoastal(true);
        s3.setCode('P');
        
        
        //Test file is empty
        System.out.println("Test: Empty file.");
        db.open();
        assert( db.get(1) == null );
        assert(db.save(s1).equals(s1) );
        System.out.println("Passed \n");
        
        //Test file has 1 object
        System.out.println("Test: File has 1 object.");
        db.open();
        assert( db.get(1).equals(s1) );
        s1.setCountry("USA");
        assert(db.save(s1).equals(s1) ); //updates s1
        assert(db.save(s2).equals(s2)); //adds another object
        db.close();
        System.out.println("Passed \n");
        
        //Test file has 3 objects
        db.open();
        db.save(s3);
        System.out.println("Test: File has 3 objects.");
        assert( db.get(1).equals(s1) );
        assert( db.get(2).equals(s2) );
        assert( db.get(3).equals(s3) );
        assert( db.get(-1) == null );
        assert( db.get(4) == null);
        //assert( db.get(3).equals(test));
        db.close();
        System.out.println("Passed \n");
        
    }
    
}
