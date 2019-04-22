/**
 * @author: tang gao liang
 * @time:2019/4/17 21:56:47
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import com.tang.pojo.UploadedImageFile;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}
