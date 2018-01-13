package com.spsolutions.grand.util;

import com.spsolutions.grand.domain.EdgeDocument;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class ArchiveUtils {
    final static Logger logger = Logger.getLogger(ArchiveUtils.class);
    final static int SCALE_WIDTH = 250;

    public EdgeDocument writeToFile(String base64, String archivePath, String fileName, boolean thumbnail) {
        EdgeDocument edgeDocument = null;

        if (base64 != null && base64.contains("base64")) {
            String extension = base64.substring(0, base64.indexOf(";base64")).replaceAll("data:image/", "");
            try {
                edgeDocument = new EdgeDocument();
                String folderPath = findFolder(archivePath).concat(File.separator).concat(findFileName(fileName).concat(".").concat(extension).toUpperCase());
                String altPath = findFolder(archivePath).concat(File.separator).concat(findFileName(fileName).concat("_alt").concat(".").concat(extension).toUpperCase());
                ByteArrayInputStream bis = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(base64.substring(base64.indexOf(",") + 1)));
                BufferedImage image = ImageIO.read(bis);
                File file = new File(folderPath);

                ImageIO.write(image, extension, new File(folderPath));
                if (thumbnail) {
                    ImageIO.write(convertToThumbnail(image), extension, new File(altPath));
                }

                edgeDocument.setFileName(file.getName());
                edgeDocument.setFileSizeBytes(file.length());
                edgeDocument.setFilePath(folderPath);
                edgeDocument.setExt(extension);
                edgeDocument.setAltPath(altPath);
                edgeDocument.setCreatedDate(new Date());
                edgeDocument.setActivated(true);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return edgeDocument;
    }

    public BufferedImage convertToThumbnail(BufferedImage image) {
        int h = image.getHeight();
        int w = image.getWidth();
        if (image.getWidth() > SCALE_WIDTH) {
            h = (int) (image.getHeight() * ((double) (SCALE_WIDTH) / image.getWidth()));
            w = SCALE_WIDTH;
        }

        Image tmp = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(w, h, BufferedImage.SCALE_SMOOTH);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }


    public String findFolder(String archivePath) throws IOException {
        String folderPath = archivePath;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);

        folderPath = folderPath.concat(File.separator + year);
        File file = new File(folderPath);
        if (file.exists()) {
            folderPath = folderPath.concat(File.separator + month);
            file = new File(folderPath);
        } else {
            file.mkdir();

            folderPath = folderPath.concat(File.separator + month);
            file = new File(folderPath);
        }

        if (file.exists()) {
            return folderPath;
        } else {
            file.mkdir();
        }
        return folderPath;
    }

    private String findFileName(String fileName) {
        return DateUtils.getFileNameDate().concat("-").concat(fileName);
    }

    public String convertToBase64(String path) {
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(fileInputStream);
            return new BASE64Encoder().encode(bytes);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String convertToBase64(EdgeDocument edgeDocument) {
        return convertToBase64(edgeDocument.getFilePath());
    }

    public EdgeDocument writeStreamToFile(InputStream inputStream, String fileName, String archivePath) {
        EdgeDocument document = new EdgeDocument();

        byte[] buffer;
        try {
            buffer = new byte[inputStream.available()];

            document.setFileName(findFileName(fileName));

            String[] exts = fileName.split("[.]");
            document.setExt(exts[exts.length - 1]);

            document.setFilePath(findFolder(archivePath).concat(File.separator).concat(document.getFileName()));

            File targetFile = new File(document.getFilePath());
            document.setFileSizeBytes(targetFile.length());
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return document;
    }
}
