package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.UploadDocDTO;
import org.parul.pmp.entity.UplodedDocuments;

public class UploadDocMapper
{
    public static UplodedDocuments toEntity(UploadDocDTO dto)
    {
        UplodedDocuments uplodedDocs = new UplodedDocuments();
        uplodedDocs.setDescription(dto.getDescription());
        uplodedDocs.setDocurl(dto.getDocurl());
        uplodedDocs.setUploadedby(dto.getUploadedby());

        return uplodedDocs;
    }
    public static UploadDocDTO toDto(UplodedDocuments uplodedDocuments)
    {
        UploadDocDTO dto = new UploadDocDTO();
        dto.setUploaddocid(uplodedDocuments.getUploaddocid());
        dto.setDescription(uplodedDocuments.getDescription());
        dto.setDocurl(uplodedDocuments.getDocurl());
        dto.setUploadedby(uplodedDocuments.getUploadedby());

        return dto;
    }
}
