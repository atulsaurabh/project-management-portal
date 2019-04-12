package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.DocTypeDTO;
import org.parul.pmp.entity.DocType;

public class DocTypeMapper {
    public static DocType toEntity(DocTypeDTO dto)
    {
        DocType docType = new DocType();
        docType.setDoctypeid(dto.getDoctypeid());
        docType.setDocumentname(dto.getDocumentname());
        return docType;
    }
    public static DocTypeDTO toDTO(DocType docType)
    {
        DocTypeDTO dto = new DocTypeDTO();
        dto.setDoctypeid(docType.getDoctypeid());
        dto.setDocumentname(docType.getDocumentname());
        return dto;
    }
    }
