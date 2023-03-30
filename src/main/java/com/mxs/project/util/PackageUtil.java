package com.mxs.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Class responsible for methods related to packages
 */
public class PackageUtil {

    private static final Logger logger = LoggerFactory.getLogger(PackageUtil.class);

    /**
     * Method responsible for creating a package
     *
     * @param originPath - Path where the package will be created
     * @param createdPath - Package or sequence of packages that will be created
     */
    public static void createPackage(String originPath, String createdPath) {

        File originFile = new File(originPath);
        File createdFile = new File(originFile, createdPath);

        if (createdFile.mkdirs()) {
            logger.info("PackageUtil.createPackage -> Package created successfully! " +
                    "originPath: {}, createdPath: {}", originPath, createdPath);
        } else {
            logger.error("PackageUtil.createPackage -> An error occurred while creating the package! " +
                    "originPath: {}, createdPath: {}", originPath, createdPath);
        }
    }
}
