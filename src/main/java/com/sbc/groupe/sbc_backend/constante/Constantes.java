package com.sbc.groupe.sbc_backend.constante;

//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

public class Constantes {
    public static final String host="http://localhost:9091";
    static String DIRECTORY="C:\\MesProjet\\projet_sbc_groupe\\src\\assets\\images\\";

    public static String upload(String urlimage) throws IOException{
        String filename="";
        //On verifie si le type de contenu est different de text
        if(urlimage!=null)
            if (!urlimage.equals("")) {
                try {
                    byte[] fileFromBase64 = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(urlimage);
                    //On crée le nom de l'image
                    filename = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault()).format(new Date()) + "_" + "img.jpg";
                    //directory = chemin de l'image
                    String directory = DIRECTORY + filename;
                    new FileOutputStream(directory).write(fileFromBase64); //upload l'image
                    //preuveTacheEntity.setUrlfichier(imageName);  //Change la b64 en url
                } catch (IOException e) {
                    e.printStackTrace();
                    return  "";
                }
            }
        return filename;
    }

    public String convertStringToBase64(String fileName) {
        return getString(fileName, DIRECTORY);
    }
    static String getString(String fileName, String directory) {
        byte[] fileContent;
        if (fileName!=null) {
            try {
                File file = new File(directory + fileName);
                if (file.exists()) {
                    fileContent = FileUtils.readFileToByteArray(file);
                    return Base64.getEncoder().encodeToString(fileContent);
                } else
                    return "";
            } catch (IOException e) {
                return "Erreur de conversio";
            }
        }else{
            return "";
        }
    }

}
