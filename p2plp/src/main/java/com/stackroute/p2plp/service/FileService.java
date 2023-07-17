package com.stackroute.p2plp.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.stackroute.p2plp.model.LoadFile;

@Service
public class FileService {
    
    private GridFsTemplate gridFsTemplate;
    private GridFsOperations gridFsOperations;

    @Autowired
    public FileService(GridFsTemplate gridFsTemplate, GridFsOperations gridFsOperations) {
        this.gridFsTemplate = gridFsTemplate;
        this.gridFsOperations = gridFsOperations;
    }

    public String addFile(MultipartFile file) throws IOException {
       DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", file.getSize());

        Object fileID = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metadata);

        return fileID.toString();
    }

    public LoadFile downloadFile(String fileId) throws IllegalStateException, IOException {
         GridFSFile gridFSFile = gridFsTemplate.findOne( new Query(Criteria.where("_id").is(fileId)) );

        LoadFile loadFile = new LoadFile();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile.setFileName( gridFSFile.getFilename() );

            loadFile.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            loadFile.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            loadFile.setFile( IOUtils.toByteArray(gridFsOperations.getResource(gridFSFile).getInputStream()) );
        }

        return loadFile;}
}
