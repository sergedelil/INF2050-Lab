package com.company;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;


public class JSONHash {

    private final String filename;
    private JSONObject obj;

    public JSONHash(String filename) {
        this.obj = null;
        this.filename = filename;
    }

    public boolean load() throws FileNotFoundException, JSONException, LabINF2050Exception{
        boolean resultat = false;
        try {
            String stringJson = IOUtils.toString(new FileInputStream(this.filename),  "UTF-8");
            JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(stringJson);
            this.obj = jsonObj;
            resultat = true;
        }catch(FileNotFoundException e){
            throw new LabINF2050Exception("Le fichier d'entré n'exixte pas");
        }catch(JSONException e){
            throw new LabINF2050Exception("Le fichier json n'est pas valide");
        }catch(IOException e){
            throw new LabINF2050Exception(e.toString());
        }
        return resultat;
    }

    public int countAlbum(){
        int result = 0;
        JSONArray collection = (JSONArray) JSONSerializer.toJSON(obj.getString("collection"));
        for(int i = 0 ; i < collection.size(); i++){
            if (collection.getJSONObject(i).getString("type").equals("album")){
                result += 1;
            }
        }
        return result;
    }

    public int countSingle(){
        int result = 0;
        JSONArray collection = (JSONArray) JSONSerializer.toJSON(obj.getString("collection"));
        for(int i = 0 ; i < collection.size(); i++){
            if (collection.getJSONObject(i).getString("type").equals("single")){
                result += 1;
            }
        }
        return result;
    }

    public void getListAlbumFrom2003(){

        JSONObject msgObj = new JSONObject();
        ArrayList<JSONObject> liste = new ArrayList<>();

        JSONArray collection = (JSONArray) JSONSerializer.toJSON(obj.getString("collection"));
        for(int i = 0 ; i < collection.size(); i++){
            if (collection.getJSONObject(i).getInt("publication") >= 2003){
                accumulateJSON(msgObj, liste, collection, i);
            }
        }
        liste.forEach((elem) -> {
            System.out.println(elem.toString(3));
        });

    }

    private void accumulateJSON(JSONObject msgObj, ArrayList<JSONObject> liste, JSONArray collection, int i) {
        msgObj.put("type", collection.getJSONObject(i).getString("type"));
        msgObj.put("artist", collection.getJSONObject(i).getString("artist"));
        msgObj.put("title", collection.getJSONObject(i).getString("title"));
        msgObj.put("publication", collection.getJSONObject(i).getInt("publication"));
        msgObj.put("rating", collection.getJSONObject(i).getInt("rating"));

        liste.add(msgObj);
    }

    public void getListAlbumPreferes() throws LabINF2050Exception {

        JSONObject msgObj = new JSONObject();
        ArrayList<JSONObject> liste = new ArrayList<>();

        JSONArray collection = (JSONArray) JSONSerializer.toJSON(obj.getString("collection"));
        for(int i = 0 ; i < collection.size(); i++){

            if (collection.getJSONObject(i).getString("title").equals("Century Child")
                    || collection.getJSONObject(i).getString("title").equals("The System has Failed")
                    || collection.getJSONObject(i).getString("title").equals("Land of the Free")){

                accumulateJSON(msgObj, liste, collection, i);
            }
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("preferes", liste);
        System.out.println(jsonObj.toString(3));
        save("albumsPreferes", jsonObj);
    }

    public void getListAlbumNote5(){

        JSONObject msgObj = new JSONObject();
        ArrayList<JSONObject> liste = new ArrayList<>();

        JSONArray collection = (JSONArray) JSONSerializer.toJSON(obj.getString("collection"));
        for(int i = 0 ; i < collection.size(); i++){
            if (collection.getJSONObject(i).getInt("rating") == 5){
                accumulateJSON(msgObj, liste, collection, i);
            }
        }
        liste.forEach((elem) -> {
            System.out.println(elem.toString(3));
        });

    }

    public boolean save(String filename, JSONObject jsonObj) throws LabINF2050Exception {
        boolean resultat;
        try (FileWriter f = new FileWriter(filename)) {
            f.write(jsonObj.toString(3));
            f.flush();
            f.close();
            resultat = true;
        }catch(IOException e){
            throw new LabINF2050Exception(e.toString());
        }
        return resultat;
    }

}
