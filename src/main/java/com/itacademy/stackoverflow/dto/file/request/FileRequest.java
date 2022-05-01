package com.itacademy.stackoverflow.dto.file.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import org.springframework.web.multipart.MultipartFile;
@Jacksonized //missing
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileRequest {
    MultipartFile multipartFile;
}
