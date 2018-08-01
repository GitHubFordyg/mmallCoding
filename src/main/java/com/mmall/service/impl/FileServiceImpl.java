package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 把上传的文件名返回回去
     *
     * @param file 上传的文件名
     * @param path 上传的路径
     * @return 返回上传的文件名
     */
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename(); // 获取上传文件的原始文件名
        // 获取文件的扩展名（如：abc.jpg）
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 拼接新的文件名（作用是防止用户上传的文件文件名重复）
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        // 创建目录。先判断目录是否不存在，如果不存在则新建目录并赋予写权限（mkdirs()生成多级目录）
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        // 创建文件（path：路径；uploadFileName：上传的文件名）
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile); // 上传文件
            // 到此文件已经上传成功了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));  // 将targetFile上传到ftp服务器上
            //到此文件已经上传到ftp服务器上了

            targetFile.delete();  // 上传完成后，删除upload文件夹下面的文件
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return null;
        }
        // A:abc.jpg
        // B:abc.jpg
        return targetFile.getName();
    }

}
