package org.parul.pmp.dto.mapper;

import org.parul.pmp.dto.DocumentDTO;
import org.parul.pmp.entity.Documents;

public class DocumentMapper {
    public static Documents toEntity(DocumentDTO documentDTO)
    {
        Documents docs = new Documents();
        return docs;
    }
}
