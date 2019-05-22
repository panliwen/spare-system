package com.ufi.pdioms.resource.utlis;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class FileUtils
{
    
    private static final int BUFFER_SIZE = 2 * 1024;
    
    /**
     * 压缩成ZIP 方法 1 保留原文件目录结构
     * 
     * @param srcDir 压缩文件夹路径
     * @param out 压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, OutputStream out)
        throws RuntimeException
    {
        ZipOutputStream zos = null;
        try
        {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile, zos, "/");
        }
        catch (Exception e)
        {
            throw new RuntimeException("zip error from ZipUtils", e);
        }
        finally
        {
            if (zos != null)
            {
                try
                {
                    zos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    
    /**
     * 递归压缩方法
     * 
     * @param sourceFile 源文件
     * @param zos zip输出流
     * @param baseDir 上级路径
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String baseDir)
        throws Exception
    {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile())
        {
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(baseDir + sourceFile.getName()));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1)
            {
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        }
        else
        {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0)
            {
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                // 空文件夹的处理
                zos.putNextEntry(new ZipEntry("/"));
                // 没有文件，不需要文件的copy
                zos.closeEntry();
            }
            else
            {
                for (File file : listFiles)
                {
                    compress(file, zos, (file.isFile() ? baseDir : (file.getName() + "/")));
                }
            }
        }
    }
    
    // 删除单个文件
    public static void delete(File file) {
        if (file != null) {
            file.delete();
        }
    }
    
    // 删除指定列表中的文件（若所给文件路径的文件被其他程序占用，无法删除）
    public static void deleteFiles(List<String> deleteFilePaths)
    {
        // 删除临时文件
        for (String deleteFilePath : deleteFilePaths)
        {
            File tempFile = new File(deleteFilePath);
            tempFile.delete();
        }
    }
    
    
    public static void downloadFile(String fileLink, String targetFilePath) throws IOException
    {
        URL url = new URL(fileLink);    
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();    
        //设置超时间为3秒  
        conn.setConnectTimeout(3 * 1000);  
  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();   
        FileOutputStream out = new FileOutputStream(targetFilePath);
        out.write(bos.toByteArray());
        out.flush();
        out.close();
    }

    /**
     * downloadExcel
     * @param response
     * @param fileName
     * @param wb
     */
    public static void downloadExcel(HttpServletResponse response, String fileName, HSSFWorkbook wb){
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel;charset:utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    
    public static void main(String[] args)
        throws Exception
    {
        /** 测试压缩方法1 */
        // FileOutputStream fos1 = new FileOutputStream(new File("C:\\Users\\cwh\\Desktop\\ziptest4.zip"));
//        FileUtils.toZip("C:\\Users\\cwh\\Desktop\\ziptest", "C:\\Users\\cwh\\Desktop\\ziptest2.zip", true);
        
        // /** 测试压缩方法2 */
        // List<File> fileList = new ArrayList<>();
        // fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/jar.exe"));
        // fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/java.exe"));
        // FileOutputStream fos2 = new FileOutputStream(new File("c:/mytest02.zip"));
        // ZipUtils.toZip(fileList, fos2);
       // FileUtils.downloadFile("http://dev.30days-tech.com:9804/static/file/2018-04-10/20180410-010-label-2.PDF", "C:\\Users\\cwh\\Desktop\\file.pdf");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(new Date()));
    }
}
