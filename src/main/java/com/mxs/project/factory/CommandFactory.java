package com.mxs.project.factory;

import com.mxs.project.command.*;
import com.mxs.project.projection.CommandProjection;
import com.mxs.project.type.CommandType;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private static class CommandFactoryHelper {
        private static final CommandFactory INSTANCE = new CommandFactory();
    }

    public static CommandFactory getInstance() {
        return CommandFactoryHelper.INSTANCE;
    }

    public CommandProjection getCommandCatalog(String[] input) {
        switch(CommandType.of(input[0])) {
            case PROJECT:
                return new ProjectCommand();
            case DOMAIN:
                return new DomainCommand();
            case POJO:
                return new PojoCommand();
            case MAPPER:
                return new MapperCommand();
            case CLIENT:
                return new ClientCommand();
            case REPOSITORY:
                return new RepositoryCommand();
            case USE_CASE:
                return new UseCaseCommand();
            case FACADE:
                return new FacadeCommand();
            case CONTROLLER:
                return new ControllerCommand();
            case LISTENER:
                return new ListenerCommand();
            case PUBLISH:
                return new PublishCommand();
            case UNIT_TEST:
                return new UnitTestCommand();
            case INTEGRATION_TEST:
                return new IntegrationTestCommand();
            default:
                throw new IllegalArgumentException();
        }
    }
}
