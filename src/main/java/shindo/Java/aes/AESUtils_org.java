//package shindo.Java.aes;
//
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.Security;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.CipherInputStream;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import cfca.org.bouncycastle.util.encoders.Hex;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//public class AESUtils {
//    private static final AESUtils instance = new AESUtils();
//    byte[] iv = { 0x38, 0x37, 0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x38, 0x37,
//            0x36, 0x35, 0x34, 0x33, 0x32, 0x31 };
//
//    byte[] keybytes = { 0x70, 0x2F, 0x17, 0x7F, 0x6C, 0x3A, 0x22, 0x11, 0x3F,
//            0x44, 0x5A, 0x66, 0x77, 0x1A, 0x12, 0x1C };
//
//    private AESUtils() {
//
//    }
//
//    public static AESUtils getInstance() {
//        return instance;
//    }
//
//    private Key key;
//    private byte[] enc;
//
//    private static final String IV_STRING = "1234567812345678";
//    private static final String charset = "UTF-8";
//    private static final String desKey = "1234567891234567";
//    private static final String IMGPATH = "D:\\data\\www\\img\\testUploadImg4.jpg";
//
//    public String encrypt(String msg) {
//        String str;
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//            key = new SecretKeySpec(keybytes, "AES");
//            Cipher in = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
//            in.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
//            enc = in.doFinal(msg.getBytes());
//            str = new String(Hex.encode(enc));
//            return str;
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static String decrypt(InputStream is) {
//        try {
//
//        	//图片流解密
//        	Security.addProvider(new BouncyCastleProvider());
//        	Cipher cipher = null;
//            SecretKeySpec secretKey = new SecretKeySpec(desKey.getBytes(), "AES");
//            byte[] initParam = IV_STRING.getBytes(charset);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
//            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
//            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
//            CipherInputStream cis = new CipherInputStream(is,cipher);
//
//            byte[] d = new byte[1024];
//            int len = 0;
//
//            //保存图片到本地硬盘
//            FileOutputStream out = new FileOutputStream(IMGPATH);
//            while ((len = cis.read(d)) != -1) {
//                out.write(d, 0, len);
//            }
//            out.flush();
//            out.close();
//            is.close();
//
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        }catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        return null;
//    }
//
//    /**
//     * 读取图片再加密返回图片字节数组
//     */
//    public static byte[] encryptBack() {
//        try {
//            //读图片流
//            InputStream inStream = new BufferedInputStream(new FileInputStream(IMGPATH));
//
//            //图片流加密返回
//            Security.addProvider(new BouncyCastleProvider());
//            SecretKeySpec secretKey = new SecretKeySpec(desKey.getBytes(), "AES");
//            byte[] initParam = IV_STRING.getBytes(charset);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
//            Cipher encrypt =  Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
//            encrypt.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
//            CipherInputStream cin = new CipherInputStream(inStream,encrypt);
//
//            byte[] encryptByte = readInputStream(cin);
//            inStream.close();
//            cin.close();
//
//        	return encryptByte;
//
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        }catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        return null;
//    }
//
//    /**
//     * 将流转为二进制数组
//     */
//    public static byte[] readInputStream(InputStream is) throws IOException {
//    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//
//    	byte[] buffer = new byte[1024];
//    	int len  = 0;
//
//    	while((len=is.read(buffer)) != -1){
//    		outStream.write(buffer,0,len);
//    	}
//
//    	is.close();
//    	return outStream.toByteArray();
//    }
//}
