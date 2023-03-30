package com.mxs.project.command;

import com.mxs.project.projection.CommandProjection;
import org.kohsuke.args4j.Argument;

public class ControllerCommand implements CommandProjection {
    @Argument(required = true, usage = "Controller Name")
    private String controllerName;
}
