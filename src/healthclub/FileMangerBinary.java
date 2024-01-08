/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthclub;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 *
 * @author c.city
 */
public class FileMangerBinary implements Serializable{
        public boolean fwrite(String FilePath, Object data) {

        try {

            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));

            writter.writeObject(data);

            writter.close();
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }

    public Object fread(String FilePath) {

        Object Result = null;

        try {

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();
            Reader.close();

        }
        catch( ClassNotFoundException e)
        {
            System.out.print(e);
        }
        
        catch (IOException e) {
            System.out.println(e);
        } 

        return Result;

    }
    
}