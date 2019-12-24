import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import java.io.FileWriter;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public class JSON_manager {
    public JSONObject readJSON() throws FileNotFoundException, IOException{
            Reader r = new FileReader(System.getProperty("user.dir")+"//data.json");
            JSONTokener jt = new JSONTokener(r);
            JSONObject jo = new JSONObject(jt);
            r.close();
            //System.out.println(System.getProperty("user.dir")+"//data.json");
            //System.out.println("JSON File : "+jo.toString());
            
            return jo;
    }
    public boolean checkJSON() throws IOException{
        boolean FILE;
        try{
        Reader r = new FileReader(System.getProperty("user.dir")+"//data.json");
        FILE = true;
        r.close();}
        catch(FileNotFoundException e){
            FILE = false;
        }
            return FILE;
    }
    public void writeJSON(String uname, String pwd) throws IOException{
        
        Writer wr=new FileWriter(System.getProperty("user.dir")+"//data.json");
        JSONObject jo = new JSONObject();
        jo.put("uname", uname);
        jo.put("pwd", pwd);
        JSONWriter js = new JSONWriter(wr);
        js.object()
                .key("MySQL")
                .value(jo)
          .endObject();
        wr.close();
    }
}
