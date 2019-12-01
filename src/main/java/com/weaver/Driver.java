package com.weaver;

import java.io.FileNotFoundException;

/**
 * Pass all the raw components provided by the use to the
 * Manager class which will then start the universe and
 * execute it.
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        if(args.length != 3)
            System.out.println("Usage: path/to/file/seedfile generations(int) millis-between-generations(long)");

        Manager mng = new Manager(args[0], new Strategy(), Integer.parseInt(args[1]), Long.parseLong(args[2]));

        mng.start();
    }
}
