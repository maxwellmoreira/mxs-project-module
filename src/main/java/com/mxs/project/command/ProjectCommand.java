package com.mxs.project.command;

import com.mxs.project.projection.CommandProjection;
import com.mxs.project.util.PackageUtil;
import org.kohsuke.args4j.Argument;

public class ProjectCommand implements CommandProjection {
    @Argument(index = 0, required = true, usage = "Project Name")
    private String projectName;

    public ProjectCommand() {
        createProject();
    }

    private void createProject() {
        PackageUtil.createPackage("","src/main/java/com/mxs/project");
        PackageUtil.createPackage("","src/main/resources");
        PackageUtil.createPackage("","src/test/java/com/mxs/project");
        PackageUtil.createPackage("","src/test/resources");
    }
}
