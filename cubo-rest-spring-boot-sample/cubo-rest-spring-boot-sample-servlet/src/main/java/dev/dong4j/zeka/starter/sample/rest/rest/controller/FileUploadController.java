package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.StringUtils;
import dev.dong4j.zeka.starter.rest.ServletController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.11 15:30
 * @since 1.6.0
 */
@Slf4j
@RestController
@Api(tags = "文件上传")
public class FileUploadController extends ServletController {

    /**
     * Upload
     *
     * @param file file
     * @return the string
     * @since 1.6.0
     */
    @ApiOperation(value = "文件上传测试", notes = "xxx")
    @PostMapping("upload")
    public Result<String> upload(@RequestParam("file") @NotNull MultipartFile file) {
        if (file.isEmpty()) {
            return R.failed();
        }

        try {
            // 获取系统临时目录
            File tempDir = new File(System.getProperty("java.io.tmpdir"));

            // 构建目标文件
            String fileName = file.getOriginalFilename();
            if (!StringUtils.hasText(fileName)) {
                log.warn("上传文件名为空");
                return R.failed("文件名不能为空");
            }
            File dest = new File(tempDir, fileName);

            // 保存文件到临时目录
            file.transferTo(dest);

            // 输出调试日志
            log.debug("文件已保存至临时目录，完整路径: {}", dest.getAbsolutePath());

            // 返回成功结果
            return R.succeed();
        } catch (IOException e) {
            log.error("文件上传失败", e);
            return R.failed();
        }
    }


    /**
     * Gets image *
     *
     * @return the image
     * @throws IOException io exception
     * @since 1.0.0
     */
    @RequestMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public BufferedImage getImage() throws IOException {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("static/images/header.png")) {
            if (in == null) {
                throw new IOException("文件不存在于 classpath 中");
            }
            return ImageIO.read(in);
        }
    }
}
