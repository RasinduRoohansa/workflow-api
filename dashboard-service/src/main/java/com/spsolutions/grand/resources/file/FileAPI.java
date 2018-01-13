package com.spsolutions.grand.resources.file;

import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/file/")
public class FileAPI {

    @Autowired
    private FileService fileService;

    @GetMapping(value = "findImage/{id}")
    public UploadImage findImage(@PathVariable("id") Long id) {
        return fileService.findImage(id);
    }

}
