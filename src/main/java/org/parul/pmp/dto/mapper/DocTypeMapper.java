package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.DocTypeDTO;
import org.parul.pmp.entity.DocType;

public class DocTypeMapper {
    public static DocType toEntity(DocTypeDTO dto)
    {
        DocType docType = new DocType();
        docType.setDoctypeid(docType.getDoctypeid());
        docType.setDocumentname(docType.getDocumentname());
        docType.setDocumentname(dto.getDocumentname());
        return docType;
    }
    public static DocTypeDTO toDTO(DocType docType)
    {
        DocTypeDTO dto = new DocTypeDTO();
        dto.setDoctypeid(dto.getDoctypeid());
        dto.setDocumentname(dto.getDocumentname());
        dto.setDocumentname(docType.getDocumentname());
        return dto;
    }
}
