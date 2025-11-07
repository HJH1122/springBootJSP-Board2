package com.hjh.myapp.util.file;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    // 파일이 존재하는지 확인하는 메서드
    public static boolean exist(File file) throws Exception {
        return file.exists();
    }

    // 파일이 존재하는지 확인하는 메서드 (문자열 버전)
    public static boolean exist(String fileName) throws Exception {
        return toFile(fileName).exists();
    }

    // 문자열을 파일 객체로 만들어 주는 메서드
    public static File toFile(String fileName) throws Exception {
        return new File(fileName);
    }

    // 파일 삭제
    public static boolean delete(File file) throws Exception {
        return file.delete();
    }

    // 파일 경로 문자열로 파일 삭제
    public static boolean remove(String fileName) throws Exception {
        File file = toFile(fileName);

        if (!exist(file)) {
            System.out.println("삭제하려는 파일이 존재하지 않습니다.");
        } else if (!delete(file)) {
            System.out.println("삭제하려는 파일이 삭제되지 않았습니다.");
        } else {
            System.out.println("FileUtil.remove() - 파일이 삭제 되었습니다.");
        }

        return true;
    }

    // 서버의 상대 경로를 절대 경로로 변환
    public static String getRealPath(String path, String fileName, HttpServletRequest request) {
        String filePath = path + "/" + fileName;
        return request.getServletContext().getRealPath(filePath);
    }

    // 중복되지 않는 파일 객체 생성
    public static File noDuplicate(String fileFullName) throws Exception {
        File file = null;
        int dotPos = fileFullName.lastIndexOf(".");

        String fileName = fileFullName.substring(0, dotPos);
        String ext = fileFullName.substring(dotPos);

        int cnt = 0;

        while (true) {
            if (cnt == 0) {
                file = toFile(fileFullName);
            } else {
                file = toFile(fileName + cnt + ext);
            }

            // 중복되지 않으면 빠져나감
            if (!exist(file)) break;

            cnt++;
        }

        return file;
    }

    // 파일 업로드 메서드
    public static String upload(final String PATH, MultipartFile multiFile, HttpServletRequest request)
            throws Exception {

        String fileFullName = "";

        if (multiFile != null && !multiFile.getOriginalFilename().equals("")) {
            String fileName = multiFile.getOriginalFilename();

            // 서버의 파일명 중복을 배제한 File 객체
            File saveFile = noDuplicate(getRealPath(PATH, fileName, request));
            fileFullName = PATH + "/" + saveFile.getName();

            // 실제 파일 업로드 수행
            multiFile.transferTo(saveFile);
        } else {
            fileFullName = PATH + "/" + "noImage.jpg";
        }

        return fileFullName;
    }
}
