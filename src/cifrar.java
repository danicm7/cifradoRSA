
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a
 */
public class cifrar {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException, NoSuchProviderException {
        //IMPORTANTE: El texto/datos a cifrar no puede ser mayor que la longitud de la clave
                    //si fuera mayor habria que cifrar por bloques
        
// TODO code application logic here
        //Definimos un texto a cifrar
        String str = "Este es el texto a cifrar";

        System.out.println(
                "\nTexto a cifrar:");
        System.out.println(str);

        //Instanciamos la clase
        RSA rsa = new RSA();

        //Generamos un par de claves
        //Admite claves de 512, 1024, 2048 y 4096 bits
        rsa.genKeyPair(512);

        String clave_private;
        String clave_public;

        //Las guardamos en un String
        clave_private = rsa.getPrivateKeyString();
        clave_public = rsa.getPublicKeyString();
        /*
        //tambien podriamos guardarlo en disco de la siguientemanera
         String file_private = "/tmp/rsa.pri";
        String file_public = "/tmp/rsa.pub";
        
        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        rsa.saveToDiskPrivateKey("/tmp/rsa.pri");
        rsa.saveToDiskPublicKey("/tmp/rsa.pub");
        */
        
        //Ciframos y e imprimimos, el texto cifrado
        //es devuelto en la variable cifrado
        String cifrado = rsa.Encrypt(str);

        System.out.println(
                "\nCifrado:");
        System.out.println(cifrado);

        //A modo de ejemplo creamos otra clase rsa
        RSA rsa2 = new RSA();

        //A diferencia de la anterior aca no creamos
        //un nuevo par de claves, sino que cargamos
        //el juego de claves que habiamos guadado
        rsa2.setPrivateKeyString(clave_private);
        rsa2.setPublicKeyString(clave_public);
        
        /* 
        //Asi seria si tuvieramos las lcaves guardadas en disco
        rsa2.openFromDiskPrivateKey("/tmp/rsa.pri");    
        rsa2.openFromDiskPublicKey("/tmp/rsa.pub");
        */
                
        //Le pasamos el texto cifrado (cifrado) y nos 
        //es devuelto el texto ya descifrado (unsecure) 
        String unsecure = rsa2.Decrypt(cifrado);

        //Imprimimos
        System.out.println(
                "\nDescifrado:");
        System.out.println(unsecure);

    }
}
