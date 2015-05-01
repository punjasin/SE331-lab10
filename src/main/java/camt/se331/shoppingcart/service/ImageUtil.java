package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Image;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;


public class ImageUtil {

    static ImageUtil imageUtil = null;
    public static ImageUtil getInstance(){
        if (imageUtil == null){
            imageUtil = new ImageUtil();
        }
        return imageUtil;
    }
    public static Image getImage(String resourcePath) throws IOException {
        Image image = new Image();
        ClassLoader classLoader = ImageUtil.getInstance().getClass().getClassLoader();

        File file = new File(classLoader.getResource(resourcePath).getFile());
        BufferedImage originalImage= ImageIO.read(file);
        BufferedImage target= Scalr.resize(originalImage,Scalr.Method.QUALITY,
                100, 100);
        try {

            image.setFileName(file.getName());
            try {
                image.setContentType(Files.probeContentType(file.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            ImageIO.write(target,"jpg",bos);


            image.setContent(bos.toByteArray());
            image.setCreated(Calendar.getInstance().getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return image;

    }

}