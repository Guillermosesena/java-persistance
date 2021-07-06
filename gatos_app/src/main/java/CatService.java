
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
            if(catBackground.getIconHeight() > 700 ){
                Image background = catBackground.getImage();
                Image modified = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                catBackground = new ImageIcon(modified);
            }

            String menu = "Options: \n" +
                    "1. Watch another image \n" +
                    "2. Favorite \n" +
                    "3. Back \n";
            String[] buttons = {"Watch another image", "Favorite", "Back"};
            String catId = String.valueOf(cats.getId());
            String option = (String) JOptionPane.showInputDialog(null,menu,
                        catId, JOptionPane.INFORMATION_MESSAGE,
                        catBackground, buttons, buttons[0]);

            int selectedOption = -1;

            //Valid the option that user selects
            for(int i=0; i < buttons.length; i++){
                if(option.equals(buttons[i])){
                    selectedOption = i;
                }
            }
             switch(selectedOption){
                    case 0:
                        CatService.watchCats();
                        break;
                    case 1:
                        favoriteCat(cats);
                        break;
                    default:
                        break;
                }

        }catch(IOException e){
            System.out.println(e);
        }        
    }  

    public static void favoriteCat(Cats cat){
        try{
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\""+ cat.getId() +"\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApikey())
                    .build();
            Response response = client.newCall(request).execute();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void watchFavorites(String apikey) throws IOException{
        
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.thecatapi.com/v1/favourites")
        .method("GET", null)
        .addHeader("x-api-key", apikey)
        .build();
        
        
        Response response = client.newCall(request).execute();
      
        String json = response.body().string();

        //Delete brackets
        /*json = json.substring(1, json.length());//first
        json = json.substring(0, json.length()-1);//last*/

        //create json objetc
        Gson gson = new Gson();
        FavoriteCats[] catsArray = gson.fromJson(json, FavoriteCats[].class);
        
        if(catsArray.length > 0)
        {
            int min=1;
            int max=catsArray.length;
            int random = (int)(Math.random() * ((max-min)+1))+min;
            int index = random-1;
            
            FavoriteCats favCats = catsArray[index];
            
            
            Image image = null;
            try{
               URL url = new URL(favCats.image.getUrl());
               image = ImageIO.read(url);
               ImageIcon catBackground = new ImageIcon(image);
               if(catBackground.getIconHeight() > 700 ){
                   Image background = catBackground.getImage();
                   Image modified = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                   catBackground = new ImageIcon(modified);
               }

               String menu = "Options: \n" +
                       "1. Watch another favorite \n" +
                       "2. Delete Favorite \n" +
                       "3. Back \n";
               String[] buttons = {"Watch another favorite", "Delete favorite", "Back"};
               String catId = favCats.getId();
               String option = (String) JOptionPane.showInputDialog(null,menu,
                           catId, JOptionPane.INFORMATION_MESSAGE,
                           catBackground, buttons, buttons[0]);

               int selectedOption = -1;

               //Valid the option that user selects
               for(int i=0; i < buttons.length; i++){
                   if(option.equals(buttons[i])){
                       selectedOption = i;
                   }
               }
                switch(selectedOption){
                       case 0:
                           watchFavorites(apikey);
                           break;
                       case 1:
                           deleteFavoriteCat(favCats);
                           break;
                       default:
                           break;
                   }

           }catch(IOException e){
               System.out.println(e);
           }      

        }
        
    }

    
    
    
    public static void deleteFavoriteCat(FavoriteCats favCat){
        
    }
    
    
}

