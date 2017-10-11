package com.shenyang.utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 图片处理工具类
 */
public class ImageUtil {
    private ImageUtil() {
    }

    public static class ImageSize {
        private int x1;
        private int x2;
        private int y1;
        private int y2;

        public int getX1() {
            return x1;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public int getX2() {
            return x2;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public int getY1() {
            return y1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public int getY2() {
            return y2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }

        public ImageSize(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public ImageSize() {
        }
    }

    /**
     * 按比例缩放图片
     *
     * @param image
     * @param weight
     * @param height
     * @return
     * @throws IOException
     */
    public static byte[] zoomImage(byte[] image, int weight, int height) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(image);
        BufferedImage originalImage = ImageIO.read(bis);
        BufferedImage zoomImage = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) zoomImage.getGraphics();
        graphics.setBackground(new Color(255, 255, 255));
        graphics.setColor(new Color(255, 255, 255));
        graphics.drawImage(originalImage.getScaledInstance(weight, height, Image.SCALE_SMOOTH), 0, 0, null);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(zoomImage, getImgFormat(image), bos);
        return bos.toByteArray();
    }

    /**
     * 获取图像格式
     *
     * @return
     */
    public static String getImgFormat(byte[] image) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(image);
        ImageInputStream iis = ImageIO.createImageInputStream(bis);
        Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
        if (!iter.hasNext()) return null;
        ImageReader reader = iter.next();
        iis.close();
        return reader.getFormatName();
    }

    /**
     * 切割图片
     *
     * @param image
     * @param size
     * @return
     * @throws IOException
     */
    public static byte[] imageClipper(byte[] image, ImageSize size) throws IOException {
        return imageClipper(image, size.x1, size.x2, size.y1, size.y2);
    }

    /**
     * 切割图片
     *
     * @param image
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     * @throws IOException
     */
    public static byte[] imageClipper(byte[] image, int x1, int x2, int y1, int y2) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(image);
        ImageInputStream iis = ImageIO.createImageInputStream(byteArrayInputStream);
        Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
        if (!iter.hasNext()) {
            return null;
        }
        ImageReader reader = iter.next();
        String format = reader.getFormatName();
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(x1, y1, (x2 - x1), (y2 - y1));
        param.setSourceRegion(rect);
        reader.setInput(iis);
        BufferedImage cutImg = reader.read(0, param);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(cutImg, format, baos);
        iis.close();
        return baos.toByteArray();
    }


}
