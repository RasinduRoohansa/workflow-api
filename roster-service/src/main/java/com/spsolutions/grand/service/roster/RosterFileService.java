package com.spsolutions.grand.service.roster;

import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.mappers.roster.RosterDocumentMapper;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RosterFileService {

    @Autowired
    private RosterDocumentMapper documentMapper;

    public UploadImage findImage(Long id) {
        UploadImage uploadImage = new UploadImage();

        EdgeDocument edgeDocument = this.documentMapper.findImage(id);
        if (edgeDocument != null) {
            uploadImage.setImage("data:image/".concat(edgeDocument.getExt()).concat(";") + "base64,".concat(new ArchiveUtils().convertToBase64(edgeDocument)));
            return uploadImage;
        }
        return null;
    }

    public String findThumbnail(String path, String ext) {
        return "data:image/".concat(ext).concat(";") + "base64,".concat(new ArchiveUtils().convertToBase64(path));
    }
}
