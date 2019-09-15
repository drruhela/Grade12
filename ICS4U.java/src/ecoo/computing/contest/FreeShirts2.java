/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoo.computing.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author drruh
 */
public class FreeShirts2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //OPEN FILE 
        File file = new File("DATA.txt");
        Scanner file1 = new Scanner(file);
        //System.out.println("hello");
        int n;
        int m;
        int d;
        int laundry = 0;
        int dirtyShirts = 0;
        int initialShirts = 0;

        while (file1.hasNextLine()) {

            String info = file1.nextLine();
            StringTokenizer st = new StringTokenizer(info);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            laundry = 0;

            String eventDaysStr = file1.nextLine();
            st = new StringTokenizer(eventDaysStr);
            int counter = 0;

            while (counter < m) {
                counter++;
            }
            int[] eventDays = new int[counter];

            for (int index = 0; index < eventDays.length; index++) {
                eventDays[index] = Integer.parseInt(st.nextToken());
            }

            int day = 0;

            while (day < d) {
                n -= 1;
                dirtyShirts += 1;

                for (int i = 0; i < eventDays.length; i++) {
                    if (eventDays[i] == day) {
                        n += 1;
                    }
                }

                if (n == 0) {
                    laundry += 1;
                    n = dirtyShirts;
                    dirtyShirts = 0;
                }
                day++;
            }

            System.out.println(laundry);

        }
    }

}
