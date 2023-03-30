package com.mxs.project.structure;

import com.mxs.project.util.PackageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectStructure {
    @Value("${mxs.root}")
    private String root;
    @Value("${base.package}")
    private String basePackage;

    public void createProject() {
        String base = this.basePackage.replace(".", "/");
        String javaPath = "src/main/java/".concat(base);
        PackageUtil.createPackage(this.root, javaPath);
    }
}
