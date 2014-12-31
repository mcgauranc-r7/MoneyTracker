package com.wraith.money.web.controller;

import javax.inject.Inject;

import org.springframework.batch.core.BatchStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wraith.money.web.service.DataUploadService;

/**
 * This controller manages the data upload request functionality.
 * <p/>
 * User: rowan.massey
 * Date: 26/08/2014
 * Time: 21:02
 */
@Controller
public class DataUploadController {

    @Inject
    private DataUploadService dataUploadService;

    @RequestMapping(value = "/$service/performDataUpload", method = RequestMethod.POST)
    @ResponseBody
    public BatchStatus performDataUpload(@RequestParam("file") MultipartFile file, @RequestParam("uploadType") String uploadType) {
        return dataUploadService.performUploadData(file, uploadType).getStatus();
    }
}
