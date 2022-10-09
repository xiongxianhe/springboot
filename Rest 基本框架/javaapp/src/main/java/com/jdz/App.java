package com.jdz;

import com.jdz.beans.RESCODE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(RESCODE.SUCCESS);
        System.out.println(RESCODE.getCodeDesc(RESCODE.SUCCESS));
        SpringApplication.run(App.class, args);
    }
}
