
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g.sesena.pascacio
 */
public class CatService {
    public static void watchCats()throws IOException{
        
        
    OkHttpClient client = new OkHttpClient();
    
    Request request = new Request.Builder()
    .url("https://api.thecatapi.com/v1/images/search")
    .method("GET", null)
    .build();
    
    Response response = client.newCall(request).execute();
    
    String json = response.body().string();
    
    //Delete brackets
    json = json.substring(1, json.length());//first
    json = json.substring(0, json.length()-1);//last
    
    //create json objetc
    Gson gson = new Gson();
    Cats cats = gson.fromJson(json, Cats.class);
    
    //
    Image image = null;
    try{
        URL url = new URL(cats.getUrl());
        image = ImageIO.read(url);
        ImageIcon catBackground = new ImageIcon(image);
        if(catBackground.getIconHeight() > 800 ){
            Image background = catBackground.getImage();
            Image modified = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
            catBackground = new ImageIcon(modified);
        }
        
    }catch(IOException e){
        System.out.println(e);
    }
        
        
        
    }  
}
