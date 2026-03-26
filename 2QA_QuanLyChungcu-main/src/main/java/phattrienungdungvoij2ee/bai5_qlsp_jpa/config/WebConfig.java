package phattrienungdungvoij2ee.bai5_qlsp_jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map URL /uploads/** toi thu muc uploads tren may
        Path uploadDir = Paths.get("src/main/resources/static/uploads");
        String uploadPathUri = uploadDir.toUri().toString();

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(uploadPathUri);

        // Map URL /images/** sang thu muc static/images o goc project.
        // De hien thi QR (vd: /images/QR/<ten-file>.jpg).
        Path imagesDir = Paths.get("static/images");
        String imagesPathUri = imagesDir.toUri().toString();

        // Fallback theo duong dan workspace hien tai (de tranh truong hop CWD khac thu muc project).
        Path fallbackImagesDir = Paths.get("E:/WorkPlace/Doan4monFORKED/2QA_PhamTranDangQuang/2QA_QuanLyChungcu-main/static/images");
        String fallbackImagesPathUri = fallbackImagesDir.toUri().toString();

        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/", imagesPathUri, fallbackImagesPathUri);
    }
}