package com.stackroute.p2plp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadFile {
    private String fileName;
    private String fileType;
    private String fileSize;
    private byte[] file;
}
