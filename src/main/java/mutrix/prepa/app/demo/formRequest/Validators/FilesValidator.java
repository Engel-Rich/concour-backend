package mutrix.prepa.app.demo.formRequest.Validators;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class FilesValidator {
    private static final List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif");
    private static final List<String> allowedVideoExtensions = Arrays.asList("mp4", "avi", "mov", "wmv");
    private static final long MAX_SIZE = 10 * 1024 * 1024; // 2 MB

    public static void validateImage(Object file) throws IllegalArgumentException {
        if (file instanceof MultipartFile multipartFile) {
            FilesValidator.validateMultipartFile(multipartFile);
        } else {
            throw new IllegalArgumentException("Invalid file type.");
        }
    }

    private static void validateMultipartFile(MultipartFile file) throws IllegalArgumentException {
        if (file != null) {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("A file must be uploaded.");
            }
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || !originalFilename.contains(".")) {
                throw new IllegalArgumentException("Invalid file name.");
            }

            String extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1).toLowerCase();
            if (!allowedExtensions.contains(extension)) {
                throw new IllegalArgumentException("Invalid file type. Allowed types are: " + allowedExtensions);
            }

            if (file.getSize() > MAX_SIZE) {
                throw new IllegalArgumentException("File is too large. Max size is 2MB.");
            }
        }

    }


    public static void validateVideo(Object video, Boolean isRequired) throws IllegalArgumentException {
        if (isRequired) {
            if (video == null) {
                throw new IllegalArgumentException("A file must be uploaded.");
            }
        } else {
            if (video == null) {
                return;
            }
        }
        String extension = getExtension(video);
        if (!allowedVideoExtensions.contains(extension)) {
            throw new IllegalArgumentException("Invalid file type. Allowed types are: " + allowedVideoExtensions);
        }

    }

    private static String getExtension(Object video) {
        if (!(video instanceof MultipartFile multipartFile)) {
            throw new IllegalArgumentException("Invalid file type.");
        }

        if (multipartFile.isEmpty()) {
            throw new IllegalArgumentException("A file must be uploaded.");
        }
        String originalFilename = multipartFile.getOriginalFilename();

        if (originalFilename == null || !originalFilename.contains(".")) {
            throw new IllegalArgumentException("Invalid file name.");
        }
        return originalFilename.substring(originalFilename.lastIndexOf('.') + 1).toLowerCase();
    }
}
