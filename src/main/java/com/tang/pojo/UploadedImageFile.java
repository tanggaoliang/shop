/**
 * @author: tang gao liang
 * @time:2019/4/17 21:56:16
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}