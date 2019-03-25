package com.dingpeng.java.exercise.lottery.api.web.utils;

import com.dingpeng.java.exercise.lottery.common.utils.StringUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dp
 * Date: 2019/3/19 18:13
 * Description: TODO
 */
@Slf4j
public class FileUtil {
    /**
     * 2003版本的excel后缀
     */
    private final static String EXCEL_2003L = ".xls";
    /**
     * 2007+版本的excel
     */
    private final static String EXCEL_2007U = ".xlsx";

    public static ResponseEntity<byte[]> download(String filePath) {
        try {
            if (StringUtils.isNotEmpty(filePath)) {
                filePath = new String(filePath.getBytes("ISO-8859-1"), "UTF-8");
                File file = new File(filePath);
                String fileName = null;
                if (file.exists()) {
                    InputStream cvsIS = new FileInputStream(file);
                    fileName = URLEncoder.encode(filePath.substring(filePath.lastIndexOf("/") + 1), "UTF-8");
                }
                HttpHeaders headers = new HttpHeaders();
                //下载显示的文件名，解决中文名称乱码问题
                String downloadFileName = new String(Objects.requireNonNull(fileName).getBytes("UTF-8"), "iso-8859-1");
                //通知浏览器以attachment（下载方式）打开图片
                headers.setContentDispositionFormData("attachment", downloadFileName);
                //application/octet-stream ： 二进制流数据（最常见的文件下载）。
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                        headers, HttpStatus.CREATED);
            }
            return null;
        } catch (Exception e) {
            log.error("Download CSV File Error, e = ", e);
            return null;
        }
    }


    /**
     * 读取csv文件，转换为数据列表
     *
     * @param input    输入流
     * @param encoding 编码方式
     * @return
     */
    public static List<String[]> readCsvFile(InputStream input, String fileName, String encoding) {

        List<String[]> list = Lists.newArrayList();

        InputStreamReader reader;
        BufferedReader bReader = null;
        try {
            if (encoding == null) {
                reader = new InputStreamReader(input);
            } else {
                reader = new InputStreamReader(input, encoding);
            }
            bReader = new BufferedReader(reader);
            String str = bReader.readLine();
            String str1 = "";
            Pattern pCells = Pattern.compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");
            while ((str = bReader.readLine()) != null) {
                if (!str.endsWith(",")) {
                    str = str + ",";
                }
                Matcher mCells = pCells.matcher(str);
                List<String> listTemp = Lists.newArrayList();
                // 读取每个单元格
                while (mCells.find()) {

                    str1 = mCells.group();
                    str1 = str1.replaceAll(
                            "(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*,", "$1");
                    str1 = str1.replaceAll("(?sm)(\"(\"))", "$2");
                    listTemp.add(str1);

                }
                list.add((String[]) listTemp.toArray(new String[listTemp.size()]));

            }
        } catch (IOException e) {
            log.error("exception happened for readCsvFile, fileName:{}, e:", fileName, e);
        } finally {
            if (null != bReader) {
                try {
                    bReader.close();
                } catch (IOException e) {
                    log.error("exception happened finally for readCsvFile, fileName:{}, e:", fileName, e);
                }
            }
        }
        return list;
    }


    /**
     * 删除文件
     *
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
