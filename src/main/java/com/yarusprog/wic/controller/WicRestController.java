package com.yarusprog.wic.controller;

import com.yarusprog.wic.dto.FullShareResponse;
import com.yarusprog.wic.dto.entity.CreateShareDto;
import com.yarusprog.wic.dto.entity.ImageDto;
import com.yarusprog.wic.facade.ImageFacade;
import com.yarusprog.wic.facade.ShareFacade;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class WicRestController {

    @Autowired
    private ShareFacade shareFacade;

    @Autowired
    private ImageFacade imageFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shares")
    public FullShareResponse publicShare(@Valid @RequestBody final CreateShareDto createShareDto) {
        return new FullShareResponse(shareFacade.saveShare(createShareDto));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shares/productPhoto/{shareId}")
    public FullShareResponse setPhotoForShareProduct(@RequestParam(value = "photo") MultipartFile photo,
                                            @PathVariable Long shareId) {
        return new FullShareResponse(shareFacade.uploadPhotoForShareProduct(photo, shareId));
    }

    @GetMapping("/productImage/{id}")
    public void getProductImageAsResource(HttpServletResponse response, @PathVariable("id") long id) throws IOException {
        final ImageDto imageDto = imageFacade.getImageById(id);
        InputStream in = new ByteArrayInputStream(imageDto.getImage());
        response.setContentType(imageDto.getFormat());
        IOUtils.copy(in, response.getOutputStream());
    }
}
