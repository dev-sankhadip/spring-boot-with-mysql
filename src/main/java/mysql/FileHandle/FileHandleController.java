package mysql.FileHandle;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileHandleController {
    @PostMapping("/createTextFile")
    public String createTextFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile=new File("/home/sankha/springFile/" +file.getOriginalFilename());
        System.out.print(file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream out=new FileOutputStream(convertFile);
        out.write(file.getBytes());
        out.close();
        return "Text File Created";
    }
}
