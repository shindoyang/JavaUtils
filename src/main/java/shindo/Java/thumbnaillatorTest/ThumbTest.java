package shindo.Java.thumbnaillatorTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.alibaba.simpleimage.ImageWrapper;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.util.ImageReadHelper;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class ThumbTest {

    public void testHandlePicture() throws IOException {

        // 创建图片文件(此处为1920x1200x的图片)和处理后的图片文件
        File fromPic = new File("D:/IDE/workspace-Neon/Java/src/thumbTestPic/测试图片.jpg");
        File toPic = new File("D:/IDE/workspace-Neon/Java/src/thumbTestPic/结果图片.jpg");
        File waterPic = new File("D:/IDE/workspace-Neon/Java/src/thumbTestPic/水印.jpg");

        // 按指定大小把图片进行缩和放(会遵循原图高宽比例)
        // 此处把图片压成600x700的缩略图
//        Thumbnails.of(fromPic).size(600, 700).toFile(toPic);//原方法
        
        //Thumbnails操作图片发红的问题解决
        try {  
            File in = new File("D:/IDE/workspace-Neon/Java/src/thumbTestPic/1.jpg"); // 原图片  
            FileInputStream inStream = new FileInputStream(in);  
            ImageWrapper imageWrapper = ImageReadHelper.read(inStream);  
            Thumbnails.of(imageWrapper.getAsBufferedImage()).size(160, 160)  
                    .toFile("D:/IDE/workspace-Neon/Java/src/thumbTestPic/11.jpg");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (SimpleImageException e) {  
            e.printStackTrace();  
        }  

        // 按照指定比例进行缩小和放大 , scale值小于1是缩小，大于1是放大
//        Thumbnails.of(fromPic).scale(0.2f).toFile(toPic);// 缩小
//        Thumbnails.of(fromPic).scale(1.5f).toFile(toPic);//放大

        // 不按比例，就按指定的大小进行缩放
        // 方法一
//        Thumbnails.of(fromPic).size(100, 100).keepAspectRatio(false).toFile(toPic);
        // 方法二
//        Thumbnails.of(fromPic).forceSize(100, 100).toFile(toPic);

        // 旋转图片，rotate(角度)，正数则为顺时针，负数则为逆时针
//        Thumbnails.of(fromPic).size(300, 300).rotate(60).toFile(toPic);

        // 图片尺寸不变，压缩图片文件大小outputQuality实现，参数1为最高质量
//        Thumbnails.of(fromPic).scale(1f).outputQuality(0.25f).toFile(toPic);

        // 给图片加水印，watermark(位置，水印图，透明度)Positions.CENTER表示加在中间
//        Thumbnails.of(fromPic).size(400, 400).watermark(Positions.CENTER, ImageIO.read(waterPic), 0.5f).outputQuality(0.8f).toFile(toPic);

        // 用sourceRegion()实现图片裁剪
        // 图片中心300x300的区域，Positions.CENTER表示中心，还有许多其他位置可选
//        Thumbnails.of(fromPic).sourceRegion(Positions.BOTTOM_CENTER, 300, 300).size(300, 300).toFile(toPic);

        // 图片中上区域300x300的区域
//        Thumbnails.of(fromPic).sourceRegion(Positions.TOP_CENTER, 300, 300).size(300, 300).toFile(toPic);

        // 左上角
//        Thumbnails.of(fromPic).sourceRegion(0, 0, 200, 200).size(300, 300).toFile(toPic);

        // 用outputFormat(图像格式)转换图片格式，保持原尺寸不变
//        Thumbnails.of(fromPic).scale(1f).outputFormat("png").toFile("D:/IDE/workspace-Neon/Java/src/thumbTestPic/png格式的图片.png");

//        OutputStream os = new FileOutputStream(toPic);
//        Thumbnails.of(fromPic).size(120, 120).toOutputStream(os);

        // 输出BuffererImage，asBufferedImage()返回BufferImage
//        BufferedImage bi = Thumbnails.of(fromPic).size(120, 120).asBufferedImage();
//        ImageIO.write(bi, "jpg", toPic);

        // 压缩至指定图片尺寸（例如：横400高300），保持图片不变形，多余部分裁剪掉
//        BufferedImage image = ImageIO.read(fromPic);
//        Builder<BufferedImage> builder = null;

//        int imageWidth = image.getWidth();
//        int imageHeight = image.getHeight();
//        if ((float) 300 / 400 != (float) imageWidth / imageHeight) {
//            if (imageWidth > imageHeight) {
//                image = Thumbnails.of(fromPic).height(300).asBufferedImage();
//            } else {
//                image = Thumbnails.of(fromPic).width(300).asBufferedImage();
//            }
//            builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, 400, 300).size(400, 300);
//        } else {
//            builder = Thumbnails.of(image).size(400, 300);
//        }
//        builder.outputFormat("jpg").toFile(toPic);
    }

    public static void main(String[] args) {
        try {
            new ThumbTest().testHandlePicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
