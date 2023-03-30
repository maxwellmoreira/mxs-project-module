package com.mxs.project.component;

import com.mxs.project.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerComponent {

    private static final Logger logger = LoggerFactory.getLogger(ControllerComponent.class);

    public void createController(String domainUri, String controllerName, String path) throws IOException {

        logger.info("ControllerComponent.createController -> domainUri={}, controllerName={}", domainUri, controllerName);

        File file = new File(path + File.separator + controllerName + ".java");
        FileWriter writer = new FileWriter(file);

        String template = FileUtil.readFile(path);
        template = template.replace("[DOMAIN_URI]", domainUri);
        template = template.replace("[CONTROLLER_NAME]", controllerName);

        writer.write(template);
        writer.flush();
        writer.close();

        logger.info("ControllerComponent.createController -> end");
    }
}
