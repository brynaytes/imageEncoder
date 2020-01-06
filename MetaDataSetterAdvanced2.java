import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * Write a description of class MetaDataMaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MetaDataSetterAdvanced2
{
    static int a,r,g,b,b2;
    public static void main(String name,String s) {
        BufferedImage img = null;
        File f = null;
        int MAXPIXELS;
        double fractionIncrement;
        //Words
        char words[] = s.toCharArray();
        //char words[] = {'w','o','r','d','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s'};
        try{
            f = new File(name);
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        MAXPIXELS = (img.getHeight() / 10) * (img.getWidth()/ 10);
            int u=0;   
            
        //This for loop creates an identifier for the image
            String key = "aytes";
        for(int i=1;i < 6;i++){
           int p = img.getRGB(i,1);
                a = (p >> 24) & 0xff;
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p& 0xff;
                
                if(b > 40){
                        b= b-converterb(key.charAt(i-1));
                        }else{
                        b=b+converterb(key.charAt(i-1));
                        }
                
                p = (a<<24)|(r<<16)|(g<<8)|b;
                img.setRGB(i,0,p);
        }
        
        //Setting every 10 pixels to a letter
        for(int i = 0; i < img.getHeight(); i+= 10){

            for(int o =0; o < img.getWidth();o+=10){
                
                
                int p = img.getRGB(o,i);
                a = (p >> 24) & 0xff;
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p& 0xff;
                b2 = p& 0xff;
                //b=255;
                
                //if(s.length() > u && Character.isUpperCase(words[u])){
                if(s.length() > u){
                    if(words[u] == '\n'){
                        System.out.println("return found");
                    if(b > 40){
                        b= b-1;
                        r= r-1;
                        }else{
                        b=b+1;
                        r=r+1;
                        }
                    }else
                       
                    if(Character.isLowerCase(words[u])){
                        if(b > 40){
                        b= b-converterb(words[u]);
                        }else{
                        b=b+converterb(words[u]);
                        }
                    }else if(Character.isUpperCase(words[u])){
                        if(r > 40){
                        r= r-convertera(words[u]);
                        }else{
                        r= r+convertera(words[u]);
                        }
                    }else{
                        //System.out.print(words[u]);
                        if(g > 40){
                        g= g-converterg(words[u]);
                        }else{
                        g= g+converterg(words[u]);
                        }
                    
                        
                    }
                    
                }else{
                    //a= 255 - convertera(words[u]);
                    
                   //b=255;
                }
                
                u += 1;
                
                p = (a<<24)|(r<<16)|(g<<8)|b;
                img.setRGB(o,i+1,p);
            }
            
            //
        }
        try{
            f = new File("Out.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
        //System.out.printf("%nDone%n");
    }
    public static int converterb(char x){        
        return x - 96;
    }
    
    public static int convertera(char x){
        return x - 64;
    }
    
    public static int converterg(char x){
        return x - 31;
    }
}
